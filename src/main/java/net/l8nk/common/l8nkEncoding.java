package net.l8nk.common;

import java.math.BigInteger;

public class l8nkEncoding {

	private static String charset = "0123456789abcdefghijklmnopqrstuvwxyz";
	
	public static String encode(BigInteger code) {
		StringBuilder charsBuilder = new StringBuilder();
		String charsetLength= String.valueOf(charset.length());
		BigInteger restOfCode = code;
		int nextCode;
		char nextChar;
		
		do {
			nextCode = restOfCode.mod(new BigInteger(charsetLength)).intValue();
			restOfCode = restOfCode.divide(new BigInteger(charsetLength));
			
			nextChar = charset.charAt(nextCode);
			charsBuilder.insert(0, nextChar);
		} while(restOfCode.compareTo(BigInteger.ZERO) > 0);
		
		return charsBuilder.toString();
	}
	
	public static long decode(String text) {
		return -1;
	}
	
}
