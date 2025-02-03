package com.sunbeam;

public class LinkedList {
	static class Node{
		private int data;
		private Node next;
		private Node prev;
		public Node(int value) {
			data = value;
			next = prev = null;
		}
	}
	
	private Node head;
	private Node tail;
	public LinkedList() {
		head = tail = null;
	}
	
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	
	public void addFirst(int value) {
		//1. create node
		Node newnode = new Node(value);
		//2. if list is empty, add newnode into head and tail
		if(head == null)
			head = tail = newnode;
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. add newnode into prev of first node
			head.prev = newnode;
			//c. move head on newnode
			head = newnode;
		}
		
	}
	
	public void addLast(int value) {
		//1. create node
		Node newnode = new Node(value);
		//2. if list is empty, then add newnode into head and tail
		if(head == null)
			head = tail = newnode;
		//3. if list is not empty
		else {
			//a. add last node into prev of newnode
			newnode.prev = tail;
			//b. add newnode into next of last node
			tail.next = newnode;
			//c. move tail on newnode
			tail = newnode;
		}
			
	}
	
	public void addPosition(int value, int pos) {
		//1. create node for data
		Node newnode = new Node(value);
		//2. if list is empty, then add newnode into head and tail
		if(head == null)
			head = tail = null;
		// special case 1
		else if(pos <= 1) 
			addFirst(value);
		//3. if list is not empty
		else {
			//a. traverse till pos - 1 node
			Node trav = head;
										// special case 2
			for(int i = 1 ; i < pos - 1 && trav.next != null ; i++)
				trav = trav.next;
			/*
			if(trav == tail) {
				addLast(value);
				return;
			}*/
			//b. add pos node into next of newnode
			newnode.next = trav.next;
			//c. add pos-1 node into prev of newnode
			newnode.prev = trav;
			//d. add newnode into prev of pos node
			if(trav.next != null)
				trav.next.prev = newnode;
			//e. add newnode into next of pos -1 node 
			trav.next = newnode;
			if(trav == tail)
				tail = newnode;
		}
	}
	
	public void deleteFirst() {
		//1. if list is empty, return
		if(head == null)
			return;
		//2. if list has single node
		else if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. make prev of second node null
			head.next.prev = null;
			//b. move head on second node
			head = head.next;
		}
	}
	
	public void deleteLast() {
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		else if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. make next of second last node null
			tail.prev.next = null;
			//b. move tail on second last node
			tail = tail.prev;
		}
	}
	
	public void deletePosition(int pos) {
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		else if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. traverse till pos node
			Node trav = head;
			for(int i = 1 ; i < pos ; i++)
				trav = trav.next;
			//b. add pos + 1 node into next of pos - 1 node
			trav.prev.next = trav.next;
			//c. add pos - 1 node into prev of pos + 1 node
			trav.next.prev = trav.prev;
		}
	}
	
	public void fDisplay() {
		//1. create trav and start at first node
		Node trav = head;
		System.out.print("Forward list : ");
		while(trav != null) {
			//2. print current node data
			System.out.print(" " + trav.data);
			//3. go on next node
			trav = trav.next;
		}//4. repeat step 2 and 3 till last node
		System.out.println("");
	}
	
	public void rDisplay() {
		//1. create trav and start at last node
		Node trav = tail;
		System.out.print("Backward list : ");
		while(trav != null) {
			//2. print current node data
			System.out.print(" " + trav.data);
			//3. go on prev node
			trav = trav.prev;
		}//4. repeat step 2 and 3 till first node
		System.out.println("");
	}
	
	public void deleteAll() {
		head = tail = null;
	}
}











