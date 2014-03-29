package net.l8nk.common;

import java.math.BigInteger;
import java.net.URI;

public class Utility {
	
	public static String createShortLink(URI longLink) {
		String shortLink = "";
		
		SharedObject sharedObject = SharedObject.getInstance();
		BigInteger linkToken = sharedObject.increaseLinkToken();
		
		
		return shortLink;
	}
	
	
	
}
