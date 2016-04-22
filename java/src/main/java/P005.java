package main.java;

/*
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */

public class P005 extends Problem {

	@Override
	public String solve() {
		return Long.toString(lcm(20));
	}

}
