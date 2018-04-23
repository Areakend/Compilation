package Exceptions;

import Expr.TreeParser;

public class PointerTypeException extends Exception {
    public PointerTypeException(Boolean VV, String var) {
		System.out.println(VV ? "Erreur ligne : " + TreeParser.LIGNE + " | Pointeur attendu sur la variable \"" + var + "\"" : "Erreur ligne : " + TreeParser.LIGNE + " | Pas de pointeur attendu sur la variable \"" + var + "\"");
    }
}
