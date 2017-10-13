package hamingtonserver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public Server() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		try {
			ServerSocket sender = new ServerSocket(8888);
			Socket get = sender.accept();
			DataOutputStream dataOutputStream = new DataOutputStream(get.getOutputStream());
			DataInputStream dataInputStream = new DataInputStream(get.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String messsege = "",string="";
			while(true){
				 messsege =dataInputStream.readUTF();
				System.out.println("Client says "+messsege+"\n");
	     	     string = bufferedReader.readLine();
		        dataOutputStream.writeUTF(string);
		        dataOutputStream.flush();
		   
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
