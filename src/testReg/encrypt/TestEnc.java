package testReg.encrypt;

public class TestEnc {

	public static void main(String[] args) {
		try {
			System.out.println("###TestEnc");			
			//String str = "01032814147";
			String str = "41111";
			System.out.println("ORGN_STR:"+str);
			str = AES256Cipher.AES_Encode(str);
			System.out.println("ENC_STR:"+str);
			str = AES256Cipher.AES_Decode(str);
			System.out.println("DEC_STR:"+str);
					
			// CU 편의점
			System.out.println("CU_DEC_STR-APPRNO:"+AES256Cipher.AES_Decode("a6qmpeNIJio1+/5lJYXhbVmojLlgSvC0rrT6NrphJwg=", "zAdajeiaejIJIJEJEJFDJksajdeiaeei", "1234567890123456"));
			System.out.println("CU_DEC_STR-TXNNO:"+AES256Cipher.AES_Decode("a6qmpeNIJio1+/5lJYXhbVmojLlgSvC0rrT6NrphJwg=", "zAdajeiaejIJIJEJEJFDJksajdeiaeei", "1234567890123456"));
			System.out.println("CU_DEC_STR-AMOUNT:"+AES256Cipher.AES_Decode("CEFtIolg2wDzVL+x8KeupQ==", "zAdajeiaejIJIJEJEJFDJksajdeiaeei", "1234567890123456"));
			System.out.println("CU_DEC_STR-BARCD:"+AES256Cipher.AES_Decode("mpQN9be9z3tJwqEcPeYqpQ==", "zAdajeiaejIJIJEJEJFDJksajdeiaeei", "1234567890123456"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
