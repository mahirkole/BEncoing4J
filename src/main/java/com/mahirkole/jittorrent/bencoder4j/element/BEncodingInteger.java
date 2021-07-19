package com.mahirkole.jittorrent.bencoder4j.element;

public class BEncodingInteger implements BEncodingElement<Integer> {

	private Integer integer;
	
	public BEncodingInteger(Integer integer) {
		this.integer = integer;
	}
	
	public Integer decode() {
		return integer;
	}

	public String encode() {
		return "i" + integer + "e";
	}
	
	@Override
	public String toString() {
		return "BEncodingInteger [integer=" + integer + "]";
	}
}
