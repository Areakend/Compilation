package Exceptions;

import Expr.TreeParser;

public class NotACondition extends Exception {
	public NotACondition(String condition){
		System.out.println("Erreur ligne : \"" + TreeParser.LIGNE + "\"  \"" + condition + "\" n'est pas une condition valide \n");		
	}
}
