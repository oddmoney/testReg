package testReg.encrypt;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.util.Base64Utils;

public final class EncryptUtils {

	static {
		Security.addProvider(new BouncyCastleProvider());
	}
	
	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	private EncryptUtils() {
	}

	private static String toHexString(byte[] letter) {
		StringBuffer sbHex = new StringBuffer();
        for (int j=0; j < letter.length; j++) {             
            String hexValue = Integer.toHexString((int)letter[j] & 0xff); 
            
            if (hexValue.length() == 1) sbHex.append("0");
            sbHex.append(hexValue.toUpperCase());
        } 
        
        return sbHex.toString();
	}
	
	/**
	 * MD5 암호화 문자열 생성
	 * @param text
	 * @return md5str
	 */
	public static String md5(String text) {
		MessageDigest msgDigest = null;

		try {
			msgDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("System doesn't support MD5 algorithm.");
		}

		try {
			msgDigest.update(text.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("System doesn't support your EncodingException.");
		}

		byte[] bytes = msgDigest.digest();
		String md5Str = new String(encodeHex(bytes));

		return md5Str;
	}
	
	public static char[] encodeHex(byte[] data) {
		int l = data.length;
		char[] out = new char[l << 1];

		// two characters form the hex value.
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS[0x0F & data[i]];
		}

		return out;
	}
	
	
	 //AES 보안 Key 생성
	 public static SecretKey getSecretAES( String psKey ) throws java.io.UnsupportedEncodingException{		 
		return new SecretKeySpec(psKey.getBytes(), "AES");
		 
	 }
	 
	 //AES 암호화
	 public static String  encryptAES(  SecretKey poSecretKey,  String psIV, String psTarget ) throws Exception{
		 
		 Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		 c.init(Cipher.ENCRYPT_MODE, poSecretKey, new IvParameterSpec(psIV.getBytes()));
		 byte[] encrypted = c.doFinal(psTarget.getBytes("UTF-8"));
		 return  new String(Base64Utils.encodeToString(encrypted));
		 
	 }
	 
	//AES 복원화
	 public static String  decryptAES(  SecretKey poSecretKey,  String psIV, String psTarget ) throws Exception{
		 
		 Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		 c.init(Cipher.DECRYPT_MODE, poSecretKey, new IvParameterSpec(psIV.getBytes()));
		 return  new String(c.doFinal(Base64Utils.decodeFromString(psTarget)),"UTF-8");
		 
	 }
	 
	 
	 public static String encryptSeed(String plain, String key, String iv)
		        throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
		        InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

			SecretKeySpec keySpec = new SecretKeySpec(Base64Utils.decodeFromString(key), "SEED");
			IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
			Cipher cipher = Cipher.getInstance("SEED/CBC/PKCS5Padding");

			cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

			return Base64Utils.encodeToString(cipher.doFinal(plain.getBytes()));
	}

	public static String decryptSeed(String encrypted, String key, String iv)
	        throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
	        InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

		SecretKeySpec keySpec = new SecretKeySpec(Base64Utils.decodeFromString(key), "SEED");
		IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
		Cipher cipher = Cipher.getInstance("SEED/CBC/PKCS5Padding");

		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

		return new String(cipher.doFinal(Base64Utils.decodeFromString(encrypted)), StandardCharsets.UTF_8);
	}
	
	/**
	 * SHA256 암호화 문자열 생성
	 * @param text
	 * @return SHA256str
	 */
	public static String encryptSHA256(String text) {
		return encryptSHA256(text, "UTF-8");
	}
	
	/**
	 * SHA256 암호화 문자열 생성
	 * @param text
	 * @return SHA256str
	 */
	public static String encryptSHA256(String text, String charset) {
		try {
	        byte[] plainText = text.getBytes(charset);
	        byte[] hashValue = null;
	        
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        hashValue = md.digest(plainText);
   
	        return toHexString(hashValue);
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
        return "";
	}

	/**
	 * 이니시스 SHA-256, SHA-512
	 * HashValue does not toUpperCase()
	 * @param input
	 * @param type : Sha256, 512
	 * @return
	 * @throws Exception
	 */
	public static String encryptSHA256_512(String input, String type) throws Exception {
		StringBuffer sb = new StringBuffer();
		MessageDigest md = MessageDigest.getInstance(type);
		md.update(input.getBytes());
		byte[] msgb = md.digest();
		for (int i=0; i<msgb.length; i++) {
			byte temp = msgb[i];
			String str = Integer.toHexString(temp & 0xFF);

			while(str.length() < 2) str = "0" + str;

			str = str.substring(str.length() - 2);
			sb.append(str);
		}
		return sb.toString();
	}

}
