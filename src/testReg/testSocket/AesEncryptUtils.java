package testReg.testSocket;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.util.Base64Utils;

public final class AesEncryptUtils {

	static {
		Security.addProvider(new BouncyCastleProvider());
	}

	private AesEncryptUtils() {
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

}
