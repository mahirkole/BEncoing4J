package com.mahirkole.jittorrent.bencoder4j.element;

public class BEncodingNumber implements BEncodingElement<Long> {

	private Long number;
	
	public BEncodingNumber(Long number) {
		this.number = number;
	}
	
	public Long decode() {
		return number;
	}

	public String encode() {
		return "i" + number + "e";
	}
	
	@Override
	public String toString() {
		return number.toString();
		//return "BEncodingNumber [number=" + number + "]";
	}
}
