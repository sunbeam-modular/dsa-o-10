package com.sunbeam;

public class RodCuttingMain {
	public static final int[] price = { 0, 1, 5, 8, 9, 10, 14, 17, 20, 24, 30 };
	public static int count = 0;
	
	public static int recRodMaxPrice(int len) {
		count++;
		if(len == 0)
			return 0;
		int maxPrice = 0;
		for(int i=1; i<=len; i++) {
			int total = price[i] + recRodMaxPrice(len-i);
			if(total > maxPrice)
				maxPrice = total;
		}
		return maxPrice;
	}
	
	public static int memRodMaxPrice(int len, int[] maxPrices) {
		count++;
		if(maxPrices[len] != 0)
			return maxPrices[len];
		if(len == 0)
			return 0;
		int maxPrice = 0;
		for(int i=1; i<=len; i++) {
			int total = price[i] + memRodMaxPrice(len-i, maxPrices);
			if(total > maxPrice)
				maxPrice = total;
		}
		maxPrices[len] = maxPrice;
		return maxPrice;
	}
	public static int memRodMaxPrice(int len) {
		int[] maxPrices = new int[len + 1];
		return memRodMaxPrice(len, maxPrices);
	}
	
	public static int dpRodMaxPrice(int rodLen) {
		count++;
		int[] maxPrices = new int[rodLen + 1];
		maxPrices[0] = 0; // initial state for dp
		for(int len=1; len<=rodLen; len++) {
			// find max price for rod of length "len"
			int maxPrice = 0;
			for(int i=1; i<=len; i++) {
				int total = price[i] + maxPrices[len-i];
				if(total > maxPrice)
					maxPrice = total;
			}
			maxPrices[len] = maxPrice;
		}
		return maxPrices[rodLen];
	}

	public static void main(String[] args) {
		int rodLen = 8, maxPrice;
		
		maxPrice = recRodMaxPrice(rodLen);
		System.out.println("Max Price is " + maxPrice + " with fn calls " + count);

		count = 0;
		maxPrice = memRodMaxPrice(rodLen);
		System.out.println("Max Price is " + maxPrice + " with fn calls " + count);

		count = 0;
		maxPrice = dpRodMaxPrice(rodLen);
		System.out.println("Max Price is " + maxPrice + " with fn calls " + count);
	}
}
