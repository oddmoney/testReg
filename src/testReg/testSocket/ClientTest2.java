package testReg.testSocket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTest2 {

	private static final String reqMsg = "JEJUAIRQSSD23                        210309533533020010106424  @4111111111111111                     00000101030000000000000000000000                  JJ7901010000000                                                                \n";

	public static void main(String[] args) {
			
		new ClientTest2().sendTest("dnesb.jejuair.net",30301);
		 
	}


	public void sendTest(String host, int port) {
		byte[] resMsg = null;
    	byte[] bOutbuff = null;
    	Socket socket = null;
    	OutputStream os = null;
    	BufferedOutputStream bos = null;
    	InputStream is = null;
    	BufferedInputStream bis = null;
    	try {
    		bOutbuff = reqMsg.getBytes(); 
   			System.out.println("###Send-Data:::"+new String(bOutbuff));   			
   			socket = new Socket(host, port);
    		os = socket.getOutputStream();
    		bos = new BufferedOutputStream(os);
    		bos.write(bOutbuff);
    		System.out.println("###write-Success");
    		bos.flush();
   			System.out.println("###Flush-Success");   			
    		resMsg = new byte[227];
    		is = socket.getInputStream();
    		bis = new BufferedInputStream(is);
    		bis.read(resMsg);
    		System.out.println("###read-Success");
    		System.out.println("###Receive-Data:::"+new String(resMsg));
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
            	if (os != null) { os.close(); os = null; }
            	if (bos != null) { bos.close(); bos = null; }
            	if (is != null) { is.close(); is = null; }
            	if (bis != null) { bis.close(); bis = null; }
            	if (socket != null) { socket.close(); }
            	
        		/*
        		 * 硫붾え由ъ큹湲고솕(蹂��닔珥덇린�솕)
        		 */
    			if (bOutbuff != null) {
    				for (int i = 0; i < bOutbuff.length; i++) {
    					bOutbuff[i] = (byte) 0x00;
    					bOutbuff[i] = (byte) 0xff;
    					bOutbuff[i] = (byte) 0x00;
    				}
    				bOutbuff = null;
    			}				
            	
    		} catch (Exception fe) {
        		// Finally 遺�遺꾩뿉�꽌�뒗 �삤瑜� 由ы꽩�븯吏� �븡�뒗�떎.
    		}
    	}
	}

}
