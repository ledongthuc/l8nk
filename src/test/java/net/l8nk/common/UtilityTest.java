package net.l8nk.common;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilityTest {

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
	
}
