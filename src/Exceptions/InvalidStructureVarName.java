package Exceptions;

public class InvalidStructureVarName extends Exception{
    public InvalidStructureVarName(String structureName, String varNameStruc, String varName) {
        System.out.println("Erreur ligne : \"" + varName + "\" n'exite pas dans la structure \"" + structureName + "\" n");
    }
}
