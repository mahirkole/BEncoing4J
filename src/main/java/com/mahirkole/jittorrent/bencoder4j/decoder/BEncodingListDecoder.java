package com.mahirkole.jittorrent.bencoder4j.decoder;

import java.io.IOException;
import java.io.StringReader;

import com.mahirkole.jittorrent.bencoder4j.Decoder;
import com.mahirkole.jittorrent.bencoder4j.element.BEncodingList;

public class BEncodingListDecoder implements BEncodingElementDecoder<BEncodingList>{

	private StringReader reader;
	
	public void setReader(StringReader reader) {
		this.reader = reader;
	}

	public BEncodingList decode() throws IOException {
		Decoder decoder = Decoder.getInstance();
		
		char next = (char) reader.read();
		
		BEncodingList elementList = new BEncodingList();
		
		while('e' != next) {
			reader.skip(-1);
			elementList.add(decoder.decode(reader));
			next = (char) reader.read();
		}
		
		return elementList;
	}

}
