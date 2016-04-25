package main.java;

/*
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 
 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */

public class P014 extends Problem {
	
	private static final int MAX_STARTING = 1_000_000; // given in problem

	@Override
	public String solve() {
		// number of steps to reach 1 for each number (index) under MAX_STARTING:
		long[] steps = new long[MAX_STARTING]; 
		steps[0] = 0;
		steps[1] = 1;
		
		long longestChain = 0; // starting number that produces the longest Collatz Chain
		
		// get Collatz Chain step count for each number under MAX_STARTING
		for (int i=2; i<MAX_STARTING; i++) {
			long nextNum = nextCollatz(i); // next number in Collatz Sequence
			long stepCount = 1;            // count the steps to reach 1
			
			while (nextNum != 1) { // loop until chain ends at 1
				if (nextNum < i) { // step count was already calculated for this number
					stepCount += steps[(int) nextNum]; 
					break;
				}
				nextNum = nextCollatz(nextNum);
				stepCount++;
			}
			
			steps[i] = stepCount;
		
			// get starting number of longest chain:
			if (steps[i] > steps[(int) longestChain]) {
				longestChain = i;
			}
		}
		
		return Long.toString(longestChain);
	}

}
