package Exceptions;

public class NonExistingParent extends Exception{

	public NonExistingParent(String name, String parent)
	{		
		System.out.println("Erreur ligne : \"" + " dans \"" +  "\" : \" Le parent " + parent + "\" de la classe : \"" + name + "\" n existe pas\n");
	}
}