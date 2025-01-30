package com.sunbeam;

public class Stack {
	private int arr[];
	private int top;
	private final int SIZE;
	public Stack(int size) {
		SIZE = size;
		arr = new int[SIZE];
		top = -1;
	}
	
	public void push(int value) {
		if(top == SIZE - 1)
			System.out.println("Stack is Full");
		else {
			//a. reposition top
			top++;
			//b. add value at top index
			arr[top] = value;
		}
	}
	
	public int pop() {
		int temp = -1;
		if(top == -1)
			System.out.println("Stack is empty");
		else {
			temp = arr[top];
			//a. reposition top
			top--;
		}
		return temp;
	}
	
	public int peek() {
		if(top == -1)
			System.out.println("Stack is empty");
		else
			//a. read value of top index
			return arr[top];
		return -1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == SIZE - 1;
	}
}

















