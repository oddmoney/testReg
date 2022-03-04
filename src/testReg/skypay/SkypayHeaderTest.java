package testReg.skypay;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class SkypayHeaderTest {

	private static final String svrDomain = "http://dpae.jejuair.net";

	public static void main(String[] args) {
		// 수기특약 Header 테스트
		testAfterAprvlHeader();
	}

	/**
	 * 수기특약 
	 */
	private static void testAfterAprvlHeader() {
		String resJson = null;
		CloseableHttpClient client = null;
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			client = HttpClients.createDefault();

			HttpPost httpPost = new HttpPost(svrDomain + "/paeg/skypay/requestApproval/v1.0");
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Connection", "keep-alive");
			httpPost.setHeader("Content-Type", "application/json");
			httpPost.addHeader("G-TXID", "22222222222222222222222"); 

			// Body
			JsonObject cardInfo = new JsonObject();
			cardInfo.addProperty("cardNo", "4101000000000000");
			cardInfo.addProperty("expiryDate", "0125");
			cardInfo.addProperty("installment", "00");
			
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("systemType", "CRS");
			jsonObj.addProperty("pnrAlpha", "APQQ41");
			jsonObj.addProperty("paymentId", "2041");
			jsonObj.addProperty("paymentTypeCode", "KF");
			jsonObj.addProperty("currency", "KRW");
			jsonObj.addProperty("amount", "10000.000");
			jsonObj.addProperty("bookId", "11212312");
			jsonObj.addProperty("skySpeedId", "11212312");
			jsonObj.add("cardInfo", cardInfo);
			
			StringEntity entity = new StringEntity(new Gson().toJson(jsonObj));
		    httpPost.setEntity(entity);
		    CloseableHttpResponse response = client.execute(httpPost);
		    
		    String strRes = new BasicResponseHandler().handleResponse(response);
		    System.out.println("new BasicResponseHandler().handleResponse(response):"+strRes);
		    
		    if (response.getStatusLine().getStatusCode()==200) {
			    resJson = gson.toJson(gson.fromJson(strRes, JsonObject.class));
			    System.out.println("resJson:"+resJson);
		    }
		    
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (client != null) { client.close(); }
			} catch (Exception se) { }
		}
	}
	
}
