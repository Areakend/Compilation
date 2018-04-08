package Objets;

public enum TableType {
    VAR("Variables"),
    FONC("Fonctions"),
    STRUCT("Structures"),
    VEC("Vecteur");

    private String name;

    TableType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
