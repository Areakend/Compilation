package Objets;

import Exceptions.IndexOutOfBounds;

import java.util.ArrayList;

public class Vecteur {
    private String name;
    private String type;
    private ArrayList<String> valeurs;
    private boolean pointeur;
    private boolean param;

    public Vecteur(String name, String type, boolean pointeur, boolean param) {
        this(name, type, null, pointeur, param);
    }

    Vecteur(String name, String type, ArrayList<String> valeurs, boolean pointeur, boolean param) {
        this.name = name;
        this.type = type;
        this.valeurs = valeurs;
        this.pointeur = pointeur;
        this.param = param;
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

    public void setParam(boolean param) {
        this.param = param;
    }

    boolean isParam() {
        return param;
    }

    public boolean isPointeur() {
        return this.pointeur;
    }

    public String getValeur(int i) throws IndexOutOfBounds {
        if (i > this.valeurs.size())
            throw new IndexOutOfBounds(name);

        return valeurs.get(i);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("\tVecteur : " + this.name + " | type : " + this.type + " | pointeur : " + this.pointeur + " | valeurs : ");

        res.append(valeurs.get(0));

        for (int i = 1; i < valeurs.size(); i++)
            res.append(", ").append(valeurs.get(i));

        return res.append(" | param : " + this.param + "\n").toString();
    }
}
