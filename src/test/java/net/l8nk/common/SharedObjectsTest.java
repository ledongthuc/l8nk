/**
 * 
 */
package net.l8nk.common;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import net.l8nk.entity.SharedObject;

import org.junit.Test;

/**
 * @author thuc.le
 *
 */
public class SharedObjectsTest {

	@Test
	public void testLinkToken() {
		SharedObject.getInstance().setLinkToken(new BigInteger("123"));
		assertEquals(new BigInteger("123"), SharedObject.getInstance().getLinkToken());
		assertEquals(new BigInteger("124"), SharedObject.getInstance().increaseLinkToken());
		assertEquals(new BigInteger("124"), SharedObject.getInstance().getLinkToken());
		
		
		SharedObject.getInstance().setLinkToken(new BigInteger("100000000000"));
		assertEquals(new BigInteger("100000000000"), SharedObject.getInstance().getLinkToken());
		assertEquals(new BigInteger("100000000001"), SharedObject.getInstance().increaseLinkToken());
		assertEquals(new BigInteger("100000000001"), SharedObject.getInstance().getLinkToken());
		
		
		SharedObject.getInstance().setLinkToken(new BigInteger("100007513500"));
		assertEquals(new BigInteger("100007513501"), SharedObject.getInstance().increaseLinkToken());
		assertEquals(new BigInteger("100007513502"), SharedObject.getInstance().increaseLinkToken());
		assertEquals(new BigInteger("100007513503"), SharedObject.getInstance().increaseLinkToken());
		assertEquals(new BigInteger("100007513503"), SharedObject.getInstance().getLinkToken());
	}
	
}
