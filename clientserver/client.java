package hamingtonserver;

import java.awt.image.RescaleOp;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket receiever;
		try {
			receiever = new Socket("localhost",8888);
			DataInputStream dataInputStream = new DataInputStream(receiever.getInputStream());
			DataOutputStream dataOutputStream =new DataOutputStream(receiever.getOutputStream());
		    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		    String messege ="",string="";
		    while(true){
			string= bufferedReader.readLine();
			  dataOutputStream.writeUTF(string);
			  dataOutputStream.flush();
			  messege=dataInputStream.readUTF();
			
			System.out.println("server says  "+messege+"\n");
		  
		    }
		   
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		

	}

}
