package Exceptions;

import Expr.TreeParser;

public class InvalidArgumentsNumber extends Exception {
	public InvalidArgumentsNumber(String name, int numberArgs) {
		System.out.println("Erreur ligne : " + TreeParser.LIGNE + " | \"" + name + "\" doit avoir " + numberArgs + " argument(s)");
	}
}