package main.java;

/*
 * The number 3797 has an interesting property. Being prime itself, it is possible to 
 * continuously remove digits from left to right, and remain prime at each stage: 
 * 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.
 * 
 * Find the sum of the only eleven primes that are both truncatable from left to right 
 * and right to left.
 * 
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */

public class P037 extends Problem {
	

	@Override
	public String solve() {
		int sum = 0;    // sum of truncatable primes, to return:
		int limit = 11; // number of truncatable primes to find, given by problem
		int x = 23;     // start at 23, because it is the first obviously truncatable prime
		
		while (limit>0) {
			if (isPrime(x)) {
				boolean truncatable = true;
				int l = truncateLeft(x);
				int r = truncateRight(x);
				while (l>0 && r>0) {
					if (isPrime(l) && isPrime(r)) {
						l = truncateLeft(l);
						r = truncateRight(r);
					} else {
						truncatable = false;
						break;
					}
				}
				if (truncatable) {
					sum += x;
					limit--;
				}
			}
			x += 2; 
		}
		
		
		return Integer.toString(sum);
	}

}
