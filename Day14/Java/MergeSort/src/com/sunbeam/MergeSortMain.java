package com.sunbeam;

import java.util.Arrays;

public class MergeSortMain {
	
	public static void mergeSort(int arr[], int left, int right) {
		//0. stop if single element partition or invalid partition
		if(left >= right)
			return;
		//1. divide array into two parts
		int mid = (left + right) / 2;
		//2. sort both partitions individually
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		//3. merge sorted partitions into temp array
		int size = right - left + 1;
		int temp[] = new int[size];
		int i = left, j = mid + 1, k = 0;
		while(i <= mid && j <= right) {
			//3.1 compare ith and jth element
			if(arr[i] < arr[j]) {
				//3.2 if ith element is less than jth element then put ith element in to temp array
				temp[k] = arr[i];
				i++;
				k++;
			}
			else {
				//3.3 if jth element is less than ith element then put jth element in to temp array
				temp[k] = arr[j];
				j++;
				k++;
			}
		}
		//3.4 if right partition is finished first, then put remaining elements of left partition into temp array
		while(i <= mid) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		//3.5 if left partition is finished first, then put remaining elements of right partition into temp array
		while(j <= right) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		//4. overwrite temp array into original array
		for(i = 0 ; i < size ; i++)
			arr[left + i] = temp[i];
	}

	public static void main(String[] args) {
		int arr[] = {6, 1, 9, 7, 3, 8, 2, 4, 5};
		
		System.out.println("Array before sort : " + Arrays.toString(arr));

		mergeSort(arr, 0, arr.length-1);
		
		System.out.println("Array after sort : " + Arrays.toString(arr));
	}

}
