package main.java;

/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 */

import java.util.ArrayList;

public class P010 extends Problem {
	
	public final static int VALUE = 2000000; // given by problem

	@Override
	public String solve() {
		long sum = 0;
		ArrayList<Integer> primes = getPrimesBelow(VALUE);
		for (Integer prime : primes) {
			sum += prime.intValue();
		}		
		return Long.toString(sum);
	}

}
