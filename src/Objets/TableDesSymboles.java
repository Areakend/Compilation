package Objets;

import Exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;

public class TableDesSymboles extends Table<TableType, Table> {
    private TableDesSymboles parent;
    private String name;
    private int filsNbr = 0;

    public TableDesSymboles(Tables tables) {
        tables.add(this);
        this.parent = null;
        this.name = "1";
    }

    public TableDesSymboles(Tables tables, TableDesSymboles parent) {
        tables.add(this);
        this.parent = parent;
        this.parent.ajouterFils();
        this.name = this.setName();
    }

    private void ajouterFils() {
        this.filsNbr++;
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
        } catch(AlreadyExistantFonction | WrongRegionDeclaration | NonExistantType | NonExistantStructure e) {
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
        } catch (NonExistantType | AlreadyExistantStructure | WrongRegionDeclaration e) {
        }
    }

    public void ajouterVecteur(String name, String type, ArrayList<String> valeurs) {
        TableType tableType = TableType.VEC;
        TableDesVecteurs tableDesVecteurs = (TableDesVecteurs) this.get(tableType);

        if(tableDesVecteurs == null) {
            tableDesVecteurs = new TableDesVecteurs();
            this.put(tableType, tableDesVecteurs);
        }

        try {
            tableDesVecteurs.ajouterVecteur(this, name, type, valeurs);
        } catch(InvalidVecteurVariableType invalidVecteurVariableType) {
        }
    }

    public String getName() {
        return this.name;
    }

    public TableDesSymboles getParent() {
        return this.parent;
    }

    public Variable getVariable(TableDesSymboles tableDesSymboles, String name) throws NonExistantVariable {
        TableDesVariables tableDesVariables = ((TableDesVariables) tableDesSymboles.get(TableType.VAR));

        if(tableDesVariables != null) {
            Variable variable = tableDesVariables.get(name);

            if (variable != null)
                return variable;
        } else if(tableDesSymboles.getParent().getName().equals("1"))
            throw new NonExistantVariable(name);

        return this.getVariable(tableDesSymboles.getParent(), name);
    }

    private String setName() {
        return this.parent.getName().concat(Integer.toString(this.parent.getFilsNbr()));
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder("TDS : " + this.name + " | PARENT : " + (this.parent != null ? this.parent.getName() : null) + "\n");

        for(HashMap.Entry<TableType, Table> entry : table.entrySet())
            temp.append("\t").append(entry.getValue().toString()).append("\n");

        return temp.toString();
    }

    private int getFilsNbr() {
        return filsNbr;
    }
}
