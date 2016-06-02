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
		boolean familyFound = false;
		
		/*
		 * Number has to be larger than 56003 (given by the problem as the smallest of the
		 * first 7 prime family), so we are assuming it will be 5 or 6 digits long.
		 * I tried 5 digits, and didn't find an answer, so we will try 6 digits:
		 */
		ArrayList<Integer> primes = getPrimesBelow(1_000_000);
		int index = 0;
		for (int i=0; i<primes.size(); i++) {
			if (primes.get(i).intValue() > 99999) { 
				index = i;
				break;
			}
		}
		primes.subList(0, index).clear();
		
		for (int i=3; i<=6; i++) { // should start at 1
			/*
			int[] p6 = new int[6];
			for (int j=0; j<i; j++) {
				p6[j] = 1;				
			}
			*/
			
			ArrayList<Long> perms6 = new ArrayList<Long>();
			//permutations(6, p6, perms6);
			perms6.add(Long.valueOf(101010L)); // the correct pattern, but should try all
			
			for (Long l : perms6) {
				for (Integer prime : primes) {
					int familySize = 0;
					int pr = prime.intValue();
					boolean smallestFound = false;
					// digit to replace with:
					for (int d=1; d<=9; d++) { // final solution should include 0
						int p = l.intValue();
						int digitIndex = 5;
						while (p > 0) {
							if (p % 10 == 1) {
								pr = replaceDigit(digitIndex, pr, d);
							}
							p /= 10;
							digitIndex--;
						}
						if (primes.contains(Integer.valueOf(pr))) {
							if (!smallestFound) {
								smallestFound = true;
								smallest = pr;
							}
							familySize++;
						}
						if ((d>=2) && (!smallestFound)) break;
					}	
					if (familySize >= 8) {
						familyFound = true;
						break;
					}
				}
				if (familyFound) break;
			}
			if (familyFound) break;
		}
		
		
		return Integer.toString(smallest);
	}

}
