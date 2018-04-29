package Objets;

import Exceptions.AlreadyExistantStructure;
import Exceptions.InvalidTypeAffectation;
import Exceptions.NonExistantVariable;
import Exceptions.NonMutable;

import java.util.ArrayList;
import java.util.HashMap;

public class TableDesVariables extends Table<String, Variable> {
    void ajouterVariable(TableDesSymboles tableSymboles, String name, boolean mut, String type, String value, boolean pointeur, boolean param, int deplacement) throws NonMutable, InvalidTypeAffectation {
        Variable variable = ((TableDesVariables) tableSymboles.get(TableType.VAR)).get(name);

        if (variable != null) {
            if (variable.getValeur() != null && !variable.isMut())
                throw new NonMutable(name);

            if (variable.getValeur() != null && value == null)
                value = variable.getValeur();

            if (!variable.getType().equals(type) && !variable.getType().equals(""))
                throw new InvalidTypeAffectation(name, variable.getType(), type);
            else tableSymboles.get(TableType.VAR).put(name, new Variable(name, variable.isMut(), type, value, variable.isPointeur(), variable.isParam(), deplacement));
        } else if (tableSymboles.getParent().get(TableType.VAR) == null || tableSymboles.getParent().getName().equals("1"))
            this.put(name, new Variable(name, mut, type, value, pointeur, param, deplacement));
        else this.ajouterVariable(tableSymboles.getParent(), name, mut, type, value, pointeur, param, deplacement);
    }

    void ajouterStructureVariable(TableDesSymboles tableSymboles, String name, String structureName, ArrayList<String> structureVariables, ArrayList<ArrayList<String>> structureValeurs, boolean pointeur) {
        Variable variable = ((TableDesVariables) tableSymboles.get(TableType.VAR)).get(name);

        if (variable != null)
            tableSymboles.get(TableType.VAR).put(name, new Variable(name, structureName, tableSymboles, structureVariables, structureValeurs));
        else if (tableSymboles.getParent().get(TableType.VAR) == null || tableSymboles.getParent().getName().equals("1"))
            this.put(name, new Variable(name, structureName, tableSymboles, structureVariables, structureValeurs));
        else this.ajouterStructureVariable(tableSymboles.getParent(), name, structureName, structureVariables, structureValeurs, pointeur);
    }

    void ajouterArgumentStructure(TableDesSymboles tableSymboles, String name, Structure structure, boolean pointeur) throws AlreadyExistantStructure {
        Variable variable = ((TableDesVariables) tableSymboles.get(TableType.VAR)).get(name);

        if (variable != null)
            throw new AlreadyExistantStructure(name);
        else if (tableSymboles.getParent().get(TableType.VAR) == null || tableSymboles.getParent().getName().equals("1"))
            this.put(name, new Variable(name, structure, pointeur));
        else this.ajouterArgumentStructure(tableSymboles.getParent(), name, structure, pointeur);
    }

    private String getValeurVariable(TableDesSymboles tableSymboles, String name) throws NonExistantVariable {
        Variable variable = ((TableDesVariables) tableSymboles.get(TableType.VAR)).get(name);

        if (variable != null) {
            return variable.getValeur();
        } else if (tableSymboles.getParent() == null)
            throw new NonExistantVariable(name);

        return this.getValeurVariable(tableSymboles.getParent(), name);
    }

    @Override
    public String toString() {
        StringBuilder stringVariables = new StringBuilder("Variables : \n");

        for (HashMap.Entry<String, Variable> entry : table.entrySet())
            stringVariables.append("\t").append(entry.getValue().toString());

        return stringVariables.toString();
    }
}