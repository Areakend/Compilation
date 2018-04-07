package Exceptions;

public class NonExistantVecteur extends Exception {
    public NonExistantVecteur(String name) {
        System.out.println("Erreur ligne : \"" + "Le vecteur " + name + "\" n'existe pas\n");
    }
}
