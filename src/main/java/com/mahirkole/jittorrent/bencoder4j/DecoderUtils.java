package com.mahirkole.jittorrent.bencoder4j;

public class DecoderUtils {
	private DecoderUtils() {

	}

	public static boolean isNumber(char ch) {
		return ch >= 48 && ch <= 57;
	}
}
