package Objets;

import Exceptions.InvalidVecteurVariableType;
import Exceptions.NonExistantVecteur;

import java.util.ArrayList;
import java.util.HashMap;

import static Expr.TreeParser.findType;

public class TableDesVecteurs extends Table<String, Vecteur> {
    public void ajouterVecteur(TableDesSymboles tableSymboles, String name, String type, ArrayList<String> valeurs) throws InvalidVecteurVariableType {
        Vecteur vecteur = ((TableDesVecteurs) tableSymboles.get(TableType.VEC)).get(name);

        if(vecteur != null)
            tableSymboles.get(TableType.VEC).put(name, new Vecteur(name, type, valeurs));
        else if(tableSymboles.getParent() == null) {
            for (int i = 0; i<valeurs.size(); i++) {
                if (!findType(valeurs.get(i)).equals(type))
        		    throw new InvalidVecteurVariableType(name, type, valeurs.get(i), findType(valeurs.get(i)));
            }

            this.put(name, new Vecteur(name, type, valeurs));
        } else this.ajouterVecteur(tableSymboles.getParent(), name, type, valeurs);
    }

    public Vecteur getVecteur(TableDesSymboles tableSymboles, String name) throws NonExistantVecteur {
        Vecteur vecteur = ((TableDesVecteurs) tableSymboles.get(TableType.VEC)).get(name);

        if(vecteur != null)
            return vecteur;
        else if(tableSymboles.getParent() == null)
            throw new NonExistantVecteur(name);

        return this.getVecteur(tableSymboles.getParent(), name);
    }

    @Override
    public String toString() {
        StringBuilder stringVecteurs = new StringBuilder("Vecteurs : \n");

        for(HashMap.Entry<String, Vecteur> entry : table.entrySet())
            stringVecteurs.append("\t").append(entry.getValue().toString()).append("\n");

        return stringVecteurs.toString();
    }
}