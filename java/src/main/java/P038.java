package main.java;

/*
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 * 
 * 192 x 1 = 192
 * 192 x 2 = 384
 * 192 x 3 = 576
 * 
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. 
 * We will call 192384576 the concatenated product of 192 and (1,2,3)
 * 
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, 
 * giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
 * 
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the 
 * concatenated product of an integer with (1,2, ... , n) where n > 1?
 */

public class P038 extends Problem {

	@Override
	public String solve() {
		/*
		 * Since n>1, our number must be less than 5 digits, because at the very least where
		 * n=2, a concatenation of a 5 digit number x1 and a 5 digit number x2 = 10 digits, 
		 * and we need 9.
		 * 
		 * In the problem we are given a candidate concatenated product, 918273645, which in 
		 * order to find a higher candidate, ours must also start with a 9.
		 * 
		 * Assume our number is 2-digit (remember, because of the candidate already given, it must 
		 * start with at most 98, and at least 91):
		 * n=3 -> 98x1, 98x2, 98x3 = 99, 196, 294 = 99196294 = at most an 8-digit candidate, too small
		 * n=4 -> 91x1, 91x2, 91x3, 91x4 = 91182273364 = at least 11-digits, too large
		 * Therefore, we can't get a 9-digit concatenated product with a 2-digit number.
		 * 
		 * Assume our number is 3-digits instead:
		 * n=2 -> 987x1, 987x2 = 987, 1974 = 9871974 = at most a 7-digit candidate, too small
		 * n=3 -> 918x1, 918x2, 918x3 = 91818362754 = at least 11-digits, too large
		 * Therefore, we can't get a 9-digit concatenated product with a 3-digit number.
		 * 
		 * Assume our number is 4-digits instead:
		 * n=2 -> 9876x1, 9876x2 = 9876, 19752 = 987619752 = 9-digit candidates!
		 * Therefore, our number must be 4-digits, and n=2.
		 * If n is higher or lower than 2, we won't be able to get the right number of digits,
		 * and if our number is 5-digits or higher, there is no n>1 that can get a 9-digit candidate.
		 * 
		 * Therefore, our range to check for a 4-digit number to make a concatenated product
		 * larger than 918273645 (given in problem) must be between 9182 and 9876.
		 */
		
		// candidate concatenated product given by problem to try to beat:
		int largest = 918273645; 
		
		for (int i=9876; i>9182; i--) {
			// i*100_000 -> to concatenate i*1 and i*2, because we know i*2 is 5 digits:  
			int candidate = i*100_000 + i*2; 
			if (isPandigital(candidate)) {
				largest = candidate;
				break;
			}
		}
		
		return Integer.toString(largest);
	}

}
