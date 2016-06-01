package main.java;

import java.util.ArrayList;

/*
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine 
 * possible values: 13, 23, 43, 53, 73, and 83, are all prime.
 * 
 * By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number 
 * is the first example having seven primes among the ten generated numbers, 
 * yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. 
 * Consequently 56003, being the first member of this family, is the smallest prime with 
 * this property.
 * 
 * Find the smallest prime which, by replacing part of the number 
 * (not necessarily adjacent digits) with the same digit, is part of an eight prime 
 * value family.
 */

public class P051 extends Problem {

	@Override
	public String solve() {
		/*
		 * Since we are looking for the smallest prime in the 8 prime family, the digits 
		 * that we are replacing must be 0, 1, or 2 in the smallest member.
		 */
		int smallest = 0;
		
		/*
		 * Number has to be larger than 56003 (given by the problem as the smallest of the
		 * first 7 prime family), so we are assuming it will be 5 or 6 digits long.
		 */
		ArrayList<Integer> primes = getPrimesBelow(1_000_000);
		int index = 0;
		for (int i=0; i<primes.size(); i++) {
			if (primes.get(i).intValue() > 56003) { 
				index = i;
				break;
			}
		}
		primes.subList(0, index).clear();
		
		int digit = 0; // digit to replace with
		
		
		
		return Integer.toString(smallest);
	}

}
