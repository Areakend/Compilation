package Objets;

import java.util.ArrayList;

public class Tables {
	private ArrayList<Table> tables = new ArrayList<>();
	
	public void add(Table t) {
		this.tables.add(t);
	}
	
	public Table get(int i) {
		return this.tables.get(i);
	}
	
	public Table getTablesById(String id) {
        for(int i = 0; i < tables.size(); i++)
            if(((TableDesSymboles)tables.get(i)).getName().equals(id))
                return tables.get(i);

        return null;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();

		for(int i = 0; i < tables.size(); i ++)
			res.append(tables.get(i).toString());

		return res.toString();
	}
}
