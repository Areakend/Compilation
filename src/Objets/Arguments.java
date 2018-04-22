package Objets;

import java.util.ArrayList;

public class Arguments {
    private ArrayList<String> names;
    private ArrayList<String> types;
    private ArrayList<Boolean> pointeurs;

    public Arguments(ArrayList<String> names, ArrayList<String> types, ArrayList<Boolean> pointeurs) {
        this.names = names;
        this.types = types;
        this.pointeurs = pointeurs;
    }

    public ArrayList<String> getNames() {
        return this.names;
    }

    public ArrayList<String> getTypes() {
        return this.types;
    }

    public ArrayList<Boolean> getPointeurs() {
        return this.pointeurs;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(this.names.get(0) + " - " + this.types.get(0));

        for (int i = 1; i < this.names.size(); i++)
            res.append(", ").append(this.names.get(i)).append(" - ").append(this.types.get(i));

        return res.toString();
    }
}