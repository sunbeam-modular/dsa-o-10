package com.sunbeam;

import java.util.Scanner;

public class LinearQueueMain {

	public static void main(String[] args) {
		
		Queue q = new Queue(4);
		int choice;
		Scanner sc  = new Scanner(System.in);

		do {
			System.out.println("0. Exit\n1. Push\n2. Pop\n3. Peek");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.print("Enter value to be inserted : ");
				int value = sc.nextInt();
				q.push(value);
				break;
				
			case 2:
				value = q.pop();
				System.out.println("Poped value : " + value);
				break;
				
			case 3:
				value = q.peek();
				System.out.println("Peeked value : " + value);
				break;
			}
		}while(choice != 0);
				
		sc.close();
	}
}














