package Objets;

import java.util.ArrayList;

public class Arguments {
    private ArrayList<String> names;
    private ArrayList<String> types;

    public Arguments(ArrayList<String> names, ArrayList<String> types) {
        this.names = names;
        this.types = types;
    }

    public ArrayList<String> getNames() {
        return this.names;
    }

    public ArrayList<String> getTypes() {
        return this.types;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Arguments = " + this.names.get(0) + " : " + this.types.get(0));

        for(int i = 1; i < this.names.size(); i++)
            res.append(", ").append(this.names.get(i)).append(" : ").append(this.types.get(i));

        return res.toString();
    }
}