package com.mahirkole.jittorrent.bencoder4j.exception;

public class BEncodingInvalidTypeOfElementIdentifier extends Exception {

	private static final long serialVersionUID = -2554344029440234371L;

	public BEncodingInvalidTypeOfElementIdentifier(char elementIdentifier) {
		super("Element identifier [" + elementIdentifier + "] is invalid!");
	}
	
}
