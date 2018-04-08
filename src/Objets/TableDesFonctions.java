package Objets;

import Exceptions.AlreadyExistantFonction;
import Exceptions.NonExistantFunction;

import java.util.HashMap;

public class TableDesFonctions extends Table<String, Fonction> {
    public void ajouterFonction(TableDesSymboles tableSymboles, String name, String returnType, Arguments args) throws AlreadyExistantFonction {
        Fonction fonction = ((TableDesFonctions) tableSymboles.get(TableType.FONC)).get(name);

        if(fonction != null && fonction.getArgs().equals(args) && fonction.getReturnType().equals(returnType))
            throw new AlreadyExistantFonction(name);
        else if(tableSymboles.getParent() == null)
            this.put(name, new Fonction(name, returnType, args));
        else this.ajouterFonction(tableSymboles.getParent(), name, returnType, args);
    }

    public Fonction getFonction(TableDesSymboles tableSymboles, String name) throws NonExistantFunction {
        Fonction fonction = ((TableDesFonctions) tableSymboles.get(TableType.FONC)).get(name);

        if(fonction != null)
            return fonction;
        else if(tableSymboles.getParent() == null)
            throw new NonExistantFunction(name);

        return this.getFonction(tableSymboles.getParent(), name);
    }

    @Override
    public String toString() {
        StringBuilder stringFonctions = new StringBuilder();

        for(HashMap.Entry<String, Fonction> entry : table.entrySet())
            stringFonctions.append("\t").append(entry.getValue().toString()).append("\n");

        return stringFonctions.toString();
    }
}
