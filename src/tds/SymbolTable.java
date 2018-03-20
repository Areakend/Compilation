package tds;

import java.util.HashMap;

public class SymbolTable {
    protected HashMap<String, Symbol> symbolTable;

    public SymbolTable() {
        this.symbolTable = new HashMap<String,Symbol>();
    }

    /*
    public void add(String token, String name,ValueType type, List<ValueType> params, Object value, int adresse) {
        this.symbolTable.put(token, new Symbol(name, type, params, value, adresse));
    }
    */

    public void delete(String token) {
        this.symbolTable.remove(token);
    }
}