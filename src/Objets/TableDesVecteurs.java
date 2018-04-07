package Objets;

import Exceptions.NonExistantVariable;

import java.util.ArrayList;
import java.util.HashMap;

public class TableDesVecteurs extends Table<String, Vecteur> {
     public void ajouterVecteur(TableDesSymboles tableSymboles, String name, String type, ArrayList<String> valeurs) {
        Vecteur vecteur = this.get(name);

        if(vecteur != null) {
            this.get(name).setValue(valeurs);
        } else if(tableSymboles.getParent() == null)
            this.put(name, new Vecteur(name, type, valeurs));
        else this.ajouterVecteur(tableSymboles.getParent(), name, type, valeurs);
    }

    public Vecteur getVecteur(TableDesSymboles tableSymboles, String name) throws NonExistantVariable {
        Vecteur vecteur = ((TableDesVecteurs)tableSymboles.getParent().get(TableType.VEC)).get(name);

        if(vecteur != null)
            return vecteur;
        else if(tableSymboles.getParent() == null)
            throw new NonExistantVariable(name);

        return this.getVecteur(tableSymboles.getParent(), name);
    }

    @Override
    public String toString() {
        StringBuilder stringVecteurs = new StringBuilder();

        for (HashMap.Entry<String, Vecteur> entry : table.entrySet())
            stringVecteurs.append("\t").append(entry.getValue().toString()).append("\n");

        return stringVecteurs.toString();
    }
}