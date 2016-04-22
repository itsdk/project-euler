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
	public void testP001() { 
		p = new P001();
		assertEquals(p.solve(), "233168");
		p.time();
	}
	
	@Test
	public void testP002() {
		p = new P002();
		assertEquals(p.solve(), "4613732");
		p.time();	
	}
	
	@Test
	public void testP003() {
		p = new P003();
		assertEquals(p.solve(), "6857");
		p.time();	
	}
	
	@Test
	public void testP004() {
		p = new P004();
		assertEquals(p.solve(), "906609");
		p.time();	
	}
	
	@Test
	public void testP005() {
		p = new P005();
		assertEquals(p.solve(), "232792560");
		p.time();
	}

}
