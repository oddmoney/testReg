package testReg;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Basse62Test {

	private final static String URL_PREFIX = "http://jejuair.net/";
	private final static int BASE62 = 62;
	private final static String BASE62_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	//private final static String BASE62_CHAR = "20210406132258";

	public static void main(String[] args) {
		try {
			testBase62();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String encoding(long param) {
		StringBuffer sb = new StringBuffer();
		while (param > 0) {
			sb.append(BASE62_CHAR.charAt((int)(param % BASE62)));
			param /= BASE62;
		}
		return URL_PREFIX + sb.toString();
	}

	private static long decoding(String param) {
		long sum = 0;
		long power = 1;
		for (int i=0; i<param.length();i++) {
			sum+=BASE62_CHAR.indexOf(param.charAt(i)) * power;
			power *= BASE62;
		}
		return sum;
	}
	
	private static String urlEncoder(String reqStr) throws Exception {
		String encodeStr = encoding(Long.valueOf(reqStr));
		//String encodeStr = encoding(Integer.valueOf(reqStr));
		return encodeStr;
	}

	private static long urlDecoder(String reqStr) throws Exception {
		if (reqStr.trim().startsWith(URL_PREFIX)) {
			reqStr = reqStr.replace(URL_PREFIX,  "");
		}
		long decodeVal = decoding(reqStr);
		return decodeVal;
	}

	private static void testBase62() throws Exception {
		System.out.println("######################\n### BASE62 TEST START ###\n");

		//String text = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + new Random(System.currentTimeMillis()).nextInt(1000);
		//String text = "12345678902315";
		String text = "9999999999" + new SimpleDateFormat("mmssSSS").format(new Date());
		System.out.println("###text:"+text);
		String encodeUrl = urlEncoder(""+text);
		System.out.println("###encodeUrl:"+encodeUrl);
		long decodeUrl = urlDecoder(encodeUrl);
		System.out.println("###decodeUrl:"+decodeUrl);

		System.out.println("### BASE62 TEST END ###\n######################");
	}

}
