package com.mahirkole.jittorrent.bencoder4j;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	public <T> T decodeElement(BEncodingElement<T> element) {

		return null;
	}

	public List<BEncodingElement<?>> decode(String content) throws Exception {
		StringReader reader = new StringReader(content);
		int beginning = reader.read();

		List<BEncodingElement<?>> elementList = new ArrayList<BEncodingElement<?>>();
		
		while(beginning != -1) {
			if('i' == (char) beginning) {
				
				StringBuilder numberBuilder = new StringBuilder();
				
				char next = (char) reader.read();
				
				while('e' != next) {
					numberBuilder.append(next);
					next = (char) reader.read();
				}
				
				elementList.add(null);
			} else if('l' == (char) beginning) {
				
			} else if('d' == (char) beginning) {
				
			} else if(DecoderUtils.isNumeric((char) beginning)) {
				
				StringBuilder lenStrBuilder = new StringBuilder();
				lenStrBuilder.append(String.valueOf((char) beginning));
				
				char next = (char) reader.read();
				
				while(DecoderUtils.isNumeric(next)) {
					lenStrBuilder.append(String.valueOf(next));
					next = (char) reader.read();
				}
				
				int strlen = Integer.parseInt(lenStrBuilder.toString());
				char[] buf = new char[strlen];
				
				reader.read(buf, 0, strlen);
				
				String data = String.valueOf(buf);
				
				if(data.length() != strlen) {
					throw new Exception("String.error.1");
				}
				
				elementList.add(new BEncodingString(data));
			}
			
			beginning = reader.read();
		}
		
		return elementList;
	}
}
