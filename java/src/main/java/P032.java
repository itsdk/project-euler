package main.java;

import java.util.HashSet;

/*
 * We shall say that an n-digit number is pandigital if it makes use of all the 
 * digits 1 to n exactly once; for example, the 5-digit number, 15234, is 
 * 1 through 5 pandigital.
 * 
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, 
 * containing multiplicand, multiplier, and product is 1 through 9 pandigital.
 * 
 * Find the sum of all products whose multiplicand/multiplier/product identity can 
 * be written as a 1 through 9 pandigital.
 * 
 * HINT: Some products can be obtained in more than one way so be sure to only 
 * include it once in your sum.
 */

public class P032 extends Problem {
	
	@Override
	public String solve() {
		int sumProducts = 0; // sum of the products, to return
		HashSet<Integer> products = new HashSet<Integer>(); // to store non-duplicate products
		
		for (int i=1; i<=9876; i++) { // can stop at 9876 and still get 9 digits
			for (int j=1; j<=100; j++) { // 100*100=10000 } 11 digits, too much
				int p = i*j; // product
				String s = Integer.toString(i) + Integer.toString(j) + Integer.toString(p);
				int slen = s.length();
				if (slen > 9) { // break out early if we start to go over 9 digits
					break;
				} else if (slen == 9) { // won't be pandigital if length != 9
					if (isPandigital(Integer.parseInt(s))) { 
						if (products.add(p) == true) { // if pandigital, add product to set, ignoring duplicates
							sumProducts += p;
						}
					}
				}
			}
		}
		
		return Integer.toString(sumProducts);
	}

}
