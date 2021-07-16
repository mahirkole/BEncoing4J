package com.mahirkole.jittorrent.bencoder4j;

public class DecoderUtils {
	private DecoderUtils() {

	}

	public static boolean isNumeric(char ch) {
		return ch >= 48 && ch <= 57;
	}
	
	public static boolean isAsciiAlpha(char ch) {
		return (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122);
	}
}
