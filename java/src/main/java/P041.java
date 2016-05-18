package main.java;

/*
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 
 * 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.
 * 
 * What is the largest n-digit pandigital prime that exists?
 */

import java.util.ArrayList;
import java.util.Collections;

public class P041 extends Problem {

	@Override
	public String solve() {
		int largest = 0; // largest prime pandigital number, to return
		
		/*
		 * A number is divisible by 3 if the sum of it's digits are also divisible by 3, 
		 * so if the sum of the digits of the pandigital are divisible by 3, then it cannot 
		 * be prime:
		 * 9-digit pandigitals: 1+2+3+4+5+6+7+8+9 = 45 <- divisible by 3
		 * 8-digit pandigitals: 1+2+3+4+5+6+7+8 = 36   <- divisible by 3
		 * 7-digit pandigitals: 1+2+3+4+5+6+7 = 28     <- not divisible by 3
		 * So, we can start at 7-digit pandigital numbers.
		 */
		int start = 7654321; // starting pandigital number to check
		
		// primes up to largest pandigital:
		ArrayList<Integer> primes = getPrimesBelow(start+1);
		Collections.reverse(primes);
		
		for (Integer p : primes) {
			int prime = p.intValue();
			if (isPandigital(prime)) {
				largest = prime;
				break;
			}
		}
		
		return Integer.toString(largest);
	}

}
