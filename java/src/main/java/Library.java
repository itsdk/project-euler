package main.java;

/*
 * collection of methods that could be reused across problems
 */

import java.util.TreeSet;

public abstract class Library {
	
	/*
	 * get the factors of a number
	 */
	protected TreeSet<Long> getFactors(long n) {
		TreeSet<Long> factors = new TreeSet<Long>();
		factors.add(n);  // n is always a factor of n
		factors.add(1L); // 1 is always a factor of n
		long max = (long) Math.sqrt(n) + 1; // largest first number of the factor pairs
		for (long i = 2; i <= max; i++) {
			if (n % i == 0) {
				factors.add(i);
				factors.add(n / i);
			}
		}
		return factors;
	}
	
	/*
	 * is a number a prime number or not?
	 * through trial division
	 */
	protected boolean isPrime(long n) {
		if (n == 2) return true;                   // 2 is prime
		if ((n < 2) || (n % 2 == 0)) return false; // not prime if less than 2 or a multiple of 2
		long max = (long) Math.sqrt(n); 
		for (long i=3; i<=max; i+=2) {
			if (n % i == 0) return false;          // not prime if multiple of a number
		}
		return true;
	}
	
	/*
	 * estimate how many fibonacci numbers <= value, using Binet's formula
	 */
	protected double numberOfFibonaccis(double value) {
		double phi = (1 + Math.sqrt(5))/2;
		return 1 + (Math.log((Math.sqrt(5))*(value+0.5)))/(Math.log(phi));
	}
}
