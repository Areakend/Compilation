package Exceptions;

public class InvalidTypeReturn extends Exception{
    public InvalidTypeReturn(String name, String typeVariable, String typeReturn) {
        System.out.println("Erreur ligne : \"" + name + "\" est de type " + typeVariable + " mais le retour doit etre de type " + typeReturn + "\n");
    }
}

