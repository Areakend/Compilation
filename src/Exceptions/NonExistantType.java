package Exceptions;

public class NonExistantType extends Exception {

	public NonExistantType(String name) {
		System.out.println("Erreur ligne : \"" + "\" le type \"" + name + "\" n'existe pas\n");

	}
}