package com.mahirkole.jittorrent.bencoder4j.element;

import java.util.ArrayList;
import java.util.List;

public class BEncodingList implements BEncodingElement<List<BEncodingElement<?>>> {

	private List<BEncodingElement<?>> elementList;

	public BEncodingList() {
		this.elementList = new ArrayList<BEncodingElement<?>>();
	}
	
	public List<BEncodingElement<?>> read() {
		return elementList;
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
