package Exceptions;

import Expr.TreeParser;

public class WrongRegionDeclaration extends Exception {
    public WrongRegionDeclaration(String name) {
        System.out.println("Erreur ligne : " + TreeParser.LIGNE + " | La structure \"" + name + "\" ne peut pas etre declaree ici");
    }
}
