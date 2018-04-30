package Objets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Offsets {

    public ArrayList<Offset> tableDesOffsets = new ArrayList<>();

    public void add(Offset offset) {
        this.tableDesOffsets.add(offset);
    }

    public boolean isInOffsets(String name, String tdsId) {
        for (int i=0; i<this.tableDesOffsets.size(); i++) {
            if (this.tableDesOffsets.get(i).getNameVar().equals(name) && (this.tableDesOffsets.get(i).getTdsId().equals(tdsId))) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder stringOffsets = new StringBuilder("Offsets : \n");

        for (int i=0; i<this.tableDesOffsets.size(); i++)
            stringOffsets.append("\t").append(this.tableDesOffsets.get(i).toString());

        return stringOffsets.toString();
    }
}
