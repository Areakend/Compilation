package Objets;

import Exceptions.IndexOutOfBounds;

import java.util.ArrayList;

public class Vecteur extends VecVar {
    private ArrayList<String> valeurs;

    public Vecteur(String name, String type, boolean pointeur, boolean param) {
        this(name, type, null, pointeur, param);
    }

    Vecteur(String name, String type, ArrayList<String> valeurs, boolean pointeur, boolean param) {
        super(name, type, pointeur, param);
        this.valeurs = valeurs;
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

    public String getValeur(int i) throws IndexOutOfBounds {
        if (i > this.valeurs.size())
            throw new IndexOutOfBounds(name);

        return valeurs.get(i);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("\tVecteur : " + this.name + " | type : " + this.type + " | pointeur : " + this.pointeur);

        if(valeurs != null) {
            res.append(" | valeurs : ");
            res.append(valeurs.get(0));

            for (int i = 1; i < valeurs.size(); i++)
                res.append(", ").append(valeurs.get(i));
        }

        return res.append(" | param : ").append(this.param).append("\n").toString();
    }
}
