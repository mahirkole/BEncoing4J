package com.mahirkole.jittorrent.bencoder4j;

import java.io.IOException;

import com.mahirkole.jittorrent.bencoder4j.element.BEncodingElement;

public class Test {

	public static void main(String[] args) {
		Decoder decoder = Decoder.getInstance();
		Encoder encoder = Encoder.getInstance();
		
		try {
			BEncodingElement<?> string = decoder.decode("12:abcdefghijkf");
			BEncodingElement<?> integer = decoder.decode("i-3e");
			BEncodingElement<?> integer2 = decoder.decode("i3e");
			BEncodingElement<?> integer3 = decoder.decode("i321e");
			BEncodingElement<?> list = decoder.decode("l12:abcdefghijkfe");
			BEncodingElement<?> list2 = decoder.decode("l12:abcdefghijkfi-3ei321ee");
			BEncodingElement<?> list3 = decoder.decode("l12:abcdefghijkfi-3ei321el12:abcdefghijkfee");
			BEncodingElement<?> list4 = decoder.decode("le");
			BEncodingElement<?> dict = decoder.decode("d3:cow3:moo4:spam4:eggse");
			BEncodingElement<?> dict2 = decoder.decode("d4:spaml1:a1:bee");
			BEncodingElement<?> dict3 = decoder.decode("d9:publisher3:bob17:publisher-webpage15:www.example.com18:publisher.location4:homee");
			BEncodingElement<?> dict4 = decoder.decode("de");
			
			System.out.println(string);
			System.out.println(integer);
			System.out.println(integer2);
			System.out.println(integer3);
			System.out.println(list);
			System.out.println(list2);
			System.out.println(list3);
			System.out.println(list4);
			System.out.println(dict);
			System.out.println(dict2);
			System.out.println(dict3);
			System.out.println(dict4);
			
			String strString = encoder.encode(string);
			String strInteger = encoder.encode(integer);
			String strInteger2 = encoder.encode(integer2);
			String strInteger3 = encoder.encode(integer3);
			String strList = encoder.encode(list);
			String strList2 = encoder.encode(list2);
			String strList3 = encoder.encode(list3);
			String strList4 = encoder.encode(list4);
			String strDict = encoder.encode(dict);
			String strDict2 = encoder.encode(dict2);
			String strDict3 = encoder.encode(dict3);
			String strDict4 = encoder.encode(dict4);
			
			System.out.println(strString);
			System.out.println(strInteger);
			System.out.println(strInteger2);
			System.out.println(strInteger3);
			System.out.println(strList);
			System.out.println(strList2);
			System.out.println(strList3);
			System.out.println(strList4);
			System.out.println(strDict);
			System.out.println(strDict2);
			System.out.println(strDict3);
			System.out.println(strDict4);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
