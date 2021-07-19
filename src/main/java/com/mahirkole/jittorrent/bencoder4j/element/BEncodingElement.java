package com.mahirkole.jittorrent.bencoder4j.element;

public interface BEncodingElement<T> {
	public T decode();
	
	public String encode();
}
