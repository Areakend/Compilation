package Objets;

import java.util.ArrayList;

public class Fonction {
    private String name;
    private String returnType;
    private ArrayList<Argument> args;

    public Fonction(String id, ArrayList<Argument> args) {
        this(id, null, args);
    }

    public Fonction(String name, String returnType, ArrayList<Argument> arguments) {
        this.setName(name);
        this.setReturnType(returnType);
        this.setArgs(arguments);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public ArrayList<Argument> getArgs() {
        return args;
    }

    public void setArgs(ArrayList<Argument> args) {
        this.args = args;
    }

    @Override
    public String toString() {
        String res = "Fonction " + this.name + " " + this.returnType + "\n";

        for(int i = 0; i < this.args.size(); i++) {
            res += "\tArg : " + this.args.get(i) + "\n";
        }

        return res;
    }
}