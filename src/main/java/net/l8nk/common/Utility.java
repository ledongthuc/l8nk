package net.l8nk.common;

import java.math.BigInteger;
import java.security.MessageDigest;

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
	
	public static String linkIdToShortUrl(int linkId) {
		String encodedPart = L8nkEncoding.encode(BigInteger.valueOf(linkId));
		String shortUrl = buildShortUrl(encodedPart);
		return shortUrl;
		
	}
	
	public static String md5(String origin) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] bytes = messageDigest.digest(origin.getBytes(Constants.CHARSET_UTF8));
			String result = new String(bytes, Constants.CHARSET_UTF8);
			return result;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return origin;
	}
	
}
