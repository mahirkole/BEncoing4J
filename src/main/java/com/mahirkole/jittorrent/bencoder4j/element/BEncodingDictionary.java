package com.mahirkole.jittorrent.bencoder4j.element;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BEncodingDictionary implements BEncodingElement<Map<BEncodingString, BEncodingElement<?>>> {

	private Map<BEncodingString, BEncodingElement<?>> elementDictionary;

	public BEncodingDictionary() {
		this.elementDictionary = new HashMap<BEncodingString, BEncodingElement<?>>();
	}

	public Map<BEncodingString, BEncodingElement<?>> decode() {
		return this.elementDictionary;
	}

	public String encode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("d");
		
		for(Entry<BEncodingString, BEncodingElement<?>> entry : elementDictionary.entrySet()) {
			strBuilder.append(entry.getKey().encode());
			strBuilder.append(entry.getValue().encode());
		}
		
		strBuilder.append("e");
		return strBuilder.toString();
	}
	
	public void put(BEncodingString key, BEncodingElement<?> value) {
		this.elementDictionary.put(key, value);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("{");
		
		for(Entry<BEncodingString, BEncodingElement<?>> entry : elementDictionary.entrySet()) {
			stringBuilder.append(entry.getKey().toString());
			stringBuilder.append(": ");
			stringBuilder.append(entry.getValue().toString());
			stringBuilder.append(", ");
		}
		
		stringBuilder.append("}");
		
		return stringBuilder.toString();
	}
}
