package main.java;

import java.math.BigInteger;

/*
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 * 
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */

public class P048 extends Problem {

	@Override
	public String solve() {
		// the series 1^1 + 2^2 + 3^3 + ... + 10^10, given by problem:
		BigInteger n = new BigInteger("10405071317");
		
		// complete series up to 1000^1000:
		for (int i=11; i<=1000; i++) {
			n = n.add(new BigInteger(Integer.toString(i)).pow(i));
		}
		
		// get the last ten digits:
		long lastTen = n.mod(new BigInteger("10000000000")).longValue();
		
		return Long.toString(lastTen);
	}

}
