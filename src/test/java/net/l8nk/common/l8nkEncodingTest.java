package net.l8nk.common;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class l8nkEncodingTest {

	@Test
	public void testEncode() {
		
		assertEquals("a", l8nkEncoding.encode(new BigInteger("10")));
		assertEquals("2s", l8nkEncoding.encode(new BigInteger("100")));
		assertEquals("7ps", l8nkEncoding.encode(new BigInteger("10000")));
		assertEquals("255s", l8nkEncoding.encode(new BigInteger("100000")));
		assertEquals("l1x", l8nkEncoding.encode(new BigInteger("27285")));
		assertEquals("232d", l8nkEncoding.encode(new BigInteger("97285")));
		assertEquals("19xtf1ts", l8nkEncoding.encode(new BigInteger("100000000000"))); //1 milion
	}

}
