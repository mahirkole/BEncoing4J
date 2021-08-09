package com.mahirkole.jittorrent.bencoder4j.decoder;

import java.io.IOException;

import com.mahirkole.jittorrent.bencoder4j.BEncodingReader;
import com.mahirkole.jittorrent.bencoder4j.Decoder;
import com.mahirkole.jittorrent.bencoder4j.element.BEncodingDictionary;
import com.mahirkole.jittorrent.bencoder4j.element.BEncodingElement;
import com.mahirkole.jittorrent.bencoder4j.element.BEncodingString;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingInvalidFormatException;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingInvalidTypeOfElementIdentifier;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingNoContentException;

public class BEncodingDictionaryDecoder implements BEncodingElementDecoder<BEncodingDictionary> {

	public BEncodingDictionary decode(BEncodingReader reader) throws IOException, BEncodingNoContentException, BEncodingInvalidTypeOfElementIdentifier, BEncodingInvalidFormatException {
		try {
			Decoder decoder = Decoder.getInstance();

			char next = (char) reader.read();

			BEncodingDictionary elementDictionary = new BEncodingDictionary();

			while ('e' != next) {
				reader.rewind(1);
				BEncodingString key = (BEncodingString) decoder.decode(reader);
				BEncodingElement<?> value = decoder.decode(reader);
				elementDictionary.put(key, value);
				next = (char) reader.read();
			}

			return elementDictionary;
		} catch (IOException e) {
			throw e;
		} catch (BEncodingNoContentException e) {
			throw e;
		} catch (BEncodingInvalidTypeOfElementIdentifier e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BEncodingInvalidFormatException();
		}
	}

}
