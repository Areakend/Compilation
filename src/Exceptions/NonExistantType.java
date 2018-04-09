package Exceptions;

import Expr.TreeParser;

public class NonExistantType extends Exception {
	public NonExistantType(String name) {
		System.out.println("Erreur ligne : \"" + TreeParser.LIGNE + "\" le type \"" + name + "\" n'existe pas\n");
	}
}