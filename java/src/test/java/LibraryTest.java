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
	public void lcmTest() {
		assertEquals(lcm(10), 2520); // given in Project Euler problem#5's question
	}
}
