package Exceptions;

import Expr.TreeParser;

public class NonExistantStructure extends Exception {
    public NonExistantStructure(String structureName) {
        System.out.println("Erreur ligne : " + TreeParser.LIGNE + " | la structure \"" + structureName + "\" n'existe pas \n");
    }
}
