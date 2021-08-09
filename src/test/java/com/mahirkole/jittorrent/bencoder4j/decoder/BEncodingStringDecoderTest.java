package com.mahirkole.jittorrent.bencoder4j.decoder;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import com.mahirkole.jittorrent.bencoder4j.element.BEncodingString;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingInvalidFormatException;

public class BEncodingStringDecoderTest {
	
	private BEncodingStringDecoder decoder;
	
	@Before
	public void before() {
		decoder = new BEncodingStringDecoder();
	}
	
	@Test
	public void givenEmptyEncodedStringThenEmptyString() throws IOException, BEncodingInvalidFormatException {
		String input = "0:";
		//decoder.setReader(new StringReader(input));
		//assertEquals(decoder.decode(), new BEncodingString(""));
	}
	
	@Test
	public void givenOneCharacterEncodedStringThenCharacter() throws IOException, BEncodingInvalidFormatException {
		String input = "1:a";
		//decoder.setReader(new StringReader(input));
		//assertEquals(decoder.decode(), new BEncodingString("a"));
	}
	
	@Test(expected = BEncodingInvalidFormatException.class)
	public void givenInvalidEmptyEncodedStringThenThrownBEncodingInvalidFormatException() throws IOException, BEncodingInvalidFormatException {
		String input = "1:";
		//decoder.setReader(new StringReader(input));
		//decoder.decode();
	}

}
