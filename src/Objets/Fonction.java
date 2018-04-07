package Objets;

public class Fonction {
    private String name;
    private String returnType;
    private Arguments args;

    public Fonction(String name, String returnType, Arguments args) {
        this.name = name;
        this.returnType = returnType;
        this.args = args;
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

    public Arguments getArgs() {
        return args;
    }

    public void setArgs(Arguments args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "Fonction " + this.name + " " + this.returnType + this.args + "\n";
    }
}