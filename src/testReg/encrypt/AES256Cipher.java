package testReg.encrypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES256Cipher {

	//private static final String secretKey = "14587895456234ab"; // 16byte Key
	private static final String secretKey = "jejuair_paeg_enc_45c3Q7B89i3qe45"; // 32byte Key
	
    private static volatile AES256Cipher INSTANCE;
    
    // 16byte IV
	private static final String IV = "jejuair_aesivval";
    
    public static AES256Cipher getInstance() {
        if(INSTANCE==null) {
            synchronized(AES256Cipher.class) {
                if(INSTANCE == null) {
                    INSTANCE = new AES256Cipher();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * AES 암호화
     * 순서 : AES256 암호화 -> Base64 Encode -> URL Encode
     * @param str
     * @return 파라메터 암호화 문자열
     * @throws java.io.UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws InvalidAlgorithmParameterException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public static String AES_Encode(String str) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
    	
        SecretKey secureKey = new SecretKeySpec(secretKey.getBytes(), "AES");
        
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes()));
        
        byte[] encrypted = c.doFinal(str.getBytes("UTF-8")); // AES 암호화
        
        String enStr = new String(Base64.getEncoder().encode(encrypted)); // Base64 Encoding
        
        return enStr;
    }

    /**
     * AES 복호화
     * 순서 : URL Decode -> Base64 Decode -> AES256 복호화
     * @param str
     * @return 파라메터 복호화 문자열
     * @throws java.io.UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws InvalidAlgorithmParameterException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public static String AES_Decode(String str) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
    	
        SecretKey secureKey = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes()));

        byte[] byteStr = Base64.getDecoder().decode(str.getBytes()); // Base64 Decoding
        
        return new String(c.doFinal(byteStr), "UTF-8"); // AES 복호화
    }

    /**
     * AES 복호화
     * 순서 : URL Decode -> Base64 Decode -> AES256 복호화
     * @param str
     * @return 파라메터 복호화 문자열
     * @throws java.io.UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws InvalidAlgorithmParameterException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public static String AES_Decode(String str, String key, String iv) throws Exception {
    	
        SecretKey secureKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, secureKey, new IvParameterSpec(iv.getBytes()));

        byte[] byteStr = Base64.getDecoder().decode(str.getBytes()); // Base64 Decoding
        
        return new String(c.doFinal(byteStr), "UTF-8"); // AES 복호화
    }

}
