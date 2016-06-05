package main.java;

/*
 * There are exactly ten ways of selecting three from five, 12345:
 * 
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 * 
 * In combinatorics, we use the notation, 5C3 = 10.
 * 
 * In general,
 * 
 * nCr = n!/(r!(n-r)!) ,where r =< n, n! = n*(n-1)*...*3*2*1, and 0! = 1.
 * It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
 * 
 * How many, not necessarily distinct, values of  nCr, for 1 =< n =< 100, are greater than 
 * one-million?
 */

public class P053 extends Problem {

	@Override
	public String solve() {
		int overOneMillion = 0; // number to return
		
		/*
		 * start at 23, because problem states that is first value of n where an nCr can
		 * exceed one million
		 */
		for (int n=23; n<=100; n++) { 
			for (int r=0; r<=n; r++) {
				if (binomialCoefficient(n,r) > 1_000_000L) {
					/*
					 * The binomial coefficients will get larger than a long can store,
					 * so we can avoid calculating them by realizing the symmetry in 
					 * Pascal's Triangle and counting all binomial coefficients that will 
					 * be greater than one million as soon as we hit the first nCr that is 
					 * greater than one million.
					 */
					overOneMillion += n-(2*r)+1;
					break;
				}
			}
		}
		
		return Integer.toString(overOneMillion);
	}

}
