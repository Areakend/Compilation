package Exceptions;

public class AlreadyExistantStructure extends Exception {
    public AlreadyExistantStructure(String name) {
        System.out.println("Erreur ligne : \"" + "La structure \"" + name + "\" existe deja\n");
    }
}
