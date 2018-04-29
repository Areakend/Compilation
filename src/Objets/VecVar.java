package Objets;

public abstract class VecVar {
    String name;
    String type;
    boolean pointeur;
    boolean param;

    VecVar() {}

    VecVar(String name, String type, boolean pointeur, boolean param) {
        this.name = name;
        this.type = type;
        this.pointeur = pointeur;
        this.param = param;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    boolean isParam() {
        return param;
    }

    boolean isPointeur() {
        return this.pointeur;
    }

    @Override
    public abstract String toString();
}
