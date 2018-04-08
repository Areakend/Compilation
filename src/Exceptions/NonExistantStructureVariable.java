package Exceptions;

public class NonExistantStructureVariable extends Exception {
    public NonExistantStructureVariable(String structureName) {
        System.out.println("Erreur ligne : \"" + structureName + "\" n'a pas le meme nombre de variables que de types\n");
    }
}
