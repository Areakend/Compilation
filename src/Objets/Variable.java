package Objets;

import Exceptions.NonExistantStructure;
import Exceptions.NonInitialisedVariable;

import java.util.ArrayList;

public class Variable {
    private String name;
    private boolean mut;
    private String value;
    private Structure structure;
    private ArrayList<String> structureVariables;

    public Variable(String name) {
        this(name, false, null);
    }

    public Variable(String name, boolean mut, String value) {
        this.name = name;
        this.mut = mut;
        this.value = value;
    }

    public Variable(String name, boolean mut, String structureName, ArrayList<String> structureVariables) {
        this.name = name;
        this.mut = mut;

        try {
            this.setStructure(structureName, structureVariables);
        } catch(NonExistantStructure nonExistantStructure) {
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStructure(String structureName, ArrayList<String> structureVariables) throws NonExistantStructure {
        //parcours de l'ensemble des structures
        throw new NonExistantStructure(structureName);
        //parcours des types d'entrées par rapport à ceux de la struct + affectation
        //throw new InvalidType(name);
    }

    public String getValue() throws NonInitialisedVariable {
        if(value == null)
            throw new NonInitialisedVariable(this.name);

        return value;
    }

    public boolean isMut() {
        return mut;
    }

    public void setMut(boolean mut) {
        this.mut = mut;
    }

    @Override
    public String toString() {
        return "Variable " + this.name + " " + this.mut + " = " + this.value + "\n";
    }
}
