package Exceptions;

import Expr.TreeParser;

public class NonExistantStructureVariable extends Exception {
    public NonExistantStructureVariable(String structureName) {
        System.out.println("Erreur ligne : \"" + TreeParser.LIGNE + structureName + "\" n'a pas le meme nombre de variables que de types\n");
    }
}
