package main.java;

import java.util.ArrayList;

/*
 * Euler discovered the remarkable quadratic formula:
 * 
 * n^2 + n + 41
 * 
 * It turns out that the formula will produce 40 primes for the consecutive values 
 * n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, 
 * and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.
 * 
 * The incredible formula  n^2 - 79n + 1601 was discovered, which produces 80 primes for 
 * the consecutive values n = 0 to 79. The product of the coefficients, -79 and 1601, 
 * is -126479.
 * 
 * Considering quadratics of the form:
 * 
 * n^2 + an + b, where |a| < 1000 and |b| < 1000
 * 
 * where |n| is the modulus/absolute value of n
 * e.g. |11| = 11 and |-4| = 4
 * 
 * Find the product of the coefficients, a and b, 
 * for the quadratic expression that produces the maximum number of primes 
 * for consecutive values of n, starting with n = 0.
 */

public class P027 extends Problem {

	@Override
	public String solve() {
		// variables in equation, when it produces maximum number of primes:
		int aMax = 0;
		int bMax = 0;
		int nMax = 0;
		
		// when n=0, n^2 + an + b = b, therefore b must be prime:
		ArrayList<Integer> bValues = getPrimesBelow(1000);
		
		/*
		 *  when n=1, n^2 + an + b = 1 + a + b,
		 *  since all primes are odd except for 2,
		 *  a must be odd, except when b = 2,
		 *  so that 1 + a + b is odd
		 */
		for (int b : bValues) {
			int aValue = (b % 2 == 0) ? -998 : -999; // if b is even (b==2), a will be even
			for (int a=aValue; a<1000; a+=2) {
				int n = 0;
				while (isPrime((n*n) + (a*n) + b)) {
					n++;
				}
				if (n > nMax) {
					aMax = a;
					bMax = b;
					nMax = n;
				}
			}
		}
		
		return Integer.toString(aMax*bMax);
	}

}
