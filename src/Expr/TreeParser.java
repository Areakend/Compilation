package Expr;

import Exceptions.NonExistantVariable;
import Objets.*;
import org.antlr.runtime.tree.CommonTree;

import java.util.ArrayList;

public class TreeParser {

    private static void analyseRec(CommonTree t, TableDesSymboles tds, Tables tables) throws Exception {

        if (t.isNil()) {
            return;
        }

        if (t.getText().equals("nil")) {
            int nbChilds = t.getChildCount();
            for (int i = 0; i < nbChilds; i++) {
                analyseRec((CommonTree) t.getChild(i), tds, tables);
            }
        }

        if (t.getText().equals("DECL")) {
            boolean mut = false;
            String name = null;
            int nbChilds = t.getChildCount();

            if (nbChilds == 1) {
                name = t.getChild(0).getText();
            } else if (nbChilds == 2) {
                if (t.getChild(1).getChildCount() == 0) {
                    mut = true;
                    name = t.getChild(1).getText();
                } else {
                    name = t.getChild(0).getText();
                }
            } else {
                mut = true;
                name = t.getChild(1).getText();
            }

            if (t.getChild(nbChilds - 1).getChildCount() > 0) { //AFFECT
                CommonTree node = (CommonTree) t.getChild(nbChilds - 1);
                String value = analyseExp((CommonTree) node.getChild(0), tds, tables);
                tds.ajouterVariable(tds, name, mut, value);
            }
        }

        if (t.getText().equals("STRUCT")) {
            String nameStruct = t.getChild(0).getText();
            ArrayList<String> varNames = new ArrayList<>();
            ArrayList<String> varTypes = new ArrayList<>();
            int nbChilds = t.getChildCount();
            for (int i = 1; i < nbChilds; i++) {
                CommonTree node = (CommonTree) t.getChild(i);
                fillVarNamesTypes(node,varNames,varTypes);
            }
            TableDesStructures tdstruct = new TableDesStructures();
            tdstruct.ajouterStructure(nameStruct, varNames, varTypes);
        }

        if (t.getText().equals("BLOC")) {
            TableDesSymboles tds2 = new TableDesSymboles(tds);
            int nbChilds = t.getChildCount();
            for (int i = 0; i < nbChilds; i++) {
                analyseRec((CommonTree) t.getChild(i), tds2, tables);
            }
        }

        if (t.getText().equals("IF")) {
            analyseExp((CommonTree) t.getChild(0), tds, tables);
            for (int i = 1; i < t.getChildCount(); i++) {
                analyseRec((CommonTree) t.getChild(i), tds, tables);
            }
        }

        if (t.getText().equals("ELSE")) {
            analyseExp((CommonTree) t.getChild(0), tds, tables);
        }

        if (t.getText().equals("WHILE")) {
            analyseExp((CommonTree) t.getChild(0), tds, tables);
            analyseRec((CommonTree) t.getChild(1), tds, tables);
        }

        if (t.getText().equals("FUNC")) {
            String nameFunc = t.getChild(0).getText();
            String returnType = null;
            Arguments args;
            ArrayList<String> argNames;
            ArrayList<String> argTypes;
            for (int i=1 ; i<t.getChildCount() ; i++) {
                CommonTree node = (CommonTree) t.getChild(i);
                if (node.getText().equals("FUNC_ARGS")) {
                    argNames = new ArrayList<>();
                    argTypes = new ArrayList<>();
                    for (int j=1 ; j<node.getChildCount() ; j++) {
                        CommonTree node2 = (CommonTree) node.getChild(j);
                        fillVarNamesTypes(node2,argNames,argTypes);
                    }
                    args = new Arguments(argNames,argTypes);
                }
                else if (node.getText().equals("BLOC")) {
                    analyseRec(node,tds,tables);
                }
                else {
                    returnType = node.getText();
                }
            }
            tds.ajouterFonction(nameFunc,returnType,args);
        }

        if (t.getText().equals("print") || t.getText().equals("RETURN")) {
            analyseExp((CommonTree) t.getChild(0),tds,tables);
        }


    }


    private static String analyseExp(CommonTree t, TableDesSymboles tds, Tables tables) {
        if (t.getText().equals("+") || t.getText().equals("-") || t.getText().equals("*") || t.getText().equals("/")) {
            double value = 0.0;
            if (t.getText().equals("+")) {
                value = Double.valueOf(analyseExp((CommonTree) t.getChild(0), tds, tables)) + Double.valueOf(analyseExp((CommonTree) t.getChild(1), tds, tables));
            } else if (t.getText().equals("-")) {
                value = Double.valueOf(analyseExp((CommonTree) t.getChild(0), tds, tables)) - Double.valueOf(analyseExp((CommonTree) t.getChild(1), tds, tables));
            } else if (t.getText().equals("*")) {
                value = Double.valueOf(analyseExp((CommonTree) t.getChild(0), tds, tables)) * Double.valueOf(analyseExp((CommonTree) t.getChild(1), tds, tables));
            } else if (t.getText().equals("/")) {
                value = Double.valueOf(analyseExp((CommonTree) t.getChild(0), tds, tables)) / Double.valueOf(analyseExp((CommonTree) t.getChild(1), tds, tables));
            }
            return String.valueOf(value);
        } else if (t.getText().equals("<")) {
            if (Double.valueOf(analyseExp((CommonTree) t.getChild(0), tds, tables)) < Double.valueOf(analyseExp((CommonTree) t.getChild(1), tds, tables))) {
                return "true";
            } else {
                return "false";
            }
        } else if (t.getText().equals("<=")) {
            if (Double.valueOf(analyseExp((CommonTree) t.getChild(0), tds, tables)) <= Double.valueOf(analyseExp((CommonTree) t.getChild(1), tds, tables))) {
                return "true";
            } else {
                return "false";
            }
        } else if (t.getText().equals(">")) {
            if (Double.valueOf(analyseExp((CommonTree) t.getChild(0), tds, tables)) > Double.valueOf(analyseExp((CommonTree) t.getChild(1), tds, tables))) {
                return "true";
            } else {
                return "false";
            }
        } else if (t.getText().equals(">=")) {
            if (Double.valueOf(analyseExp((CommonTree) t.getChild(0), tds, tables)) >= Double.valueOf(analyseExp((CommonTree) t.getChild(1), tds, tables))) {
                return "true";
            } else {
                return "false";
            }
        } else if (t.getText().equals("==")) {
            if (Double.valueOf(analyseExp((CommonTree) t.getChild(0), tds, tables)) == Double.valueOf(analyseExp((CommonTree) t.getChild(1), tds, tables))) {
                return "true";
            } else {
                return "false";
            }
        } else if (t.getText().equals("!=")) {
            if (Double.valueOf(analyseExp((CommonTree) t.getChild(0), tds, tables)) != Double.valueOf(analyseExp((CommonTree) t.getChild(1), tds, tables))) {
                return "true";
            } else {
                return "false";
            }
        } else {
            try {
                Double.valueOf(t.getText());
                return t.getText();
            } catch (NumberFormatException e) {
                try {
                    return String.valueOf(((TableDesVariables) (tds.get(TableType.VAR))).getValeurVariable(tds, t.getText()));
                } catch (NonExistantVariable nonExistantVariable) {
                }
            }
        }
    }

    private static void fillVarNamesTypes(CommonTree node, ArrayList<String> varNames, ArrayList<String> varTypes) {
        String name = node.getChild(0).getText();
        String temp = node.getChild(1).getText();
        String type = temp;
        node = (CommonTree) node.getChild(1);
        while (temp.equals("VEC")) {
            node = (CommonTree) node.getChild(0);
            temp = node.getText();
            type.concat(" ");
            type.concat(temp);
        }
        varNames.add(name);
        varTypes.add(type);
    }

}
