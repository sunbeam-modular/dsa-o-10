package com.sunbeam;

public class GreedyCoinsMain {
	public static int findMinNumOfCoins(int amount, int[] coins) {
		int count=0;
		for(int i=0; i<coins.length; i++) {
			if(amount == 0)
				break;
			if(amount >= coins[i]) {
				count++; // select a coin of coins[i]
				amount = amount - coins[i];	// subtract coin from that amount
				i--; // enable to try current coin again
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int[] coins = { 50, 20, 10, 5, 2, 1 }; // sorted in desc order
		int amount = 46;
		int count = findMinNumOfCoins(amount, coins);
		System.out.println("Number of coins: " + count);
	}

}
