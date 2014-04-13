package net.l8nk.common;

public class L8nkEncoding {

	private static String charset = "0123456789abcdefghijklmnopqrstuvwxyz";
	
	public static String encode(long restOfCode) {
		StringBuilder charsBuilder = new StringBuilder();
		int charsetLength= charset.length();
		int nextCode;
		char nextChar;
		
		do {
			nextCode = (int) (restOfCode % charsetLength);
			restOfCode = restOfCode / charsetLength;
			
			nextChar = charset.charAt(nextCode);
			charsBuilder.insert(0, nextChar);
		} while(restOfCode > 0);
		
		return charsBuilder.toString();
	}
	
	public static long decode(String text) {
		
		long result = 0;
		
		for (int loopIndex = 0; loopIndex < text.length(); loopIndex++) {
			int basedNumber = charset.length();
			int charIndex = text.length() - loopIndex - 1;
			char character = text.charAt(charIndex);
			 
			long charsetIndex = charset.indexOf(character);
			long value = (long) (Math.pow(basedNumber, loopIndex) * charsetIndex);
			result = result + value;
		}
		
		return result;
	}
	
}
