import java.io.Flushable;

public class Tester {

	public static void main(String[] args) {
		
		HashTable tbl = new HashTable(10);
		
		tbl.put(8, "v1");
		tbl.put(3, "v2");
		tbl.put(10, "v3");
		tbl.put(4, "v4");
		tbl.put(6, "v5");
		tbl.put(13, "v6");
		tbl.put(23, "v7");
		tbl.put(26, "v8");
		tbl.put(3, "updated");
		
		String ret = tbl.get(3);
		if(ret == null)
			System.out.println("Key is not present");
		else
			System.out.println("Key is prsent and value : " + ret);

	}

}
