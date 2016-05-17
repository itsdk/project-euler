package main.java;

/*
 * An irrational decimal fraction is created by concatenating the positive integers:
 * 
 * 0.123456789101112131415161718192021...
 * 
 * It can be seen that the 12th digit of the fractional part is 1.
 * 
 * If dn represents the nth digit of the fractional part, find the value of the 
 * following expression.
 * 
 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 */

public class P040 extends Problem {

	@Override
	public String solve() {
		// Champernowne constant
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<1_000_000; i++) {
			sb.append(i);
		}
		
		int product = 1; // product of d1*d10*d100*d1000*d10000*d100000*d1000000 (7 d's)
		
		for (int i=0; i<7; i++) {
			char digit = sb.charAt((int)(Math.pow(10, i)-1));
			product *= Character.getNumericValue(digit); 
		}
		
		return Integer.toString(product);
	}

}
