package Objets;

import Exceptions.DoubleDecl;
import Exceptions.NonExistantVariable;
import Exceptions.NonMutable;

import java.util.HashMap;

public class TableDesVariables extends Table<String, Variable> {
    public void ajouterVariable(String name) throws DoubleDecl {
        this.ajouterVariable(name, false, null);
    }

    public void ajouterVariable(String name, boolean mut, String value) throws DoubleDecl {
        if (this.get(name) != null)
            throw new DoubleDecl(name);

        this.put(name, new Variable(name, mut, value));
    }

    public void modifierValeurVariable(String name, String value) throws NonMutable {
        Variable variable = this.get(name);

        if(variable.getValue() != null && !variable.isMut())
            throw new NonMutable(name);
        else this.get(name).setName(value);
    }

    public String getValeurVariable(TableDesSymboles tableSymboles, String name) throws NonExistantVariable {
        Variable var = tableSymboles.get().get(name);
       // (TableDesVariables)tableSymboles.getParent().get(TableType.VAR);
        if(var != null)
            return var.getValue();
        else if(tableSymboles.getParent() != null)
            getValeurVariable(tableSymboles.getParent(), name);
        else throw new NonExistantVariable(name);
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();

        for (HashMap.Entry<String, Variable> entry : table.entrySet())
            temp.append("\t").append(entry.getValue().toString()).append("\n");

        return temp.toString();
    }
}