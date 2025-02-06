package com.sunbeam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {
	static class Node{
		private int data;
		private Node left;
		private Node right;
		public Node(int value) {
			data = value;
			left = right = null;
		}
	}
	
	private Node root;
	public BST() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void addNode(int value) {
		//1. create node with given data
		Node newnode = new Node(value);
		//2. if BSTree is empty
		if(root == null)
			// add newnode into root itself
			root = newnode;
		//3. if BSTree is not empty
		else {
			//3.1 create trav and start at root position
			Node trav = root;
			while(true) {
				//3.2 if value is less than current node data
				if(value < trav.data) {
					//3.2.1 if left of current node is empty
					if(trav.left == null) {
						// add newnode into left of current node
						trav.left = newnode;
						break;
					}
					//3.2.2 if left of current node is not empty
					else
						// go one left of current node
						trav = trav.left;
				}
				//3.3 if value is greater or equal than current node data 
				else {
					//3.3.1 if right of current node is empty
					if(trav.right == null) {
						// add newnode intoright of current node
						trav.right = newnode;
						break;
					}
					//3.3.2 if right of current node is not empty
					else
						// go one right of current node
						trav = trav.right;
				}
			}//3.4 repeat step 3.2 and 3.3 untill node is added into BST
		}
	}
	
	private void preOrder(Node trav) {
		// if left or right subtree is absent then stop
		if(trav == null)
			return;
		System.out.print(" " + trav.data);		// V
		preOrder(trav.left);					// L
		preOrder(trav.right); 					// R
	}
	
	public void preOrder() {		// wrapper method
		System.out.print("PreOrder : ");
		preOrder(root);
		System.out.println("");
	}
	
	private void inOrder(Node trav) {
		// if left or right subtree is absent then stop
		if(trav == null)
			return;
		inOrder(trav.left);					// L
		System.out.print(" " + trav.data);		// V
		inOrder(trav.right); 					// R
	}
	
	public void inOrder() {		// wrapper method
		System.out.print("InOrder : ");
		inOrder(root);
		System.out.println("");
	}
	
	private void postOrder(Node trav) {
		// if left or right subtree is absent then stop
		if(trav == null)
			return;
		postOrder(trav.left);					// L
		postOrder(trav.right); 					// R
		System.out.print(" " + trav.data);		// V
	}
	
	public void postOrder() {		// wrapper method
		System.out.print("PostOrder : ");
		postOrder(root);
		System.out.println("");
	}
	
	
	public void DFSTraversal() {
		//0. create stack to push Nodes
		Stack<Node> st = new Stack<BST.Node>();
		//1. push root node on stack
		st.push(root);
		System.out.print("DFS Traversal : ");
		while(!st.isEmpty()) {
			//2. pop node from stack
			Node trav = st.pop();
			//3. print poped node
			System.out.print(" " + trav.data);
			//4. if right exists, then push it on stack
			if(trav.right != null)
				st.push(trav.right);
			//5. if left exists, then push it on stack
			if(trav.left != null)
				st.push(trav.left);
		}//6. repeat above steps till stack is not empty
		System.out.println("");
	}
	
	public void BFSTraversal() {
		//0. create queue to push Nodes
		Queue<Node> q = new LinkedList<BST.Node>();
		//1. push root node on queue
		q.offer(root);
		System.out.print("BFS Traversal : ");
		while(!q.isEmpty()) {
			//2. pop node from queue
			Node trav = q.poll();
			//3. print poped node
			System.out.print(" " + trav.data);
			//4. if left exists, then push it on queue
			if(trav.left != null)
				q.offer(trav.left);
			//5. if right exists, then push it on queue
			if(trav.right != null)
				q.offer(trav.right);
		}//6. repeat above steps till stack is not empty
		System.out.println("");
	}
	
	public void deleteAll() {
		root = null;
	}
}

















