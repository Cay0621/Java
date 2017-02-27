package org.com.cay.base64;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64 {

	private static String src = "org.com.cay.base64";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jdkBase64();
		System.out.println("================");
		commonsCodecBase64();
		System.out.println("================");
		bouncyCastleBase64();
	}

	public static void jdkBase64(){
		try {
			BASE64Encoder encoder = new BASE64Encoder();
			String encode = encoder.encode(src.getBytes());
			System.out.println("encode: " + encode);
			
			BASE64Decoder decoder = new BASE64Decoder();
			System.out.println("decode: " + new String(decoder.decodeBuffer(encode)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void commonsCodecBase64(){
		byte[] encodeByte = org.apache.commons.codec.binary.Base64.encodeBase64(src.getBytes());
		System.out.println("encode: " + new String(encodeByte));
		
		byte[] decodeByte = org.apache.commons.codec.binary.Base64.decodeBase64(encodeByte);
		System.out.println("decode: " + new String(decodeByte));
	}
	
	public static void bouncyCastleBase64(){
		byte[] encodeByte = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		System.out.println("encode: " + new String(encodeByte));
		
		byte[] decodeByte = org.bouncycastle.util.encoders.Base64.decode(encodeByte);
		System.out.println("decode: " + new String(decodeByte));
	}
}
