package Exceptions;

import Expr.TreeParser;

public class InvalidStructureVarName extends Exception{
    public InvalidStructureVarName(String structureName, String varName, String varName2) {
        System.out.println("Erreur ligne : " + TreeParser.LIGNE + " | \"" + varName + "\" n'exite pas dans la structure \"" + structureName + "\"");
    }
}
