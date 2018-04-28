package Objets;

import Exceptions.*;

import java.util.HashMap;

public class TableDesFonctions extends Table<String, Fonction> {
    void ajouterFonction(TableDesSymboles tableSymboles, String name, String returnType, Arguments args) throws AlreadyExistantFonction, WrongRegionDeclaration, NonExistantType, NonExistantStructure, NonExistantVecteur {
        Fonction fonction = ((TableDesFonctions) tableSymboles.get(TableType.FONC)).get(name);

        if (!tableSymboles.getName().equals("1"))
            throw new WrongRegionDeclaration(name);
        else if (fonction != null && fonction.getArgs().getTypes().equals(args.getTypes()) && fonction.getReturnType().equals(returnType))
            throw new AlreadyExistantFonction(name);
        else {
            if (args != null)
                for (String type : args.getTypes()) {
                    String[] types = type.split(" ");

                    if(types[0].equals("VEC")) {
                        for (String vecType : types)
                            if (!vecType.equals("bool") && !vecType.equals("i32") && !vecType.equals("& bool") && !vecType.equals("& i32") && !vecType.equals("VEC"))
                                throw new NonExistantVecteur(type);
                    } else if (!type.equals("bool") && !type.equals("i32") && !type.equals("& bool") && !type.equals("& i32")/* && (tableSymboles.getStructure(tableSymboles, type) == null)*/)
                        throw new NonExistantType(type);
                }

            if (returnType != null && !returnType.equals("bool") && !returnType.equals("i32") && (tableSymboles.getStructure(tableSymboles, returnType) == null))
                throw new NonExistantType(returnType);

            this.put(name, new Fonction(name, returnType, args));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringFonctions = new StringBuilder("Fonctions : \n");

        for (HashMap.Entry<String, Fonction> entry : table.entrySet())
            stringFonctions.append("\t").append(entry.getValue().toString());

        return stringFonctions.toString();
    }
}
