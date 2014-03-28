package net.l8nk.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class l8nkEncodingTest {

	@Test
	public void testEncode() {
		assertEquals("9", l8nkEncoding.encode(10));
	}

}
