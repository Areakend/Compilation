package Exceptions;

import Expr.TreeParser;

public class InvalidTypeReturn extends Exception{
    public InvalidTypeReturn(String name, String typeVariable, String typeReturn) {
        System.out.println("Erreur ligne : \"" + TreeParser.LIGNE + " | \"" + name + "\" est de type " + typeVariable + " mais le retour doit etre de type " + typeReturn);
    }
}

