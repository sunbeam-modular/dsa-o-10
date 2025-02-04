package com.sunbeam;

public class LinkedList {
	static class Node{
		private char data;
		private Node next;
		public Node(char value) {
			data = value;
			next = null;
		}
	}

	private Node head;
	private Node tail;
	private int size;
	public LinkedList() {
		head = tail = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	
	public void addFirst(char value) {
		//1. create node
		Node nn = new Node(value);
		//2. if list is empty
		if(head == null) {
			//a. add newnode into head and tail
			head = tail = nn;
			//b. make list circular
			tail.next = head;
		}
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			nn.next = head;
			//b. add newnode into next of lats node
			tail.next = nn;
			//c. move head on newnode
			head = nn;
		}
		size++;
	}
	
	public void addLast(char value) {
		//1. create node
		Node nn = new Node(value);
		//2. if list is empty
		if(head == null) {
			//a. add newnode into head and tail
			head = tail = nn;
			//b. make list circular
			tail.next = head;
		}
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			nn.next = head;
			//b. add newnode into next of lats node
			tail.next = nn;
			//c. move tail on newnode
			tail = nn;
		}
		size++;
	}
	
	public void addPosition(char value, int pos) {
		//0. validate position
		if(pos < 1 || pos > size + 1)
			return;
		
		// TO DO
	}
	
	public void deleteFirst() {
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		else if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. add second node into next of last node
			tail.next = head.next;
			//b. move head on second node
			head = head.next;
		}
		size--;
	}
	
	public void deleteLast() {
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		else if(head.next == head)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. traverse till second last node
			Node trav = head;
			while(trav.next != tail)
				trav = trav.next;
			//b. add first node into next of second last node
			trav.next = head;
			//c. move tail on second last node
			tail = trav;
		}
		size--;
	}
	
	public void deletePosition(int pos) {
		//0. validate position
		if(pos < 1 || pos > size)
			return;
		// To DO
	}
	
	public void display() {
		//1. if list is empty
		if(head == null)
			return;
		System.out.print("List : ");
		//2. create trav and start at first node
		Node trav = head;
		do {
			//3. print current node data
			System.out.print(" " + trav.data);
			//4. go on next node
			trav = trav.next;
		}while(trav != head);	//5. repeat aboce steps till last node
		System.out.println("");
		System.out.println("List size : " + size);
	}
	
	public void deleteAll() {
		head = tail = null;
	}
	
}













