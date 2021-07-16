package com.mahirkole.jittorrent.bencoder4j;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.List;

public class Decoder {
	private static Decoder decoder;

	private Decoder() {

	}

	public synchronized static Decoder getInstance() {
		if (decoder == null) {
			decoder = new Decoder();
		}
		return decoder;
	}

	public <T> T decodeElement(BEncodingElement<T> element) {

		return null;
	}

	public List<BEncodingElement<?>> decode(String content) throws IOException {
		StringReader reader = new StringReader(content);
		int beginning = reader.read();

		if (beginning == -1) {
			return Collections.emptyList();
		}

		switch ((char) beginning) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			String lengthString = String.valueOf((char) beginning);

			int next;

			// while((next = reader.read()) != -1 && next )

		}

		return null;
	}
}
