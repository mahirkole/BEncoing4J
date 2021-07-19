package com.mahirkole.jittorrent.bencoder4j;

import java.io.IOException;
import java.io.StringReader;

import com.mahirkole.jittorrent.bencoder4j.decoder.BEncodingDictionaryDecoder;
import com.mahirkole.jittorrent.bencoder4j.decoder.BEncodingElementDecoder;
import com.mahirkole.jittorrent.bencoder4j.decoder.BEncodingIntegerDecoder;
import com.mahirkole.jittorrent.bencoder4j.decoder.BEncodingListDecoder;
import com.mahirkole.jittorrent.bencoder4j.decoder.BEncodingStringDecoder;
import com.mahirkole.jittorrent.bencoder4j.element.BEncodingElement;
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
	
	public BEncodingElement<?> decode(StringReader reader) throws IOException {
		int beginning = reader.read();

		BEncodingElementDecoder<?> decoder = null; // TODO: null'ı kaldır

		if (beginning == -1) {
			//throw exp
			System.out.println("-1");
		}

		if ('i' == (char) beginning) {
			decoder = new BEncodingIntegerDecoder();
		} else if ('l' == (char) beginning) {
			decoder = new BEncodingListDecoder();
		} else if ('d' == (char) beginning) {
			decoder = new BEncodingDictionaryDecoder();
		} else if (DecoderUtils.isNumeric((char) beginning)) {
			decoder = new BEncodingStringDecoder();
		}

		decoder.setReader(reader);
		return decoder.decode();
	}
}
