package com.sunbeam;

public class Tester {

	public static void main(String[] args) {
		
		LinkedList l1 = new LinkedList();
		
		l1.addFirst('N');
		l1.addFirst('U');
		l1.addFirst('S');
		
		l1.addLast('B');
		l1.addLast('E');
		l1.addLast('A');
		l1.addLast('M');
		
		l1.deleteFirst();
		l1.deleteLast();
		
		l1.display();
	}

}
