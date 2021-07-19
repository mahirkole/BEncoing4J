package com.mahirkole.jittorrent.bencoder4j;

import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		Decoder decoder = Decoder.getInstance();
		
		try {
			//decoder.decode("12:abcdefghijkf");
			//decoder.decode("i-3e");
			//decoder.decode("i3e");
			//decoder.decode("i321e");
			//decoder.decode("l12:abcdefghijkfe");
			//decoder.decode("l12:abcdefghijkfi-3ei321ee");
			//decoder.decode("l12:abcdefghijkfi-3ei321el12:abcdefghijkfee");
			decoder.decode("le");
			//decoder.decode("d3:cow3:moo4:spam4:eggse");
			//decoder.decode("d4:spaml1:a1:bee");
			//decoder.decode("d9:publisher3:bob17:publisher-webpage15:www.example.com18:publisher.location4:homee");
			//decoder.decode("de");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
