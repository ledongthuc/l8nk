package net.l8nk.common;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class l8nkEncodingTest {

	@Test
	public void testEncode() {
		
		assertEquals("a", L8nkEncoding.encode(new BigInteger("10")));
		assertEquals("2s", L8nkEncoding.encode(new BigInteger("100")));
		assertEquals("7ps", L8nkEncoding.encode(new BigInteger("10000")));
		assertEquals("255s", L8nkEncoding.encode(new BigInteger("100000")));
		assertEquals("l1x", L8nkEncoding.encode(new BigInteger("27285")));
		assertEquals("232d", L8nkEncoding.encode(new BigInteger("97285")));
		assertEquals("19xtf1ts", L8nkEncoding.encode(new BigInteger("100000000000"))); //1 milion
	}

}
