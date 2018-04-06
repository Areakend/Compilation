package Objets;

import java.util.ArrayList;

public class Structure {
    private String name;
    private ArrayList<String> names;
    private ArrayList<String> types;
	private ArrayList<String> valeurs;

    public Structure(String name, ArrayList<String> names, ArrayList<String> types, ArrayList<String> valeurs) {
    	this.name = name;
    	this.names = names;
    	this.types = types;
    	this.valeurs=valeurs;
    }

	public String getName() {
		return name;
	}
	
	public ArrayList<String> getNames() {
		return names;
	}

	public ArrayList<String> getTypes() {
		return types;
	}

	public ArrayList<String> getValeurs() {
		return valeurs;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setNames(ArrayList<String> names) {
		this.names = names;
	}

	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}

	public void setValeurs(ArrayList<String> valeurs) {
		this.valeurs = valeurs;
	}
	
    @Override
    public String toString() {
        String res = this.name + "\n";
        for(int i = 0; i < this.types.size(); i++) {
            res += "	" + this.names.get(i) + " : " + this.types.get(i) + " " + this.valeurs.get(i) + "\n";
        }

        return res;
    }   

}
