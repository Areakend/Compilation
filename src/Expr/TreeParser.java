package Expr;

import Exceptions.*;
import Objets.*;
import org.antlr.runtime.tree.CommonTree;

import java.util.ArrayList;

public class TreeParser {

    public static int LIGNE = 0;

    public static void analyseRec(Tables tables, CommonTree t, TableDesSymboles tds) throws Exception {
        TreeParser.LIGNE = t.getLine();

        if (t.isNil()) {
            int nbChilds = t.getChildCount();

            for (int i = 0; i < nbChilds; i++)
                TreeParser.analyseRec(tables, (CommonTree) t.getChild(i), tds);
        } else {
            switch (t.getText()) {
                case "DECL": {
                    String name;
                    boolean mut = false;
                    boolean pointeur = false;
                    int nbChilds = t.getChildCount();
                    int posName = 0;
                    String type = "";

                    for (int i = 0; i < nbChilds; i++) {
                        if (t.getChild(i).getText().equals("mut")) {
                            mut = true;
                            posName = posName + 1;
                        }

                        if (t.getChild(i).getText().equals("SPE_UNAIRE"))
                            posName = i;
                    }

                    if (t.getChild(posName).getText().equals("SPE_UNAIRE")) {
                        name = t.getChild(posName).getChild(1).getText();
                        pointeur = true;
                    } else name = t.getChild(posName).getText();

                    String value = null;
                    if (t.getChild(nbChilds - 1).getChildCount() > 0) { // AFFECT
                        CommonTree node = (CommonTree) t.getChild(nbChilds - 1);
                        value = null;
                        if (isInteger(node.getChild(0).getText()) || isBoolean(node.getChild(0).getText())) {
                            value = node.getChild(0).getText();
                        }
                        type = TreeParser.analyseExp((CommonTree) node.getChild(0), tds);
                    }
                    if (!(t.getChild(nbChilds - 1)).getText().equals("vecteur")) {
                        tds.ajouterVariable(name, mut, type, value, pointeur, false);
                    } else {
                        CommonTree node = (CommonTree) t.getChild(nbChilds - 1);
                        int nbChild2 = node.getChildCount();
                        ArrayList<String> value1 = new ArrayList<>();

                        try {
                            if (nbChild2 > 1)
                                for (int i = 0; i < nbChild2 - 1; i++)
                                    isSameType(name, node.getChild(i).getText(), node.getChild(i + 1).getText());

                            for (int i = 0; i < nbChild2; i++)
                                value1.add(node.getChild(i).getText());

                            tds.ajouterVecteur(name, findType(node.getChild(0).getText()), value1);
                        } catch (InvalidTypeArgument e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                }
                case "STRUCT": {
                    String nameStruct = t.getChild(0).getText();
                    ArrayList<String> varNames = new ArrayList<>();
                    ArrayList<String> varTypes = new ArrayList<>();
                    ArrayList<Boolean> varPointeurs = new ArrayList<>();
                    int nbChilds = t.getChildCount();

                    for (int i = 1; i < nbChilds; i++) {
                        CommonTree node = (CommonTree) t.getChild(i);
                        fillVarNamesTypes(node, varNames, varTypes, varPointeurs);
                    }

                    tds.ajouterStructure(nameStruct, varNames, varTypes, varPointeurs);
                    break;
                }
                case "BLOC": {
                    int nbChilds = t.getChildCount();

                    if (!t.getParent().getText().equals("FUNC")) {
                        TableDesSymboles tds2 = new TableDesSymboles(tables, tds);

                        for (int i = 0; i < nbChilds; i++)
                            TreeParser.analyseRec(tables, (CommonTree) t.getChild(i), tds2);
                    } else {
                        for (int i = 0; i < nbChilds; i++)
                            TreeParser.analyseRec(tables, (CommonTree) t.getChild(i), tds);
                    }
                    break;
                }
                case "IF":
                    TreeParser.analyseExp((CommonTree) t.getChild(0), tds);
                    for (int i = 1; i < t.getChildCount(); i++)
                        TreeParser.analyseRec(tables, (CommonTree) t.getChild(i), tds);
                    break;
                case "ELSE":
                    TreeParser.analyseRec(tables, (CommonTree) t.getChild(0), tds);
                    break;
                case "WHILE":
                    TreeParser.analyseExp((CommonTree) t.getChild(0), tds);
                    TreeParser.analyseRec(tables, (CommonTree) t.getChild(1), tds);
                    break;
                case "FUNC":
                    String nameFunc = t.getChild(0).getText();
                    String returnType = null;
                    Arguments args = null;
                    ArrayList<String> argNames;
                    ArrayList<String> argTypes;
                    ArrayList<Boolean> argPointeurs;

                    for (int i = 1; i < t.getChildCount(); i++) {
                        CommonTree node = (CommonTree) t.getChild(i);
                        switch (node.getText()) {
                            case "FUNC_ARGS":
                                argNames = new ArrayList<>();
                                argTypes = new ArrayList<>();
                                argPointeurs = new ArrayList<>();

                                for (int j = 0; j < node.getChildCount(); j++) {
                                    CommonTree node2 = (CommonTree) node.getChild(j);
                                    fillVarNamesTypes(node2, argNames, argTypes, argPointeurs);
                                }

                                args = new Arguments(argNames, argTypes, argPointeurs);
                                break;
                            case "BLOC":
                                tds.ajouterFonction(nameFunc, returnType, args);
                                TableDesSymboles tds2 = new TableDesSymboles(tables, tds);
                                if (args != null) {
                                    ArrayList<String> names = args.getNames();
                                    ArrayList<String> types = args.getTypes();
                                    for (int k = 0; k < names.size(); k++) {
                                        boolean pointeur = false;
                                        if (types.get(k).equals("& i32") || types.get(k).equals("& bool")) {
                                            pointeur = true;
                                        }
                                        String type = (types.get(k).substring(0, 1).equals("&")) ? types.get(k).substring(2, types.get(k).length()) : types.get(k);
                                        tds2.ajouterVariable(names.get(k), true, type, null, pointeur, true);
                                    }
                                }
                                TreeParser.analyseRec(tables, node, tds2);
                                break;
                            default:
                                returnType = node.getText();
                                break;
                        }
                    }
                    break;
                case "PRINT":
                case "RETURN":
                    TreeParser.analyseExp((CommonTree) t.getChild(0), tds);
                    break;
            }
        }
    }

    private static String analyseExpUnaire(CommonTree t, String spe_unaire, TableDesSymboles tds) throws Exception {
        String type;

        switch (spe_unaire) {
            case "-":
                type = "i32";
                return type.equals(analyseExp(t, tds)) ? type : null;
            case "!":
                type = "bool";
                return type.equals(analyseExp(t, tds)) ? type : null;
            case "&":
                return analyseExp(t, tds);
            case "*":
                return analyseExp(t, tds);
            default:
                return null;
        }

    }

    private static String analyseExp(CommonTree t, TableDesSymboles tds) throws Exception {
        String s = t.getText();

        switch (s) {
            case "SPE_UNAIRE":
                return analyseExpUnaire((CommonTree) t.getChild(1), t.getChild(0).getText(), tds);
            case "+":
            case "-":
            case "*":
            case "/":
            case "<":
            case "<=":
            case ">":
            case ">=":
            case "==":
            case "!=":
            case "&&":
            case "||":
                String fg = TreeParser.analyseExp((CommonTree) t.getChild(0), tds);
                String fd = TreeParser.analyseExp((CommonTree) t.getChild(1), tds);

                try {
                    isSameTypeCalcul(fg, findType(fg), fd, findType(fd));
                } catch (InvalidTypeCalcul e) {
                    e.printStackTrace();
                }

                try {
                    assert fg != null;

                    if (fg.equals(fd)) {
                        switch (s) {
                            case "+":
                            case "-":
                            case "*":
                            case "/":
                                return "i32";
                            case "<":
                            case "<=":
                            case ">":
                            case ">=":
                            case "==":
                            case "!=":
                            case "&&":
                            case "||":
                                return "bool";
                        }
                    }

                    isSameTypeCalcul(t.getChild(0).getText(), t.getChild(1).getText(), fg, fd);
                } catch (InvalidTypeCalcul e) {
                    e.printStackTrace();
                }
            default:
                if (isInteger(t.getText()))
                    return "i32";
                else if (isBoolean(t.getText()))
                    return "bool";
                else {
                    int nbChilds = t.getChildCount();
                    if (nbChilds == 0) {
                        try {
                            switch (t.getText()) {
                                case "true":
                                    return "true";
                                case "false":
                                    return "false";
                                default:
                                    Variable variable = tds.getVariable(tds, t.getText());
                                    if (variable.getValue() == null || isInteger(variable.getValue())) {
                                        return variable.getName();
                                    } else {
                                        return variable.getValue();
                                    }
                            }
                        } catch (NonExistantVariable e) {
                            e.printStackTrace();
                        }
                    } else if (t.getChild(0).getText().equals("IND")) {
                        String name = t.getText();
                        t = (CommonTree) t.getChild(0).getChild(0);

                        try {
                            Vecteur vect = ((TableDesVecteurs) (tds.get(TableType.VEC))).getVecteur(tds, name);

                            if (t.getChildCount() == 0) try {
                                String variable = TreeParser.analyseExp(t, tds);
                                isSameType(name, "i32", findType(variable));
                            } catch (InvalidTypeArgument e) {
                                e.printStackTrace();
                            }
                            else if (t.getChild(0).getText().equals("IND")) try {
                                TreeParser.analyseExp(t, tds);
                                Vecteur vectFils = ((TableDesVecteurs) (tds.get(TableType.VEC))).getVecteur(tds,
                                        t.getText());
                                isSameTypeVecteurVariable(vect.getName(), "i32", vectFils.getName(),
                                        vectFils.getType());
                            } catch (InvalidVecteurVariableType | NonExistantVecteur e) {
                                e.printStackTrace();
                            }
                            else if (t.getChild(0).getText().equals("CALL_ARGS")) try {
                                Fonction fonctionFils = tds.getFonction(tds, t.getText());
                                isSameTypeVecteurVariable(vect.getName(), "i32", fonctionFils.getName(),
                                        fonctionFils.getReturnType());
                            } catch (InvalidVecteurVariableType | NonExistantFunction e) {
                                e.printStackTrace();
                            }
                        } catch (NonExistantVecteur e) {
                            e.printStackTrace();
                        }
                    } else if (t.getChild(0).getText().equals("CALL_ARGS")) {
                        String name1 = t.getText();

                        try {
                            Fonction fonc = tds.getFonction(tds, name1);
                            t = (CommonTree) t.getChild(0);
                            int nbChilds2 = t.getChildCount();

                            try {
                                fonc.validNumberArgs(fonc, nbChilds2);

                                for (int i = 0; i < nbChilds2; i++) {
                                    String theoricalType = fonc.getArgs().getTypes().get(i);
                                    CommonTree Child = (CommonTree) t.getChild(i).getChild(0);
                                    String nameVal = Child.getText();

                                    if (Child.getChildCount() == 0 && name1.equals("CALL_ARGS")) {
                                        try {
                                            TreeParser.isSameType(name1, theoricalType, nameVal);

                                            /*
                                             * try { boolean
                                             * theoricalPointerType =
                                             * fonc.getArgs().getPointeurs().get
                                             * (i); char pointertest[] = null;
                                             *
                                             * nameVal.getChars(0, 0,
                                             * pointertest, 0);
                                             * TreeParser.isSamePointerType(
                                             * theoricalPointerType,
                                             * pointertest[0]);
                                             *
                                             * if (fonc.getReturnType() == null)
                                             * { return null; } } catch
                                             * (PointerTypeException
                                             * pointeurTypeException) {
                                             *
                                             * }
                                             */
                                        } catch (InvalidTypeArgument e) {
                                            e.printStackTrace();
                                        }
                                    } else if (Child.getChild(0).getText().equals("IND")) try {
                                        TreeParser.analyseExp(Child, tds);
                                        Vecteur vectFils = ((TableDesVecteurs) (tds.get(TableType.VEC))).getVecteur(tds,
                                                t.getText());
                                        isSameType(fonc.getName(), theoricalType, vectFils.getType());
                                    } catch (NonExistantVecteur | InvalidTypeArgument e) {
                                        e.printStackTrace();
                                    }
                                    else if (Child.getChild(0).getText().equals("CALL_ARGS")) try {
                                        TreeParser.analyseExp(Child, tds);
                                        Fonction foncFils = tds.getFonction(tds, t.getText());
                                        System.out.println(foncFils.getName());
                                        System.out.println(foncFils.getReturnType());
                                        isSameType(fonc.getName(), theoricalType, foncFils.getReturnType());
                                    } catch (NonExistantFunction | InvalidTypeArgument e) {
                                        e.printStackTrace();
                                    }
                                }

                                return fonc.getReturnType();
                            } catch (InvalidArgumentsNumber e) {
                                e.printStackTrace();
                            }
                        } catch (NonExistantFunction e) {
                            e.printStackTrace();
                        }
                    } else if (t.getChild(0).getText().equals("ASSOC")) {
                        String name = t.getText();
                        t = (CommonTree) t.getChild(0).getChild(0);

                        try {
                            Structure struc = tds.getVariable(tds, name).getStructure();
                            int k = 0;

                            for (int j = 0; j < struc.getNames().size(); j++) {
                                try {
                                    isSameName(struc.getNames().get(j), t.getText(), struc.getStructureName(), k);

                                    if (j == struc.getNames().size() - 1)
                                        k = 1;
                                } catch (InvalidStructureVarName e) {
                                    e.printStackTrace();
                                }
                            } /*
                             * else if (t.getChild(0).getText().equals("IND")) {
                             * try { TreeParser.analyseExp(t, tds); Vecteur
                             * vectFils = ((TableDesVecteurs)
                             * (tds.get(TableType.VEC))).getVecteur(tds,
                             * t.getText());
                             * isSameTypeVecteurVariable(vect.getName(), "i32",
                             * vectFils.getName(), vectFils.getType()); } catch
                             * (InvalidVecteurVariableType e) { } catch
                             * (NonExistantVecteur e2) { } } else if
                             * (t.getChild(0).getText().equals("CALL_ARGS")) {
                             * try { Fonction fonctionFils =
                             * ((TableDesFonctions)
                             * (tds.get(TableType.FONC))).getFonction(tds,
                             * t.getText());
                             * isSameTypeVecteurVariable(vect.getName(), "i32",
                             * fonctionFils.getName(),
                             * fonctionFils.getReturnType()); } catch
                             * (InvalidVecteurVariableType e) { } catch
                             * (NonExistantFunction e2) {
                             *
                             * } } } catch (NonExistantStructure e) { }
                             */
                        } catch (NonExistantStructure e) {
                            e.printStackTrace();
                        }

                        //////////
                    }
                }
        }
        return null;
    }

    private static void fillVarNamesTypes(CommonTree node, ArrayList<String> varNames, ArrayList<String> varTypes, ArrayList<Boolean> varPointeur) {
        String name = node.getChild(0).getText();
        String temp = node.getChild(1).getText();
        String type = temp;

        if (temp.equals("&")) {
            varPointeur.add(true);
            type = type.concat(" ");
            type = type.concat(node.getChild(2).getText());
            node = (CommonTree) node.getChild(2);
        } else {
            varPointeur.add(false);
            node = (CommonTree) node.getChild(1);
        }

        while (temp.equals("VEC")) {
            node = (CommonTree) node.getChild(0);
            temp = node.getText();
            type = type.concat(" ");
            type = type.concat(temp);
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
        if (realType == null)
            throw new InvalidTypeArgument(name, theoricalType, "null");
        if (!(theoricalType.equals(findType(realType))))
            throw new InvalidTypeArgument(name, theoricalType, findType(realType));
    }

    private static void isSameTypeVecteurVariable(String vecteurName, String vecteurType, String variableName,
                                                  String variableType) throws InvalidVecteurVariableType {
        if (variableType == null)
            throw new InvalidVecteurVariableType(vecteurName, vecteurType, variableName, "null");
        else if (!(vecteurType.equals(variableType)))
            throw new InvalidVecteurVariableType(vecteurName, vecteurType, variableName, variableType);
    }

    private static void isSameTypeCalcul(String name, String theoricalType, String name2, String realType)
            throws InvalidTypeCalcul {
        if (realType == null)
            throw new InvalidTypeCalcul(name, theoricalType, name2, "null");
        if (!(theoricalType.equals(findType(realType))))
            throw new InvalidTypeCalcul(name, theoricalType, name2, findType(realType));
    }

    private static void isSamePointerType(Boolean VV, char test) throws PointerTypeException {
        if (!((VV && test == '*') || (!VV && test != '*')))
            throw new PointerTypeException(VV, test);
    }

    private static boolean isBoolean(String str) {
        if (str != null)
            return (str.equals("true") || str.equals("false"));

        return false;
    }

    private static void isSameName(String str1, String str2, String name, int parcours) throws InvalidStructureVarName {
        if (parcours == 1)
            throw new InvalidStructureVarName(name, str1, str2);
    }

    private static Boolean isInteger(String str) {
        return findType(str).equals("i32");
    }
}