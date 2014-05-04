package net.l8nk.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.l8nk.controller.ShortLinkController;

import org.apache.log4j.Logger;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;

import sun.text.ComposedCharIter;

public class Utility {

	static Logger logger = Logger.getLogger(ShortLinkController.class);
	
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
	
	public static String getTextFromUrl(String link) throws IOException {
		StringBuilder composer = new StringBuilder();
		BufferedReader reader = null;
		try {
			URL url = new URL(link);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String inputLine;
	        while ((inputLine = reader.readLine()) != null) {
	        	composer.append(inputLine);
	        }
	        reader.close();
		} catch(Exception ex) {} finally {
			if(reader != null) {
				reader.close();
			}
		}
		
		return composer.toString();
	}
	
	public static String fillDomainToRelativeLink(String longLink, String rawData) {
		try {
			
			logger.debug("Utility.fillDomainToRelativeLink, rawData:" + rawData);
			
			URL url = new URL(longLink);
			String domain = url.getHost() + ":" + url.getPort();
			
			logger.debug("Utility.fillDomainToRelativeLink, domain:" + domain);
			
			Pattern pattern = Pattern.compile("<img [^>]*");
		    Matcher matcher = pattern.matcher(rawData);
		    while(matcher.find()) {
		    	logger.debug("Utility.fillDomainToRelativeLink, StartGroup: " + matcher.start() + ", EndGroup:" + matcher.end());
		    	logger.debug("Utility.fillDomainToRelativeLink, Group: " + matcher.group());
		    	
		    	String img = matcher.group();
		    	img.indexOf("src=\"");
		    }
			
		} catch(Exception ex) {
			
		}
		
		return rawData;
	}
}
