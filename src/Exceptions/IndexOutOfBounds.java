package Exceptions;

import Expr.TreeParser;

public class IndexOutOfBounds extends Exception {
	public IndexOutOfBounds (String name) {
        System.out.println("Erreur ligne : " + TreeParser.LIGNE + " | L'indice recherche dans le vecteur \"" + name + "\" depasse la taille du vecteur");
	}
}
