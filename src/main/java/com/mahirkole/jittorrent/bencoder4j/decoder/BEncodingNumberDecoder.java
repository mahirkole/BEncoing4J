package com.mahirkole.jittorrent.bencoder4j.decoder;

import java.io.IOException;
import java.io.StringReader;

import com.mahirkole.jittorrent.bencoder4j.element.BEncodingNumber;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingInvalidFormatException;

public class BEncodingNumberDecoder implements BEncodingElementDecoder<BEncodingNumber>{

	private StringReader reader;
	
	public void setReader(StringReader reader) {
		this.reader = reader;
	}

	public BEncodingNumber decode() throws IOException, BEncodingInvalidFormatException {
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
			
			return new BEncodingNumber((sign ? 1 : -1) * Long.parseLong(numberBuilder.toString()));
		} catch(IOException e) {
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
			throw new BEncodingInvalidFormatException();
		}
		
	}

}
