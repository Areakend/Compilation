package Objets;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Table<K, V> {
    protected HashMap<K, V> table = new HashMap<>();

    public V get(K key) {
        return table.get(key);
    }

    public HashMap<K, V> getTable() {
        return table;
    }

    public void put(K key, V value) {
        this.table.put(key, value);
    }

    public Set<Entry<K, V>> entrySet() {
        return this.table.entrySet();
    }
}