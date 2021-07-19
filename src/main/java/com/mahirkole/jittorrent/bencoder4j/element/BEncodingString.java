package com.mahirkole.jittorrent.bencoder4j.element;

public class BEncodingString implements BEncodingElement<String> {
	
	private String decodedString;

	public BEncodingString(String decodedString) {
		this.decodedString = decodedString;
	}

	public String decode() {
		return decodedString;
	}

	public String encode() {
		return decodedString.length() + ":" + decodedString;
	}
	
	@Override
	public String toString() {
		return "BEncodingString [decodedString=" + decodedString + "]";
	}
}
