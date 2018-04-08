package Exceptions;

public class PointerTypeException extends Exception {
    public PointerTypeException(Boolean VV, char test) {
    	if( VV==true) {
    		System.out.println("Erreur ligne : pointeur attendu");
    	} else {
    		System.out.println("Erreur ligne : pas de pointeur attendu");
    	}
     
    }
}
