package com.mahirkole.jittorrent.bencoder4j.decoder;

import java.io.IOException;

import com.mahirkole.jittorrent.bencoder4j.BEncodingReader;
import com.mahirkole.jittorrent.bencoder4j.element.BEncodingNumber;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingInvalidFormatException;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingInvalidTypeOfElementIdentifier;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingNoContentException;

public class BEncodingNumberDecoder implements BEncodingElementDecoder<BEncodingNumber>{

	public BEncodingNumber decode(BEncodingReader reader) throws IOException, BEncodingNoContentException, BEncodingInvalidTypeOfElementIdentifier, BEncodingInvalidFormatException {
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
		} catch(Exception e) {
			e.printStackTrace();
			throw new BEncodingInvalidFormatException();
		}
	}

}
