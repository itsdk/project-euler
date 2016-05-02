package main.java;

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
	
	final static int N = 1_000_000; // given by problem, find millionth permutation
	final static int[] PERM = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // given by problem

	@Override
	public String solve() {
		int digitsLeft = PERM.length; // digits to be determined
		String nthPerm = ""; // Nth permutation to be returned
		int remainder = factorial(digitsLeft).intValue(); // remainder as digits are set
		
		while (digitsLeft > 0) {
			//for (int i=0)
			
		}
		
		return nthPerm;
	}

}
