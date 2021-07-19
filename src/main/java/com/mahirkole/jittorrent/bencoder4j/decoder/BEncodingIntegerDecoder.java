package com.mahirkole.jittorrent.bencoder4j.decoder;

import java.io.IOException;
import java.io.StringReader;

import com.mahirkole.jittorrent.bencoder4j.element.BEncodingInteger;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingInvalidFormatException;

public class BEncodingIntegerDecoder implements BEncodingElementDecoder<BEncodingInteger>{

	private StringReader reader;
	
	public void setReader(StringReader reader) {
		this.reader = reader;
	}

	public BEncodingInteger decode() throws IOException, BEncodingInvalidFormatException {
		try {
			boolean sign = true;
			StringBuilder numberBuilder = new StringBuilder();

			char next = (char) reader.read();

			if ('-' == next) {
				sign = false;
				next = (char) reader.read();
			}

			while ('e' != next) {
				numberBuilder.append(next);
				next = (char) reader.read();
			}
			
			return new BEncodingInteger((sign ? 1 : -1) * Integer.parseInt(numberBuilder.toString()));
		} catch(IOException e) {
			throw e;
		} catch(Exception e) {
			throw new BEncodingInvalidFormatException();
		}
		
	}

}
