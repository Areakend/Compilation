package Exceptions;

public class InvalidType extends Exception {
    public InvalidType(String name, String typeVariable, String typeAffect) {
        System.out.println("Erreur ligne : \"" + name + "\" est de type " + typeVariable + " et l'affectation est de type " + typeAffect + "\n");
    }
}
