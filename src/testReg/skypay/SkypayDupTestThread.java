package testReg.skypay;

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
import com.google.gson.JsonObject;

public class SkypayDupTestThread implements Runnable {

	private String url = null;
	private String reqJson = null;
	
	public SkypayDupTestThread(String url, String reqJson) {
		this.url = url;
		this.reqJson = reqJson;
	}
	
    @Override
    public void run() {
    	System.out.println("#####Request:"+reqJson);
    	String response = sendRest(url, reqJson);
    	System.out.println("#####Response:"+response);
    }

	private String sendRest(String url, String reqJson) {
		if (StringUtils.isBlank(reqJson)) return "";
		
		String resJson = null;
		CloseableHttpClient client = null;
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			client = HttpClients.createDefault();

			HttpPost httpPost = new HttpPost(url);
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
