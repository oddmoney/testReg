package testReg;

public class TestClass2 {

	public static void main(String[] args) {
		addInicisAprvlDataSet("http://fcstdpay.inicis.com/abcdefgh");
	}
	
	/**
	 * 이니시스 승인 용 가변 URL 에 따른 ESB URL 을 조회한다.
	 * @param json
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	private static boolean addInicisAprvlDataSet(String authUrl) {
		String url = "fcstdpay.inicis.com";
		String param = "";
		if (authUrl.contains(url)) {
			int urlLen = authUrl.indexOf(url) + url.length();
			if (authUrl.length() > urlLen) {
				param = authUrl.substring(urlLen);
			}
			url = "HTTPS://AAAAA."+url;
			System.out.println("CHANGE_URL:::"+url);
			System.out.println("resourcepath-param:::"+param);
			return true;
		}
		return false;
	}

}
