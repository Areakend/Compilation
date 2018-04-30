package Objets;

public class Offset {

    private  String nameVar;
    private String tabId;
    private int deplacement;

    public Offset(String nameVar, String tabId, int deplacement) {
        this.nameVar = nameVar;
        this.tabId = tabId;
        this.deplacement = deplacement;
    }

    public int getDeplacement() {
        return deplacement;
    }

    public String getNameVar() {
        return nameVar;
    }

    public String getTdsId() {
        return tabId;
    }

    public String toString() {
        return "Variable : " + this.nameVar + " | tabId : " + this.tabId + " | deplacement : " + this.deplacement + "\n";
    }
}
