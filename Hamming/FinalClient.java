package hamingtonserver;

import java.io.DataInputStream;
import java.net.Socket;

public class FinalClient {

	public FinalClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			Socket receive = new Socket("localhost",5555);
			DataInputStream dataInputStream = new DataInputStream(receive.getInputStream());
			while(true){
				String aslo = dataInputStream.readUTF();
				System.out.print("\naslo "+aslo+"\n");
				char[] hamingstring = aslo.toCharArray();
				int p1=(hamingstring[0]-'0')^(hamingstring[2]-'0')^(hamingstring[4]-'0')^(hamingstring[6]-'0')^(hamingstring[8]-'0')^(hamingstring[10]-'0');
				//System.out.println(p1);
				
//				 if(p1==0)System.out.println("1 ace even songkhok");
//			    else System.out.println("1 ace odd sonkhok");
				int p2=(hamingstring[1]-'0')^(hamingstring[2]-'0')^(hamingstring[5]-'0')^(hamingstring[6]-'0')^(hamingstring[9]-'0')^(hamingstring[10]-'0');
				int p4=(hamingstring[3]-'0')^(hamingstring[4]-'0')^(hamingstring[5]-'0')^(hamingstring[6]-'0')^(hamingstring[11]-'0');
				int p8=(hamingstring[7]-'0')^(hamingstring[8]-'0')^(hamingstring[9]-'0')^(hamingstring[10]-'0')^(hamingstring[11]-'0');
			//error check korar jonno string bosacci 	
				char[] error=new char[4];
				error[3]=(char)(p1+48);
				error[2]=(char)(p2+48);
				error[1]=(char)(p4+48);
				error[0]=(char)(p8+48);
				
				
				
				if(p1==0 && p2 ==0 && p4==0 && p8==0)System.out.print("\nkono vul nai\n");
				else System.out.print("\nsomossa ace");
				
				String errs =new String(error);
				int errorposition = Integer.parseInt(errs,2);
				if(errorposition!=0){
					System.out.print("\nsomossa ta holo "+errorposition+" numer position a\n" );
				if(hamingstring[errorposition-1]=='0')hamingstring[errorposition-1]='1';
				else hamingstring[errorposition-1]='0';
				System.out.print("sothik ta hobe "+ new String(hamingstring));
				
				}
			//	System.out.print("sothik ta hobe "+ new String(hamingstring));
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
