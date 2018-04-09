package Exceptions;

import Expr.TreeParser;

//
public class InvalidTypeArguments extends Throwable {
	public InvalidTypeArguments(String name1, String name2, String type1, String type2) {
	        System.out.println("Erreur ligne : \"" + TreeParser.LIGNE +"\""+ name1 + "\" est de type " + type1 + " mais \"" + name2 + "\" est de type \"" + type2 + "\n");
	    
	}
}
