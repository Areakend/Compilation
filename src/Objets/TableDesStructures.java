package Objets;

import Exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;

public class TableDesStructures extends Table<String, Structure> {
    public void ajouterStructure(TableDesSymboles tableSymboles, String name, ArrayList<String> names, ArrayList<String> types) throws AlreadyExistantStructure, NonSameNumberNamesTypes, NonExistantType {
        this.ajouterStructure(tableSymboles, name, names, types, new ArrayList<>());
    }

    public void ajouterStructure(TableDesSymboles tableSymboles, String name, ArrayList<String> names, ArrayList<String> types, ArrayList<String> structuresNames) throws AlreadyExistantStructure, NonSameNumberNamesTypes, NonExistantType {
        ArrayList<String> newStructureNames = structuresNames;
        TableDesStructures structuresTable = ((TableDesStructures) tableSymboles.get(TableType.STRUCT));
        Structure structure = structuresTable.get(name);

        newStructureNames.addAll(structuresTable.getTable().keySet());

        if(structure != null)
            throw new AlreadyExistantStructure(name);
        else if(tableSymboles.getParent() == null) {
            if(names.size() != types.size())
                throw new NonSameNumberNamesTypes(name);

            for(int i = 0; i < names.size(); i++) {
                String type = types.get(i);

                if(type.equals("bool") || type.equals("i32") || newStructureNames.contains(type))
                    this.put(name, new Structure(name, names, types));
                else throw new NonExistantType(type);
            }

        } else this.ajouterStructure(tableSymboles.getParent(), name, names, types, newStructureNames);
    }

    @Override
    public String toString() {
        StringBuilder stringStructures = new StringBuilder("Structures : \n");

        for(HashMap.Entry<String, Structure> entry : table.entrySet())
            stringStructures.append("\t").append(entry.getValue().toString()).append("\n");

        return stringStructures.toString();
    }
}