package Exceptions;

public class NonInitialisedVariable extends Exception {
	public NonInitialisedVariable(String name) {
		System.out.println("Erreur ligne : \"" + "\" : \"" + name + "\" n'est pas initialisee \n");
	}
}
