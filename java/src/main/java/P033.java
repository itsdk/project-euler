package main.java;

/*
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician 
 * in attempting to simplify it may incorrectly believe that 49/98 = 4/8, 
 * which is correct, is obtained by cancelling the 9s.
 * 
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 * 
 * There are exactly four non-trivial examples of this type of fraction, 
 * less than one in value, and containing two digits in the numerator and 
 * denominator.
 * 
 * If the product of these four fractions is given in its lowest common terms, 
 * find the value of the denominator.
 */

public class P033 extends Problem {

	@Override
	public String solve() {
		// n/d for the four non-trivial examples:
		int[] numerators = new int[4];
		int[] denominators = new int[4];
		int count = 0; // number of examples found so far
		
		for (int n=10; n<=99; n++) { // numerator, 10..99 because it must be 2 digits
			for (int d=n+1; d<=99; d++) { // denominator, d>n to be less than 1
				int n1 = n/10; // first digit of n
				int n2 = n%10; // second digit of n
				int d1 = d/10; // first digit of d
				int d2 = d%10; // second digit of d
				if (n1==n2) continue; // trivial example, same digits
				if ((d2!=0) && 
						(n2==d1) && 
						(((double)n1/(double)d2)==((double)n/(double)d))) {
					// found non-trivial example:
					numerators[count] = n;
					denominators[count] = d;
					count++;
				}
				if (count>3) break;
			}
			if (count>3) break;
		}
		
		// multiply together the fractions:
		int numerator = 1;
		int denominator = 1;
		for (int n : numerators) numerator *= n; 
		for (int d : denominators) denominator *= d;
		
		// greatest common divisor: 
		int i = Math.toIntExact(gcd((long)numerator, (long)denominator));
		
		return Integer.toString(denominator/i);
	}

}
