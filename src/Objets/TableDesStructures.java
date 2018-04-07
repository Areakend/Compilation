package Objets;

import Exceptions.InvalidType;
import Exceptions.NonExistantStructureVariable;

import java.util.ArrayList;
import java.util.HashMap;

public class TableDesStructures extends Table<String, Structure> {
    public void ajouterStructure(String name, ArrayList<String> names, ArrayList<String> types) {
        this.put(name, new Structure(name, names, types));
    }

    public void modifierValeurStructure(String name, String valeur, String type) throws NonExistantStructureVariable, InvalidType {
        Structure structure = this.get(name);
        ArrayList<String> names = structure.getNames();
        int pos;

        for(pos = 0; pos < names.size(); pos++) {
            if(names.get(pos).equals(name)) {
                String valeurType = structure.getTypes().get(pos);

                if(valeurType.equals(type))
                    throw new InvalidType(name, valeurType, type);
                else this.get(name).setValeur(pos, valeur);
            }
        }

        throw new NonExistantStructureVariable(structure.getStructureName(), names.get(pos));
    }

    @Override
    public String toString() {
        StringBuilder stringStructures = new StringBuilder();

        for (HashMap.Entry<String, Structure> entry : table.entrySet())
            stringStructures.append("\t").append(entry.getValue().toString()).append("\n");

        return stringStructures.toString();
    }
}