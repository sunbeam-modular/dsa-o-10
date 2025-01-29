package com.sunbeam;

import java.util.Arrays;

public class InsertionSortMain {
	
	public static void insertionSort(int arr[], int N) {
		for(int i = 1 ; i < N ; i++) {
			//1. pick one element of the array
			int temp = arr[i];
			int j;
			//2. compare picked element with all its left neighbours
			for(j = i-1 ; j >= 0 ; j--) {
				//3. if left neighbour is greater than picked element then move it
				if(arr[j] > temp)
					arr[j+1] = arr[j];
				else
					break;
			}
			//4. insert picked element at its appropriate position
			arr[j+1] = temp;
		}//repeat above steps untill array is sorted (N-1)
	}

	public static void main(String[] args) {
		int arr[] = {55, 44, 22, 66, 11, 33};
		
		System.out.println("Array before sort : " + Arrays.toString(arr));

		insertionSort(arr, arr.length);
		
		System.out.println("Array after sort : " + Arrays.toString(arr));
	}

}
