package com.mahirkole.jittorrent.bencoder4j;

public class BEncodingReader {
	
	private int index;
	private byte[] byteArray;
	
	public BEncodingReader(String content) {
		this(content.getBytes());
	}
	
	public BEncodingReader(byte[] byteArray) {
		this.byteArray = byteArray;
		index = 0;
	}
	
	public int getIndex() {
		return index;
	}
	
	public byte peek() {
		return byteArray[index];
	}
	
	public byte peek(int offset) {
		return byteArray[index + offset];
	}
	
	public byte read() {
		return byteArray[index++];
	}
	
	public void rewind(int i) {
		index -= i;
	}
}
