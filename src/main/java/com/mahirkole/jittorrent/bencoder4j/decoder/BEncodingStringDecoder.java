package com.mahirkole.jittorrent.bencoder4j.decoder;

import java.io.IOException;

import com.mahirkole.jittorrent.bencoder4j.BEncodingReader;
import com.mahirkole.jittorrent.bencoder4j.element.BEncodingString;
import com.mahirkole.jittorrent.bencoder4j.exception.BEncodingInvalidFormatException;
import com.mahirkole.jittorrent.bencoder4j.util.DecoderUtils;

public class BEncodingStringDecoder implements BEncodingElementDecoder<BEncodingString> {

	public BEncodingString decode(BEncodingReader reader) throws IOException, BEncodingInvalidFormatException {
		try {
			reader.rewind(1);
			char beginning = (char) reader.read();

			StringBuilder lenStrBuilder = new StringBuilder();
			lenStrBuilder.append(String.valueOf((char) beginning));

			char next = (char) reader.read();

			while (DecoderUtils.isNumeric(next)) {
				lenStrBuilder.append(String.valueOf(next));
				next = (char) reader.read();
			}

			int strlen = Integer.parseInt(lenStrBuilder.toString());
			byte[] buf = new byte[strlen];
			
			for(int i=0; i<strlen; i++) {
				buf[i] = reader.read();
			}
			//reader.read(buf, 0, strlen);
			
			String value = new String(buf);
			
			if(strlen > 50000) {
				StringBuilder hexBuilder = new StringBuilder();
				for(int i=0; i<strlen; i++) {
					hexBuilder.append(byteToHex(buf[i]));
				}
				
				value = hexBuilder.toString();
				
				System.out.println(value);
			}
			
			if(strlen > 0 && DecoderUtils.isEmpty(value)) {
				throw new BEncodingInvalidFormatException();
			}

			return new BEncodingString(buf);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BEncodingInvalidFormatException();
		}

	}
	
	private String byteToHex(byte num) {
	    char[] hexDigits = new char[2];
	    hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
	    hexDigits[1] = Character.forDigit((num & 0xF), 16);
	    return new String(hexDigits);
	}
}
