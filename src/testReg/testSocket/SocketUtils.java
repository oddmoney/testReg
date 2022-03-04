package testReg.testSocket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import testReg.kicc.DateUtils;

public class SocketUtils {

    private final static int DEF_TIMEOUT = 10000;
    private final static int DEF_READTIMEOUT = 120000;
    
    /**
	 * VAN사 통신을 위한 소켓 호출
	 * @param byte[]
	 * @param int 
	 * @param String
	 * @param String
	 * @return byte[]
	 * @throws Exception
	 */
    public byte[] sendSocket(byte[] reqMsg, String host, String port) throws Exception {
    	byte[] resMsg = null;
    	byte[] bOutbuff = null;
    	Socket socket = null;
    	OutputStream os = null;
    	BufferedOutputStream bos = null;
    	InputStream is = null;
    	BufferedInputStream bis = null;
    	try {
    		bOutbuff = reqMsg; 
   			System.out.println("["+DateUtils.getCurrentDate("yyMMdd HH:mm:ss:SSS") + "][SocketUtils.sendSocket]Send-Data:::"+new String(bOutbuff));   			
   			System.out.println("["+DateUtils.getCurrentDate("yyMMdd HH:mm:ss:SSS") + "][SocketUtils.sendSocket]host:["+host+"], port:["+port+"], timeout:["+DEF_TIMEOUT+"]");
   			
   			SocketAddress socketAddr = new InetSocketAddress(host, Integer.parseInt(port));
   			socket = new Socket();
   			socket.connect(socketAddr, DEF_TIMEOUT); // Socket Timeout
   			//socket = new Socket(host, Integer.parseInt(port));
   			System.out.println("["+DateUtils.getCurrentDate("yyMMdd HH:mm:ss:SSS") + "][SocketUtils.sendSocket]Connection-Success");   			
   			socket.setSoTimeout(DEF_READTIMEOUT); // Socket Read Timeout
    		os = socket.getOutputStream();
    		bos = new BufferedOutputStream(os);
    		bos.write(bOutbuff);
    		bos.flush();
   			System.out.println("["+DateUtils.getCurrentDate("yyMMdd HH:mm:ss:SSS") + "][SocketUtils.sendSocket]Flush-Success");   			
   			resMsg = new byte[1024];
    		is = socket.getInputStream();
    		bis = new BufferedInputStream(is);
    		bis.read(resMsg, 0, resMsg.length-1);
    		System.out.println("["+DateUtils.getCurrentDate("yyMMdd HH:mm:ss:SSS") + "][SocketUtils.sendSocket]read-Success");
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	} finally {
    		try {
            	if (os != null) { os.close(); os = null; }
            	if (bos != null) { bos.close(); bos = null; }
            	if (is != null) { is.close(); is = null; }
            	if (bis != null) { bis.close(); bis = null; }
            	if (socket != null) { socket.close(); }
            	
        		/*
        		 * 메모리초기화(변수초기화)
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
        		fe.printStackTrace();
    		}
    	}
    	
    	return resMsg;
	}

    /**
	 * VAN사 통신을 위한 소켓 호출
	 * @param byte[]
	 * @param String
	 * @param String
	 * @param String
	 * @return String
	 * @throws Exception
	 */
    public String sendSocket(byte[] reqMsg, String host, String port, String charset) throws Exception {
    	byte[] bOutbuff = null;
    	Socket socket = null;
    	OutputStream os = null;
    	BufferedOutputStream bos = null;
    	InputStream is = null;
    	BufferedInputStream bis = null;
    	int readLen = 0;
    	try {
    		bOutbuff = reqMsg; 
   			System.out.println("[SocketUtils.sendSocket]host:["+host+"], port:["+port+"], timeout:["+DEF_TIMEOUT+"]");
   			
   			SocketAddress socketAddr = new InetSocketAddress(host, Integer.parseInt(port));
   			socket = new Socket();
   			socket.connect(socketAddr, DEF_TIMEOUT); // Socket Timeout
   			//socket = new Socket(host, Integer.parseInt(port));
   			System.out.println("[SocketUtils.sendSocket]Connection-Success");    			
   			socket.setSoTimeout(DEF_READTIMEOUT); // Socket Read Timeout
    		os = socket.getOutputStream();
    		bos = new BufferedOutputStream(os);
    		bos.write(bOutbuff, 0, bOutbuff.length);
    		bos.flush();
   			System.out.println("[SocketUtils.sendSocket]Flush-Success");   			
   			byte[] resMsg = new byte[1024];
    		is = socket.getInputStream();
    		bis = new BufferedInputStream(is);
    		readLen = bis.read(resMsg, 0, resMsg.length-1);
    		System.out.println("[SocketUtils.sendSocket]read-Success");
    		if (readLen > 0) {
    			return new String(resMsg, 0, readLen, charset);
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	} finally {
    		try {
            	if (os != null) { os.close(); os = null; }
            	if (bos != null) { bos.close(); bos = null; }
            	if (is != null) { is.close(); is = null; }
            	if (bis != null) { bis.close(); bis = null; }
            	if (socket != null) { socket.close(); }
            	
        		/*
        		 * 메모리초기화(변수초기화)
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
        		fe.printStackTrace();
    		}
    	}
    	
    	return null;
	}

    
    /**
	 * KMPS VAN사 통신을 위한 소켓 호출
	 * @param byte[]
	 * @param int 
	 * @param String
	 * @param String
	 * @return byte[]
	 * @throws Exception
	 */
    public String sendKmpsSocket(byte[] reqMsg, String host, String port) throws Exception {
        String s1;
        s1 = null;
        Socket socket = null;
        DataInputStream datainputstream = null;
        DataOutputStream dataoutputstream = null;
        try
        {
   			SocketAddress socketAddr = new InetSocketAddress(host, Integer.parseInt(port));
   			socket = new Socket();
   			socket.connect(socketAddr, DEF_TIMEOUT); // Socket Timeout
   			//socket = new Socket(host, Integer.parseInt(port));
   			System.out.println("[SocketUtils.sendSocket]Connection-Success::"+DateUtils.getCurrentDate("yyyy-MM-dd HH:mm:ss"));    			
   			socket.setSoTimeout(DEF_READTIMEOUT); // Socket Read Timeout
            java.io.InputStream inputstream = socket.getInputStream();
            datainputstream = new DataInputStream(inputstream);
            java.io.OutputStream outputstream = socket.getOutputStream();
            dataoutputstream = new DataOutputStream(outputstream);
            try
            {
                dataoutputstream.write(reqMsg);
                dataoutputstream.flush();
            }
            catch(Exception e1)
            {
                e1.printStackTrace();
            }
            byte abyte0[] = new byte[512];
            try
            {
                int i = datainputstream.read(abyte0);
                if(i < 0)
                {
                    System.out.println("[ERR] length < 0");
                }
                
                StringBuffer sb = new StringBuffer();
                for(final byte b: abyte0)
                    sb.append(String.format("%02x ", b&0xff));
                System.out.println("HEXA:::"+ sb.toString());
                s1 = new String(abyte0, 0, i);
            }
            catch(Exception e3)
            {
            	e3.printStackTrace();
            }
            datainputstream.close();
            dataoutputstream.close();
            socket.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(datainputstream != null)
                    datainputstream.close();
                if(dataoutputstream != null)
                    dataoutputstream.close();
                if(socket != null)
                    socket.close();
            }
            catch(Exception exception5) { }
        }
        return s1;
	}

}
