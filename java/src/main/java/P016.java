package main.java;

/*
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 */

import java.math.BigInteger;

public class P016 extends Problem {

	@Override
	public String solve() {
		BigInteger number = new BigInteger("2");
		number = number.pow(1000);
		return Long.toString(sumDigits(number));
	}

}
