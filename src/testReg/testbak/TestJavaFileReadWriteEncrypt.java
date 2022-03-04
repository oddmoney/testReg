package testReg.testbak;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import testReg.encrypt.EncryptUtils;

public class TestJavaFileReadWriteEncrypt {

	private static final String ASE_KEY="tourTest190A367V751IT471S3807355";
	private static final String ASE_IV="tourTest12345678";

	private static String lineDivStr = "@#RN#@";
	private static String fileDivStr = "@#FL#@";
	
	private static String bakFolder = "E:\\ShinhanDevelopmentToolkit\\eclipse\\workspace\\bnd_paeg"; // PAEG
//	private static String bakFolder = "E:\\ShinhanDevelopmentToolkit\\eclipse\\workspace\\frt_pacg"; // PACG
//	private static String bakFolder = "E:\\ShinhanDevelopmentToolkit\\eclipse\\workspace\\adm_ibea"; // ADM
//	private static String bakFolder = "E:\\ShinhanDevelopmentToolkit\\eclipse\\workspace\\bnd_ibeg"; //IBEG
//	private static String bakFolder = "E:\\ShinhanDevelopmentToolkit\\eclipse\\workspace\\bnd_paeg_bat"; // PAEG_BAT
//	private static String bakFolder = "E:\\ShinhanDevelopmentToolkit\\eclipse\\workspace\\bnd_ibeg_bat"; // IBEG_BAT

	private static String bakFile = "C:\\dev\\source\\lineFile\\bakFile_bnd_paeg.txt"; // PAEG
//	private static String bakFile = "C:\\dev\\source\\lineFile\\bakFile_frt_pacg.txt"; // PACG
//	private static String bakFile = "C:\\dev\\source\\lineFile\\bakFile_adm_ibeg.txt"; // ADM
//	private static String bakFile = "C:\\dev\\source\\lineFile\\bakFile_bnd_ibeg.txt"; //IBEG
//	private static String bakFile = "C:\\dev\\source\\lineFile\\bakFile_bnd_paeg_bat.txt"; // PAEG_BAT
//	private static String bakFile = "C:\\dev\\source\\lineFile\\bakFile_bnd_ibeg_bat.txt"; // IBEG_BAT

	private static String restoreFolder = "C:\\dev\\source\\lineFolder\\bnd_paeg"; // PAEG
//	private static String restoreFolder = "C:\\dev\\source\\lineFolder\\frt_pacg"; // PACG
//	private static String restoreFolder = "C:\\dev\\source\\lineFolder\\adm_ibeg"; // ADM
//	private static String restoreFolder = "C:\\dev\\source\\lineFolder\\bnd_ibeg"; //IBEG
//	private static String restoreFolder = "C:\\dev\\source\\lineFolder\\bnd_paeg_bat"; // PAEG_BAT
//	private static String restoreFolder = "C:\\dev\\source\\lineFolder\\bnd_ibeg_bat"; // IBEG_BAT

	public static void main(String[] args) {
		printBakEncrypt();
		//executeBakEncrypt();
		//printRestoreEncrypt();
		//executeRestoreEncrypt();
	}

	/**
	 * 파일Print
	 * File 명(암호화)  + \n + file내용(암호화)
	 */
	private static void printBakEncrypt() {
		try {
			List<String> fileList = new ArrayList<>();
			findFile(fileList, bakFolder);
			
			for (String fileStr : fileList) {
				System.out.println(getEnc(fileStr.replace(bakFolder, "")));
				StringBuffer sb = getJavaFile(fileStr);
				for (String str : sb.toString().split(lineDivStr)) {
					System.out.println(getEnc(str));	
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
	private static void executeBakEncrypt() {
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			TestJavaFileReadWrite receiveServer = new TestJavaFileReadWrite();
			List<String> fileList = new ArrayList<>();
			findFile(fileList, bakFolder);
			
			fw = new FileWriter(bakFile);
			bw = new BufferedWriter(fw);

			for (String fileStr : fileList) {
				bw.write(getEnc(fileStr.replace(bakFolder, "")) + fileDivStr + getEnc(receiveServer.getJavaFile(fileStr).toString())+"\n");
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
	private static void printRestoreEncrypt() {
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
				System.out.println(getDec(strFile[0]));
				for (String str : strFile[1].split(lineDivStr)) {
					System.out.println(getDec(str));
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
	private static void executeRestoreEncrypt() {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			fis = new FileInputStream(bakFile);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			String data = null;
			while((data=br.readLine()) != null) restoreFileEncrypt(data);
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
	private static void restoreFileEncrypt(String fileData) {
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			String strFile[] = fileData.split(fileDivStr);
			String folders[] = getDec(strFile[0]).split("\\\\");
			if (folders.length > 1) {
				String folderStr = restoreFolder;
				for (int i=0;i<folders.length-1;i++) {
					folderStr += "\\" + folders[i];
					File newFolder = new File(folderStr);
					if (!newFolder.exists()) newFolder.mkdir();
				}
			}
			
			fw = new FileWriter(restoreFolder + getDec(strFile[0]));
			bw = new BufferedWriter(fw);
			for (String str : getDec(strFile[1]).split(lineDivStr)) {
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

	private static StringBuffer getJavaFile(String filePath){
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

	private static void findFile(List<String> fileList, String fnm) throws Exception {
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

	private static String getEnc(String str) throws Exception {
		return EncryptUtils.encryptAES(EncryptUtils.getSecretAES(ASE_KEY), ASE_IV, str);
	}
	
	private static String getDec(String str) throws Exception {
		return EncryptUtils.decryptAES(EncryptUtils.getSecretAES(ASE_KEY), ASE_IV, str);
	}
	
}
