package com.sunbeam;

import com.sunbeam.LinkedList.Node;

public class LinkedList {
	static class Node{
		private int data;
		private Node next, prev;
		public Node(int value) {
			data = value;
			next = prev = null;
		}
	}
	
	public Node head;
	public LinkedList() {
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addFirst(int value) {
		//1. create node
		Node nn = new Node(value);
		//2. if list is empty
		if(head == null) {
			//a. add newnode into head
			head = nn;
			//b. make list circular
			head.next = head.prev = head;
		}
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			nn.next = head;
			//b. add last node into prev of newnode
			nn.prev = head.prev;
			//c. add newnode into next of last node
			head.prev.next = nn;
			//d. add newnode into prev of first node
			head.prev = nn;
			//e. move head on newnode
			head = nn;
		}
	}
	
	public void addLast(int value) {
		//1. create node
		Node nn = new Node(value);
		//2. if list is empty
		if(head == null) {
			//a. add newnode into head
			head = nn;
			//b. make list circular
			head.next = head.prev = head;
		}
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			nn.next = head;
			//b. add last node into prev of newnode
			nn.prev = head.prev;
			//c. add newnode into next of last node
			head.prev.next = nn;
			//d. add newnode into prev of first node
			head.prev = nn;
		}
	}
	
	public void addPosition(int value, int pos) {
		//1. create node for data
		Node newnode = new Node(value);
		//2. if list is empty, then add newnode into head 
		if(head == null)
			head = newnode;
		// special case 1
		else if(pos <= 1) 
			addFirst(value);
		//3. if list is not empty
		else {
			//a. traverse till pos - 1 node
			Node trav = head;
										// special case 2
			for(int i = 1 ; i < pos - 1 && trav.next != head ; i++)
				trav = trav.next;
			//b. add pos node into next of newnode
			newnode.next = trav.next;
			//c. add pos-1 node into prev of newnode
			newnode.prev = trav;
			//d. add newnode into prev of pos node
			trav.next.prev = newnode;
			//e. add newnode into next of pos -1 node 
			trav.next = newnode;
		}
	}
	
	public void deleteFirst() {
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		else if(head.next == head)
			head = null;
		//3. if list has multiple nodes
		else {
			//a. add second node into next of last node
			head.prev.next = head.next;
			//b. add last node into prev of second node
			head.next.prev = head.prev;
			//c. move head on second node
			head = head.next;
		}
	}
	
	public void deleteLast() {
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		else if(head.next == head)
			head = null;
		//3. if list has multiple nodes
		else {
			//a. add second last node into prev of first node
			head.prev = head.prev.prev;
			//b. add first node into next of second last node
			head.prev.next = head;
		}
	}
	
	public void deletePosition(int pos) {
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		else if(head.next == head)
			head =  null;
		else if(pos <= 1)
			deleteFirst();
		//3. if list has multiple nodes
		else {
			//a. traverse till pos node
			Node trav = head;
			for(int i = 1 ; i < pos && trav.next != head ; i++)
				trav = trav.next;
			//b. add pos + 1 node into next of pos - 1 node
			trav.prev.next = trav.next;
			//c. add pos - 1 node into prev of pos + 1 node
			trav.next.prev = trav.prev;
		}
	}
	
	public void fDisplay() {
		if(head == null)
			return;
		System.out.print("Forward list : ");
		Node trav = head;
		do {
			System.out.print(" " + trav.data);
			trav = trav.next;
		}while(trav != head);
		System.out.println("");
	}
	
	public void bDisplay() {
		if(head == null)
			return;
		System.out.print("Backward list : ");
		Node trav = head.prev;
		do {
			System.out.print(" " + trav.data);
			trav = trav.prev;
		}while(trav != head.prev);
		System.out.println("");
	}
	
	
	public void deleteAll() {
		head = null;
	}
}








