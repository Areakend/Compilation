package Exceptions;

public class NullDivision extends Exception {
    public NullDivision() {
        System.out.println("Erreur ligne : \"" + "La division par 0 est interdite \n");
    }
}