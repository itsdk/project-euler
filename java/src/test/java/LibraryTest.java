package test.java;

/*
 * tests that library of reusable methods are correctly implemented
 */

import static org.junit.Assert.*;
import org.junit.Test;
import main.java.Library;

public class LibraryTest extends Library{
	
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
	public void isPrime() {
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
	public void squareOfSum() {
		assertEquals(squareOfSum(1,10), 3025); // (1 + 2 + ... + 10)^2 = 55^2 = 3025
	}
	
	@Test
	public void sumOfSquares() {
		assertEquals(sumOfSquares(1,10), 385); // 1^2 + 2^2 + ... + 10^2 = 385
	}
}
