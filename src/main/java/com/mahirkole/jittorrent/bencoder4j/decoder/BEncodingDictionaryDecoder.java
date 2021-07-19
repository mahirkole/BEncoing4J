package com.mahirkole.jittorrent.bencoder4j.decoder;

import java.io.IOException;
import java.io.StringReader;

import com.mahirkole.jittorrent.bencoder4j.Decoder;
import com.mahirkole.jittorrent.bencoder4j.element.BEncodingDictionary;
import com.mahirkole.jittorrent.bencoder4j.element.BEncodingString;

public class BEncodingDictionaryDecoder implements BEncodingElementDecoder<BEncodingDictionary> {

	private StringReader reader;
	
	public void setReader(StringReader reader) {
		this.reader = reader;
	}

	public BEncodingDictionary decode() throws IOException {
		Decoder decoder = Decoder.getInstance();
		
		char next = (char) reader.read();
		
		BEncodingDictionary elementDictionary = new BEncodingDictionary();
		
		while('e' != next) {
			reader.skip(-1);
			elementDictionary.put((BEncodingString) decoder.decode(reader), decoder.decode(reader));
			next = (char) reader.read();
		}
		
		return elementDictionary;
	}

}
