package com.mahirkole.jittorrent.bencoder4j;

public interface BEncodingElementDecoder {
	
	BEncodingElement<?> decode(String content);
}
