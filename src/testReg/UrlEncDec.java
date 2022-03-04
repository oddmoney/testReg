package testReg;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class UrlEncDec {

	public static void main(String[] args) {
		String str = "%EC%B0%B8%EA%B0%80%EA%B8%B0%EA%B4%80+%EC%97%90%EB%9F%AC";
		try {
			System.out.println(new URLDecoder().decode(str, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
