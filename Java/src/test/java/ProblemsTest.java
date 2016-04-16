package test.java;

/*
 * test that all problems have correct solutions 
 */

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.*; // problems (P001, P002, etc.)

public class ProblemsTest {
	
	private Problem p = null;
	
	@Test 
	public void TestP001() { 
		p = new P001();
		assertEquals(p.solve(), "233168");
		p.time();
	}

}
