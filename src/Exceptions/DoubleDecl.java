package Exceptions;

public class DoubleDecl extends Exception {
    public DoubleDecl(String name) {
        System.out.println("Erreur ligne : \"" + name + "\" est déjà declarée\n");
    }
}
