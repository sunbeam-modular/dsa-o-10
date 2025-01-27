package com.sunbeam;

import java.util.Scanner;

public class LinearSearchMain {
	
	public static int linearSearch(int arr[], int key) {
		//2. traverse array from 0 to N-1 n=index
		for(int i = 0 ; i < arr.length ; i++){
			//3. compare key with ith element of array
			if(key == arr[i]) {
				//3.1 if key is matching
				return i;
			}
		}
		//3.1 if key is not matching
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[] = {88, 33, 66, 99, 11, 77, 22, 55, 14};
		
		//1. Take key from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter key to be searched : ");
		int key = sc.nextInt();
		
		int index = linearSearch(arr, key);
		if(index != -1)
			System.out.println("Key is found at index " + index);
		else
			System.out.println("Key is not found");
		
		sc.close();

	}

}
