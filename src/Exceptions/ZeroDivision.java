package Exceptions;

import Expr.TreeParser;

public class ZeroDivision extends Exception {
    public ZeroDivision() {
        System.out.println("Erreur ligne : " + TreeParser.LIGNE + " | La division par 0 est interdite");
    }
}