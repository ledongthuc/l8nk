package net.l8nk.common;

public class l8nkEncoding {

	private static String charset = "0123456789abcdefghijklmnopqrstuvwxyz";
	
	public static String encode(long code) {
		StringBuilder charsBuilder = new StringBuilder();
		int charsetLength= charset.length();
		long restOfCode = code;
		int nextCode;
		char nextChar;
		
		do {
			nextCode = (int) (restOfCode % charsetLength);
			restOfCode = restOfCode / charsetLength;
			
			nextChar = charset.charAt(nextCode);
			charsBuilder.insert(0, nextChar);
		} while(restOfCode > charsetLength);
		
		return charsBuilder.toString();
	}
	
	public static long decode(String text) {
		return -1;
	}
	
}
