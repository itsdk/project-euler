package main.java;

import java.util.ArrayList;

/*
 * It was proposed by Christian Goldbach that every odd composite number can be written as 
 * the sum of a prime and twice a square.
 * 
 * 9  = 7  + 2×1^2
 * 15 = 7  + 2×2^2
 * 21 = 3  + 2×3^2
 * 25 = 7  + 2×3^2
 * 27 = 19 + 2×2^2
 * 33 = 31 + 2×1^2
 * 
 * It turns out that the conjecture was false.
 * 
 * What is the smallest odd composite that cannot be written as the sum of a prime and 
 * twice a square?
 */

public class P046 extends Problem {

	@Override
	public String solve() {
		ArrayList<Integer> primes = getPrimesBelow(10000); // list of primes
		int i = 33; // odd composite to check (problem gives up to 33, so that's where we start)
		boolean found = false; // found answer to problem
		
		while (!found) {
			i += 2; // increment odd composite
			found = true;
			for (Integer p : primes) {
				int prime = p.intValue();
				if (prime > i) break; // only checking primes =< current i value
				/*
				 * if sqrt((i value minus a prime number)/2) is a whole number then we 
				 * haven't found our answer yet 
				 */
				if (isNSquare(i-prime, 2)) {
					found = false;
					break;
				}
			}			
		}
		
		return Integer.toString(i);
	}

}
