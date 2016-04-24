package main.java;

/*
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */

public class P009 extends Problem {
	
	private final int sum = 1000; // given by problem, the sum of the pythagorean triplet

	@Override
	public String solve() {
		for (int m=2; m<Integer.MAX_VALUE; m++) {
			for (int n=1; n<m; n++) {
				/*
				 * Euclid's Formula:
				 * a = m^2 - n^2
				 * b = 2mn
				 * c = m^2 + n^2
				 */
				int a = (m*m)-(n*n);
				int b = 2*m*n;        
				int c = (m*m)+(n*n);
				if((sum % (a+b+c)) == 0) {
					int k = sum/(a+b+c);
					return Integer.toString((k*a)*(k*b)*(k*c));
				}
			}
		} 
		return "No Pythagorean Triplet that adds to " + sum + " has been found.";
	}

}
