package Objets;

import Exceptions.*;

import java.util.HashMap;

public class TableDesFonctions extends Table<String, Fonction> {
    public void ajouterFonction(TableDesSymboles tableSymboles, String name, String returnType, Arguments args) throws AlreadyExistantFonction, WrongRegionDeclaration {
        Fonction fonction = ((TableDesFonctions) tableSymboles.get(TableType.FONC)).get(name);

        if(!tableSymboles.getName().equals("1"))
            throw new WrongRegionDeclaration(name);
        else if(fonction != null && fonction.getArgs().getTypes().equals(args.getTypes()) && fonction.getReturnType().equals(returnType))
            throw new AlreadyExistantFonction(name);
        else {
            /*
            for(int i = 0; i < names.size(); i++) {
                String type = types.get(i);

                if(type.equals("bool") || type.equals("i32") || fonctionsTable.get(name) != null)
                    this.put(name, new Fonction(name, returnType, args));
                else throw new NonExistantType(type);
            }
            */
        }
    }

    public Fonction getFonction(TableDesSymboles tableSymboles, String name) throws NonExistantFunction {
        Fonction fonction = ((TableDesFonctions) tableSymboles.get(TableType.FONC)).get(name);

        if(!tableSymboles.getName().equals("1"))
            return this.getFonction(tableSymboles.getParent(), name);
        else if(fonction != null)
            return fonction;

        throw new NonExistantFunction(name);
    }

    @Override
    public String toString() {
        StringBuilder stringFonctions = new StringBuilder("Fonctions : \n");

        for(HashMap.Entry<String, Fonction> entry : table.entrySet())
            stringFonctions.append("\t").append(entry.getValue().toString()).append("\n");

        return stringFonctions.toString();
    }
}
