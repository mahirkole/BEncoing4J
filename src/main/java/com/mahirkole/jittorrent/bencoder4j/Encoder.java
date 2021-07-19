package com.mahirkole.jittorrent.bencoder4j;

import com.mahirkole.jittorrent.bencoder4j.element.BEncodingDictionary;
import com.mahirkole.jittorrent.bencoder4j.element.BEncodingElement;
import com.mahirkole.jittorrent.bencoder4j.element.BEncodingInteger;
import com.mahirkole.jittorrent.bencoder4j.element.BEncodingList;
import com.mahirkole.jittorrent.bencoder4j.element.BEncodingString;

public class Encoder {

	private static Encoder encoder;

	private Encoder() {

	}

	public synchronized static Encoder getInstance() {
		if (encoder == null) {
			encoder = new Encoder();
		}
		return encoder;
	}

	public String encode(BEncodingElement<?> element) {
		return element.encode();
	}
	
	public String encode(BEncodingString string) {
		return string.encode();
	}

	public String encode(BEncodingInteger integer) {
		return integer.encode();
	}

	public String encode(BEncodingList list) {
		return list.encode();
	}

	public String encode(BEncodingDictionary dictionary) {
		return dictionary.encode();
	}
}
