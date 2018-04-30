package Objets;

import java.util.ArrayList;

public class Structure {
    private String structureName;
    private ArrayList<VecVar> vecVars;
    private ArrayList<Boolean> vecteurs;

    Structure(Structure structure) {
        this(structure.getStructureName(), structure.getNames(), structure.getTypes(), structure.getPointeurs(), structure.getVecteurs());
    }

    Structure(String structureName, ArrayList<String> names, ArrayList<String> types, ArrayList<Boolean> pointeurs, ArrayList<Boolean> vecteurs) {
        this.structureName = structureName;
        this.vecVars = new ArrayList<>(names.size());
        this.vecteurs = vecteurs;

        for (int i = 0; i < names.size(); i++) {
            if(this.vecteurs.get(i))
                this.vecVars.add(new Vecteur(names.get(i), types.get(i), pointeurs.get(i)));
            else this.vecVars.add(new Variable(names.get(i), types.get(i), pointeurs.get(i)));
        }
    }

    public String getStructureName() {
        return this.structureName;
    }

    public ArrayList<String> getNames() {
        ArrayList<String> names = new ArrayList<>(this.vecVars.size());

        for (VecVar vecVar : this.vecVars)
            names.add(vecVar.getName());

        return names;
    }

    ArrayList<String> getTypes() {
        ArrayList<String> types = new ArrayList<>(this.vecVars.size());

        for (VecVar vecVar : this.vecVars)
            types.add(vecVar.getType());

        return types;
    }

    public ArrayList<Boolean> getPointeurs() {
        ArrayList<Boolean> pointeurs = new ArrayList<>(this.vecVars.size());

        for (VecVar vecVar : this.vecVars)
            pointeurs.add(vecVar.isPointeur());

        return pointeurs;
    }

    ArrayList<Boolean> getVecteurs() {
        return this.vecteurs;
    }

    ArrayList<VecVar> getVecVars() {
        return this.vecVars;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("\tStructure " + this.structureName + " :\n");

        for (VecVar vecVar : this.vecVars)
            res.append("\t").append("\t").append(vecVar);

        return res.append("\n").toString();
    }
}
