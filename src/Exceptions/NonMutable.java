package Exceptions;

import Expr.TreeParser;

public class NonMutable extends Exception {
    public NonMutable(String name) {
        System.out.println("Erreur ligne : \"" + TreeParser.LIGNE + " | \"" + name + "\" ne peut pas etre modifie car non mutable");
    }
}
