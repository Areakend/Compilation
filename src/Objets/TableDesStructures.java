package Objets;

import Exceptions.AlreadyExistantStructure;
import Exceptions.InvalidTypeAffectation;
import Exceptions.NonExistantStructureVariable;

import java.util.ArrayList;
import java.util.HashMap;

public class TableDesStructures extends Table<String, Structure> {
    public void ajouterStructure(TableDesSymboles tableSymboles, String name, ArrayList<String> names, ArrayList<String> types) throws AlreadyExistantStructure {
        Structure structure = ((TableDesStructures) tableSymboles.get(TableType.STRUCT)).get(name);

        if(structure != null)
            throw new AlreadyExistantStructure(name);
        else if(tableSymboles.getParent() == null)
            this.put(name, new Structure(name, names, types));
        else this.ajouterStructure(tableSymboles.getParent(), name, names, types);
    }

    public void modifierValeurStructure(String name, String valeur, String type) throws NonExistantStructureVariable, InvalidTypeAffectation {
        Structure structure = this.get(name);
        ArrayList<String> names = structure.getNames();
        int pos;

        for(pos = 0; pos < names.size(); pos++) {
            if(names.get(pos).equals(name)) {
                String valeurType = structure.getTypes().get(pos);

                if(valeurType.equals(type))
                    throw new InvalidTypeAffectation(name, valeurType, type);
                else this.get(name).setValeur(pos, valeur);
            }
        }

        throw new NonExistantStructureVariable(structure.getStructureName(), names.get(pos));
    }

    @Override
    public String toString() {
        StringBuilder stringStructures = new StringBuilder();

        for(HashMap.Entry<String, Structure> entry : table.entrySet())
            stringStructures.append("\t").append(entry.getValue().toString()).append("\n");

        return stringStructures.toString();
    }
}