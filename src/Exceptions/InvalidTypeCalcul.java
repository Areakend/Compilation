package Exceptions;

import Expr.TreeParser;

public class InvalidTypeCalcul extends Exception {
	public InvalidTypeCalcul(String name1, String type1, String name2, String type2) {
		System.out.println("Erreur ligne : " + TreeParser.LIGNE + " | \"" +  name1 + "\" est de type \"" + type1 + "\" et le calcul est effectue avec \"" + name2 + "\" qui est de type " + type2);
	}
}