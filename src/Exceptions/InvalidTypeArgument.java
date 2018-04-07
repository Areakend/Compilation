package Exceptions;

public class InvalidTypeArgument extends Exception {
    public InvalidTypeArgument(String name, String theoricalType, String realType) {
        System.out.println("Erreur ligne : \"" + name + "\" est de type " + realType + " mais l argument doit etre de type " + theoricalType + "\n");
    }
}
