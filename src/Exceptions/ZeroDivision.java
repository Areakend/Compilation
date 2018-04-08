package Exceptions;

public class ZeroDivision extends Exception {
    public ZeroDivision() {
        System.out.println("Erreur ligne : \"" + "La division par 0 est interdite \n");
    }
}