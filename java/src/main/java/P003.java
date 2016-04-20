package main.java;

/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */

import java.util.TreeSet;

public class P003 extends Problem {
	private long num = 600851475143L; // target number from question
	
	@Override
	public String solve() {
		// get factors in reverse order
		TreeSet<Long> factors = (TreeSet<Long>) getFactors(num).descendingSet(); 
		
		// check if each factor is prime
		for (Long f : factors) {
			if (isPrime(f)) {
				return f.toString();
			}
		}
		
		return "No prime factor found.";
	}

}
