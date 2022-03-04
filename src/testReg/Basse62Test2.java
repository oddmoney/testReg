package testReg;

public class Basse62Test2 {

	private final static int BASE62 = 62;
	private final static String BASE62_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	public static void main(String[] args) {
		try {
			String str = encodBase62("9876543210");
			System.out.println("###encode:"+str);
			System.out.println("###decode:"+decodBase62(str));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String encodBase62(String reqStr) {
		long param = Long.valueOf(reqStr);
		StringBuffer sb = new StringBuffer();
		while (param > 0) {
			sb.append(BASE62_CHAR.charAt((int)(param % BASE62)));
			param /= BASE62;
		}
		return sb.toString();
	}

	private static long decodBase62(String param) {
		long sum = 0;
		long power = 1;
		for (int i=0; i<param.length();i++) {
			sum+=BASE62_CHAR.indexOf(param.charAt(i)) * power;
			power *= BASE62;
		}
		return sum;
	}

}
