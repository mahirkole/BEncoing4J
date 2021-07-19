package com.mahirkole.jittorrent.bencoder4j.element;

public class BEncodingInteger implements BEncodingElement<Integer> {

	private Integer integer;
	
	public BEncodingInteger(Integer integer) {
		this.integer = integer;
	}
	
	public Integer read() {
		return integer;
	}

	@Override
	public String toString() {
		return "BEncodingInteger [integer=" + integer + "]";
	}
}
