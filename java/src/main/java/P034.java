package main.java;

/*
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * 
 * Find the sum of all numbers which are equal to the sum of the factorial 
 * of their digits.
 * 
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */

public class P034 extends Problem {

	@Override
	public String solve() {
		int sum = 0; // sum to return, as asked for in problem
		
		// precalculate the factorials for each digit 0..9:
		int[] factorials = new int[10];
		factorials[0] = factorials[1] = 1;
		for (int i=2; i<=9; i++) {
			factorials[i] = factorials[i-1]*i;
		}
		
		/*
		 * 9!   =   362_880
		 * 9!*7 = 2_540_160
		 * 9!*8 = 2_903_040
		 * therefore 9!*7 is the upper limit, because 9!*8 is still a 7 digit number
		 * and the lower limit is 10, because 1 digit numbers can't produce a sum
		 */
		for (int i=10; i<=2_540_160; i++) {
			int sumFactorial = 0; // sum of the factorials of the digits in i
			int num = i;
			while (num>0) {
				int digit = num%10; // get last digit
				num /= 10;          // remove last digit
				sumFactorial += factorials[digit];
			}
			if (sumFactorial == i) sum += i; // match, as per problem
		}
		
		return Integer.toString(sum);
	}

}
