package Exceptions;


public class NoReturn extends Exception{

	public NoReturn(String fonctName){
		System.out.println("Erreur ligne : \"" + " dans \"" +  "\" : il n'y a pas de return dans la fonction \"" + fonctName + "\n");

	}
}