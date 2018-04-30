package Objets;

import Exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;

public class TableDesSymboles extends Table<TableType, Table> {
    private TableDesSymboles parent;
    private String name;
    private int filsNbr = 0;
    private int currentDeplacement;
    private int precDeplacement;

    public TableDesSymboles(Tables tables) {
        tables.add(this);
        this.parent = null;
        this.name = "1";
        this.currentDeplacement = 0;
        this.precDeplacement = 0;
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

    public void ajouterVariable(String name, boolean mut, String type, String value, boolean pointeur, boolean param, int deplacement, Offsets tabOffsets) {
        TableType tableType = TableType.VAR;
        TableDesVariables tableDesVariables = (TableDesVariables) this.get(tableType);

        if (tableDesVariables == null) {
            tableDesVariables = new TableDesVariables();
            this.put(tableType, tableDesVariables);
        }

        try {
            tableDesVariables.ajouterVariable(this, name, mut, type, value, pointeur, param, deplacement, tabOffsets);
        } catch (NonMutable | InvalidTypeAffectation e) {
            e.printStackTrace();
        }
    }

    public void ajouterStructureVariable(String name, String structureName, ArrayList<String> structureVariables, ArrayList<String> structureValeurs, boolean pointeur) {
        TableType tableType = TableType.VAR;
        TableDesVariables tableDesVariables = (TableDesVariables) this.get(tableType);

        if (tableDesVariables == null) {
            tableDesVariables = new TableDesVariables();
            this.put(tableType, tableDesVariables);
        }

        tableDesVariables.ajouterStructureVariable(this, name, structureName, structureVariables, structureValeurs, pointeur);
    }

    public void ajouterFonction(String name, String returnType, Arguments arguments) {
        TableType tableType = TableType.FONC;
        TableDesFonctions tableDesFonctions = (TableDesFonctions) this.get(tableType);

        if (tableDesFonctions == null) {
            tableDesFonctions = new TableDesFonctions();
            this.put(tableType, tableDesFonctions);
        }

        try {
            tableDesFonctions.ajouterFonction(this, name, returnType, arguments);
        } catch (AlreadyExistantFonction | WrongRegionDeclaration | NonExistantType | NonExistantStructure | NonExistantVecteur e) {
            e.printStackTrace();
        }
    }

    public void ajouterStructure(String name, ArrayList<String> names, ArrayList<String> types, ArrayList<Boolean> pointeurs) {
        TableType tableType = TableType.STRUCT;
        TableDesStructures tableDesStructures = (TableDesStructures) this.get(tableType);

        if (tableDesStructures == null) {
            tableDesStructures = new TableDesStructures();
            this.put(tableType, tableDesStructures);
        }

        try {
            tableDesStructures.ajouterStructure(this, name, names, types, pointeurs);
        } catch (NonExistantType | AlreadyExistantStructure | WrongRegionDeclaration e) {
            e.printStackTrace();
        }
    }

    public void ajouterVecteur(String name, String type, ArrayList<String> valeurs, boolean pointeur, boolean param) {
        TableType tableType = TableType.VEC;
        TableDesVecteurs tableDesVecteurs = (TableDesVecteurs) this.get(tableType);

        if (tableDesVecteurs == null) {
            tableDesVecteurs = new TableDesVecteurs();
            this.put(tableType, tableDesVecteurs);
        }

        try {
            tableDesVecteurs.ajouterVecteur(this, name, type, valeurs, pointeur, param);
        } catch (InvalidVecteurVariableType | InvalidTypeAffectation e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return this.name;
    }

    TableDesSymboles getParent() {
        return this.parent;
    }

    public Variable getVariable(TableDesSymboles tableDesSymboles, String name, boolean exception) throws NonExistantVariable {
        TableDesVariables tableDesVariables = ((TableDesVariables) tableDesSymboles.get(TableType.VAR));

        if (tableDesVariables != null) {
            Variable variable = tableDesVariables.get(name);

            if (variable != null)
                return variable;
        } else if (tableDesSymboles.getName().equals("1")) {
            if(exception)
                throw new NonExistantVariable(name);
            else return null;
        }

        return this.getVariable(tableDesSymboles.getParent(), name, exception);
    }

    public Fonction getFonction(TableDesSymboles tableDesSymboles, String name) throws NonExistantFunction {
        TableDesFonctions tableDesFonctions;

        if (tableDesSymboles != null)
            tableDesFonctions = ((TableDesFonctions) tableDesSymboles.get(TableType.FONC));
        else throw new NonExistantFunction(name);

        if (tableDesFonctions != null) {
            Fonction fonction = tableDesFonctions.get(name);

            if (fonction != null)
                return fonction;
        }

        return this.getFonction(tableDesSymboles.getParent(), name);
    }

    Structure getStructure(TableDesSymboles tableDesSymboles, String name) throws NonExistantStructure {
        TableDesStructures tableDesStructures;

        if (tableDesSymboles != null)
            tableDesStructures = ((TableDesStructures) tableDesSymboles.get(TableType.STRUCT));
        else throw new NonExistantStructure(name);

        if (tableDesStructures != null) {
            Structure structure = tableDesStructures.get(name);

            if (structure != null)
                return structure;
        } else if (tableDesSymboles.getName().equals("1"))
            throw new NonExistantStructure(name);

        return this.getStructure(tableDesSymboles.getParent(), name);
    }

    public int getCurrentDeplacement() {
        return this.currentDeplacement;
    }

    public void updateDeplacements(int deplacement) {
        this.currentDeplacement=this.currentDeplacement+precDeplacement;
        this.precDeplacement=deplacement;
    }


    private String setName() {
        return this.parent.getName().concat(Integer.toString(this.parent.getFilsNbr()));
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder("TDS : " + this.name + " | PARENT : " + (this.parent != null ? this.parent.getName() : null) + "\n");

        for (HashMap.Entry<TableType, Table> entry : table.entrySet())
            temp.append("\t").append(entry.getValue().toString()).append("\n");

        return temp.toString();
    }

    private int getFilsNbr() {
        return filsNbr;
    }
}
