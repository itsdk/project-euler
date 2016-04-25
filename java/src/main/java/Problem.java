package main.java;

/*
 * all problems (P001, P002, etc.) will extend this
 */

public abstract class Problem extends Library {
	
	public abstract String solve();	// return solution to the problem
	
	/*
	 * time the solution to a problem, and print it
	 */
	public final long time() {
		long startTime = System.nanoTime();
		String solution = solve();
		long elapsedTime = System.nanoTime() - startTime;
		System.out.printf("%s \t Time: %fs \t Solution: %s\n", 
				this.getClass().getSimpleName(), elapsedTime*1E-9, solution);
		return elapsedTime;
	}
}
