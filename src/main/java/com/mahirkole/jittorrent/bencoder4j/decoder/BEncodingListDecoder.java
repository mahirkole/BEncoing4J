package com.mahirkole.jittorrent.bencoder4j.decoder;

import java.io.IOException;
import java.io.StringReader;

import com.mahirkole.jittorrent.bencoder4j.Decoder;
import com.mahirkole.jittorrent.bencoder4j.element.BEncodingList;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingInvalidFormatException;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingInvalidTypeOfElementIdentifier;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingNoContentException;

public class BEncodingListDecoder implements BEncodingElementDecoder<BEncodingList> {

	private StringReader reader;

	public void setReader(StringReader reader) {
		this.reader = reader;
	}

	public BEncodingList decode() throws IOException, BEncodingNoContentException, BEncodingInvalidTypeOfElementIdentifier, BEncodingInvalidFormatException {
		try {
			Decoder decoder = Decoder.getInstance();

			char next = (char) reader.read();

			BEncodingList elementList = new BEncodingList();

			while ('e' != next) {
				reader.skip(-1);
				elementList.add(decoder.decode(reader));
				next = (char) reader.read();
			}

			return elementList;
		} catch (IOException e) {
			throw e;
		} catch (BEncodingNoContentException e) {
			throw e;
		} catch (BEncodingInvalidTypeOfElementIdentifier e) {
			throw e;
		} catch (Exception e) {
			throw new BEncodingInvalidFormatException();
		}
	}

}
