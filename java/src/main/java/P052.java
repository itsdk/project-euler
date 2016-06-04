package main.java;

import java.util.TreeSet;

/*
 * It can be seen that the number, 125874, and its double, 251748, contain exactly the 
 * same digits, but in a different order.
 * 
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the 
 * same digits.
 */

public class P052 extends Problem {

	@Override
	public String solve() {
		/*
		 * Number to return for problem.
		 * Start at 100, because if 2 digits, there could only be 2 combinations of the 
		 * digits, not 6.
		 */
		long number = 100; 
		
		while (true) {
			/*
			 * Assumed that the number would have unique digits, and the answer did,
			 * but should probably not assume this, unless I find a reason why.
			 * (ie. a digit does not appear twice in the number)
			 */
			TreeSet<Integer> n1 = getDigitsUnique(number);
			boolean found = true;
			for (int i=2; i<=6; i++) {
				TreeSet<Integer> n2 = getDigitsUnique(number*i);
				if (!n1.equals(n2)) {
					found = false;
					break;
				}
			}
			if (found) break;
			number++;
		}

		return Long.toString(number);
	}

}
