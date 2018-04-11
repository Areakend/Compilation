package Objets;

import Exceptions.*;

import java.util.ArrayList;

import static Expr.TreeParser.findType;

public class Variable {
    private String name;
    private boolean mut;
    private String value;
    private Structure structure;
	private ArrayList<String> structureValeurs;
    private boolean pointeur;
    private boolean param;
    String type;

    Variable(String name, boolean mut, String type, String value, boolean pointeur, boolean param) {
        this.name = name;
        this.mut = mut;
        this.type = type;
        this.value = value;
        this.pointeur = pointeur;
        this.param = param;
    }

    Variable(String name, String structureName, TableDesSymboles tableDesSymboles, ArrayList<String> structureVariables, ArrayList<String> structureValeurs) {
        this.name = name;

        try {
            this.setStructure(tableDesSymboles, structureName, structureVariables, structureValeurs);
        } catch(NonExistantStructure | InvalidTypeAffectation | InvalidStructureVarName e) {
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

    public String getType() {
        return type;
    }

    public boolean isParam() {
        return param;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setStructure(TableDesSymboles tableDesSymboles, String structureName, ArrayList<String> structureNewVariables, ArrayList<String> structureNewValeurs) throws InvalidTypeAffectation, NonExistantStructure, InvalidStructureVarName {
        Structure structure = tableDesSymboles.getStructure(tableDesSymboles, structureName);
        ArrayList<String> valeurs = new ArrayList<>();

        if(structure != null) {
            this.structure = structure;
            ArrayList<String> structureVariables = structure.getNames();
            ArrayList<String> structureTypes = structure.getTypes();

            for(int i = 0; i < structureNewVariables.size(); i++) {
                String structureNewVariable = structureNewVariables.get(i);
                String typeVariable = findType(structureNewVariable);

                for(int j = 0; j < structureVariables.size(); i++) {
                    if(structureNewVariable.equals(structureVariables.get(j))) {
                        if(typeVariable.equals(structureTypes.get(i)))
                            valeurs.add(structureNewValeurs.get(i));
                        else throw new InvalidTypeAffectation(name, structureTypes.get(j), typeVariable);
                    } else throw new InvalidStructureVarName(structureName, structureVariables.get(i), structureNewVariables.get(i));
                }
            }
        }

        this.structureValeurs = valeurs;
    }

    public void modifierValeurStructure(String name, String valeur) {
        this.structureValeurs.set(this.structureValeurs.indexOf(name), valeur);
    }

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
        return "\tVariable : " + this.name + " | type : " + this.type + " | mut : " + this.mut + " | pointeur : " + this.pointeur + " | val : " + this.value + " | param : " + this.param + "\n";
    }
}
