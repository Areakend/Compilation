package Exceptions;

public class AlreadyExistantFonction extends Exception {
    public AlreadyExistantFonction(String name) {
        System.out.println("Erreur ligne : \"" + "La fonction \"" + name + "\" existe deja\n");
    }
}
