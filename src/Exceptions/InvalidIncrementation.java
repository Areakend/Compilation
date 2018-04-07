package Exceptions;


public class InvalidIncrementation extends Exception {
	public InvalidIncrementation (String name){
		System.out.println("Erreur ligne : \"" + " dans \"" +  "\" : \"" + name + "\" n'est pas un entier\n");

	}
}
