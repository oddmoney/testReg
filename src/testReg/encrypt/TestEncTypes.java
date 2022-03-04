package testReg.encrypt;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class TestEncTypes {

	public static void main(String[] args) {
		try {
			/*
			 * AES
			 */
			String aesKey = "zAdajeiaejIJIJEJEJFDJksajdeiaeei";
			String aesIv = "1234567890123456";
			String aesOrgnVal = "ABsdfsfwerw232232 대한민국   짝짝짝짝짝!!!";
			SecretKey secureKey = new SecretKeySpec(aesKey.getBytes(), "AES");
			String aesEncVal = EncryptUtils.encryptAES(secureKey, aesIv, aesOrgnVal);
			System.out.println("###AES-ENC-Val:::" + aesEncVal);
			String aesDecVal = EncryptUtils.decryptAES(secureKey, aesIv, aesEncVal);
			System.out.println("###AES-DEC-Val:::" + aesDecVal);
			
			/*
			 * MD5
			 */
			String md5OrgnVal = "ABsdfsfwerw232232 대한민국   짝짝짝짝짝!!!";
			String md5EncVal = EncryptUtils.md5(md5OrgnVal);
			System.out.println("###MD5-ENC-Val:::" + md5EncVal);

			/*
			 * SHA256
			 */
			String sha256OrgnVal = "ABsdfsfwerw232232 대한민국   짝짝짝짝짝!!!";
			String sha256EncVal = EncryptUtils.encryptSHA256(sha256OrgnVal);
			System.out.println("###SHA256-ENC-Val:::" + sha256EncVal);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
