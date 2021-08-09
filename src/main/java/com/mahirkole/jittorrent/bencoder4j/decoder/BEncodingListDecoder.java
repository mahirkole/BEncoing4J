package com.mahirkole.jittorrent.bencoder4j.decoder;

import java.io.IOException;

import com.mahirkole.jittorrent.bencoder4j.BEncodingReader;
import com.mahirkole.jittorrent.bencoder4j.Decoder;
import com.mahirkole.jittorrent.bencoder4j.element.BEncodingList;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingInvalidFormatException;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingInvalidTypeOfElementIdentifier;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingNoContentException;

public class BEncodingListDecoder implements BEncodingElementDecoder<BEncodingList> {

	public BEncodingList decode(BEncodingReader reader) throws IOException, BEncodingNoContentException, BEncodingInvalidTypeOfElementIdentifier, BEncodingInvalidFormatException {
		try {
			Decoder decoder = Decoder.getInstance();

			char next = (char) reader.read();

			BEncodingList elementList = new BEncodingList();

			while ('e' != next) {
				reader.rewind(1);
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
			e.printStackTrace();
			throw new BEncodingInvalidFormatException();
		}
	}

}
