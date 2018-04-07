package Exceptions;

public class NonExistantArgument extends Exception {
    public NonExistantArgument(String name) {
        System.out.println("Erreur ligne : \"" + " \" \"" + name + "\" n'est pas un argument \n");
    }
}

