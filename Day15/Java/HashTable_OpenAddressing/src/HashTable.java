import java.util.LinkedList;
import java.util.List;

public class HashTable {
	static class Entry{
		private int key;
		private String value;
		public Entry(int key, String value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private int SIZE;
	private List<Entry> table[];
	
	public HashTable(int size) {
		SIZE = size;
		table = new List[SIZE];
		for(int i = 0 ; i < SIZE ; i++)
			table[i] = new LinkedList<HashTable.Entry>();
	}
	
	public int h(int k) {
		return k % SIZE;
	}
	
	public void put(int key, String value) {
		//1. find slot corresponding to given key
		int slot = h(key);
		
		//2. update value corresponding to key if it is already prsent
		if(!table[slot].isEmpty()) {
			for(Entry e : table[slot]) {
				if(key == e.key) {
					e.value = value;
					return;
				}
			}
		}
		
		//3. store key value pair into linked list of slot if it is not present
		Entry e = new Entry(key, value);
		table[slot].add(e);
	}
	
	public String get(int key) {
		//1. find slot corresponding to given key
		int slot = h(key);
		
		//2. get value corresponding to key if it is present
		if(!table[slot].isEmpty()) {
			for(Entry e : table[slot]) {
				if(key == e.key) {
					return e.value;
				}
			}
		}
		
		//3.  if key is not present
		return null;
	}
}











