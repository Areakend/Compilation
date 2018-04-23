package Exceptions;

import Expr.TreeParser;

public class AlreadyExistantStructure extends Exception {
    public AlreadyExistantStructure(String name) {
        System.out.println("Erreur ligne : " + TreeParser.LIGNE + " | La structure \"" + name + "\" existe deja");
    }
}
