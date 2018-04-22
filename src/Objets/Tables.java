package Objets;

import java.util.ArrayList;

public class Tables {
    private ArrayList<Table> tables = new ArrayList<>();

    void add(Table t) {
        this.tables.add(t);
    }

    public Table get(int i) {
        return this.tables.get(i);
    }

    public Table getTablesById(String id) {
        for (Table table : tables)
            if (((TableDesSymboles) table).getName().equals(id))
                return table;

        return null;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        for (Table table : tables)
            res.append(table.toString());

        return res.toString();
    }
}
