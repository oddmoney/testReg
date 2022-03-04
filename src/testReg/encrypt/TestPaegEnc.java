package testReg.encrypt;

public class TestPaegEnc {

	//private static final String paegKey="jejuairT17OU5506R2108SO5456F578T"; // 개발
	//private static final String paegIv="jejuair17T50637S"; // 개발
	
	private static final String paegKey="jejuairN190A367V751IT471S3807355"; // 운영
	private static final String paegIv="jejuair22N84T413"; // 운영
			
	public static void main(String[] args) {
		try {
			/*
			String str = "01089093587";
			System.out.println("ORGN_STR:"+str);
			str = getEnc(str);
			System.out.println("ENC_STR:"+str);
			str = getDec(str);
			System.out.println("DEC_STR:"+str);
			*/
			String str = "25920204314826";
			System.out.println("END_STR:"+getEnc(str));
			
			str = "WIG4D4+l7cFhOqhBU3DtqA==";
			System.out.println("DEC_STR:"+getDec(str));		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String getEnc(String str) throws Exception {
		return EncryptUtils.encryptAES(EncryptUtils.getSecretAES(paegKey), paegIv, str);
	}
	private static String getDec(String str) throws Exception {
		return EncryptUtils.decryptAES(EncryptUtils.getSecretAES(paegKey), paegIv, str);
	}
}
