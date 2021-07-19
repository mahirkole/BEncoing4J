package com.mahirkole.jittorrent.bencoder4j.element;

import java.util.ArrayList;
import java.util.List;

public class BEncodingList implements BEncodingElement<List<BEncodingElement<?>>> {

	private List<BEncodingElement<?>> elementList;

	public BEncodingList() {
		this.elementList = new ArrayList<BEncodingElement<?>>();
	}
	
	public List<BEncodingElement<?>> decode() {
		return elementList;
	}
	
	public String encode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("l");
		
		for(BEncodingElement<?> element : elementList) {
			strBuilder.append(element.encode());
		}
		
		strBuilder.append("e");
		
		return strBuilder.toString();
	}

	public void add(BEncodingElement<?> element) {
		elementList.add(element);
	}
	
	public void addAll(List<BEncodingElement<?>> elementList) {
		elementList.addAll(elementList);
	}
	
	public void remove(BEncodingElement<?> element) {
		elementList.remove(element);
	}
	
	@Override
	public String toString() {
		return "BEncodingList [elementList=" + elementList + "]";
	}
}
