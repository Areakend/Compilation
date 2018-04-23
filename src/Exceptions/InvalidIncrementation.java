package Exceptions;

import Expr.TreeParser;

public class InvalidIncrementation extends Exception {
	public InvalidIncrementation (String name){
		System.out.println("Erreur ligne : " + TreeParser.LIGNE + " | \"" + name + "\" n'est pas un entier");
	}
}
