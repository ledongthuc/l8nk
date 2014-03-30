package net.l8nk.common;

import java.math.BigInteger;
import java.net.URI;

public class Utility {
	
	public static String formatUrl(String rawUrl) {
		if(rawUrl == null || rawUrl.isEmpty()) {
			return "";
		}
		
		rawUrl = rawUrl.toLowerCase();
		
		if(!rawUrl.startsWith("http")) {
			rawUrl = "http://" + rawUrl;
		}
		
		return rawUrl;
	}

	public static String buildShortUrl(String encodedPart) {
		String rawUrl = String.format(Constants.SHORT_LINK_PARTTEN, encodedPart);
		return formatUrl(rawUrl);
	}
	
}
