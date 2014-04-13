package net.l8nk.common;

import static org.junit.Assert.*;


import org.junit.Test;

public class l8nkEncodingTest {

	@Test
	public void testEncode() {
		
		assertEquals("a", L8nkEncoding.encode(10));
		assertEquals("2s", L8nkEncoding.encode(100));
		assertEquals("7ps", L8nkEncoding.encode(10000));
		assertEquals("255s", L8nkEncoding.encode(100000));
		assertEquals("l1x", L8nkEncoding.encode(27285));
		assertEquals("232d", L8nkEncoding.encode(97285));
	}
	
	@Test
	public void testDecode() {
		
		assertEquals(10, L8nkEncoding.decode("a"));
		assertEquals(100, L8nkEncoding.decode("2s"));
		assertEquals(10000, L8nkEncoding.decode("7ps"));
		assertEquals(100000, L8nkEncoding.decode("255s"));
		assertEquals(27285, L8nkEncoding.decode("l1x"));
		assertEquals(97285, L8nkEncoding.decode("232d"));
	}

}
