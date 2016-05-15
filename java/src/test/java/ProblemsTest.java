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
	
	@Test
	public void testP011() {
		p = new P011();
		assertEquals(p.solve(), "70600674");
		p.time();
	}
	
	@Test
	public void testP012() {
		p = new P012();
		assertEquals(p.solve(), "76576500");
		p.time();
	}
	
	@Test
	public void testP013() {
		p = new P013();
		assertEquals(p.solve(), "5537376230");
		p.time();
	}
	
	@Test
	public void testP014() {
		p = new P014();
		assertEquals(p.solve(), "837799");
		p.time();
	}
	
	@Test
	public void testP015() {
		p = new P015();
		assertEquals(p.solve(), "137846528820");
		p.time();
	}
	
	@Test
	public void testP016() {
		p = new P016();
		assertEquals(p.solve(), "1366");
		p.time();
	}
	
	@Test
	public void testP017() {
		p = new P017();
		assertEquals(p.solve(), "21124");
		p.time();
	}
	
	@Test
	public void testP018() {
		p = new P018();
		assertEquals(p.solve(), "1074");
		p.time();
	}
	
	@Test
	public void testP019() {
		p = new P019();
		assertEquals(p.solve(), "171");
		p.time();
	}
	
	@Test
	public void testP020() {
		p = new P020();
		assertEquals(p.solve(), "648");
		p.time();
	}
	
	@Test
	public void testP021() {
		p = new P021();
		assertEquals(p.solve(), "31626");
		p.time();
	}
	
	@Test
	public void testP022() {
		p = new P022();
		assertEquals(p.solve(), "871198282");
		p.time();
	}
	
	@Test
	public void testP023() {
		p = new P023();
		assertEquals(p.solve(), "4179871");
		p.time();
	}
	
	@Test
	public void testP024() {
		p = new P024();
		assertEquals(p.solve(), "2783915460");
		p.time();
	}
	
	@Test
	public void testP025() {
		p = new P025();
		assertEquals(p.solve(), "4782");
		p.time();
	}
	
	@Test
	public void testP026() {
		p = new P026();
		assertEquals(p.solve(), "983");
		p.time();
	}
	
	@Test
	public void testP027() {
		p = new P027();
		assertEquals(p.solve(), "-59231");
		p.time();
	}
	
	@Test
	public void testP028() {
		p = new P028();
		assertEquals(p.solve(), "669171001");
		p.time();
	}
	
	@Test
	public void testP029() {
		p = new P029();
		assertEquals(p.solve(), "9183");
		p.time();
	}
	
	@Test
	public void testP030() {
		p = new P030();
		assertEquals(p.solve(), "443839");
		p.time();
	}
	
	@Test
	public void testP031() {
		p = new P031();
		assertEquals(p.solve(), "73682");
		p.time();
	}
	
	@Test
	public void testP032() {
		p = new P032();
		assertEquals(p.solve(), "45228");
		p.time();
	}
	
	@Test
	public void testP033() {
		p = new P033();
		assertEquals(p.solve(), "100");
		p.time();
	}
	
	@Test
	public void testP034() {
		p = new P034();
		assertEquals(p.solve(), "40730");
		p.time();
	}
	
	@Test
	public void testP035() {
		p = new P035();
		assertEquals(p.solve(), "55");
		p.time();
	}
	
	@Test
	public void testP036() {
		p = new P036();
		assertEquals(p.solve(), "872187");
		p.time();
	}
	
	@Test
	public void testP037() {
		p = new P037();
		assertEquals(p.solve(), "748317");
		p.time();
	}
	
	@Test
	public void testP038() {
		p = new P038();
		assertEquals(p.solve(), "932718654");
		p.time();
	}
	
	@Test
	public void testP039() {
		p = new P039();
		assertEquals(p.solve(), "840");
		p.time();
	}
	
}
