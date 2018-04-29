package Objets;

public class Offset {

    private String tabId;
    private int deplacement;

    public Offset(String tabId, int deplacement) {
        this.tabId = tabId;
        this.deplacement = deplacement;
    }

    public int getDeplacement() {
        return deplacement;
    }

    public String toString() {
        return "\ttabId : " + this.tabId + " | deplacement : " + this.deplacement + "\n";
    }
}
