package Exceptions;

import Expr.TreeParser;

public class NoReturn extends Exception{
	public NoReturn(String fonctName){
		System.out.println("Erreur ligne : " + TreeParser.LIGNE + " | Pas de valeur retournee dans la fonction \"" + fonctName + "\"");
	}
}