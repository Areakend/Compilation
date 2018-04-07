package Exceptions;

public class InvalidArgumentsNumber extends Exception {
	public InvalidArgumentsNumber(String name, int numberArgs) {
		System.out.println("Erreur ligne : \"" + "\"" + name + "\" doit avoir \"" + numberArgs + "\"argument(s)");
	}
}