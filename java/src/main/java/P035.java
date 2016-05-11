package main.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * The number, 197, is called a circular prime because all rotations of the digits: 
 * 197, 971, and 719, are themselves prime.
 * 
 * There are thirteen such primes below 100: 
 * 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * 
 * How many circular primes are there below one million?
 */

public class P035 extends Problem {

	private final int LIMIT = 1_000_000; // given by problem
	
	@Override
	public String solve() {
		ArrayList<Integer> primes = getPrimesBelow(LIMIT); // all primes below LIMIT
		Set<Integer> circulars = new HashSet<Integer>();   
		
		// add circular primes:
		for (Integer p : primes) {
			if (!circulars.contains(p)) {
				ArrayList<Integer> perms = cyclicallyPermute(p.intValue());
				if (isPrime(perms)) circulars.addAll(perms);
			}
		}
		
		return Integer.toString(circulars.size());
	}

}
