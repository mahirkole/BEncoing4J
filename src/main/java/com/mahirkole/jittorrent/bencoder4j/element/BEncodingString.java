package com.mahirkole.jittorrent.bencoder4j.element;

public class BEncodingString implements BEncodingElement<String> {
	
	private String decodedString;

	public BEncodingString(String decodedString) {
		this.decodedString = decodedString;
	}

	public String read() {
		return decodedString;
	}

	@Override
	public String toString() {
		return "BEncodingString [decodedString=" + decodedString + "]";
	}
}
