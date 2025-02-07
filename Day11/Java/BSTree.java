package com.sunbeam;

import java.util.Stack;

public class BSTree {
	static class Node{
		private int data;
		private Node left;
		private Node right;
		private boolean visited;
		public Node(int value) {
			data = value;
			left = right = null;
			visited = false;
		}
	}

	private Node root;
	public BSTree() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void addNode(int value) {
		//1. create node with given value
		Node newnode = new Node(value);
		//2. if BST is empty
		if(isEmpty())
			//add newnode into root itself
			root = newnode;
		//3. if BST is not empty
		else {
			//3.1  create trav and start at root node
			Node trav = root;
			while(true) {
				//3.2 if value is less than current data (trav.data)
				if(value < trav.data) {
					//3.2.1 if left of current node is empty
					if(trav.left == null) {
						// add newnode into left of current node
						trav.left = newnode;
						break;
					}
					//3.2.2 if left of current node is not empty
					else
						// go into left of current node
						trav = trav.left;
				}
				//3.3 if value is greater or eqaul than current data (trav.data)
				else {
					//3.3.1 if right of current node is empty
					if(trav.right == null) {
						// add newnode into right of current node
						trav.right = newnode;
						break;
					}
					//3.3.2 if right of current node is not empty
					else
						// go into right of current node
						trav = trav.right;
				}
			}//3.4 repeat step 3.2 or 3.3 untill node is added into BST
		}
	}
	
	
	public void preorder() {
		//0. create stack to push nodes
		Stack<Node> st = new Stack<BSTree.Node>();
		//1. start traversing from root
		Node trav = root;
		System.out.print("Preorder : ");
		while(trav != null || !st.isEmpty()) {
			while(trav != null) {
				//2. visit trav
				System.out.print(" " + trav.data);
				//3. if trav has right, push trav->right on stack
				if(trav.right != null)
					st.push(trav.right);
				//4. go to left of trav
				trav = trav.left;
			}//5. repeat 2-4 until trav is null
			//6. pop node from stack into trav
			if(!st.isEmpty())
				trav = st.pop();
		}//7. repeat 2-6, until trav is null or stack is empty
		System.out.println("");
	}
	
	
	public void inorder() {		
		//0. Create stack to push nodes
		Stack<Node> st = new Stack<BSTree.Node>();
		//1. start traversing from root
		Node trav = root;
		System.out.print("Inorder : ");
		while(trav != null || !st.isEmpty()) {
			while(trav != null) {
				//2. push trav on stack
				st.push(trav);
				//3. go to left of trav
				trav = trav.left;
			}//4. repeat 2-3 until trav is null
			//5. pop node from stack into trav
			if(!st.isEmpty())
				trav = st.pop();
			//6. visit trav
			System.out.print(" " + trav.data);
			//7. go to the right
			trav = trav.right;
		}//8. repeat 2-7, until trav is null or stack is empty
		System.out.println("");

	}
	
		
	public void postorder() {		
		// create stack to push nodes
		Stack<Node> st = new Stack<BSTree.Node>();
		// start trav from root
		Node trav = root;
		System.out.print("Postorder : ");
		// while trav is not null or stack is not empty
		while(trav != null || !st.isEmpty()) {
			// until null is reached
			while(trav != null) {
				// push trav on stack
				st.push(trav);
				// go to trav's left
				trav = trav.left;
			}
			// if stack is not empty
			if(!st.isEmpty()) {
				// pop node from stack into trav
				trav = st.pop();
				// if trav's right is not present or visited
				if(trav.right == null || trav.right.visited == true) {
					// visit trav & mark it as visited
					System.out.print(" " + trav.data);
					trav.visited = true;
					// make trav null (so that next node will be popped from stack)
					trav = null;
				}
				// otherwise
				else {
					// push node on stack
					st.push(trav);
					// go to its right
					trav = trav.right;
				}
			}
		}
		System.out.println("");
	}
	
	public int height(Node trav) {
		//1. if sub tree is absent(empty) then
		if(trav == null)
			return -1;
		//2. find height of left subtree
		int hl = height(trav.left);
		//3. find height of right subtree
		int hr = height(trav.right);
		//4. find max of both heights
		int max = hl > hr ? hl : hr;
		//5. return max height + 1
		return max + 1;
	}
	
	public int height() {
		return height(root);
	}
	
	
	
	public Node[] searchNodeWithParent(int key) {
		//1. start from root
		Node trav = root;
		Node parent = null;
		while(trav != null) {
			//2. if key is equal to current data
			if(key == trav.data)
				//break the loop
				break;
			parent = trav;
			//3. if key is less than current data
			if(key < trav.data)
				// search key into left of current node
				trav = trav.left;
			//4. if key is greater than current data
			else
				// search key into right of current node
				trav = trav.right;
		}//5. repeat step 2 to 4 till leaf nodes
		//6. key is not found
		if(trav == null)
			parent = null;
		return new Node[]{trav, parent};
	}
	
	public void deleteNode(int key) {
		//1. search node with its parents
		Node arr[] = searchNodeWithParent(key);
		// arr[0] - node to be deleted
		// arr[1] - parent node 
		Node temp = arr[0], parent = arr[1];
		//2. if node to be deleted is not found
		if(temp == null)
			return;
		//3. if node is found
		//3.1 node to be deleted has two child
		if(temp.left != null && temp.right != null){
			//1. find inorder predecessor of temp
			Node pred = temp.left;
			parent = temp;
			while(pred.right != null){
				parent = pred;
				pred = pred.right;
			}
			//2. replace predecessor's value at temp's value
			temp.data = pred.data;
			//3. delete space of predecessor
			temp = pred;
		}
		//3.2 node to be deleted has single child (right)
		if(temp.left == null){
			if(temp == root)				// root node
				root = temp.right;
			else if(temp == parent.left)		// Parent's left
				parent.left = temp.right;
			else if(temp == parent.right)	// Parent's right
				parent.right = temp.right;
		}
		//3.3 node to be deleted has single child (left)
		else{	//if(temp.right == null){
			if(temp == root)				// root node
				root = temp.left;			
			else if(temp == parent.left)		// parent's left
				parent.left = temp.left;
			else if(temp == parent.right)	// parent's right	
				parent.right = temp.left;
		}
	}
	
	public void deleteAll() {
		root = null;
	}
	
}














