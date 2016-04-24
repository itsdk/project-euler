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
	
	@Test
	public void testP006() {
		p = new P006();
		assertEquals(p.solve(), "25164150");
		p.time();
	}
	
	@Test
	public void testP007() {
		p = new P007();
		assertEquals(p.solve(), "104743");
		p.time();
	}
	
	@Test
	public void testP008() {
		p = new P008();
		assertEquals(p.solve(), "23514624000");
		p.time();
	}
	
	@Test
	public void testP009() {
		p = new P009();
		assertEquals(p.solve(), "31875000");
		p.time();
	}
	
	@Test
	public void testP010() {
		p = new P010();
		assertEquals(p.solve(), "142913828922");
		p.time();
	}

}
