package Objets;

import java.util.ArrayList;

public class Structure {
    private String structureName;
    private ArrayList<String> names;
    private ArrayList<String> types;
    private ArrayList<String> valeurs = null;

    public Structure(String structureName, ArrayList<String> names, ArrayList<String> types) {
        this.structureName = structureName;
        this.names = names;
        this.types = types;
    }

    public String getStructureName() {
        return this.structureName;
    }

    public ArrayList<String> getNames() {
        return this.names;
    }

    public ArrayList<String> getTypes() {
        return this.types;
    }

    public ArrayList<String> getValeurs() {
        return this.valeurs;
    }

    public void setValeur(int pos, String valeur) {
        this.names.set(pos, valeur);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Structure " + this.structureName + " :\n");

        for (int i = 0; i < this.names.size(); i++)
            res.append("\t").append(this.names.get(i)).append(" : ").append(this.types.get(i)).append(" ").append(this.valeurs.get(i)).append("\n");

        return res.toString();
    }
}
