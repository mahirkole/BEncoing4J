package com.mahirkole.jittorrent.bencoder4j.decoder;

import java.io.IOException;
import java.io.StringReader;

import com.mahirkole.jittorrent.bencoder4j.element.BEncodingElement;

public interface BEncodingElementDecoder<T extends BEncodingElement<?>> {
	
	void setReader(StringReader reader);
	
	T decode() throws IOException;
}
