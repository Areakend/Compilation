package Exceptions;

import Expr.TreeParser;

public class PointerTypeException extends Exception {
    public PointerTypeException(Boolean VV, char test) {
    	if( VV==true) {
    		System.out.println("Erreur ligne :\"" + TreeParser.LIGNE + "\"pointeur attendu");
    	} else {
    		System.out.println("Erreur ligne :\"" + TreeParser.LIGNE + "\" pas de pointeur attendu");
    	}
     
    }
}
