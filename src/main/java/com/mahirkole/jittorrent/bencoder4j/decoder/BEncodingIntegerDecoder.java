package com.mahirkole.jittorrent.bencoder4j.decoder;

import java.io.IOException;
import java.io.StringReader;

import com.mahirkole.jittorrent.bencoder4j.element.BEncodingInteger;

public class BEncodingIntegerDecoder implements BEncodingElementDecoder<BEncodingInteger>{

	private StringReader reader;
	
	public void setReader(StringReader reader) {
		this.reader = reader;
	}

	public BEncodingInteger decode() throws IOException {
		System.out.println("IntegerDecoder.decode");
		boolean sign = true;
		StringBuilder numberBuilder = new StringBuilder();

		char next = (char) reader.read();

		if ('-' == next) {
			sign = false;
			next = (char) reader.read();
		}

		System.out.println("IntegerDecoder.decode.sign: " + (sign ? "+" : "-"));
		
		while ('e' != next) {
			numberBuilder.append(next);
			next = (char) reader.read();
		}
		
		System.out.println("IntegerDecoder.decode.numberBuilder: " + numberBuilder.toString());

		return new BEncodingInteger((sign ? 1 : -1) * Integer.parseInt(numberBuilder.toString()));
	}

}
