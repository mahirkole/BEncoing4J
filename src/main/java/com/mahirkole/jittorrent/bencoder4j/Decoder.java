package com.mahirkole.jittorrent.bencoder4j;

import java.io.IOException;
import java.io.StringReader;

import com.mahirkole.jittorrent.bencoder4j.decoder.BEncodingDictionaryDecoder;
import com.mahirkole.jittorrent.bencoder4j.decoder.BEncodingElementDecoder;
import com.mahirkole.jittorrent.bencoder4j.decoder.BEncodingNumberDecoder;
import com.mahirkole.jittorrent.bencoder4j.decoder.BEncodingListDecoder;
import com.mahirkole.jittorrent.bencoder4j.decoder.BEncodingStringDecoder;
import com.mahirkole.jittorrent.bencoder4j.element.BEncodingElement;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingInvalidFormatException;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingInvalidTypeOfElementIdentifier;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingNoContentException;
import com.mahirkole.jittorrent.bencoder4j.util.DecoderUtils;

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

	public BEncodingElement<?> decode(String content) throws Exception {
		StringReader reader = new StringReader(content);
		return decode(reader);
	}

	public BEncodingElement<?> decode(StringReader reader) throws IOException, BEncodingNoContentException, BEncodingInvalidTypeOfElementIdentifier, BEncodingInvalidFormatException {
		int beginning = reader.read();

		BEncodingElementDecoder<?> decoder;

		if (beginning == -1) {
			throw new BEncodingNoContentException();
		}

		if ('i' == (char) beginning) {
			decoder = new BEncodingNumberDecoder();
		} else if ('l' == (char) beginning) {
			decoder = new BEncodingListDecoder();
		} else if ('d' == (char) beginning) {
			decoder = new BEncodingDictionaryDecoder();
		} else if (DecoderUtils.isNumeric((char) beginning)) {
			decoder = new BEncodingStringDecoder();
		} else {
			throw new BEncodingInvalidTypeOfElementIdentifier((char) beginning);
		}

		try {
			decoder.setReader(reader);
			return decoder.decode();
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BEncodingInvalidFormatException();
		}
	}
}
