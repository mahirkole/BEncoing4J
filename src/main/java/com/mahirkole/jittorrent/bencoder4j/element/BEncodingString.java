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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((decodedString == null) ? 0 : decodedString.hashCode());
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
		if (decodedString == null) {
			if (other.decodedString != null)
				return false;
		} else if (!decodedString.equals(other.decodedString))
			return false;
		return true;
	}
}
