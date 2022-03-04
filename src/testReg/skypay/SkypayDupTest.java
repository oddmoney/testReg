package testReg.skypay;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class SkypayDupTest {

	private static final String svrDomain = "http://dpae.jejuair.net";

	public static void main(String[] args) {
		// 수기특약 Payment ID 중복 테스트
		testAfterAprvlPayIdDuplicate();
	}

	/**
	 * 수기특약 
	 */
	private static void testAfterAprvlPayIdDuplicate() {
		
		/*
		int stPayId = 2025;
		while (stPayId < 2040) {
			JsonObject jobj = getJsonObj(String.valueOf(++stPayId));	
			new Thread(new SkypayDupTestThread(svrDomain + "/paeg/skypay/requestApproval/v1.0", new Gson().toJson(jobj))).start();
			try { Thread.sleep(10); } catch (Exception e) { e.printStackTrace(); }
			new Thread(new SkypayDupTestThread(svrDomain + "/paeg/skypay/requestApproval/v1.0", new Gson().toJson(jobj))).start();
		}
		*/
		JsonObject jobj = getJsonObj("2041");
		new Thread(new SkypayDupTestThread(svrDomain + "/paeg/skypay/requestApproval/v1.0", new Gson().toJson(jobj))).start();
		try { Thread.sleep(10); } catch (Exception e) { e.printStackTrace(); }
		new Thread(new SkypayDupTestThread(svrDomain + "/paeg/skypay/requestApproval/v1.0", new Gson().toJson(jobj))).start();
	}
	
	private static JsonObject getJsonObj(String payId) {
		JsonObject cardInfo = new JsonObject();
		cardInfo.addProperty("cardNo", "4101000000000000");
		cardInfo.addProperty("expiryDate", "0125");
		cardInfo.addProperty("installment", "00");
		
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("systemType", "CRS");
		jsonObj.addProperty("pnrAlpha", "APQQ41");
		jsonObj.addProperty("paymentId", payId);
		jsonObj.addProperty("paymentTypeCode", "KF");
		jsonObj.addProperty("currency", "KRW");
		jsonObj.addProperty("amount", "10000.000");
		jsonObj.addProperty("bookId", "11212312");
		jsonObj.addProperty("skySpeedId", "11212312");
		jsonObj.add("cardInfo", cardInfo);
		return jsonObj;
	}

}
