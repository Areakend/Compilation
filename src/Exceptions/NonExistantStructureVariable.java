package Exceptions;

public class NonExistantStructureVariable extends Exception {
    public NonExistantStructureVariable(String structureName, String variableName) {
        System.out.println("Erreur ligne : \"" + variableName + "\" n'existe pas dans la structure " + structureName + "\n");
    }
}
