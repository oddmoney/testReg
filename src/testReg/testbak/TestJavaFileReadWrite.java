package testReg.testbak;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestJavaFileReadWrite {
	
	private static String lineDivStr = "@#RN#@";
	private static String fileDivStr = "@#FL#@";
	
	private static String bakFoler = "E:\\ShinhanDevelopmentToolkit\\eclipse\\workspace\\bnd_paeg\\src";
	
	private static String bakFile = "C:\\dev\\source\\lineFile\\bakFile.txt";
	
	private static String restoreFolder = "C:\\dev\\source\\lineFolder";

	public static void main(String[] args) {
		//printBak();
		//executeBak();
		//printRestore();
		executeRestore();
	}

	/**
	 * 파일Print
	 * File 명  + \n + file내용
	 */
	public static void printBak() {
		try {
			TestJavaFileReadWrite receiveServer = new TestJavaFileReadWrite();
			List<String> fileList = new ArrayList<>();
			findFile(fileList, bakFoler);
			
			for (String fileStr : fileList) {
				System.out.println(fileStr.replace(bakFoler, ""));
				StringBuffer sb = receiveServer.getJavaFile(fileStr);
				for (String str : sb.toString().split(lineDivStr)) {
					System.out.println(str);	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 파일백업
	 * File 명 + file구분자 + file내용 (line 내용 + line 구분자)
	 */
	public static void executeBak() {
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			TestJavaFileReadWrite receiveServer = new TestJavaFileReadWrite();
			List<String> fileList = new ArrayList<>();
			findFile(fileList, bakFoler);
			
			fw = new FileWriter(bakFile);
			bw = new BufferedWriter(fw);

			for (String fileStr : fileList) {
				bw.write(fileStr.replace(bakFoler, "") + fileDivStr + receiveServer.getJavaFile(fileStr).toString()+"\n");
			}
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

	/**
	 * 백업파일 복원 출력
	 */
	public static void printRestore() {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(bakFile);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			String data = null;
			while((data=br.readLine()) != null) {
				String strFile[] = data.split(fileDivStr);
				System.out.println(strFile[0]);
				for (String str : strFile[1].split(lineDivStr)) {
					System.out.println(str);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) { br.close(); br = null; }
				if (isr != null) { isr.close(); isr = null; }
				if (fis != null) { fis.close(); fis = null; }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 백업파일 복원
	 * File 명으로 파일 생성 (file내용)
	 */
	public static void executeRestore() {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			fis = new FileInputStream(bakFile);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			String data = null;
			while((data=br.readLine()) != null) restoreFile(data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) { br.close(); br = null; }
				if (isr != null) { isr.close(); isr = null; }
				if (fis != null) { fis.close(); fis = null; }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 백업파일 복원 - 파일생성
	 */
	public static void restoreFile(String fileData) {
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			String strFile[] = fileData.split(fileDivStr);
			String folders[] = strFile[0].split("\\\\");
			if (folders.length > 1) {
				String folderStr = restoreFolder;
				for (int i=0;i<folders.length-1;i++) {
					folderStr += "\\" + folders[i];
					File newFolder = new File(folderStr);
					if (!newFolder.exists()) newFolder.mkdir();
				}
			}
			
			fw = new FileWriter(restoreFolder + strFile[0]);
			bw = new BufferedWriter(fw);
			for (String str : strFile[1].split(lineDivStr)) {
				bw.write(str+"\n");
			}
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

	public StringBuffer getJavaFile(String filePath){
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			fis = new FileInputStream(filePath);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			String data = null;
			while((data=br.readLine()) != null) {
				sb.append(data + lineDivStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) { br.close(); br = null; }
				if (isr != null) { isr.close(); isr = null; }
				if (fis != null) { fis.close(); fis = null; }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sb;
	}

	static void findFile(List<String> fileList, String fnm) throws Exception {
		File file = new File(fnm);
		if (file.exists()) {
			if (file.isDirectory()) {
				for(File subf : file.listFiles()) {
					findFile(fileList, subf.getAbsolutePath());
				}
			} else {
				if (file.getAbsolutePath().matches("^.*\\.((java)|(properties)|(xml)|(jsp)|(html)|(htm)|(js))$")) {
					fileList.add(file.getAbsolutePath());
				}
			}
		}
	}

}
