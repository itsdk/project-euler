package main.java;

/*
 * collection of methods that could be reused across problems
 */

import java.util.TreeSet;
import java.util.ArrayList;

public abstract class Library {
	
	/*
	 * greatest common divisor of two numbers
	 * (returns largest integer that divides both a and b without a remainder)
	 */
	protected long gcd(long a, long b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a%b);
		}
	}
	
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
	 * get the nth prime
	 */
	protected long getPrime(int n) {
		if (n<1) { return 0; } 
		int numPrimes = 0; // number of primes so far
		long prime = 1;
		while (numPrimes < n) {
			prime++;
			if (isPrime(prime)) {
				numPrimes++;
			}
		}		
		return prime;
	}
	
	/*
	 * get all the prime numbers below a value (n),
	 * using Sieve of Eratosthenes
	 */
	protected ArrayList<Integer> getPrimesBelow(int n) {
		ArrayList<Integer> primes = new ArrayList<Integer>(); 
		if (n<=2) { return primes; } // no primes below 2
		
		boolean[] sieve = new boolean[n]; // false = prime, true = composite
		sieve[0] = true;
		sieve[1] = true; 
		sieve[2] = false; // prime

		// sieve out even numbers
		for(int i=4; i<n; i+=2) { 
			sieve[i] = true; 
		}

		int limit = (int)Math.sqrt(n)+1;
		for(int i=3; i<limit; i+=2) { // iterate through odd numbers
			if(!sieve[i]) { // if prime
				for(int j=i*i; j<n; j+=i) { // sieve out multiples of i
					sieve[j] = true; 
				}
			}
		}
		
		// get primes as list
		for (int i=0; i<sieve.length; i++) {
			if (!sieve[i]) {
				primes.add(i);
			}
		}
		return primes;
	}
	
	/*
	 * checks if a String is a palindrome or not
	 * (reads the same forwards and backwards)
	 */
	protected boolean isPalindrome(String s) {
		for (int i=0; i<s.length()/2; i++) {
			if (Character.toLowerCase(s.charAt(i)) != 
					Character.toLowerCase(s.charAt(s.length()-1-i))) {
				return false;
			}
		}
		return true;
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
	 * least common multiple of the numbers [1,n]
	 * (returns smallest integer divisible by all numbers [1,n])
	 */
	protected long lcm(long n) {
		long lcm = 1;
		for (long i=2; i<=n; i++) {
	    	lcm *= i/gcd(i,lcm);
		}
		return lcm;	
	}
	
	/*
	 * estimate how many fibonacci numbers <= value, using Binet's formula
	 */
	protected double numberOfFibonaccis(double value) {
		double phi = (1 + Math.sqrt(5))/2;
		return 1 + (Math.log((Math.sqrt(5))*(value+0.5)))/(Math.log(phi));
	}
	
	/*
	 * square of the sum of the numbers [a,b]
	 * eg: [(a) + (a+1) + (a+2) + ... + (b-2) + (b-1) + (b)]^2
	 */
	protected long squareOfSum(int a, int b) {
		long sum = 0;
		for (int i=a; i<b+1; i++) {
			sum += i;
		}
		return sum*sum;
	}
	
	/*
	 * sum of the squares of the numbers [a,b]
	 * eg: (a)^2 + (a-1)^2 + (a-2)^2 + ... + (b-2)^2 + (b-1)^2 + (b)^2
	 */
	protected long sumOfSquares(int a, int b) {
		long sum = 0;
		for (int i=a; i<b+1; i++) {
			sum += i*i;
		}
		return sum;
	}
}
