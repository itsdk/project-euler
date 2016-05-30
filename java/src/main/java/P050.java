package main.java;

import java.util.ArrayList;

/*
 * The prime 41, can be written as the sum of six consecutive primes:
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * 
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 * 
 * The longest sum of consecutive primes below one-thousand that adds to a prime, 
 * contains 21 terms, and is equal to 953.
 * 
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */

public class P050 extends Problem {

	@Override
	public String solve() {
		ArrayList<Integer> primes = getPrimesBelow(1_000_000); // list of primes below a million
		int numPrimes = primes.size();
		
		// list of the cumulative sum of all primes below a million:
		ArrayList<Long> cumulativeSum = new ArrayList<Long>(numPrimes);
		long sum = 0;
		for (Integer p : primes) {
			sum += p.longValue();
			cumulativeSum.add(Long.valueOf(sum));
		}
		
		int prime = 0;          // prime number to return, sum of consecutive primes
		int numConsecutive = 0; // current number of consecutive primes
		
		for (int i=numConsecutive; i<numPrimes; i++) {
			for (int j=i-numConsecutive; j>=0; j--) {
				long difference = cumulativeSum.get(i)-cumulativeSum.get(j);
				if ((difference > 1_000_000) || ((i-j) < numConsecutive)) break;
				int intDiff = Math.toIntExact(difference);
				if (primes.contains(Integer.valueOf(intDiff))) {
					numConsecutive = i-j;
					prime = intDiff;
				}				
			}
		}
		
		return Integer.toString(prime);
	}

}
