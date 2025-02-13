

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
	private Entry table[];
	
	public HashTable(int size) {
		SIZE = size;
		table = new Entry[SIZE];
	}
	
	public int h(int k) {
		return k % SIZE;
	}
	
	public int h(int k, int i) {
		return h(k) + i;
	}
	
	public void put(int key, String value) {
		//1. find slot corresponding to given key
		int slot = h(key);
		int i = 1;
		
		//2. update value corresponding to key if it is already present
		while(table[slot] != null) {
			//2.1 if slot contains same key then update its value
			if(key == table[slot].key) {
				table[slot].value = value;
				return;
			}
			//2.1 collision has occured go for probing
			slot = h(key, i++);
		}
		
		//3. store key value pair into linked list of slot if it is not present
		Entry e = new Entry(key, value);
		table[slot] = e;
	}
	
	public String get(int key) {
		//1. find slot corresponding to given key
		int slot = h(key);
		int i = 1;

		//2. update value corresponding to key if it is already present
		while(table[slot] != null) {
			//2.1 if slot contains same key then update its value
			if(key == table[slot].key) {
				return table[slot].value;
			}
			//2.1 collision has occured go for probing
			slot = h(key, i++);
		}

		//3.  if key is not present
		return null;
	}
}











