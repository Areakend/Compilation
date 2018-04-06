package Objets;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public abstract class Table<K,V> {

	protected HashMap<K,V> table;

	public Table(HashMap<K, V> table) {
		super();
		this.table = table;
	}

	public V get(K key)
	{
		return table.get(key);
	}
	
	public void put(K key,V value)
	{
		this.table.put(key, value);
		
		
		
	}
	
	public Set<Entry<K,V>> entrySet()
	{
		return this.table.entrySet();
	}
	
	
	

}