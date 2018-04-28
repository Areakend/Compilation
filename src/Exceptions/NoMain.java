package Exceptions;

import Expr.TreeParser;

public class NoMain extends Exception {
    public NoMain() {
        System.out.println("Impossible de trouver le main");
    }
}
