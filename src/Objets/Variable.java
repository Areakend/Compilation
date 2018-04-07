package Objets;

public class Variable {
    private String name;
    private boolean mut;
    private String value;

    public Variable(String name) {
        this(name, false, null);
    }

    public Variable(String name, boolean mut, String value) {
        this.name = name;
        this.mut = mut;
        this.value = value;
    }

    public String getName() {
        return name;
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

    public void setValue(String value) {
        this.value = value;
    }

    public void setMut(boolean mut) {
        this.mut = mut;
    }

    @Override
    public String toString() {
        return "Variable " + this.name + " " + this.mut + " = " + this.value + "\n";
    }
}
