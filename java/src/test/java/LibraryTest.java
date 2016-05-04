package test.java;

/*
 * tests that library of reusable methods are correctly implemented
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
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
	public void isPrimeTest() {
		assertFalse(isPrime(-1));
		assertFalse(isPrime(0));
		assertFalse(isPrime(1));
		assertTrue(isPrime(2));
		assertTrue(isPrime(3));
		assertFalse(isPrime(4));
		assertTrue(isPrime(5));
		assertTrue(isPrime(787));
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
	public void squareOfSumTest() {
		assertEquals(squareOfSum(1,10), 3025); // (1 + 2 + ... + 10)^2 = 55^2 = 3025
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
}
