package main.java;

/*
 * In England the currency is made up of pound, £, and pence, p, 
 * and there are eight coins in general circulation:
 * 
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:
 * 
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * How many different ways can £2 be made using any number of coins?
 */

public class P031 extends Problem {

	private final int AMOUNT = 200; // £2 in pence, given by problem
		
	@Override
	public String solve() {
		int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 }; // all coins in pence
		int[] ways = new int[AMOUNT+1];                  // number of ways to make AMOUNT
		ways[0] = 1;
		 
		// calculate number of ways to produce each amount from 0..AMOUNT:
		for (int i=0; i<coins.length; i++) {
		    for (int j=coins[i]; j<=AMOUNT; j++) {
		        ways[j] += ways[j-coins[i]];
		    }
		}
		
		return Integer.toString(ways[ways.length-1]);
	}

}
