package net.l8nk.common;

import java.net.URI;

public class Utility {
	
	public static String createShortLink(URI longLink) {
		String shortLink = "";
		
		SharedObjects sharedObject = SharedObjects.getInstance();
		long linkToken = sharedObject.getLinkToken();
		
		
		return shortLink;
	}
	
	
	
}
