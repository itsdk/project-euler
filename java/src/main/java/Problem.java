package main.java;

/*
 * all problems (P001, P002, etc.) will extend this
 */

public abstract class Problem {
	
	public abstract String solve();	// return solution to the problem
	
	/*
	 * time the solution to a problem, and print it
	 */
	public final long time() {
		long startTime = System.nanoTime();
		solve();
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println(this.getClass().getSimpleName() + " time: " + elapsedTime + " nanoseconds");
		return elapsedTime;
	}
}
