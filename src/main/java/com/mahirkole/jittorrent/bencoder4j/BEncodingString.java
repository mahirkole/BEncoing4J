package com.mahirkole.jittorrent.bencoder4j;

public class BEncodingString implements BEncodingElement<String> {
	private String encodedString;

	public BEncodingString(String encodedString) {
		this.encodedString = encodedString;
	}

	public String read() {
		return null;
	}
}
