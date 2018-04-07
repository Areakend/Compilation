package Objets;

import java.util.ArrayList;

public class Vecteur {
    private String name;
    private String type;
	private ArrayList<Variable> variables;

    public Vecteur(String name, String type, ArrayList<Variable> variables) {
    	this.name = name;
    	this.type = type;
    	this.variables=variables;
    }

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public ArrayList<Variable> getVariables() {
		return variables;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setVariables(ArrayList<Variable> variables) {
		this.variables = variables;
	}
    
    @Override
    public String toString() {
        return "Vecteur" + this.name + " : " + this.type + " = " + this.variables;
    }

    
}
