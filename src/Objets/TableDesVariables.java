package Objets;

import Exceptions.NonExistantVariable;
import Exceptions.NonInitialisedVariable;
import Exceptions.NonMutable;

import java.util.HashMap;

public class TableDesVariables extends Table<String, Variable> {

    public void ajouterVariable(TableDesSymboles tableSymboles, String name, boolean mut, String value) throws NonMutable {
        Variable variable = ((TableDesVariables) tableSymboles.get(TableType.VAR)).get(name);
        if(variable != null) {
            try {
                if(variable.getValue() != null && !variable.isMut())
                    throw new NonMutable(name);
                else tableSymboles.get(TableType.VAR).put(name, new Variable(name, mut, value, false));
            } catch(NonInitialisedVariable nonInitialisedVariable) {
            }
        } else if(tableSymboles.getParent().get(TableType.VAR) == null || tableSymboles.getParent().getName().equals("1"))
            this.put(name, new Variable(name, mut, value,false));
        else {
            this.ajouterVariable(tableSymboles.getParent(), name, mut, value);
        }
    }

    public String getValeurVariable(TableDesSymboles tableSymboles, String name) throws NonExistantVariable {
        Variable variable = ((TableDesVariables) tableSymboles.get(TableType.VAR)).get(name);

        if(variable != null) {
            try {
                return variable.getValue();
            } catch(NonInitialisedVariable nonInitialisedVariable) {
            }
        } else if(tableSymboles.getParent() == null)
            throw new NonExistantVariable(name);

        return this.getValeurVariable(tableSymboles.getParent(), name);
    }

    @Override
    public String toString() {
        StringBuilder stringVariables = new StringBuilder("Variables : \n");

        for(HashMap.Entry<String, Variable> entry : table.entrySet())
            stringVariables.append("\t").append(entry.getValue().toString());

        return stringVariables.toString();
    }
}