package Objets;

import java.util.HashMap;

//import exception.DoubleDeclaration;
import Objets.Table;
import Objets.Variable;

public class TableDesVariables extends Table<String,Variable>{

	public TableDesVariables() {
		super(new HashMap<String,Variable>());
	}
	
	public void ajouterVariable(String name, String type) //throws DoubleDeclaration
	{
		if(this.get(name) != null) 
		{
			//throw new DoubleDeclaration(name);
			//System.out.println("Erreur ligne : " + ParserSemantique.LINE + " dans \"" + ParserSemantique.EXP +  "\" : \"" + name + "\" est deja declaree\n");

		}
		Variable temp = new Variable(name,type);
		this.put(name,temp);
		
	}

	public String toString()
	{
		String temp = "";
		for(HashMap.Entry<String, Variable> entry : table.entrySet()) {
			temp += entry.getValue().toString() + "\n" ;
		}
		return temp;
	}
	
}