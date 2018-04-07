package Exceptions;

public class NonMutable extends Exception {
    public NonMutable(String name) {
        System.out.println("Erreur ligne : \"" + name + "\" ne peut pas etre modifie\n");
    }
}
