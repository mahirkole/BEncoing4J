package com.mahirkole.jittorrent.bencoder4j.decoder;

import java.io.IOException;
import java.io.StringReader;

import com.mahirkole.jittorrent.bencoder4j.element.BEncodingString;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingInvalidFormatException;
import com.mahirkole.jittorrent.bencoder4j.util.DecoderUtils;

public class BEncodingStringDecoder implements BEncodingElementDecoder<BEncodingString> {

	private StringReader reader;

	public void setReader(StringReader reader) {
		this.reader = reader;
	}

	public BEncodingString decode() throws IOException, BEncodingInvalidFormatException {
		try {
			reader.skip(-1);
			char beginning = (char) reader.read();

			StringBuilder lenStrBuilder = new StringBuilder();
			lenStrBuilder.append(String.valueOf((char) beginning));

			char next = (char) reader.read();

			while (DecoderUtils.isNumeric(next)) {
				lenStrBuilder.append(String.valueOf(next));
				next = (char) reader.read();
			}

			int strlen = Integer.parseInt(lenStrBuilder.toString());
			char[] buf = new char[strlen];

			reader.read(buf, 0, strlen);

			return new BEncodingString(String.valueOf(buf));
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			throw new BEncodingInvalidFormatException();
		}

	}
}
