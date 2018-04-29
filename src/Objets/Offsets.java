package Objets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Offsets {

    private HashMap<String,Offset> tableDesOffsets = new HashMap<>();

    public void add(String name, Offset offset) {
        this.tableDesOffsets.put(name,offset);
    }

    @Override
    public String toString() {
        StringBuilder stringOffsets = new StringBuilder("Offsets : \n");

        for (HashMap.Entry<String, Offset> entry : tableDesOffsets.entrySet())
            stringOffsets.append("\t").append(entry.getKey().toString()).append(entry.getValue().toString());

        return stringOffsets.toString();
    }
}
