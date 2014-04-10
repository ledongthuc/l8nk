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
	
	@Test
	public void testDecode() {
		
		assertEquals(new BigInteger("10"), L8nkEncoding.decode("a"));
		assertEquals(new BigInteger("100"), L8nkEncoding.decode("2s"));
		assertEquals(new BigInteger("10000"), L8nkEncoding.decode("7ps"));
		assertEquals(new BigInteger("100000"), L8nkEncoding.decode("255s"));
		assertEquals(new BigInteger("27285"), L8nkEncoding.decode("l1x"));
		assertEquals(new BigInteger("97285"), L8nkEncoding.decode("232d"));
		assertEquals(new BigInteger("100000000000"), L8nkEncoding.decode("19xtf1ts")); //1 milion
	}

}
