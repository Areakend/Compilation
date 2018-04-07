package Exceptions;

public class NonExistantFunction extends Exception {
    public NonExistantFunction(String functionName) {
        System.out.println("Erreur ligne : \"" + "\" la fonction \"" + functionName + "\" n'existe pas \n");
    }
}
