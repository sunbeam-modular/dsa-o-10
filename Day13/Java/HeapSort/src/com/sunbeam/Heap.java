package com.sunbeam;

public class Heap {
	private int SIZE;
	
	public Heap() {
		SIZE = 0;
	}
	
	public void addHeap(int arr[]) {
		for(int i = 1 ; i < arr.length ; i++) {
			//1. increment size of heap by one
			SIZE++;
			//2. adjust position of newly added element by comparing all its ancestors 
			int ci = SIZE;
			int pi = ci / 2;
			while(pi >= 1) {
				//3. if parent is already maximum than newly added value
				if(arr[pi] > arr[ci])
					break;
				//4. if parent is minimum than newly added value then swap both
				int temp = arr[pi];
				arr[pi] = arr[ci];
				arr[ci] = temp;
				//5. update indices of parent and child
				ci = pi;
				pi = ci / 2;
			}
			
		}
	}
	
	public void deleteHeap(int arr[]) {
		for(int i = 1 ; i < arr.length ; i++) {
			//1. swap first and last element of heap
			int max = arr[1];
			arr[1] = arr[SIZE];
			arr[SIZE] = max;
			//2. decrement size of heap by one
			SIZE--;
			//3. adjust position of root upto leaf positions
			int pi = 1;
			int ci = pi * 2;
			while(ci <= SIZE) {
				//4. find index of maximum child
				if((ci + 1) <= SIZE && arr[ci + 1] > arr[ci])
					ci = ci + 1;
				//5. if parent is already maximum than max child
				if(arr[pi] > arr[ci])
					break;
				//6. if parent is minimum than maximum child, then swap
				int temp = arr[pi];
				arr[pi] = arr[ci];
				arr[ci] = temp;
				//7. update parent and child index
				pi = ci;
				ci = pi * 2;				
			}
		}
	}
	
	public void heapSort(int arr[]) {
		//1. add all elements of array into heap
		addHeap(arr);
		//2. delete all elements from heap one by one
		deleteHeap(arr);
	}

}
