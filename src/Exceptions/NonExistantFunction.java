package Exceptions;

import Expr.TreeParser;

public class NonExistantFunction extends Exception {
    public NonExistantFunction(String functionName) {
        System.out.println("Erreur ligne : " + TreeParser.LIGNE + " | la fonction \"" + functionName + "\" n'existe pas");
    }
}
