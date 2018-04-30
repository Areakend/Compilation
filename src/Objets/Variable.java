package Objets;

import Exceptions.InvalidStructureVarName;
import Exceptions.InvalidTypeAffectation;
import Exceptions.NonExistantStructure;

import java.util.ArrayList;

import static Expr.TreeParser.findType;

public class Variable extends VecVar {
    private boolean mut;
    private String valeur;
    private Structure structure;
    private int deplacement;

    Variable(String name, String type, boolean pointeur, int deplacement) {
        super(name, type, pointeur, false, deplacement);
        this.mut = true;
    }

    Variable(String name, boolean mut, String type, String valeur, boolean pointeur, boolean param, int deplacement) {
        super(name, type, pointeur, param, deplacement);
        this.mut = mut;
        this.valeur = valeur;
    }

    Variable(String name, String structureName, TableDesSymboles tableDesSymboles, ArrayList<String> structureVariables, ArrayList<ArrayList<String>> structureValeurs, int deplacement) {
        this.setName(name);
        this.deplacement = deplacement;

        try {
            this.setStructure(tableDesSymboles, structureName, structureVariables, structureValeurs);
        } catch (NonExistantStructure | InvalidTypeAffectation | InvalidStructureVarName e) {
            e.printStackTrace();
        }
    }

    Variable(String name, Structure structure, boolean pointeur) {
        this.setName(name);
        this.structure = new Structure(structure);
        this.setParam();
        this.setPointeur(pointeur);
    }

    public Structure getStructure() throws NonExistantStructure {
        if (structure == null)
            throw new NonExistantStructure(" null ");
        return structure;
    }

    private void setStructure(TableDesSymboles tableDesSymboles, String structureName, ArrayList<String> structureNewVariables, ArrayList<ArrayList<String>> structureNewValeurs) throws InvalidTypeAffectation, NonExistantStructure, InvalidStructureVarName {
        Structure structureModel = tableDesSymboles.getStructure(tableDesSymboles, structureName, true);

        if (structureModel != null) {
            this.structure = new Structure(structureModel);
            ArrayList<String> structureVariables = this.structure.getNames();
            ArrayList<String> structureTypes = this.structure.getTypes();

            for (int i = 0; i < structureNewVariables.size(); i++) {
                String structureNewVariable = structureNewVariables.get(i);
                String typeVariable = findType(structureNewValeurs.get(i).get(0));
                int variablePos = -1;

                for (int j = 0; j < structureVariables.size(); j++) {
                    if (structureNewVariable.equals(structureVariables.get(j))) {
                        variablePos = i;

                        if (!typeVariable.equals(structureTypes.get(j)))
                            throw new InvalidTypeAffectation(this.getName(), structureTypes.get(j), typeVariable);
                    }
                }

                if(variablePos == -1)
                    throw new InvalidStructureVarName(structureName, structureVariables.get(i), structureNewVariable);
                else if (this.structure.getVecteurs().get(i))
                    ((Vecteur) this.structure.getVecVars().get(i)).setValeurs(structureNewValeurs.get(i));
                else ((Variable) this.structure.getVecVars().get(i)).setValeur(structureNewValeurs.get(i).get(0));
            }
        }
    }

    public void modifierValeurStructure(String name, String valeur) {
        for (VecVar variable : this.structure.getVecVars())
            if (variable.getName().equals(name))
                ((Variable) variable).setValeur(valeur);
    }

    public void modifierValeurStructure(String name, ArrayList<String> valeurs) {
        for (VecVar vecteur : this.structure.getVecVars())
            if (vecteur.getName().equals(name))
                ((Vecteur) vecteur).setValeurs(valeurs);
    }

    public String getValeur() {
        return this.valeur;
    }

    public boolean isMut() {
        return mut;
    }

    public void setMut(boolean mut) {
        this.mut = mut;
    }

    private void setValeur(String valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        if(this.structure == null)
            return "\tVariable : " + this.getName() + " | type : " + this.getType() + " | mut : " + this.mut + " | pointeur : " + this.isPointeur() + (this.valeur == null ? "" : " | valeur : " + this.valeur) + " | param : " + this.isParam()+ " | deplacement : " + this.deplacement + "\n";
        else {
            StringBuilder res = new StringBuilder("\tVariable : " + this.getName() + " | structure : " + this.structure.getStructureName() + " | param : " + this.isParam() + " | pointeur : " + this.isPointeur()+ " | deplacement : " + this.deplacement + "\n");
            ArrayList<String> names = this.structure.getNames();

            for(int i = 0; i < names.size(); i++)
                res.append("\t").append("\t").append(this.structure.getVecVars().get(i));

            return res.append("\n").toString();
        }
    }
}
