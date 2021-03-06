package main.java;

import java.util.ArrayList;

/*
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of 
 * the digits 0 to 9 in some order, but it also has a rather interesting sub-string 
 * divisibility property.
 * 
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. 
 * In this way, we note the following:
 * 
 * d2d3d4=406 is divisible by 2
 * d3d4d5=063 is divisible by 3
 * d4d5d6=635 is divisible by 5
 * d5d6d7=357 is divisible by 7
 * d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13
 * d8d9d10=289 is divisible by 17
 * 
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 */

public class P043 extends Problem {

	// First 7 primes, given by problem:
	private static int[] DIVISIBLE_BY = {2, 3, 5, 7, 11, 13, 17};  
	
	@Override
	public String solve() {
		long sum = 0; // number to return
		
		// get permutations of the numbers 0,1,2,3,4,5,6,7,8,9
		ArrayList<Long> perms = new ArrayList<Long>(factorial(10).intValue());
		permutations(10, new int[]{0,1,2,3,4,5,6,7,8,9}, perms);
		
		for (Long p : perms) {
			long longP = p.longValue();
			
			/*
			 * If number of digits is 9, then the permutation started with a 0.
			 * So start index will be 0, otherwise 1
			 */
			int start = (numberOfDigits(longP) == 9) ? 0 : 1;
			
			// check if each divisibility property is true, or false:
			boolean divisible = true;
			for (int i=0; i<DIVISIBLE_BY.length; i++) {
				if (subNum(longP, start, 3) % DIVISIBLE_BY[i] != 0) {
					divisible = false;
					break;
				}
				start++;
			}
			if (divisible) sum += longP;
		}
		
		return Long.toString(sum);
	}

}
