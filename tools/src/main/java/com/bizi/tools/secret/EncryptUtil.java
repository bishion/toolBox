package com.bizi.tools.secret;

import com.bizi.tools.validate.ValidateUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;

/**
 * 加密工具，包含各种加密方式，对称加密非对称加密等等。
 * @author bishion@163.com
 *
 */
@SuppressWarnings("restriction")
public class EncryptUtil {

	/**
	 * DES 加密算法，对称加密
	 * @param message 原文
	 * @param key 密钥
	 * @return
	 */
	public static String DESEnc(String message, String key){
		if(ValidateUtil.hasOneNullOrEmpty(message,key)){
			throw new RuntimeException("message or key is null!");
		}
		
		try {
			SecureRandom secureRandom = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(key.getBytes());
			
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(SecretConst.DES);
			SecretKey secureKey = keyFactory.generateSecret(desKey);
			
			Cipher cipher = Cipher.getInstance(SecretConst.DES);
			
			cipher.init(Cipher.ENCRYPT_MODE, secureKey, secureRandom);
			
			return new String(EncryptUtil.base64ToStr(cipher.doFinal(message.getBytes())));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * AES加密，对称加密算法
	 * @param message 原文
	 * @param key 密钥
	 * @return
	 */
	public static String AESEnc(String message, String key){
		if(ValidateUtil.hasOneNullOrEmpty(message, key)){
			throw new RuntimeException("message or key is null!");
		}
		
		try {
			KeyGenerator kgen = KeyGenerator.getInstance(SecretConst.AES);
			
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(key.getBytes());
			kgen.init(128,secureRandom);
			
			SecretKey secureKey = kgen.generateKey();
			
			byte[] enCodeFormat = secureKey.getEncoded();
			SecretKeySpec securKeySpec = new SecretKeySpec(enCodeFormat, "AES");
			
			Cipher cipher = Cipher.getInstance(SecretConst.AES);
			
			cipher.init(Cipher.ENCRYPT_MODE, securKeySpec);
			
			return EncryptUtil.base64ToStr(cipher.doFinal(message.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Base64，简单编码，使文本不可读，并不算严格的加密程序。
	 * @param message
	 * @return
	 */
	public static String BASE64Enc(String message){
		if(ValidateUtil.isBlank(message)){
			throw new RuntimeException("message or key is null!");
		}
		return EncryptUtil.base64ToStr(message.getBytes());
	}
	
	/**
	 * MD5加密，原则上不能解密，只是作为数字签名使用，可以用来当作密码加密使用
	 * @param message
	 * @return
	 */
	public static String MD5Enc(String message){
		if(ValidateUtil.isBlank(message)){
			throw new RuntimeException("message or key is null!");
		}
		MessageDigest messageDigest;
		try {
			
			messageDigest = MessageDigest.getInstance(SecretConst.MD5);
			messageDigest.update(message.getBytes());
			return EncryptUtil.base64ToStr(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * SHA加密，跟sha1是一样。原则上不能解密，只是作为数字签名使用，可以用来当作密码加密使用
	 * @param message
	 * @return
	 */
	public static String SHAEnc(String message){
		if(ValidateUtil.isBlank(message)){
			throw new RuntimeException("message or key is null!");
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(SecretConst.SHA);
			messageDigest.update(message.getBytes());
			return EncryptUtil.hexToString(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static String RSAEncByPub(String message, String key){
		if(ValidateUtil.hasOneNullOrEmpty(message, key)){
			throw new RuntimeException("message or key is null!");
		}
		try{
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(base64ToByte(key));
			KeyFactory keyFactory= KeyFactory.getInstance(SecretConst.RSA);
			PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
			
			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			
			return base64ToStr(cipher.doFinal(message.getBytes()));
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	/**
	 * @param message
	 * @param key
	 * @return
	 */
	public static String HMACEnc(String message,String key){
		if(ValidateUtil.hasOneNullOrEmpty(message,key)){
			throw new RuntimeException("message or key is null!");
		}
		try {
			SecretKey secretKey = new SecretKeySpec(key.getBytes(), SecretConst.HMAC);
			Mac mac = Mac.getInstance(secretKey.getAlgorithm());
			mac.init(secretKey);
			return EncryptUtil.base64ToStr(mac.doFinal(message.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
    
    
	private static String base64ToStr(byte[] message){
		return new String(new Base64().encode(message));
    }
	private static byte[] base64ToByte(String message) throws IOException{
		return new Base64().decodeBase64(message.getBytes());
    }

	private static String hexToString(byte[] message){
		return new String (Hex.encodeHex(message));
	}


}
