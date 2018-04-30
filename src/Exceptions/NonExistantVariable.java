package Exceptions;

import Expr.TreeParser;

public class NonExistantVariable extends Exception {
    public NonExistantVariable(String name) {
        System.out.println("Erreur ligne : " + TreeParser.LIGNE + " | La variable \"" + name + "\" n'existe pas ou a un type non valide");
    }
}
