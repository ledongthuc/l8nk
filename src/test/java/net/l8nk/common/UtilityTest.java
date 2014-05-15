package net.l8nk.common;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilityTest {

	@Test
	public void testGetHostWithPort() {
		assertEquals("", Utility.getHostWithPort(""));
		assertEquals("http://thuc.com.vn", Utility.getHostWithPort("http://thuc.com.vn"));
		assertEquals("", Utility.getHostWithPort("abc"));
		assertEquals("http://abc", Utility.getHostWithPort("http://abc"));
		assertEquals("http://abc.net", Utility.getHostWithPort("http://abc.net/a"));
		assertEquals("http://abc.net:8080", Utility.getHostWithPort("http://abc.net:8080/a"));
		assertEquals("http://abc.net:8080", Utility.getHostWithPort("http://abc.net:8080/b"));
	}
	
	@Test
	public void testFillDomainToRelativeLink() {
		assertEquals("", Utility.fillDomainToRelativeLink("http://thuc.com.vn", ""));
		assertEquals("<i", Utility.fillDomainToRelativeLink("http://thuc.com.vn", "<i"));
		assertEquals("<img", Utility.fillDomainToRelativeLink("http://thuc.com.vn", "<img"));
		assertEquals("<img abc", Utility.fillDomainToRelativeLink("http://thuc.com.vn", "<img abc"));
		assertEquals("<img sr", Utility.fillDomainToRelativeLink("http://thuc.com.vn", "<img sr"));
		assertEquals("<img src", Utility.fillDomainToRelativeLink("http://thuc.com.vn", "<img src"));
		assertEquals("<img src=", Utility.fillDomainToRelativeLink("http://thuc.com.vn", "<img src="));
		assertEquals("<img src=\"http://thuc.com.vn/abc", Utility.fillDomainToRelativeLink("http://thuc.com.vn", "<img src=\"abc"));
		assertEquals("<img src=\"http://thuc.com.vn/gamevn.img\" />", Utility.fillDomainToRelativeLink("http://thuc.com.vn", "<img src=\"gamevn.img\" />"));
		assertEquals("<img src=\"http://thuc.com.vn/gamevn.img\" /><img src=\"http://thuc.com.vn/gamevn.img\" /><img src=\"http://thuc.com.vn/gamevn.img\" />", Utility.fillDomainToRelativeLink("http://thuc.com.vn", "<img src=\"gamevn.img\" /><img src=\"gamevn.img\" /><img src=\"gamevn.img\" />"));
	}
	
	public void testIsNumeric() {
		assertEquals(true, Utility.isNumeric("1"));
		assertEquals(false, Utility.isNumeric(""));
		assertEquals(false, Utility.isNumeric(null));
		assertEquals(true, Utility.isNumeric("123"));
		assertEquals(false, Utility.isNumeric("123a"));
		assertEquals(false, Utility.isNumeric("123aa123"));
	}
}
