package Exceptions;

public class WrongRegionDeclaration extends Exception {
    public WrongRegionDeclaration(String name) {
        System.out.println("Erreur ligne : \"" + "La structure \"" + name + "\" ne peut pas etre declaree ici\n");
    }
}
