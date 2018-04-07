package Objets;

import Exceptions.DoubleDecl;

import java.util.ArrayList;
import java.util.HashMap;

public class TableDesSymboles extends Table<TableType, Table> {
    private String name;
    private TableDesSymboles parent;

    public TableDesSymboles(String name, TableDesSymboles parent) {
        this.name = name;
        this.parent = parent;
    }

    public void ajouterVariable(String name, boolean mut, String value) throws DoubleDecl {
        TableType tableType = TableType.VAR;
        TableDesVariables tableDesVariables = (TableDesVariables) this.get(tableType);

        if(tableDesVariables == null) {
            tableDesVariables = new TableDesVariables();
            this.put(tableType, tableDesVariables);
        }

        tableDesVariables.ajouterVariable(name, mut, value);
    }

    public void ajouterFonction(String id, String typeRetour, ArrayList<Argument> arguments) throws DoubleDecl {
        TableType tableType = TableType.FONC;
        TableDesFonctions foncTab = (TableDesFonctions) this.get(tableType);

        if(foncTab == null) {
            foncTab = new TableDesFonctions();
            this.put(tableType, foncTab);
        }

        foncTab.ajouterFonction(id, typeRetour, arguments);
    }

    public void ajouterFonction(String id, ArrayList<Argument> arguments) throws DoubleDecl {
        TableType tableType = TableType.FONC;
        TableDesFonctions foncTab = (TableDesFonctions) this.get(tableType);

        if(foncTab == null) {
            foncTab = new TableDesFonctions();
            this.put(tableType, foncTab);
        }

        foncTab.ajouterFonction(id, arguments);
    }

    public String getName() {
        return this.name;
    }

    public TableDesSymboles getParent() {
        return this.parent;
    }

    public void setParent(TableDesSymboles parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder("TDS : " + this.name + " : PARENT : " + this.parent != null ? this.parent.getName() : null + "\n");

        for(HashMap.Entry<TableType, Table> entry : table.entrySet())
            temp.append("\t").append(entry.getValue().toString()).append("\n");

        return temp.toString();
    }
}
