package Exceptions;

public class NonExistantVariable extends Exception {
    public NonExistantVariable(String name) {
        System.out.println("Erreur ligne : \"" + "La variable \"" + name + "\" n'existe pas\n");
    }
}
