package main.java;

/*
 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
 * 
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 * 
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 */

public class P036 extends Problem {

	private final int LIMIT = 1_000_000; // limited by problem
	
	@Override
	public String solve() {
		int sum = 0; // sum of numbers palindromic in base 10 and base 2
		
		/*
		 * can't include leading zeros, which means that in base 2, 
		 * the rightmost digit can't be zero, which means that we only need to check even
		 * numbers
		 */
		for (int i=1; i<LIMIT; i+=2) {
			// check if palindrome in base 10 and base 2:
			if (isPalindrome(Integer.toString(i)) && isPalindrome(Integer.toBinaryString(i))) {
				sum += i;
			}
		}
		
		return Integer.toString(sum);
	}

}
