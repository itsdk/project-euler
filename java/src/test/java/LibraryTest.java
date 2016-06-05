package test.java;

/*
 * tests that library of reusable methods are correctly implemented
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.TreeSet;
import java.math.BigInteger;
import java.util.ArrayList;
import main.java.Library;

public class LibraryTest extends Library{
	
	@Test
	public void alphaScoreTest() {
		assertEquals(alphaScore("COLIN"), 53); // COLIN = 3 + 15 + 12 + 9 + 14 = 53
	}
	
	@Test
	public void binomialCoefficientTest() {
		assertEquals(binomialCoefficient(5,3), 10L); 
		// 8th row of Pascal's Triangle:
		assertEquals(binomialCoefficient(8,0), 1L); 
		assertEquals(binomialCoefficient(8,1), 8L); 
		assertEquals(binomialCoefficient(8,2), 28L); 
		assertEquals(binomialCoefficient(8,3), 56L); 
		assertEquals(binomialCoefficient(8,4), 70L); 
		assertEquals(binomialCoefficient(8,5), 56L); 
		assertEquals(binomialCoefficient(8,6), 28L); 
		assertEquals(binomialCoefficient(8,7), 8L); 
		assertEquals(binomialCoefficient(8,8), 1L); 
	}
	
	@Test
	public void cyclicallyPermuteTest() {
		assertEquals(cyclicallyPermute(1234), 
				new ArrayList<Integer>(Arrays.asList(1234, 2341, 3412, 4123)));
		assertEquals(cyclicallyPermute(5), 
				new ArrayList<Integer>(Arrays.asList(5)));
	}
	
	@Test
	public void decimalToFactorialTest() {
		/*
		 * 463 / 1 = 463, remainder 0
		 * 463 / 2 = 231, remainder 1
		 * 231 / 3 = 77,  remainder 0
		 *  77 / 4 = 19,  remainder 1
		 *  19 / 5 = 3,   remainder 4
		 *   3 / 6 = 0,   remainder 3
		 */
		assertEquals(decimalToFactorial(463), 341010);
	}
	
	@Test
	public void factorialTest() {
		assertEquals(factorial(0), new BigInteger("1"));
		assertEquals(factorial(1), new BigInteger("1"));
		assertEquals(factorial(2), new BigInteger("2"));
		assertEquals(factorial(3), new BigInteger("6"));
		assertEquals(factorial(4), new BigInteger("24"));
		assertEquals(factorial(5), new BigInteger("120"));
		assertEquals(factorial(6), new BigInteger("720"));
		assertEquals(factorial(7), new BigInteger("5040"));
		assertEquals(factorial(8), new BigInteger("40320"));
		assertEquals(factorial(9), new BigInteger("362880"));
		assertEquals(factorial(10), new BigInteger("3628800")); // 10! == 3628800
		assertEquals(factorial(11), new BigInteger("39916800"));
	}
	
	@Test
	public void factorialToDecimalTest() {
		/*
		 * 341010 (factorial number system)
		 * = 3*5! + 4*4! + 1*3! + 0*2! + 1*1! + 0*0! 
		 * = 463 (decimal number system)
		 */
		assertEquals(factorialToDecimal(341010), 463);
	}
	
	@Test
	public void fibonacciIndexOfTest() {
		assertEquals(fibonacciIndexOf(new BigInteger("1")), 2);    // 1   == F(2)
		assertEquals(fibonacciIndexOf(new BigInteger("2")), 3);    // 2   == F(3)
		assertEquals(fibonacciIndexOf(new BigInteger("3")), 4);    // 3   == F(4)
		assertEquals(fibonacciIndexOf(new BigInteger("4")), 5);    // 4   <  F(5)  = 5
		assertEquals(fibonacciIndexOf(new BigInteger("5")), 5);    // 5   == F(5)
		assertEquals(fibonacciIndexOf(new BigInteger("10")), 7);   // 10  <  F(7)  = 13
		assertEquals(fibonacciIndexOf(new BigInteger("100")), 12); // 100 <  F(12) = 144
	}
	
	@Test
	public void gcdTest() {
		assertEquals(gcd(8,12), 4); // 4 is greatest number that divides both 8 and 12 with no remainder
	}
	
	@Test
	public void getDigitsUniqueTest() {
		assertEquals(getDigitsUnique(0), new TreeSet<Integer>(Arrays.asList(0)));
		assertEquals(getDigitsUnique(12345), new TreeSet<Integer>(Arrays.asList(1,2,3,4,5)));
		assertEquals(getDigitsUnique(4242), new TreeSet<Integer>(Arrays.asList(2,4)));
	}
	
	@Test
	public void getHexagonalTest() {
		assertEquals(getHexagonal(-1), 0L);
		assertEquals(getHexagonal(0), 0L);
		assertEquals(getHexagonal(1), 1L);
		assertEquals(getHexagonal(2), 6L);
		assertEquals(getHexagonal(143), 40755L);
	}
	
	@Test
	public void getPentagonalTest() {
		assertEquals(getPentagonal(-1), 0);
		assertEquals(getPentagonal(0), 0);
		assertEquals(getPentagonal(1), 1);
		assertEquals(getPentagonal(2), 5);
		assertEquals(getPentagonal(3), 12);
		assertEquals(getPentagonal(4), 22);
		assertEquals(getPentagonal(5), 35);
		assertEquals(getPentagonal(6), 51);
		assertEquals(getPentagonal(7), 70);
		assertEquals(getPentagonal(8), 92);
		assertEquals(getPentagonal(9), 117);
		assertEquals(getPentagonal(10), 145);
	}
	
	@Test
	public void getPrimeTest() {
		assertEquals(getPrime(-1), 0); // invalid n=-1
		assertEquals(getPrime(0), 0);  // invalid n=0
		assertEquals(getPrime(1), 2);  // first prime = 2
		assertEquals(getPrime(6), 13); // sixth prime = 13
	}
	
	@Test
	public void getPrimesBelowTest() {
		// prime numbers below 10 are; 2, 3, 5, and 7
		assertEquals(getPrimesBelow(10), new ArrayList<Integer>(Arrays.asList(2,3,5,7)));
	}
	
	@Test
	public void getTriangularNumberTest() {
		assertEquals(getTriangularNumber(0L), 0L);
		assertEquals(getTriangularNumber(7L), 28L); // 1+2+3+4+5+6+7=28
	}
	
	@Test
	public void intPowTest() {
		assertEquals(intPow(0, 4), 0);
		assertEquals(intPow(1, 4), 1);
		assertEquals(intPow(2, 4), 16);
		assertEquals(intPow(3, 4), 81);
		assertEquals(intPow(9, 5), 59049);
	}
	
	@Test
	public void isNSquareTest() {
		assertFalse(isNSquare(-1, 2));
		assertTrue(isNSquare(0, 2));  // 2*(0^2) == 0
		assertFalse(isNSquare(1, 2));
		assertTrue(isNSquare(2, 2));  // 2*(1^2) == 2
		assertFalse(isNSquare(3, 2));
		assertFalse(isNSquare(4, 2));
		assertTrue(isNSquare(8, 2));  // 2*(2^2) == 8
		assertTrue(isNSquare(18, 2)); // 2*(3^2) == 18
		
		assertFalse(isNSquare(-1, 3));
		assertTrue(isNSquare(0, 3));  // 3*(0^2) == 0
		assertFalse(isNSquare(1, 3)); 
		assertFalse(isNSquare(2, 3)); 
		assertTrue(isNSquare(3, 3));  // 3*(1^2) == 3
		assertFalse(isNSquare(4, 3));
		assertTrue(isNSquare(12, 3)); // 3*(2^2) == 12
		assertTrue(isNSquare(27, 3)); // 3*(3^2) == 27
	}
	
	@Test 
	public void isPalindromeTest() { 
		assertTrue(isPalindrome("racecar"));  // odd number of characters
		assertTrue(isPalindrome("noon"));     // even number of characters
		assertTrue(isPalindrome("Madam"));    // upper and lower case
		assertTrue(isPalindrome("777"));      // odd number of numbers
		assertTrue(isPalindrome("19877891")); // even number of numbers
		
		assertFalse(isPalindrome("matthew")); // not a palindrome
		assertFalse(isPalindrome("1234567890"));
	}
	
	@Test
	public void isPandigitalTest() {
		assertFalse(isPandigital(0));
		assertFalse(isPandigital(4));
		assertTrue(isPandigital(1));
		assertTrue(isPandigital(12345));
		assertTrue(isPandigital(23154));
		assertFalse(isPandigital(12335));
		assertFalse(isPandigital(111));
	}
	
	@Test
	public void isPentagonalTest() {
		assertFalse(isPentagonal(-1));
		assertFalse(isPentagonal(0));
		assertTrue(isPentagonal(1));
		assertFalse(isPentagonal(2));
		assertFalse(isPentagonal(3));
		assertFalse(isPentagonal(4));
		assertTrue(isPentagonal(5));
		assertTrue(isPentagonal(40755));
		assertFalse(isPentagonal(40756));
	}
	
	@Test
	public void isPrimeTest() {
		assertFalse(isPrime(-1));
		assertFalse(isPrime(0));
		assertFalse(isPrime(1));
		assertTrue(isPrime(2));
		assertTrue(isPrime(3));
		assertFalse(isPrime(4));
		assertTrue(isPrime(5));
		assertTrue(isPrime(787));
		
		assertFalse(isPrime(new ArrayList<Integer>(Arrays.asList(4))));
		assertFalse(isPrime(new ArrayList<Integer>(Arrays.asList(2,3,4,5))));
		assertTrue(isPrime(new ArrayList<Integer>(Arrays.asList(2,3,5))));
	}
	
	@Test
	public void isRightTriangleTest() {
		assertTrue(isRightTriangle(3,4,5));
		assertTrue(isRightTriangle(20,48,52));
		assertFalse(isRightTriangle(1,1,1));
		assertFalse(isRightTriangle(2,3,4));
	}
	
	@Test
	public void lcmTest() {
		assertEquals(lcm(10), 2520); // given in Project Euler problem#5's question
	}
	
	@Test
	public void longestRecurrenceTest() {
		assertEquals(longestRecurrence(2), 1); // 1/2 = 0.5
		assertEquals(longestRecurrence(3), 1); // 1/3 = 0.(3)333333...
		assertEquals(longestRecurrence(7), 6); // 1/7 = 0.(142857)142857...
	}
	
	@Test
	public void maxRowsSumTest() {
		/*
		 * 	  7 4
		 * + 2 4 6
		 * --------
		 * = 11 10
		 */
		assertArrayEquals(maxRowsSum(new int[]{7,4}, new int[]{2, 4, 6}), new int[]{11, 10});
	}
	
	@Test
	public void nextCollatzTest() {
		// test Collatz Chain: 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1:
		assertEquals(nextCollatz(13), 40);
		assertEquals(nextCollatz(40), 20);
		assertEquals(nextCollatz(20), 10);
		assertEquals(nextCollatz(10), 5);
		assertEquals(nextCollatz(5), 16);
		assertEquals(nextCollatz(16), 8);
		assertEquals(nextCollatz(8), 4);
		assertEquals(nextCollatz(4), 2);
		assertEquals(nextCollatz(2), 1);
	}
	
	@Test
	public void numberOfDigitsTest() {
		assertEquals(numberOfDigits(-1L), 0); // negative numbers not supported
		assertEquals(numberOfDigits(0L), 0);
		assertEquals(numberOfDigits(5L), 1);
		assertEquals(numberOfDigits(42L), 2);
		assertEquals(numberOfDigits(777L), 3);
		assertEquals(numberOfDigits(4096L), 4);
	}
	
	@Test
	public void numberToWordsTest() {
		assertEquals(numberToWords(1001), ""); // >1000 not implemented
		assertEquals(numberToWords(-1), "negativeone");
		assertEquals(numberToWords(1), "one");
		assertEquals(numberToWords(12), "twelve");
		assertEquals(numberToWords(30), "thirty");
		assertEquals(numberToWords(35), "thirtyfive");
		assertEquals(numberToWords(600), "sixhundred");
		assertEquals(numberToWords(704), "sevenhundredandfour");
		assertEquals(numberToWords(787), "sevenhundredandeightyseven");
		assertEquals(numberToWords(1000), "onethousand");
	}
	
	@Test
	public void permutationsTest() {
		/*
		 * permutations of 123:
		 * # permutations = 3! = 3*2*1 = 6
		 * permutations = 123, 213, 312, 132, 231, 321
		 */
		ArrayList<Long> perms = new ArrayList<Long>(factorial(3).intValue());
		permutations(3, new int[]{1,2,3}, perms);
		assertEquals(perms, Arrays.asList(123L, 213L, 312L, 132L, 231L, 321L));
	}
	
	@Test
	public void replaceDigitTest() {
		assertEquals(replaceDigit(0,22,4), 42);
		assertEquals(replaceDigit(3,22,4), 22); // index out of range
		assertEquals(replaceDigit(-1,22,4), 22); // index out of range
		assertEquals(replaceDigit(0,22,11), 22); // digit out of range
		assertEquals(replaceDigit(0,22,-1), 22); // digit out of range

		assertEquals(replaceDigit(0,12345,9), 92345);
		assertEquals(replaceDigit(1,12345,9), 19345);
		assertEquals(replaceDigit(4,12345,9), 12349);
	}
	
	@Test
	public void squareOfSumTest() {
		assertEquals(squareOfSum(1,10), 3025); // (1 + 2 + ... + 10)^2 = 55^2 = 3025
	}
	
	@Test
	public void subNumTest() {
		assertEquals(subNum(123456L, 2, 3), 345L);
		assertEquals(subNum(120456L, 2, 3), 45L);
		assertEquals(subNum(1063572894L, 1, 3), 63L);
	}
	
	@Test
	public void sumAmicablesTest() {
		assertEquals(sumAmicables(300), 504); // 504 = 220 + 284
	}
	
	@Test
	public void sumDigitsTest() {
		assertEquals(sumDigits(new BigInteger("123")), 6L);    // 1+2+3=6
		assertEquals(sumDigits(new BigInteger("-123")), 6L);   // 1+2+3=6
		assertEquals(sumDigits(new BigInteger("32768")), 26L); // 3+2+7+6+8=26
	}
	
	@Test
	public void sumOfSquaresTest() {
		assertEquals(sumOfSquares(1,10), 385); // 1^2 + 2^2 + ... + 10^2 = 385
	}
	
	@Test
	public void sumPropDivsTest() {
		assertEquals(sumPropDivs(1), 0);  
		assertEquals(sumPropDivs(2), 1);  // 1 = 1
		assertEquals(sumPropDivs(3), 1);  // 1 = 1
		assertEquals(sumPropDivs(4), 3);  // 3 = 1+2
		assertEquals(sumPropDivs(10), 8); // 8 = 1+2+5		
	}
	
	@Test
	public void truncateLeftTest() {
		assertEquals(truncateLeft(1234), 123);
		assertEquals(truncateLeft(0), 0);
		assertEquals(truncateLeft(5), 0);
	}

	@Test
	public void truncateRightTest() {
		assertEquals(truncateRight(1234), 234);
		assertEquals(truncateRight(0), 0);
		assertEquals(truncateRight(5), 0);
	}
	
	
}
