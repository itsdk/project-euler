package main.java;

/*
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. 
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, 
 * which means that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than n 
 * and it is called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, 
 * the smallest number that can be written as the sum of two abundant numbers is 24. 
 * By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. 
 * However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that 
 * cannot be expressed as the sum of two abundant numbers is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */

public class P023 extends Problem {

	@Override
	public String solve() {
		// sum of all non abundant composite numbers:
		int sum = Math.toIntExact(getTriangularNumber(23)); // 24 is first number that is abundant composite
		
		// sum of proper divisors of index:
		int[] sumPropDivs = new int[28123+1];
		for (int i=0; i<sumPropDivs.length; i++) {
			sumPropDivs[i] = sumPropDivs(i);
		}
		
		// all numbers greater than 28123 can be written as the sum of two abundant numbers
		for (int i=25; i<=28123; i++) { 
			boolean abundantComposite = false; // not sum of two abundant numbers
			for (int j=12; 2*j<=i; j++) { // 12 is smallest abundant number
				if ((sumPropDivs[j]>j) && sumPropDivs[i-j]>(i-j)) { // sum of two abundants
					abundantComposite = true;
					break;
				}
			}
			if (!abundantComposite) sum += i;
		}
		
		return Integer.toString(sum);
	}

}
