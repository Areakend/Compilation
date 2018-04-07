package Exceptions;

public class NonExistantStructure extends Exception {
    public NonExistantStructure(String structureName) {
        System.out.println("Erreur ligne : \"" + "\" la structure \"" + structureName + "\" n'existe pas \n");
    }
}
