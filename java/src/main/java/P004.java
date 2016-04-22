package main.java;
/*
 * A palindromic number reads the same both ways. 
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class P004 extends Problem {

	@Override
	public String solve() {
		int largest = 0;
		for (int i=999; i>99; i--) {
			for (int j=999; j>99; j--) {
				if (i*j > largest) {
					if (isPalindrome(Integer.toString(i*j))) {
						largest = i*j;
					}
				}
			}
		}
		return Integer.toString(largest);
	}

}
