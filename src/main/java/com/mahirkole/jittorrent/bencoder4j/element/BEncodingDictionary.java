package com.mahirkole.jittorrent.bencoder4j.element;

import java.util.HashMap;
import java.util.Map;

public class BEncodingDictionary implements BEncodingElement<Map<BEncodingString, BEncodingElement<?>>> {

	private Map<BEncodingString, BEncodingElement<?>> elementDictionary;

	public BEncodingDictionary() {
		this.elementDictionary = new HashMap<BEncodingString, BEncodingElement<?>>();
	}

	public Map<BEncodingString, BEncodingElement<?>> read() {
		return this.elementDictionary;
	}

	public void put(BEncodingString key, BEncodingElement<?> value) {
		this.elementDictionary.put(key, value);
	}

	@Override
	public String toString() {
		return "BEncodingDictionary [elementDictionary=" + elementDictionary + "]";
	}
}
