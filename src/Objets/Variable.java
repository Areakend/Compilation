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

    public Variable(String name) {
        this(name, false, null, false);
    }

    public Variable(String name, boolean mut, String value,boolean pointeur) {
        this.name = name;
        this.mut = mut;
        this.value = value;
        this.pointeur= pointeur;
    }

    public Variable(String name, boolean mut, String structureName, ArrayList<String> structureVariables,boolean pointeur) {
        this.name = name;
        this.mut = mut;
        this.pointeur= pointeur;
        
    /*    try {
            this.setStructure(structureName, structureVariables);
        } catch(NonExistantStructure nonExistantStructure) {
        }
        */
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public void setStructure(TableDesSymboles tableSymboles, String structureName, ArrayList<String> structureNewVariables, ArrayList<String> structureNewValeurs) throws NonExistantStructure, InvalidTypeAffectation  {
        Structure structure = ((TableDesStructures) tableSymboles.get(TableType.STRUCT)).get(name);

        if(structure != null) {
            this.structure = structure;
            this.structureVariables = structure.getValeurs();

            for(int i = 0; i < structureVariables.size(); i++) {
                String var = structureVariables.get(i);

                for(int j = 0; j < structureNewVariables.size(); i++) {
                    String newVar = structureNewVariables.get(j);

                    if() {
                        String typeVariable = findType(var);
                        String typeAffect = findType(newVar);

                        if(typeVariable.equals(typeAffect))
                            this.structureVariables.add(structureNewVariables.get(i));
                        else throw new InvalidTypeAffectation(name, typeVariable, typeAffect);
                    }
                }
            }
        } else if(tableSymboles.getParent() == null)
            throw new NonExistantStructure(structureName);
        else this.setStructure(tableSymboles.getParent(), structureName, structureNewVariables, structureNewVariables);
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
    
    public boolean isPointeur() {
        return mut;
    }

    public void setPointeur(boolean pointeur) {
        this.pointeur = pointeur;
    }

    @Override
    public String toString() {
        return "Variable " + this.name + " " + this.mut + " = " + this.value + " " + this.pointeur +"\n";
    }
}
