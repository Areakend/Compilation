package Objets;

import Exceptions.InvalidVecteurVariableType;
import Exceptions.NonExistantVecteur;

import java.util.ArrayList;
import java.util.HashMap;

import static Expr.TreeParser.findType;

public class TableDesVecteurs extends Table<String, Vecteur> {
    void ajouterVecteur(TableDesSymboles tableSymboles, String name, String type, ArrayList<String> valeurs) throws InvalidVecteurVariableType {
        Vecteur vecteur = ((TableDesVecteurs) tableSymboles.get(TableType.VEC)).get(name);

        if (vecteur != null)
            tableSymboles.get(TableType.VEC).put(name, new Vecteur(name, type, valeurs));
        else if (tableSymboles.getParent() == null) {
            for (String valeur : valeurs) {
                if (!findType(valeur).equals(type))
                    throw new InvalidVecteurVariableType(name, type, valeur, findType(valeur));
            }

            this.put(name, new Vecteur(name, type, valeurs));
        } else this.ajouterVecteur(tableSymboles.getParent(), name, type, valeurs);
    }

    public Vecteur getVecteur(TableDesSymboles tableSymboles, String name) throws NonExistantVecteur {
        Vecteur vecteur = ((TableDesVecteurs) tableSymboles.get(TableType.VEC)).get(name);

        if (vecteur != null)
            return vecteur;
        else if (tableSymboles.getParent() == null)
            throw new NonExistantVecteur(name);

        return this.getVecteur(tableSymboles.getParent(), name);
    }

    @Override
    public String toString() {
        StringBuilder stringVecteurs = new StringBuilder();

        for (HashMap.Entry<String, Vecteur> entry : table.entrySet())
            stringVecteurs.append("\t").append(entry.getValue().toString());

        return stringVecteurs.toString();
    }
}