package Expr;

import Exceptions.*;
import Objets.*;
import org.antlr.runtime.tree.CommonTree;

import java.util.ArrayList;

public class TreeParser {
    private static void analyseRec(CommonTree t, TableDesSymboles tds, Tables tables) throws Exception {

        if (t.isNil())
            return;

        if (t.getText().equals("nil")) {
            int nbChilds = t.getChildCount();

            for (int i = 0; i < nbChilds; i++)
                TreeParser.analyseRec((CommonTree) t.getChild(i), tds, tables);
        }

        if (t.getText().equals("DECL")) {
            String name;
            boolean mut = false;
            int nbChilds = t.getChildCount();

            if (nbChilds == 1)
                name = t.getChild(0).getText();
            else if (nbChilds == 2) {
                if (t.getChild(1).getChildCount() == 0) {
                    mut = true;
                    name = t.getChild(1).getText();
                } else
                    name = t.getChild(0).getText();
            } else {
                mut = true;
                name = t.getChild(1).getText();
            }

            if (t.getChild(nbChilds - 1).getChildCount() > 0) { // AFFECT
                CommonTree node = (CommonTree) t.getChild(nbChilds - 1);
                String value = TreeParser.analyseExp((CommonTree) node.getChild(0), tds, tables);
                tds.ajouterVariable(name, mut, value);
            }
        }

        if (t.getText().equals("STRUCT")) {
            String nameStruct = t.getChild(0).getText();
            ArrayList<String> varNames = new ArrayList<>();
            ArrayList<String> varTypes = new ArrayList<>();
            int nbChilds = t.getChildCount();

            for (int i = 1; i < nbChilds; i++) {
                CommonTree node = (CommonTree) t.getChild(i);
                fillVarNamesTypes(node, varNames, varTypes);
            }

            TableDesStructures tdstruct = new TableDesStructures();
            tdstruct.ajouterStructure(tds, nameStruct, varNames, varTypes);
        }

        if (t.getText().equals("BLOC")) {
            TableDesSymboles tds2 = new TableDesSymboles(tds);
            int nbChilds = t.getChildCount();

            for (int i = 0; i < nbChilds; i++)
                TreeParser.analyseRec((CommonTree) t.getChild(i), tds2, tables);
        }

        if (t.getText().equals("IF")) {
            TreeParser.analyseExp((CommonTree) t.getChild(0), tds, tables);

            for (int i = 1; i < t.getChildCount(); i++)
                TreeParser.analyseRec((CommonTree) t.getChild(i), tds, tables);
        }

        if (t.getText().equals("ELSE"))
            TreeParser.analyseExp((CommonTree) t.getChild(0), tds, tables);

        if (t.getText().equals("WHILE")) {
            TreeParser.analyseExp((CommonTree) t.getChild(0), tds, tables);
            TreeParser.analyseRec((CommonTree) t.getChild(1), tds, tables);
        }

        if (t.getText().equals("FUNC")) {
            String nameFunc = t.getChild(0).getText();
            String returnType = null;
            Arguments args = null;
            ArrayList<String> argNames;
            ArrayList<String> argTypes;

            for (int i = 1; i < t.getChildCount(); i++) {
                CommonTree node = (CommonTree) t.getChild(i);
                if (node.getText().equals("FUNC_ARGS")) {
                    argNames = new ArrayList<>();
                    argTypes = new ArrayList<>();

                    for (int j = 1; j < node.getChildCount(); j++) {
                        CommonTree node2 = (CommonTree) node.getChild(j);
                        fillVarNamesTypes(node2, argNames, argTypes);
                    }

                    args = new Arguments(argNames, argTypes);
                } else if (node.getText().equals("BLOC"))
                    TreeParser.analyseRec(node, tds, tables);
                else
                    returnType = node.getText();
            }
            tds.ajouterFonction(nameFunc, returnType, args);
        }

        if (t.getText().equals("print") || t.getText().equals("RETURN"))
            TreeParser.analyseExp((CommonTree) t.getChild(0), tds, tables);
    }

    private static String analyseExpUnaire(CommonTree t, String spe_unaire, TableDesSymboles tds, Tables tables) {
        if (spe_unaire.equals("-") {
            return String.valueOf(-Double.valueOf(analyseExp(t, tds, tables)));
        } else if (spe_unaire.equals("!") {
            return String.valueOf(!Boolean.valueOf(analyseExp(t, tds, tables)));
        } else if (spe_unaire.equals("&") {
            return String.valueOf(Adresse(analyseExp(t, tds, tables)));
        } else if (spe_unaire.equals("*") {
            return String.valueOf(Pointeur(analyseExp(t, tds, tables)));
        }
    }


    private static String analyseExp(CommonTree t, TableDesSymboles tds, Tables tables) throws Exception {

        String s = t.getText();

        if (s.equals("SPE_UNAIRE")) {
            return analyseExpUnaire((CommonTree) t.getChild(1), t.getChild(0).getText(), tds, tables);
        } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("<") || s.equals("<=") || s.equals(">") || s.equals(">=") || s.equals("==") || s.equals("!=") || s.equals("&&") || s.equals("||")) {


            String fg = TreeParser.analyseExp((CommonTree) t.getChild(0), tds, tables);
            String fd = TreeParser.analyseExp((CommonTree) t.getChild(1), tds, tables);


            if (IsInteger(fg) && IsInteger(fd)) {

                Integer fg1 = Integer.valueOf(fg);
                Integer fd1 = Integer.valueOf(fd);

                if (s.equals("+"))
                    return String.valueOf(fg1 + fd1);
                else if (s.equals("-"))
                    return String.valueOf(fg1 - fd1);
                else if (s.equals("*"))
                    return String.valueOf(fg1 * fd1);
                else if (s.equals("/"))
                    return String.valueOf(fg1 / fd1);
                else if (s.equals("<"))
                    return String.valueOf(fg1 < fd1);
                else if (s.equals("<="))
                    return String.valueOf(fg1 <= fd1);
                else if (s.equals(">"))
                    return String.valueOf(fg1 > fd1);
                else if (s.equals(">="))
                    return String.valueOf(fg1 >= fd1);
                else if (s.equals("=="))
                    return String.valueOf(fg1 == fd1);
                else if (s.equals("!="))
                    return String.valueOf(fg1 != fd1);

            } else if (isBoolean(fg) && isBoolean(fd)) {
                Boolean fg1 = Boolean.valueOf(fg);
                Boolean fd1 = Boolean.valueOf(fd);

                if (s.equals("=="))
                    return String.valueOf(fg1 == fd1);
                else if (s.equals("!="))
                    return String.valueOf(fg1 != fd1);
                else if (s.equals("&&"))
                    return String.valueOf(fg1 && fd1);
                else if (s.equals("||"))
                    return String.valueOf(fg1 || fd1);

            } else {
                isSameTypes(fg, fd, findType(fg), findType(fd));
                return "";
            }

        } else {
            if (IsInteger(t.getText())) {
                return t.getText();
            } else {
                int nbChilds = t.getChildCount();
                if (nbChilds == 0) {
                    try {
                        return String.valueOf(
                                ((TableDesVariables) (tds.get(TableType.VAR))).getValeurVariable(tds, t.getText()));

                    } catch (NonExistantVariable nonExistantVariable) {
                    }
                } else if (t.getChild(0).getText() == "IND") {
                    String name = t.getText();
                    t = (CommonTree) t.getChild(0).getChild(0);

                    try {
                        Vecteur vect = ((TableDesVecteurs) (tds.get(TableType.VEC))).getVecteur(tds, name);

                        try {
                            int indice = Integer.valueOf(analyseExp(t, tds, tables));
                            vect.getValeur(indice);
                            String val = vect.getValeurs().get(indice);

                            return val;
                        } catch (IndexOutOfBounds indexOutOfBounds) {
                        }
                    } catch (NonExistantVecteur e1) {
                    }
                } else if (t.getChild(0).getText() == "FUNC_ARGS") {
                    String name = t.getText();
                    try {
                        Fonction fonc = ((TableDesFonctions) (tds.get(TableType.FONC))).getFonction(tds, name);
                        t = (CommonTree) t.getChild(0);
                        int nbChilds2 = t.getChildCount();
                        try {
                            fonc.validNumberArgs(fonc, nbChilds2);
                            ArrayList<String> args = new ArrayList<>();

                            for (int i = 0; i < nbChilds2; i++) {
                                args.add(TreeParser.analyseExp((CommonTree) t.getChild(i), tds, tables));
                                String theoricalType = fonc.getArgs().getTypes().get(i);
                                String nameVal = t.getChild(i).getText();
                                try {
                                    String realType = TreeParser.findType(nameVal);
                                    try {
                                        TreeParser.isSameType(name, theoricalType, realType);
                                        // return Calcul valeur de
                                        // fonction(args);
                                    } catch (InvalidTypeArgument invalidTypeArgument) {
                                    }
                                } catch (NonExistantType nonExistantType) {
                                }
                            }
                            if (nbChilds2 == 0) {
                                // ajouter valeur fonction dans le cas 0
                                // args
                            }
                        } catch (InvalidArgumentsNumber invalidArgumentsNumber) {
                        }
                    } catch (NonExistantFunction nonExistantFunction) {
                    }
                }

            }
        }

        return null;
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


    public static String findType(String value) {
        try {
            Integer.parseInt(value);
            return "i32";
        } catch (NumberFormatException e) {
            return isBoolean(value) ? "bool" : "";
        }
    }


    private static void isSameType(String name, String theoricalType, String realType) throws InvalidTypeArgument {
        if (!(theoricalType.equals(realType)))
            throw new InvalidTypeArgument(name, theoricalType, realType);
    }

    private static void isSameTypes(String name1, String name2, String theoricalType, String realType) throws InvalidTypeArguments {
        if (!(theoricalType.equals(realType)))
            throw new InvalidTypeArguments(name1, name2, theoricalType, realType);
    }

    private static boolean isBoolean(String str) {
        return (str.equals("true") || str.equals("false"));
    }

    private static Boolean IsInteger(String str) {
        int length = str.length(), c = 0;
        if (length == 0)
            return false;
        for (int i = 0; i < length; i++) {
            c = (int) str.charAt(i) - 48;
            if (!(c >= 0 && c < 10))
                return false;
        }
        return true;
    }
}