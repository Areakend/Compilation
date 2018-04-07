package Objets;

import Exceptions.DoubleDecl;

import java.util.ArrayList;
import java.util.HashMap;

public class TableDesFonctions extends Table<String, Fonction> {
    public void ajouterFonction(String name, String returnType, ArrayList<Argument> args) throws DoubleDecl {
        if(this.get(name) != null)
            throw new DoubleDecl(name);

        this.put(name, new Fonction(name, returnType, args));
    }

    public void ajouterFonction(String name, ArrayList<Argument> args) throws DoubleDecl {
        if(this.get(name) != null)
            throw new DoubleDecl(name);

        this.put(name, new Fonction(name, args));
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();

        for(HashMap.Entry<String, Fonction> entry : table.entrySet())
            temp.append("\t").append(entry.getValue().toString()).append("\n");

        return temp.toString();
    }
}
