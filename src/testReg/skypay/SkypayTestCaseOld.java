package testReg.skypay;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class SkypayTestCaseOld {

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
				{"KF", "R", "KFQQAP5121428151111",	"", 		"KFQQAP5121428151111",	"108010"},
				{"KF", "R", "KFQQAP5121428151112",	"", 		"KFQQAP5121428151112",	""},
				{"KF", "R", "", 					"108010",	"",						"108011"},
				{"KF", "R", "", 				  	"108011", "KFQQAP5121428151922",	"108022"},
				{"KF", "R", "KFQQAP5121428151113",	"108012", "KFQQAP5121428151113",	"108012"},
				{"CL", "A", "NPQQAP5121428151111", 	"", 		"NPQQAP5121428151111", 	"108013"},
				{"CL", "A", "NPQQAP5121428151112", 	"", 		"NPQQAP5121428151112", 	""},
				{"CL", "A", "", 					"108013", 	"NPQQAP5121428151112", 	"108013"},
				{"CL", "A", "", 					"108014", 	"",                    	"108014"},
				{"CL", "A", "NPQQAP5121428151113",	"108015", 	"NPQQAP5121428151113", 	"108015"},
				{"CL", "R", "NPQQAP5121428151114", 	"", 		"NPQQAP5121428151113", 	"108016"},
				{"CL", "R", "NPQQAP5121428151115", 	"", 		"NPQQAP5121428151115", 	""},
				{"CL", "R", "", 					"108017", 	"NPQQAP5121428151115", 	"108017"},
				{"CL", "R", "", 					"108018", 	"",                    	"108018"},
				{"CL", "R", "NPQQAP5121428151116", 	"108019", 	"NPQQAP5121428151116", 	"108019"},
				{"KF", "A", "KFQQAP5121428151120", 	"", 		"KFQQAP5121428151320", 	"108030"},
				{"KF", "A", "KFQQAP5121428151121", 	"", 		"KFQQAP5121428151321", 	""},
				{"KF", "A", "KFQQAP5121428151122", 	"108031", 	"KFQQAP5121428151322", 	"108031"},
				{"KF", "A", "", 					"108032", 	"KFQQAP5121428151323", 	"108332"},
				{"KF", "A", "", 					"108033", 	"", 					"108333"},
				{"KF", "A", "KFQQAP5121428151123", 	"108034", 	"KFQQAP5121428151123", 	"108334"},
				{"KF", "R", "KFQQAP5121428151124", 	"", 		"KFQQAP5121428151324", 	"108021"},
				{"KF", "R", "KFQQAP5121428151125", 	"", 		"KFQQAP5121428151325", 	""},
				{"KF", "R", "KFQQAP5121428151126", 	"108035", 	"KFQQAP5121428151326", 	"108035"},
				{"KF", "R", "", 					"108036", 	"KFQQAP5121428151326", 	"108336"},
				{"KF", "R", "", 					"108037", 	"", 					"108337"},
				{"KF", "R", "KFQQAP5121428151127", 	"108038", 	"KFQQAP5121428151127", 	"108338"},
				{"CL", "A", "NPQQAP5121428151120", 	"", 		"NPQQAP5121428151122", 	"108039"},
				{"CL", "A", "NPQQAP5121428151121", 	"", 		"NPQQAP5121428151121", 	""},
				{"CL", "A", "NPQQAP5121428151122", 	"108039", 	"NPQQAP5121428151322", 	"108039"},
				{"CL", "A", "", 					"108040", 	"NPQQAP5121428151322", 	"108340"},
				{"CL", "A", "", 					"108041", 	"NPQQAP5121428151322", 	""},
				{"CL", "A", "NPQQAP5121428151123", 	"108042", 	"NPQQAP5121428151123", 	"108342"},
				{"CL", "R", "NPQQAP5121428151124", 	"", 		"NPQQAP5121428151324", 	"108034"},
				{"CL", "R", "NPQQAP5121428151125", 	"", 		"NPQQAP5121428151325", 	""},
				{"CL", "R", "NPQQAP5121428151126", 	"108043", 	"NPQQAP5121428151326", 	"108043"},
				{"CL", "R", "", 					"108044", 	"NPQQAP5121428151326", 	"108344"},
				{"CL", "R", "", 					"108045", 	"", 					"108345"},
				{"CL", "R", "NPQQAP5121428151127", 	"108046", 	"NPQQAP5121428151127", 	"108346"},
				{"CL", "A", "NPQQAP5121428151150", 	"", 		"", 					"108060"},
				{"CL", "A", "", 					"108061", 	"", 					"108061"},
				{"CL", "A", "NPQQAP5121428151151", 	"108062", 	"", 					"108062"},
				{"CL", "A", "NPQQAP5121428151152", 	"", 		"NPQQAP5121428151152", 	""},
				{"CL", "A", "", 					"108053", 	"NPQQAP5121428151352", 	""},
				{"CL", "A", "NPQQAP5121428151153", 	"108054", 	"NPQQAP5121428151153", 	""},
				{"CL", "R", "NPQQAP5121428151154", 	"", 		"", 					"108055"},
				{"CL", "R", "", 					"108056", 	"", 					"108056"},
				{"CL", "R", "NPQQAP5121428151155", 	"108057", 	"", 					"108057"},
				{"CL", "R", "NPQQAP5121428151156", 	"", 		"NPQQAP5121428151156", 	""},
				{"CL", "R", "", 					"108058", 	"NPQQAP5121428151356", 	""},
				{"CL", "R", "NPQQAP5121428151157", 	"108059", 	"NPQQAP5121428151157", 	""}
			};
		String[][] val2 = {
				{"CL", "A", "100001", "", 						"108091"}, 
				{"CL", "A", "100002", "NPQQAP5121428151270", 	""}, 
				{"CL", "A", "100003", "NPQQAP5121428151271", 	"108092"},
				{"CL", "A", "100004", "", 						"108093"},
				{"CL", "R", "100005", "NPQQAP5121428151272", 	""}, 
				{"CL", "R", "100006", "NPQQAP5121428151273", 	"108092"}, 
				{"CL", "A", "100007", "", 						""},
				{"CL", "R", "100008", "", 						""}
			};
		
		int payId = 227;
		for (String[] v : val) {
			//testDcaseSub(payId++, v[1], v[0], "10000.000", v[2], v[3], v[4], v[5]);
			testDcaseSub(payId++, "A", v[0], "10000.000", v[2], v[3], v[4], v[5]);
		}
		for (String[] v : val2) {
			//testDcaseSub(payId++, v[1], v[0], v[2], "", "", v[3], v[4]);
			testDcaseSub(payId++, "A", v[0], v[2], "", "", v[3], v[4]);
		}
		System.out.println("==========\n==========\n==========\n");
		for (String[] v : val) {
			//testDcaseSub(payId++, v[1], v[0], "10000.000", v[2], v[3], v[4], v[5]);
			testDcaseSub(payId++, "C", v[0], "10000.000", v[2], v[3], v[4], v[5]);
		}
		for (String[] v : val2) {
			//testDcaseSub(payId++, v[1], v[0], v[2], "", "", v[3], v[4]);
			testDcaseSub(payId++, "C", v[0], v[2], "", "", v[3], v[4]);
		}
	}
	private static void testDcaseSub(int payId, String reqType, String payType, String amt, String orderId, String aprvlNum, String resOrderId, String resAprvlNum) throws Exception {
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
		if (!(resOrderId.equals(jsonRes.has("orderId") ? jsonRes.getString("orderId") : "") && resAprvlNum.equals(jsonRes.has("approvalNum") ? jsonRes.getString("approvalNum") : ""))) {
			System.out.println("==========\nRequest:"+param.toString()+"\nResponse:"+jsonRes.toString()+"\nResult:"
					+(resOrderId.equals(jsonRes.has("orderId") ? jsonRes.getString("orderId") : "") && resAprvlNum.equals(jsonRes.has("approvalNum") ? jsonRes.getString("approvalNum") : "")));
		}
	}
}
