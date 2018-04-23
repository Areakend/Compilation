package Exceptions;

import Expr.TreeParser;

public class NonInitialisedVariable extends Exception {
	public NonInitialisedVariable(String name) {
		System.out.println("Erreur ligne : " + TreeParser.LIGNE + " | \"" + name + "\" n'est pas initialisee");
	}
}
