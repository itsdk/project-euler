package main.java;

import java.util.HashSet;
import java.util.TreeSet;

/*
 * The first two consecutive numbers to have two distinct prime factors are:
 * 
 * 14 = 2 × 7
 * 15 = 3 × 5
 * 
 * The first three consecutive numbers to have three distinct prime factors are:
 * 
 * 644 = 2² × 7 × 23
 * 645 = 3 × 5 × 43
 * 646 = 2 × 17 × 19.
 * 
 * Find the first four consecutive integers to have four distinct prime factors. 
 * What is the first of these numbers?
 */

public class P047 extends Problem {
	
	@Override
	public String solve() {
		int count = 644;
		while (true) {
			boolean fourConsecutive = true;
			for (int i=count; i<count+4; i++) { // get 4 consecutive numbers
				TreeSet<Long> factors = getFactors((long)i);
				HashSet<Long> primeFactors = new HashSet<Long>(4);
				for (Long f : factors) {
					if (isPrime(f)) primeFactors.add(f);
				}
				if (primeFactors.size() < 4) {
					fourConsecutive = false;
					break;
				}
			}
			if (fourConsecutive) break;
			count++;
		}
		return Integer.toString(count);
	}

}
