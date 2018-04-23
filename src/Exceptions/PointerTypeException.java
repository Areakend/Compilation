package Exceptions;

import Expr.TreeParser;

public class PointerTypeException extends Exception {
    public PointerTypeException(Boolean VV) {
		System.out.println(VV ? "Erreur ligne : " + TreeParser.LIGNE + " | Pointeur attendu" : "Erreur ligne : " + TreeParser.LIGNE + " | Pas de pointeur attendu");
    }
}
