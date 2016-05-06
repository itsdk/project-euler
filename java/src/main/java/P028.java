package main.java;

/*
 * Starting with the number 1 and moving to the right in a clockwise direction 
 * a 5 by 5 spiral is formed as follows:
 * 
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * 
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * 
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral 
 * formed in the same way?
 */

public class P028 extends Problem {

	private final int N = 1001; // given by problem
	
	@Override
	public String solve() {
		/*
		 *  for odd N, in an N by N spiral:
		 *  top right corner    = N^2
		 *  top left corner     = N^2 - N + 1
		 *  bottom left corner  = N^2 - 2N + 2
		 *  bottom right corner = N^2 - 3N + 3
		 *  
		 *  therefore, all four corners = 4N^2 - 6N + 6
		 */		
		
		int sumDiagonals = 1; // sum to return, starts at 1 because 1 in center
		
		// add up diagonals of odd numbers
		for (int n=3; n<=N; n+=2) {
			sumDiagonals += (4*n*n) - (6*n) + 6;
		}
		
		return Integer.toString(sumDiagonals);
	}

}
