package Objets;

import Exceptions.IndexOutOfBounds;

import java.util.ArrayList;

public class Vecteur {
    private String name;
    private String type;
    private ArrayList<String> valeurs;

    public Vecteur(String name, String type) {
        this(name, type, null);
    }

    public Vecteur(String name, String type, ArrayList<String> valeurs) {
        this.name = name;
        this.type = type;
        this.valeurs = valeurs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getValeurs() {
        return valeurs;
    }

    public void setValeurs(ArrayList<String> valeurs) {
        this.valeurs = valeurs;
    }

    public String getValeur(int i) throws IndexOutOfBounds {
        if(i > this.valeurs.size())
            throw new IndexOutOfBounds(name);

        return valeurs.get(i);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Vecteur " + this.name + " : " + this.type + " =\n");
        for(int i = 0; i < this.valeurs.size(); i++)
            res.append("\t").append(this.valeurs.get(i)).append("\n");

        return res.toString();
    }
}
