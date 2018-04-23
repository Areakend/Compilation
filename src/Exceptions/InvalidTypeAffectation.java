package Exceptions;

import Expr.TreeParser;

public class InvalidTypeAffectation extends Exception {
	public InvalidTypeAffectation(String name, String typeVariable, String typeAffect) {
		System.out.println("Erreur ligne : " + TreeParser.LIGNE + " | \"" + name + "\" est de type " + typeVariable + " et l'affectation est de type " + typeAffect);
	}
}
