package com.bestore.ecommerce.core.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class EncryptionUtil {
	public static Base64 base64 = new Base64();
	
	public static byte[] getHmacSHA1Bytes(String secretToken, String src) 
			throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException{
		Mac mac = Mac.getInstance("HmacSHA1");
		SecretKeySpec secret = new SecretKeySpec(secretToken.getBytes("UTF-8"),
				mac.getAlgorithm());
		mac.init(secret);
		return mac.doFinal(src.getBytes());
	}
	
	public static String getHmacSHA1String(String secretToken, String src) 
			throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException{
		return new String(getHmacSHA1Bytes(secretToken, src));
	}
	
	public static String encoderBase64(String source){
		return base64.encodeToString(source.getBytes());
	}
	
	public static String decoderBase64(String source){
		return new String(base64.decode(source));
	}
}
