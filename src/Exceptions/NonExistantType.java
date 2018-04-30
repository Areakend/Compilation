package Exceptions;

import Expr.TreeParser;

public class NonExistantType extends Exception {
	public NonExistantType(String type) {
		System.out.println("Erreur ligne : " + TreeParser.LIGNE + " | Le type \"" + type + "\" n'existe pas");
	}
}