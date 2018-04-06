package Objets;

import java.util.ArrayList;
import java.util.HashMap;


//import exception.DoubleDeclaration;
import Objets.Table;
import defaut.ExprParser;
import Objets.Fonction;


public class TableDesFonctions extends Table<String, Fonction> {

	public TableDesFonctions() {
		super(new HashMap<String,Fonction>());
	}
	
	public void ajouterFonction(String name, String returnType, ArrayList<Argument> args) //throws DoubleDeclaration
	{
		if(this.get(name) != null) 
		{	//ajouter quand exeeption et parser faits
			//throw new DoubleDeclaration(id);
			//System.out.println("Erreur ligne : " + ParserSemantique.LINE + " dans \"" + ParserSemantique.EXP +  "\" : \"" + id + "\" est deja declaree\n");

		}
		Fonction temp = new Fonction(name,returnType,args);
		this.put(name,temp);
		
		
	}
	public void ajouterMethode(String name, ArrayList<Argument> args) //throws DoubleDeclaration
	{
		if(this.get(name) != null) 
		{
			//throw new DoubleDeclaration(name);
		}
		Fonction temp = new Fonction(name,args);
		this.put(name,temp);
		
		
	}

	public String toString()
	{
		String temp = "";
		for(HashMap.Entry<String, Fonction> entry : table.entrySet()) {
			temp += entry.getValue().toString() + "\n" ;
		}
		return temp;
	}
}
