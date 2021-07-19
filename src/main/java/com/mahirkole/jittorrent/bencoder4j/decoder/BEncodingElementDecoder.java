package com.mahirkole.jittorrent.bencoder4j.decoder;

import java.io.IOException;
import java.io.StringReader;

import com.mahirkole.jittorrent.bencoder4j.element.BEncodingElement;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingInvalidFormatException;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingInvalidTypeOfElementIdentifier;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingNoContentException;

public interface BEncodingElementDecoder<T extends BEncodingElement<?>> {
	
	void setReader(StringReader reader);
	
	T decode() throws IOException, BEncodingNoContentException, BEncodingInvalidTypeOfElementIdentifier, BEncodingInvalidFormatException;
}
