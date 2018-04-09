package Exceptions;

import Expr.TreeParser;

public class InvalidVecteurVariableType extends Exception{
    public InvalidVecteurVariableType(String vecteurName, String vecteurType, String variableName, String variableType) {
        System.out.println("Erreur ligne : \"" + TreeParser.LIGNE + variableName + "\" est de type \"" + variableType + "\" ou \"" + vecteurName + "\" est un vecteur de type " + vecteurType + "\n");
    }
}
