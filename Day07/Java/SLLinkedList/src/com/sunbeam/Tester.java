package com.sunbeam;

public class Tester {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.addFirst(40);
		list.addFirst(30);
		list.addFirst(20);
		list.addFirst(10);
		//list.addLast(50);
		//list.addLast(60);
		// 10->20->30->40->50->60
				
		//list.deleteFirst();
		//list.deleteLast();
		
		//list.addPosition(100, 4);
		//list.addPosition(100, 1);
		//list.addPosition(100, 0);
		//list.addPosition(100, 5);
		//list.addPosition(100, 6);
		
		//list.deletePosition(3);
		//list.deletePosition(1);
		//list.deletePosition(4);
		list.deletePosition(5);
		
		list.display();

	}

}
