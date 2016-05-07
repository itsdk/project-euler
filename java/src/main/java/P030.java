package main.java;

/*
 * Surprisingly there are only three numbers that can be written as the sum of 
 * fourth powers of their digits:
 * 
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * 
 * As 1 = 1^4 is not a sum it is not included.
 * 
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * 
 * Find the sum of all the numbers that can be written as the sum of fifth powers 
 * of their digits.
 */

public class P030 extends Problem {

	private final int POW = 5; // fifth powers, as given by problem
	
	@Override
	public String solve() {
		int digitMax = intPow(9,POW);  // maximum value for one digit
		int maxNum = digitMax*(POW+1); // numbers must be below or equal to this
		int answer = 0;                // answer to return
		
		for (int i=2; i<=maxNum; i++) { // start at 2 because 1^POW can not be a sum
			int sumPowers = 0; // sum of the powers of the digits
			int num = i;
			while (num > 0) {
				int digit = num % 10; // get the rightmost digit
				num /= 10;            // remove rightmost digit
				
				sumPowers += intPow(digit, POW); // digit^POW
			}
			
			if (sumPowers == i) answer += i; // add to the answer 
		}
		
		return Integer.toString(answer);
	}

}
