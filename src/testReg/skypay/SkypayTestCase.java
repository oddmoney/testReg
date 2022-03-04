package testReg.skypay;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class SkypayTestCase {

	public static void main(String[] args) {
		try {
			//testDcaseSub(1, "A", "CL", "10000", "KP21021021012345678", "123456");
			testDcase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testDcase() throws Exception {
		String[][] val = {	
				// CASE 1,2,3
	{"CL", "A", "10000","NPQQAP5121428151111", 	"", 		"NPQQAP5121428151111", 	"108013"},{"CL", "R", "10000", "NPQQAP5121428151114", 	"108013", 	"NPQQAP5121428151114",	"108016"},				
	{"CL", "A", "10000","NPQQAP5121428151112", 	"", 		"NPQQAP5121428151112", 	""		},{"CL", "R", "10000", "NPQQAP5121428151112", 	"", 		"NPQQAP5121428151112", 	""},
	{"CL", "A", "10000","", 					"108013", 	"NPQQAP5121428151112", 	"108013"},{"CL", "R", "10000", "NPQQAP5121428151112", 	"108013", 	"NPQQAP5121428151112", 	"108017"},
	{"CL", "A", "10000","NPQQAP5121428151113", 	"108015", 	"NPQQAP5121428151113", 	"108015"},{"CL", "R", "10000", "NPQQAP5121428151113", 	"108015", 	"NPQQAP5121428151113", 	"108019"},
	{"CL", "A", "10000","NPQQAP5121428151120", 	"", 		"NPQQAP5121428151122", 	"108039"},{"CL", "R", "10000", "NPQQAP5121428151122", 	"108039", 	"NPQQAP5121428151122", 	"108034"},
	{"CL", "A", "10000","NPQQAP5121428151121", 	"", 		"NPQQAP5121428151125", 	""		},{"CL", "R", "10000", "NPQQAP5121428151125", 	"", 		"NPQQAP5121428151325", 	""},
	{"CL", "A", "10000","NPQQAP5121428151122", 	"108039", 	"NPQQAP5121428151322", 	"108039"},{"CL", "R", "10000", "NPQQAP5121428151322", 	"108039", 	"NPQQAP5121428151326", 	"108043"},
	{"CL", "A", "10000","", 					"108040", 	"NPQQAP5121428151323", 	"108340"},{"CL", "R", "10000", "NPQQAP5121428151323", 	"108340", 	"NPQQAP5121428151323", 	"108344"},
	{"CL", "A", "10000","", 					"108041", 	"NPQQAP5121428151324", 	""		},{"CL", "R", "10000", "NPQQAP5121428151324", 	"108041", 	"", 					"108345"},
	{"CL", "A", "10000","NPQQAP5121428151123", 	"108042", 	"NPQQAP5121428151123", 	"108342"},{"CL", "R", "10000", "NPQQAP5121428151123", 	"108342", 	"NPQQAP5121428151123", 	"108342"},
	{"CL", "A", "10000","NPQQAP5121428151150", 	"", 		"", 					"108060"},{"CL", "R", "10000", "NPQQAP5121428151150", 	"108060", 	"", 					"108055"},
	{"CL", "A", "10000","", 					"108061", 	"", 					"108061"},{"CL", "R", "10000", "", 						"108061", 	"", 					"108056"},
	{"CL", "A", "10000","NPQQAP5121428151151", 	"108062", 	"", 					"108062"},{"CL", "R", "10000", "NPQQAP5121428151151", 	"108062", 	"", 					"108057"},
	{"CL", "A", "10000","NPQQAP5121428151152", 	"", 		"NPQQAP5121428151152", 	""		},{"CL", "R", "10000", "NPQQAP5121428151152", 	"", 		"NPQQAP5121428151152", 	""},
	{"CL", "A", "10000","", 					"108053", 	"NPQQAP5121428151352", 	""		},{"CL", "R", "10000", "NPQQAP5121428151352", 	"108053", 	"NPQQAP5121428151352", 	""},
	{"CL", "A", "10000","NPQQAP5121428151153", 	"108054", 	"NPQQAP5121428151153", 	""		},{"CL", "R", "10000", "NPQQAP5121428151153", 	"108054", 	"NPQQAP5121428151153", 	""},
				// CASE 4,5
	{"CL", "A", "100001", "",					"", 		"", 					"108091"},{"CL", "R", "100004","", 						"108091", 	"", 					"108093"},
	{"CL", "A", "100002", "",					"", 		"NPQQAP5121428151270", 	""		},{"CL", "R", "100005","NPQQAP5121428151270", 	"", 		"NPQQAP5121428151270", 	""},
	{"CL", "A", "100003", "",					"", 		"NPQQAP5121428151271", 	"108092"},{"CL", "R", "100006","NPQQAP5121428151271", 	"108092", 	"NPQQAP5121428151271", 	"108094"},
	{"CL", "A", "100007", "",					"", 		"", 					""		},{"CL", "R", "100008","", 						"", 		"", 					""}
			};
		
		int payId = 227;
		for (String[] v : val) {
			testDcaseSub(payId++, v[0], v[1], v[2], v[3], v[4], v[5], v[6]);
		}
	}
	private static void testDcaseSub(int payId, String payType, String reqType, String amt, String orderId, String aprvlNum, String resOrderId, String resAprvlNum) throws Exception {
		HttpURLConnection conn = null;
		OutputStream os = null;
		InputStream is = null;
		BufferedReader br = null;
		StringBuffer data = new StringBuffer();
		String param = "{" + 
				(reqType.equals("A") ? " \"systemType\" : \"CRS\", " : "") +
				" \"orderId\" : \"" + orderId + "\", " +
				" \"approvalNum\" : \"" + aprvlNum + "\", " +
				" \"pnrAlpha\" : \"AAAAAA\", " +
				" \"paymentId\" : \"" + payId + "\", " +
				" \"skySpeedId\" : \"12345678\", " +
				" \"bookId\" : \"56789\", " +
				" \"paymentTypeCode\" : \"" + payType + "\", " +
				" \"currency\" : \"KRW\", " +
				" \"amount\" : \"" + amt + "\" " +
					"}";
		JSONObject json = new JSONObject(param);
		try {
			URL sUrl = new URL("http://dpae.jejuair.net/paeg/skypay/request" + (reqType.equals("A") ? "Approval" : "Cancel") + "/v1.0");
			//URL sUrl = new URL("http://localhost:9080/paeg/skypay/request" + (reqType.equals("A") ? "Approval" : "Cancel") + "/v1.0");
			conn = (HttpURLConnection) sUrl.openConnection();
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Connection", "keep-alive");
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			os = conn.getOutputStream();
			os.write(json.toString().getBytes());
			os.flush();
			os.close();
			is = conn.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = br.readLine()) != null) data.append(line);
		}catch(Exception e) {
			e.printStackTrace(); 
		}finally {
			if (os != null) os.close();
			if (br != null) br.close();
			if (is != null) is.close();
			if (conn != null) conn.disconnect();
		}
		JSONObject jsonRes = new JSONObject(data.toString());
		//if (!(jsonRes.has("orderId") && resOrderId.equals(jsonRes.getString("orderId")) && jsonRes.has("approvalNum") && resAprvlNum.equals(jsonRes.getString("approvalNum")))) {
			System.out.println("==========\nRequest:"+param.toString()+"\nResponse:"+jsonRes.toString()+"\nResult:"
					+(jsonRes.has("orderId") && resOrderId.equals(jsonRes.getString("orderId")) && jsonRes.has("approvalNum") && resAprvlNum.equals(jsonRes.getString("approvalNum"))));
		//}
	}
}
