package Objets;

public class Variable {
    private String name;
    private boolean mut;
    private String type;
    private String value;

    public Variable(String name, String type) {
        this(name, type, null, false);
    }

    public Variable(String name, String type, String value, boolean mut) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.mut = mut;
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

    public boolean isMut() {
        return mut;
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

    public void setMut(boolean mut) {
        this.mut = mut;
    }

    @Override
    public String toString() {
        return "Variable " + this.name + " " + this.mut + " : " + this.type + " = " + this.value + "\n";
    }
}
