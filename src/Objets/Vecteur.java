package Objets;

import Exceptions.IndexOutOfBounds;

import java.util.ArrayList;

public class Vecteur extends VecVar {
    private ArrayList<String> valeurs;

    Vecteur(String name, String type, boolean pointeur) {
        this(name, type, null, pointeur, false);
    }

    Vecteur(String name, String type, ArrayList<String> valeurs, boolean pointeur, boolean param) {
        super(name, type, pointeur, param);
        this.valeurs = valeurs;
    }

    ArrayList<String> getValeurs() {
        return valeurs;
    }

    void setValeurs(ArrayList<String> valeurs) {
        this.valeurs = valeurs;
    }

    public String getValeur(int i) throws IndexOutOfBounds {
        if (i > this.valeurs.size())
            throw new IndexOutOfBounds(this.getName());

        return valeurs.get(i);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("\tVecteur : " + this.getName() + " | type : " + this.getType() + " | pointeur : " + this.isPointeur());

        if(valeurs != null) {
            res.append(" | valeurs : ");
            res.append(valeurs.get(0));

            for (int i = 1; i < valeurs.size(); i++)
                res.append(", ").append(valeurs.get(i));
        }

        return res.append(" | param : ").append(this.isParam()).append("\n").toString();
    }
}
