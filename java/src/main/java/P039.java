package main.java;

/*
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, 
 * there are exactly three solutions for p = 120.
 * 
 * {20,48,52}, {24,45,51}, {30,40,50}
 * 
 * For which value of p =< 1000, is the number of solutions maximised?
 */

public class P039 extends Problem {

	private final int P = 1000; // perimeter limit given by problem
	
	@Override
	public String solve() {
		int maxP = 0;         // perimeter value for the maximum solutions
		int maxSolutions = 0; // the maximum number of solutions, corresponding to max p
		
		for (int p=3; p<=P; p++) { // perimiter
			int solutions = 0; // number of solutions for p
			for (int a=1; a<=p-2; a++) {
				for (int b=a+1; b<=(p-a-1); b++) {
					int c = p-a-b;
					if (isRightTriangle(a, b, c)) solutions++;
				}
			}
			if (solutions > maxSolutions) {
				maxSolutions = solutions;
				maxP = p;
			}
		}
		
		return Integer.toString(maxP);
	}

}
