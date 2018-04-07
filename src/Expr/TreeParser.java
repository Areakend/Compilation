package Expr;
import Objets.Structure;
import Objets.TableDesStructures;
import Objets.TableDesSymboles;
import Objets.Tables;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import tds.SymbolTable;


import java.util.ArrayList;

public class TreeParser {

    private static void analyseRec(CommonTree t, TableDesSymboles tds, Tables tables, String var) throws Exception{

        if(t.isNil()){
            return;
        }

        if (t.getText().equals("nil")) {
            int nbChilds = t.getChildCount();
            for (int i=0 ; i<nbChilds; i++) {
                analyseRec((CommonTree) t.getChild(i),tds,tables,null);
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

            tds.ajouterVariable(name, mut, null);

            if (t.getChild(nbChilds-1).getChildCount() > 0) {
                analyseRec((CommonTree) t.getChild(nbChilds-1), tds, tables, name);
            }
        }

        if (t.getText().equals("AFFECT")) { // TO COMPLETE
            tds.modifierValeurVariable(var,analyseExp(t,tds,tables));
        }

        if (t.getText().equals("STRUCT")) {
            String nameStruct = t.getChild(0).getText();
            ArrayList<String> varNames = new ArrayList<String>();
            ArrayList<String> varTypes = new ArrayList<String>();
            int nbChilds = t.getChildCount();
            for (int i=1 ; i<nbChilds; i++) {
                CommonTree node = (CommonTree) t.getChild(i);
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
            TableDesStructures tdstruct = new TableDesStructures();
            tdstruct.ajouterStructure(nameStruct,varNames,varTypes);
        }

    }



    private static String analyseExp(CommonTree t, SymbolTable tds, Tables tables) {
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
            }
            else {
                return "false";
            }
        } else if (t.getText().equals("<=")) {
            if (Double.valueOf(analyseExp((CommonTree) t.getChild(0), tds, tables)) <= Double.valueOf(analyseExp((CommonTree) t.getChild(1), tds, tables))) {
                return "true";
            }
            else {
                return "false";
            }
        } else if (t.getText().equals(">")) {
            if (Double.valueOf(analyseExp((CommonTree) t.getChild(0), tds, tables)) > Double.valueOf(analyseExp((CommonTree) t.getChild(1), tds, tables))) {
                return "true";
            }
            else {
                return "false";
            }
        } else if (t.getText().equals(">=")) {
            if (Double.valueOf(analyseExp((CommonTree) t.getChild(0), tds, tables)) >= Double.valueOf(analyseExp((CommonTree) t.getChild(1), tds, tables))) {
                return "true";
            }
            else {
                return "false";
            }
        } else if (t.getText().equals("==")) {
            if (Double.valueOf(analyseExp((CommonTree) t.getChild(0), tds, tables)) == Double.valueOf(analyseExp((CommonTree) t.getChild(1), tds, tables))) {
                return "true";
            }
            else {
                return "false";
            }
        } else if (t.getText().equals("!=")) {
            if (Double.valueOf(analyseExp((CommonTree) t.getChild(0), tds, tables)) != Double.valueOf(analyseExp((CommonTree) t.getChild(1), tds, tables))) {
                return "true";
            }
            else {
                return "false";
            }
        } else {
            try {
                Double.valueOf(t.getText());
                return t.getText();
            }
            catch (NumberFormatException e) {
                return String.valueOf(tds.getValeurVariable(tds,t.getText()));
            }
        }
    }

}
