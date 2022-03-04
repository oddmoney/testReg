package testReg.skypay;

import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class TestCase {
	
	//private static final String svrDomain = "http://localhost:9080";
	private static final String svrDomain = "http://dpae.jejuair.net";
	
	private static final String aprvlUrl = "/paeg/skypay/requestApproval/v1.0";
	private static final String cnlUrl = "/paeg/skypay/requestCancel/v1.0";
	
	private static int payId = 178;
	
	public static void main(String[] args) {
		//testCaseAtestApproval();
		//testCaseAtestCancel();
		testCaseBtest();
		//testCaseCtest();
		//testCaseDtest();
		//testCaseEtest();
	}

	/**
	 * json 파일 주석 참고
	 */
	private static void testCaseEtest() {
		// SITA 취소 테스트
		executeTest("[TEST-E]", cnlUrl, "json/TEST-E-skypaySitaCancel.json");
	}

	/**
	 * json 파일 주석 참고
	 */
	private static void testCaseDtest() {
		// 승인 테스트
		executeTest("[TEST-D]", aprvlUrl, "json/TEST-D-skypayApprove.json");
		// 취소 테스트
		executeTest("[TEST-D]", cnlUrl, "json/TEST-D-skypayCancel.json");
	}

	/**
	 * json 파일 주석 참고
	 */
	private static void testCaseCtest() {
		// 승인 테스트
		//executeTest("[TEST-C]", aprvlUrl, "json/TEST-C-skypayApprove.json");
		// 취소 테스트
		executeTest("[TEST-C]", cnlUrl, "json/TEST-C-skypayCancel.json");
	}

	/**
	 * json 파일 주석 참고
	 */
	private static void testCaseBtest() {
		executeTest("[TEST-B]", aprvlUrl, "json/TEST-B-skypayApproveValidation.json");
		executeTest("[TEST-B]", cnlUrl, "json/TEST-B-skypayApproveValidation.json");
	}

	/**
	 * json 파일 주석 참고
	 */
	private static void testCaseAtestApproval() {
		executeTest("[TEST-A]", aprvlUrl, "json/TEST-A-skypayApprove.json");
	}

	/**
	 * json 파일 주석 참고
	 */
	private static void testCaseAtestCancel() {
		executeTest("[TEST-A]", cnlUrl, "json/TEST-A-skypayCancel.json");
	}

	private static void executeTest(String strTest, String url, String jsonFile) {
		try {
			JsonObject jsonObj = getReqJsonObj(jsonFile);
			if (jsonObj != null) {
				int testNum = 0;
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				if (jsonObj.has("testCase")) {
					for (JsonElement jsonEl : jsonObj.getAsJsonArray("testCase")) {
						JsonObject jsonItem = gson.fromJson(jsonEl, JsonObject.class);
						if (jsonItem.has("paymentId")) {
							jsonItem.remove("paymentId");
							jsonItem.addProperty("paymentId", String.valueOf(payId++));
						}
						executeTestRest(strTest + "[" + (++testNum) + "]", url, gson.toJson(jsonItem));
						Thread.sleep(1500);
					}
				} else {
					if (jsonObj.has("paymentId")) {
						jsonObj.remove("paymentId");
						jsonObj.addProperty("paymentId", String.valueOf(payId++));
					}
					executeTestRest(strTest + "[" + (++testNum) + "]", url, gson.toJson(jsonObj));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static JsonObject getReqJsonObj(String jsonFile) throws Exception {
		JsonReader jsonReader = new JsonReader(new FileReader(TestCase.class.getResource("").getPath()+jsonFile));
		return new Gson().fromJson(jsonReader, JsonObject.class);
	}

	private static void executeTestRest(String strTest, String url, String reqJson) throws Exception {
		System.out.println("====================\n" + strTest + "\n--------------------\n----------Request : \n"
				+ reqJson + "\n----------Response : \n" + sendRest(url, reqJson) + "\n====================\n\n");
	}

	private static String sendRest(String url, String reqJson) {
		if (StringUtils.isBlank(reqJson)) return "";
		
		String resJson = null;
		CloseableHttpClient client = null;
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			client = HttpClients.createDefault();

			HttpPost httpPost = new HttpPost(svrDomain + url);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Connection", "keep-alive");
			httpPost.setHeader("Content-Type", "application/json");
			//httpPost.addHeader("x-api-key", RestTestCommon.API_KEY); //KEY 입력 
			//postRequest.addHeader("Authorization", token); // token 이용시

			StringEntity entity = new StringEntity(reqJson);
		    httpPost.setEntity(entity);
		    CloseableHttpResponse response = client.execute(httpPost);
		    if (response.getStatusLine().getStatusCode()==200) {
			    resJson = gson.toJson(gson.fromJson(new BasicResponseHandler().handleResponse(response), JsonObject.class));
		    }
		    
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (client != null) { client.close(); }
			} catch (Exception se) { }
		}
		return resJson;
	}

}
