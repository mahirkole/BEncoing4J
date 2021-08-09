package com.mahirkole.jittorrent.bencoder4j.element;

import java.util.Arrays;

public class BEncodingString implements BEncodingElement<byte[]> {
	
	private byte[] byteString;

	public BEncodingString(byte[] byteString) {
		this.byteString = byteString;
	}

	public byte[] decode() {
		return byteString;
	}

	public String encode() {
		return byteString.length + ":" + byteString.toString();
	}
	
	@Override
	public String toString() {
		return new String(byteString);
		//return "BEncodingString [byteString=" + new String(byteString) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(byteString);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BEncodingString other = (BEncodingString) obj;
		if (!Arrays.equals(byteString, other.byteString))
			return false;
		return true;
	}
}
