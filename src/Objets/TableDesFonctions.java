package Objets;

import java.util.HashMap;

public class TableDesFonctions extends Table<String, Fonction> {
    public void ajouterFonction(String name, String returnType, Arguments args) {
        this.put(name, new Fonction(name, returnType, args));
    }

    @Override
    public String toString() {
        StringBuilder stringFonctions = new StringBuilder();

        for(HashMap.Entry<String, Fonction> entry : table.entrySet())
            stringFonctions.append("\t").append(entry.getValue().toString()).append("\n");

        return stringFonctions.toString();
    }
}
