package Exceptions;

public class NotACondition extends Exception {
	public NotACondition(String condition){
		System.out.println("Erreur ligne : \"" + "\"  \"" + condition + "\" n'est pas une condition valide \n");		
	}
}
