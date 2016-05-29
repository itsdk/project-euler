package main.java;

/*
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, 
 * is unusual in two ways: 
 * (i) each of the three terms are prime, and, 
 * (ii) each of the 4-digit numbers are permutations of one another.
 * 
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, 
 * exhibiting this property, but there is one other 4-digit increasing sequence.
 * 
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 */

import java.util.ArrayList;
import java.util.HashSet;

public class P049 extends Problem {

	@Override
	public String solve() {
		/*
		 *  concatenation of three 4-digit primes that are permutations of each other and
		 *  3330 apart (what the problem asks for):
		 */
		String cat = ""; 
		
		// get all primes that are 4 digits:
		ArrayList<Integer> primes = getPrimesBelow(10_000); // primes that are 4 digits or below
		int index = 0;
		for (int i=0; i<primes.size(); i++) {
			/*
			 * Tested using primes.get(i).intValue() > 999, and the terms that we want are
			 * greater than the given 3 terms starting with 1487, so we can disregard all 
			 * primes < 1487:
			 */
			if (primes.get(i).intValue() > 1487) { 
				index = i;
				break;
			}
		}
		primes.subList(0, index).clear(); // clear primes that are below index (prime after 1487)
		
		for (Integer p : primes) {
			int p1 = p.intValue();
			
			// turn number into int[] of digits:
			int pTemp = p1;
			int[] digits = new int[4];
			for (int i=0; i<4; i++) {
				digits[i] = pTemp % 10; 
				pTemp /= 10;
			}
			
			// get permutations of prime number:
			ArrayList<Long> allPerms = new ArrayList<Long>(4*3*2);
			permutations(4, digits, allPerms);
			
			// narrow down permutations to primes:
			HashSet<Integer> perms = new HashSet<Integer>();
			for (Long l : allPerms) {
				Integer intPerm = Integer.valueOf(l.intValue());
				if (primes.contains(intPerm)) {
					perms.add(intPerm);
				}
			}
			
			/*
			 *  find series of 3 permutations of 4-digit primes that are 3330 apart:
			 *  
			 *  (I had first tried all differences from 2 to 3333 (one third of the range), 
			 *  but it seems that just like the terms given, the answer terms are also 
			 *  3330 apart)
			 */
			if (perms.size() >= 3) {
				int p2 = p1 + 3330;
				int p3 = p2 + 3330;
				if (perms.contains(Integer.valueOf(p2)) &&
						perms.contains(Integer.valueOf(p3))) {
					cat = String.valueOf(p1) + String.valueOf(p2) + String.valueOf(p3);
					break;
				}
			}
		}
		
		return cat;
	}

}
