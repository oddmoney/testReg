package testReg;

import java.util.Arrays;

public class TestLambda {

	public static void main(String[] args) {
		try {
			testArrayFilter();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testArrayFilter() throws Exception {
		String str = null;
		System.out.println("RES:"+Arrays.asList("JPY", "CNY", "USD").stream().filter(t -> t.equals(str)).findFirst().orElse("KRW"));
	}
}
