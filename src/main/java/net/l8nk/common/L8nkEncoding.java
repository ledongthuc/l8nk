package net.l8nk.common;

import java.math.BigInteger;

public class L8nkEncoding {

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
	
	public static BigInteger decode(String text) {
		
		BigInteger result = new BigInteger("0");
		
		for (int loopIndex = 0; loopIndex < text.length(); loopIndex++) {
			BigInteger basedNumber = new BigInteger(new Integer(charset.length()).toString());
			BigInteger charIndex = new BigInteger(new Integer(text.length() - loopIndex - 1).toString());
			char character = text.charAt(charIndex.intValue());
			 
			BigInteger charsetIndex = new BigInteger(new Integer(charset.indexOf(character)).toString());
			BigInteger value = basedNumber.pow(loopIndex).multiply(charsetIndex);
			result = result.add(value);
		}
		
		return result;
	}
	
}
