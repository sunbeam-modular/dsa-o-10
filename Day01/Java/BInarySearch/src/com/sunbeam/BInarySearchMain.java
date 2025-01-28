package com.sunbeam;

import java.util.Scanner;
import java.util.function.LongBinaryOperator;

public class BInarySearchMain {
	
	public static int binarySearch(int arr[], int key) {
		int left = 0, right = arr.length - 1, mid;
		while(left <= right) {
			//2. find middle element of array
			mid = (left + right) / 2;
			//3. compare middle element and key
			//3.1 if key is matching
			if(key == arr[mid])
				return mid;
			//3.2 if key is less than middle element
			else if(key < arr[mid])
				right = mid - 1;
			//3.3. if key is greater than middle element
			else // if(key > arr[mid] )
				left = mid + 1;
		}// repeat above two steps till valid partition 
		//3.4 if key is not matching
		return -1;
	}
	
	public static int binarySearch(int arr[], int key, int left, int right) {
		//0. stop if partition is invalid
		if(left > right)
			return -1;
		//1. find middle element of array
		int mid = (left + right) / 2;
		//2. compare key with middle element
		if(key == arr[mid])
			return mid;	// if matching
		//3. if key is less than middle element
		else if(key < arr[mid])
			return binarySearch(arr, key, left, mid - 1);
		//4. if key is greater than middle element
		else
			return binarySearch(arr, key, mid + 1, right);
	}
	

	public static void main(String[] args) {
		int arr[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		
		//1. take key from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter key to be searched : ");
		int key = sc.nextInt();
		
		//int index = binarySearch(arr, key);
		int index = binarySearch(arr, key, 0, arr.length-1);
		if(index != -1)
			System.out.println("Key is found at index " + index);
		else
			System.out.println("Key is not found");
		
		sc.close();
	}

}
