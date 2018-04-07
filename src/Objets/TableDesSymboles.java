package Objets;

import Exceptions.AlreadyExistantFonction;
import Exceptions.AlreadyExistantStructure;
import Exceptions.NonMutable;

import java.util.ArrayList;
import java.util.HashMap;

public class TableDesSymboles extends Table<TableType, Table> {
    private TableDesSymboles parent;
    private String name;

    public TableDesSymboles(TableDesSymboles parent) {
        this.parent = parent;
        this.name = this.setName();
    }

    public void ajouterVariable(String name, boolean mut, String value) {
        TableType tableType = TableType.VAR;
        TableDesVariables tableDesVariables = (TableDesVariables) this.get(tableType);

        if(tableDesVariables == null) {
            tableDesVariables = new TableDesVariables();
            this.put(tableType, tableDesVariables);
        }

        try {
            tableDesVariables.ajouterVariable(this, name, mut, value);
        } catch(NonMutable nonMutable) {
        }
    }

    public void ajouterFonction(String name, String returnType, Arguments arguments) {
        TableType tableType = TableType.FONC;
        TableDesFonctions tableDesFonctions = (TableDesFonctions) this.get(tableType);

        if(tableDesFonctions == null) {
            tableDesFonctions = new TableDesFonctions();
            this.put(tableType, tableDesFonctions);
        }

        try {
            tableDesFonctions.ajouterFonction(this, name, returnType, arguments);
        } catch(AlreadyExistantFonction alreadyExistantFonction) {
        }
    }

    public void ajouterStructure(String name, ArrayList<String> names, ArrayList<String> types) {
        TableType tableType = TableType.STRUCT;
        TableDesStructures tableDesStructures = (TableDesStructures) this.get(tableType);

        if(tableDesStructures == null) {
            tableDesStructures = new TableDesStructures();
            this.put(tableType, tableDesStructures);
        }

        try {
            tableDesStructures.ajouterStructure(this, name, names, types);
        } catch(AlreadyExistantStructure alreadyExistantFonction) {
        }
    }

    public void ajouterVecteur(String name, String type, ArrayList<String> valeurs) {
        TableType tableType = TableType.VEC;
        TableDesVecteurs tableDesVecteurs = (TableDesVecteurs) this.get(tableType);

        if(tableDesVecteurs == null) {
            tableDesVecteurs = new TableDesVecteurs();
            this.put(tableType, tableDesVecteurs);
        }

        tableDesVecteurs.ajouterVecteur(this, name, type, valeurs);
    }

    public String getName() {
        return this.name;
    }

    public TableDesSymboles getParent() {
        return this.parent;
    }

    private String setName() {
        int maxName = 0;

        for(int i = 0; i < this.parent.getTable().size(); i++)
            if(Integer.getInteger(parent.getName()) == maxName)
                maxName += 1;

        return this.parent.getName() + String.valueOf(maxName);
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder("TDS : " + this.name + " : PARENT : " + this.parent != null ? this.parent.getName() : null + "\n");

        for(HashMap.Entry<TableType, Table> entry : table.entrySet())
            temp.append("\t").append(entry.getValue().toString()).append("\n");

        return temp.toString();
    }
}
