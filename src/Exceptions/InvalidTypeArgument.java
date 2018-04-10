package Exceptions;

import Expr.TreeParser;

public class InvalidTypeArgument extends Exception {
    public InvalidTypeArgument(String name, String theoricalType, String realType) {
        System.out.println("Erreur ligne : " + TreeParser.LIGNE + " \"" + name + "\" est de type " + realType + " mais l argument doit etre de type " + theoricalType + "\n");
    }
}
