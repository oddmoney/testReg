package testReg.testSocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class TestFileReadWrite {

	private static String filePath = "tempTxt.txt";

	public static void main(String[] args) {
		TestFileReadWrite receiveServer = new TestFileReadWrite();
		String oldNum = receiveServer.getApprovalNum();
		String newNum = String.valueOf(Integer.parseInt(oldNum) + 1);
		
		receiveServer.setApprovalNum(newNum);
		System.out.println("Old_ApprovalNum:["+oldNum+"], New_ApprovalNum:{"+newNum+"]");
	}

	private String getApprovalNum(){
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String data = null;
			while((data=br.readLine()) != null) {
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) { br.close(); br = null; }
				if (fr != null) { fr.close(); fr = null; }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "1";
	}


	private void setApprovalNum(String num) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(filePath);
			bw = new BufferedWriter(fw);
			bw.write(num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) { bw.close(); bw = null; }
				if (fw != null) { fw.close(); fw = null; }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
