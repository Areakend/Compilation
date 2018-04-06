package Objets;

public class Attribut extends Variable {
    public Attribut(String name, String type) {
        this(name, type, null);
    }

    public Attribut(String id, String type, String value) {
        super(id, type, value);
    }

    @Override
    public String toString() {
        return "Attribut " + this.getName() + " : " + this.getType() + " = " + this.getValue();
    }
}
