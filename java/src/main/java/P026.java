package main.java;

/*
 * A unit fraction contains 1 in the numerator. 
 * The decimal representation of the unit fractions with denominators 2 to 10 are given:
 * 
 * 1/2	= 	0.5
 * 1/3	= 	0.(3)
 * 1/4	= 	0.25
 * 1/5	= 	0.2
 * 1/6	= 	0.1(6)
 * 1/7	= 	0.(142857)
 * 1/8	= 	0.125
 * 1/9	= 	0.(1)
 * 1/10	= 	0.1
 * 
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. 
 * It can be seen that 1/7 has a 6-digit recurring cycle.
 * 
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle 
 * in its decimal fraction part.
 */

public class P026 extends Problem {
	
	private final int D = 1000; // denominator limit given by problem

	@Override
	public String solve() {
		
		double decimal;   // decimal representation of unit fraction
		String decf;      // decimal fraction part of 1/d
		int length;       // current longest length of recurring cycle in decf of 1/d
		int longest = 0;  // longest length of any recurring cycle
		int longestd = 0; // value of d for longest
		
		for (int d=2; d<D; d++) {
			decimal = 1/(double)d;
			decf = Double.toString(decimal).substring(2);
			length = longestRecurrence(decf).length();
			if (length > longest) {
				longest = length;
				longestd = d;
				System.out.println(d + "\t : " + decf + "\t : " + longest);
			}
		}
		
		return Integer.toString(longestd);
	}
}
