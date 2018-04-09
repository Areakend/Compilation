package Objets;

import Exceptions.*;

import java.util.ArrayList;

import static Expr.TreeParser.findType;

public class Variable {
    private String name;
    private boolean mut;
    private String value;
    private Structure structure;
	private ArrayList<String> structureVariables;
    private boolean pointeur;

    public Variable(String name, boolean mut, String value, boolean pointeur) {
        this.name = name;
        this.mut = mut;
        this.value = value;
        this.pointeur= pointeur;
    }

    public Variable(String name, boolean mut, String structureName, TableDesSymboles tableDesSymboles, ArrayList<String> structureVariables, boolean pointeur) {
        this.name = name;
        this.mut = mut;
        this.pointeur= pointeur;

        try {
            this.setStructure(tableDesSymboles, structureName, structureVariables);
        } catch(NonExistantStructure | InvalidTypeAffectation e) {
        }
    }
    
    public Structure getStructure() throws NonExistantStructure {
    	if (structure == null)
    		throw new NonExistantStructure(" null ");
		return structure;
	}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setStructure(TableDesSymboles tableSymboles, String structureName, ArrayList<String> structureNewValeurs) throws NonExistantStructure, InvalidTypeAffectation  {
        Structure structure = tableSymboles.getStructure(tableSymboles, structureName);

        if(structure != null) {
            this.structure = structure;
            this.structureVariables = structure.getValeurs();

            for(int i = 0; i < structureVariables.size(); i++) {
                String var = structureVariables.get(i);

                for(int j = 0; j < structureNewValeurs.size(); i++) {
                    String newVar = structureNewValeurs.get(j);


                        String typeVariable = findType(var);
                        String typeAffect = findType(newVar);

                        if(typeVariable.equals(typeAffect))
                            this.structureVariables.add(structureNewValeurs.get(i));
                        else throw new InvalidTypeAffectation(name, typeVariable, typeAffect);

                }
            }
        } else if(!tableSymboles.getParent().getName().equals("1"))
            throw new NonExistantStructure(structureName);
        else this.setStructure(tableSymboles.getParent(), structureName, structureNewValeurs);
    }

    /*public void modifierValeurStructure(String name, String valeur, String type) throws NonExistantStructureVariable, InvalidTypeAffectation {
        Structure structure = this.get(name);
        ArrayList<String> names = structure.getNames();
        int pos;

        for(pos = 0; pos < names.size(); pos++) {
            if(names.get(pos).equals(name)) {
                String valeurType = structure.getTypes().get(pos);

                if(valeurType.equals(type))
                    throw new InvalidTypeAffectation(name, valeurType, type);
                else this.get(name).setValeur(pos, valeur);
            }
        }

        throw new NonExistantStructureVariable(structure.getStructureName(), names.get(pos));
    }*/

    public String getValue() /*throws NonInitialisedVariable*/ {
        /*if(value == null)
            throw new NonInitialisedVariable(this.name);
        */
        return value;
    }

    public boolean isMut() {
        return mut;
    }
    
    public boolean isPointeur() {
        return this.pointeur;
    }

    public void setMut(boolean mut) {
        this.mut = mut;
    }

    @Override
    public String toString() {
        return "\tVariable : " + this.name + " | mut : " + this.mut + " | val : " + this.value + "\n";
    }
}
