package Objets;

import Exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;

public class TableDesStructures extends Table<String, Structure> {
    public void ajouterStructure(TableDesSymboles tableSymboles, String name, ArrayList<String> names, ArrayList<String> types) throws AlreadyExistantStructure, NonExistantType, WrongRegionDeclaration {
        TableDesStructures structuresTable = (TableDesStructures) tableSymboles.get(TableType.STRUCT);
        Structure structure = structuresTable.get(name);

        if(!tableSymboles.getName().equals("1"))
            throw new WrongRegionDeclaration(name);
        else if(structure != null)
            throw new AlreadyExistantStructure(name);
        else {
            for(int i = 0; i < names.size(); i++) {
                String type = types.get(i);
                if(!type.equals("bool") && !type.equals("i32") && structuresTable.get(name) != null) {
                	 throw new NonExistantType(type);
                }
                    
            }
            this.put(name, new Structure(name, names, types));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringStructures = new StringBuilder("Structures : \n");

        for(HashMap.Entry<String, Structure> entry : table.entrySet())
            stringStructures.append("\t").append(entry.getValue().toString());

        return stringStructures.toString();
    }
}