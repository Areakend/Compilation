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
        this.setTypeRetour(returnType);
        this.setArguments(arguments);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public void setArgs(ArrayList<Argument> args) {
        this.args = args;
    }

    public String getName() {
        return name;
    }

    public String getReturnType() {
        return returnType;
    }

    public ArrayList<Argument> getArgs() {
        return args;
    }

    @Override
    public String toString() {
        String res = this.name + " " + this.returnType;

        for(int i = 0; i < this.args.size(); i++) {
            res += " ARG : " + this.args.get(i);
        }

        return res;
    }
}