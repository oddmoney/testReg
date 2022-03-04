package testReg;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Random;

public class Basse64Test {

	public static void main(String[] args) {
		try {
			bookingKeyBase64();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void bookingKeyBase64() throws Exception{
		System.out.println("######################\n### BASE64 TEST START ###\n");
		//String text=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + new Random(System.currentTimeMillis()).nextInt(1000);
		
		String text = "MzU4NDAzMDA5MDI5MDc4OTIwMjUwMjYyODYzNTg3MQ==";
		System.out.println("#base64-Decode : " + new String(Base64.getDecoder().decode(text.getBytes()), "UTF-8"));
		
		text="7KNrEQ60EVSw7+i5O5vEpBkgfBoftjqvhMYMp7FUVKie+k/wEydDcNfpXc9a5dVTmuXlPsEtKwXQzebYS0V/KJXfm/+JGeyM8/xXeSB2Ov1CGvcHI+SC+jC7KxYlT//8jX88scALWnTAWed0kEgpzGQp7clFQsSsjYiNgHc5i+YxF0pr8+0Bev3A8C0IQPVF6l/QgAEo8T/fTbbJeoMRO/d+77uAqrC3Lbhjyb5uDPU18L7sFz0WoBOF93R6avdTQtpHpIgyLiPoJ5u7DPn1akkXsWZWdGJEykPWkoKdGRg=";
		
		byte[] decodedBytes = Base64.getDecoder().decode(text.getBytes());
		byte[] encodedBytes = Base64.getEncoder().encode(decodedBytes);
		
		System.out.println("#base64-Decode : " + new String(decodedBytes, "UTF-8"));
		System.out.println("#orgnText : " + text);
		System.out.println("#base64-Encode : " + new String(encodedBytes));
		
		String encodeStr = "Mzk2MTM1OCFDN0JZWVchZmFsc2U="; //BookingKey
		//String encodeStr = "NDY4MDQyNiExIUNMITM5NjA0ODE="; //PaymentKey
		System.out.println("base64-Encode-STR : "+encodeStr);
		System.out.println("base64-Decode-STR : "+new String(Base64.getDecoder().decode(encodeStr.getBytes())));

		System.out.println("######################\n### BASE64 TEST END ###\n");
		
		System.out.println("######################\n### BASE64 BOOKING-KEY-TEST START ###\n");
		String bookingKey = "2188801!APQQ30!false";
		encodedBytes = Base64.getEncoder().encode(bookingKey.getBytes());
		System.out.println("#orgnText : " + bookingKey);
		System.out.println("#base64-Encode : " + new String(encodedBytes));

		System.out.println("### BASE64 BOOKING-KEY-TEST END ###\n######################");
	}

}
