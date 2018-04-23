package Exceptions;

import Expr.TreeParser;

public class NonExistantVecteur extends Exception {
    public NonExistantVecteur(String name) {
        System.out.println("Erreur ligne : " + TreeParser.LIGNE + " | Le vecteur \"" + name + "\" n'existe pas");
    }
}
