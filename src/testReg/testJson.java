package testReg;

import java.util.HashMap;

import org.json.JSONObject;

public class testJson {

	public static void main(String[] args) {
		JSONObject jsonData = new JSONObject();
		jsonData.put("itemName", "11111");
		jsonData.put("occurDate", "2222");
		jsonData.put("occurTime", "3333");
		jsonData.put("expiredDate", "4444");
		jsonData.put("expiredDate2", "5555");
		jsonData.put("expiredDate3", "6666");
		try {
			procParse(jsonData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void procParse(Object obj) throws Exception {
		HashMap<String, String> returnDataMap = new HashMap<String, String>();
		if (obj instanceof JSONObject) {
			JSONObject jsonData = (JSONObject) obj;
			jsonData.keySet().forEach(j -> {
				if ("itemName".equals(j) || "occurDate".equals(j) || "occurTime".equals(j) || "expiredDate".equals(j)) {
					returnDataMap.put(j, jsonData.getString(j));
				}
			});
		}
		System.out.println("returnDataMap:::"+returnDataMap.toString());
	}
}
