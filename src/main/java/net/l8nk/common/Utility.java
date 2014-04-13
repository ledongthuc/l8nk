package net.l8nk.common;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	public static String linkIdToShortUrl(long linkId) {
		String encodedPart = L8nkEncoding.encode(linkId);
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
	
	public static String formatDateDisplay(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm a");
		
		try {
			
			long diff = Math.abs(date.getTime() - new Date().getTime());
			long diffDays = diff / (24 * 60 * 60 * 1000);


			
			if(diffDays == 0) {
				return "Today";
			}
			
			if(diffDays == 1) {
				return "1 day ago";
			}
			
			if(diffDays == 2) {
				return "2 days ago";
			}
			
			if(diffDays == 3) {
				return "3 days ago";
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return df.format(date);
	}
}
