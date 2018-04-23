package Exceptions;

import Expr.TreeParser;

public class NonExistantArgument extends Exception {
    public NonExistantArgument(String name) {
        System.out.println("Erreur ligne : \"" + TreeParser.LIGNE + " | \"" + name + "\" n'est pas un argument");
    }
}

