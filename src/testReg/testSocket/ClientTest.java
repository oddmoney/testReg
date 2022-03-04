package testReg.testSocket;

import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class ClientTest {

	public static void main(String[] args) {
			 
			boolean portCheck = new ClientTest().availablePort("dnesb.jejuair.net",30301);
			 
			if(portCheck)
			{
			    System.out.println("port available");
			}
			else
			{
			    System.out.println("port unavailable");
			} 
	}


	public boolean availablePort(String host, int port) {
		boolean result = false;
		 
		try {
		    (new Socket(host, port)).close();
		 
		    result = true;
		}
		catch(Exception e) {
		    
		}
		    return result;
	}

}
