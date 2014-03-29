package net.l8nk.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class l8nkEncodingTest {

	@Test
	public void testEncode() {
		
		assertEquals("a", l8nkEncoding.encode(10));
		assertEquals("2s", l8nkEncoding.encode(100));
		assertEquals("7ps", l8nkEncoding.encode(10000));
		assertEquals("255s", l8nkEncoding.encode(100000));
		assertEquals("255s", l8nkEncoding.encode(97285));
	}

}
