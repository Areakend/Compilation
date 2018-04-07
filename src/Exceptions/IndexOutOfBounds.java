package Exceptions;

public class IndexOutOfBounds extends Exception {
	public IndexOutOfBounds (String name) {
        System.out.println("Erreur ligne : \"" + "L'indice recherche dans le vecteur \"" + name + "\" depasse la taille du vecteur \n");
	}

}
