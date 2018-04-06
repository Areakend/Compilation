package Objets;

public class Variable {
    private String name;
    private String type;
    private String value;


    public Variable(String name, String type) {
        this(name, type, null);
    }

    public Variable(String name, String type, String value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Variable " + this.name + " : " + this.type + " = " + this.value;
    }
}
