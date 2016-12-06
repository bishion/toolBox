package com.bizi.tools.secret;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("restriction")
public class MakeKeyUtil {

	public static Map<String,String> intRSAKey(){
		try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(SecretConst.RSA);
		
	        keyPairGen.initialize(SecretConst.RSA_KEY_LEN);  
	  
	        KeyPair keyPair = keyPairGen.generateKeyPair();  
	  
	        // 公钥  
	        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  
	  
	        // 私钥  
	        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();  
	  
	        Map<String, String> keyMap = new HashMap<String, String>(2);  
	  
	        keyMap.put(SecretConst.RSA_PUBLIC_KEY, base64ToStr(publicKey.getEncoded()));  
	        keyMap.put(SecretConst.RSA_PRIVATE_KEY, base64ToStr(privateKey.getEncoded()));  
	        return keyMap;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}  
    }  
	 /** 
     * 初始化HMAC密钥 
     *  这个是为了生成密钥用的，严格来说并不算加密。但是权且放在这里，毕竟属于加密的一部分。
     *  如果不用它，自己随便定义一个key给HMAC使用也是可以的。
     * @return 
     * @throws Exception 
     */  
    public static String initHMACKey(){  
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(SecretConst.HMAC);
			SecretKey secretKey = keyGenerator.generateKey();  
	        return base64ToStr((secretKey.getEncoded())); 
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}  
    }

	private static String base64ToStr(byte[] message){
		return new String(new Base64().encode(message));
	}

    public static void main(String[] args) {
        Map<String,String> map = MakeKeyUtil.intRSAKey();
        System.out.println(map.get(SecretConst.RSA_PUBLIC_KEY));
        System.out.println(map.get(SecretConst.RSA_PRIVATE_KEY));

        String msg = EncryptUtil.RSAEncByPub("app",map.get(SecretConst.RSA_PUBLIC_KEY));
        System.out.println(msg);
        System.out.println(DecryptUtil.RSADecByPri(msg,map.get(SecretConst.RSA_PRIVATE_KEY)));
    }
}
