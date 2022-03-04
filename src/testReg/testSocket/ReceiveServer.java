package testReg.testSocket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReceiveServer {

	private static int PORT = 8889;
	private static int THREAD_CNT = 10;
	private static ExecutorService threadPool;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			threadPool = Executors.newFixedThreadPool(THREAD_CNT);

			// �꽌踰꾩냼耳� �깮�꽦
			serverSocket = new ServerSocket(PORT);
			// �냼耳볦꽌踰꾧� 醫낅즺�맆�븣源뚯� 臾댄븳猷⑦봽
			while (true) {
				try {
					//threadPool.execute(new ConnectionWrap(socket, sExcepIp));
					threadPool.execute(new ConnectionWrap(serverSocket.accept()));
				} catch (Exception se) {
					se.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null) { serverSocket.close(); serverSocket = null; }
			} catch (Exception se) {
				se.printStackTrace();
			}
		}
	}

}


class ConnectionWrap implements Runnable {

	private final static String filePath = "tempTxt.txt";
	
	//private final static String sCharsetName = "EUC-KR";
	private final static String sCharsetName = "UTF-8";

	private Socket socket = null;
	
	public ConnectionWrap(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		StringBuffer reqSb = new StringBuffer();
		StringBuffer resSb = new StringBuffer();
		InputStream is = null;
		BufferedInputStream bis = null;
		OutputStream os = null;
		BufferedOutputStream bos = null;

		try {
			/*
			 * �슂泥� �뜲�씠�꽣 �닔�떊
			 */
			System.out.println(this.socket + " �닔�떊");
			byte[] bInBuff = new byte[229];
			is = socket.getInputStream();
			bis = new BufferedInputStream(is);
			bis.read(bInBuff);
			System.out.println(this.socket + " �닔�떊�궡�슜[" + new String(bInBuff, sCharsetName) + "]");
			reqSb.append(new String(bInBuff, sCharsetName));
			System.out.println("==================== �닔�떊�셿猷� ====================["+reqSb.toString()+"]");

			/*
			 * �듅�씤踰덊샇 �깮�꽦
			 */
			String aprvlNum = String.valueOf(Integer.parseInt(getApprovalNum()) + 1);
			setApprovalNum(aprvlNum);
			System.out.println("aprvlNum:["+aprvlNum+"]");

			/*
			 * �쓳�떟 �뜲�씠�꽣 �깮�꽦
			 */
			resSb.append("JEJUAIRQSSD23                        21031764776804201011709547000088112727    170635460      �쁽��移대뱶                    08 �쁽��移대뱶�궗                 08 �쁽��移대뱶�궗                                               \n");
			byte[] resb = putAddByte(resSb.toString());
			
			/*
			 * �쓳�떟 �뜲�씠�꽣 �넚�떊
			 */
			System.out.println(this.socket + " �넚�떊");
			os = socket.getOutputStream();
			bos = new BufferedOutputStream(os);
			System.out.println(this.socket + " �넚�떊�궡�슜[" + new String(resb, sCharsetName) + "]");
			bos.write(resb);
			bos.flush();
			System.out.println("==================== �쓳�떟�셿猷� ====================");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) { bos.close(); bos = null; }
				if (os != null) { os.close(); os = null; }
				if(bis != null) { bis.close(); bis = null; }
				if(is != null) { is.close(); is = null; }
				if (socket != null) { socket.close(); socket = null; }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void putAddByte(byte[] orgb, byte[] newb, int pos) throws Exception{
		if (orgb != null && newb != null && orgb.length >= (pos + newb.length))
			System.arraycopy(newb, 0, orgb, pos, newb.length);
	}

	public static byte[] putAddByte(String newStr) throws Exception{
		byte[] retb = new byte[newStr.getBytes().length];
		System.arraycopy(newStr.getBytes(), 0, retb, 0, newStr.getBytes().length);
		return retb;
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
