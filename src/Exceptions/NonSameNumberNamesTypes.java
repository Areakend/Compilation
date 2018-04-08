package Exceptions;

public class NonSameNumberNamesTypes extends Exception {
    public NonSameNumberNamesTypes(String name) {
        System.out.println("Erreur ligne : \"" + " \" \"" + name + "\" n'est pas un argument \n");
    }
}

