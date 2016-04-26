package main.java;

/*
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, 
 * there are exactly 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20×20 grid?
 */

public class P015 extends Problem {

	@Override
	public String solve() {
		/*
		 * moves to get to bottom right = 20 moves to the right + 20 moves down = 40
		 * 40 moves, choose 20 = number of routes = C(40,20)
		 */
		return Long.toString(binomialCoefficient(40,20)); 
	}

}
