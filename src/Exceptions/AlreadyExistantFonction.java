package Exceptions;

import Expr.TreeParser;

public class AlreadyExistantFonction extends Exception {
    public AlreadyExistantFonction(String name) {
        System.out.println("Erreur ligne : " + TreeParser.LIGNE + " | La fonction \"" + name + "\" existe deja");
    }
}
