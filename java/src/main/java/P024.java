package main.java;

import java.util.ArrayList;

/*
 * A permutation is an ordered arrangement of objects. 
 * For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. 
 * If all of the permutations are listed numerically or alphabetically, 
 * we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 * 
 * 012   021   102   120   201   210
 * 
 * What is the millionth lexicographic permutation of the digits 
 * 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */

public class P024 extends Problem {
	
	private final static int N = 1_000_000; // given by problem, find millionth permutation
	private final static int D = 10;        // given by problem, number of digits to use
	
	@Override
	public String solve() {
		ArrayList<Integer> perm = new ArrayList<Integer>(D); // hold digits
		for (int i=0; i<D; i++) { // add digits
			perm.add(i);
		}
		
		int digitsLeft = perm.size(); // digits to be determined
		String nthPerm = ""; // Nth permutation to be returned
		
		int p = N; // permutations to be determined
		
		for (int i=0; i<D; i++) {
			int permutations = factorial(digitsLeft-1).intValue();
			int total = 0;
			for (int j : perm) {
				total += permutations;
				if (total >= p) {
					nthPerm += j;
					perm.remove(Integer.valueOf(j));
					digitsLeft--;
					break;
				} 
			}
			p -= (total-permutations);
		}
		
		return nthPerm;
	}

}
