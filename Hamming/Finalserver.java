package hamingtonserver;

import java.beans.ExceptionListener;
import java.io.DataOutputStream;
import java.io.FileReader;import java.io.ObjectInputStream.GetField;
import java.net.ServerSocket;
import java.net.Socket;

public class Finalserver {
	static char[] hamingstring = new char[12];
     static int p =0;
	public static void main(String[] args) {

		try {
			
			ServerSocket ss = new ServerSocket(5555);
			Socket s = ss.accept();
			
		    DataOutputStream out = new DataOutputStream(s.getOutputStream());
		
			FileReader fileReader = new FileReader("FileOne.txt");
			
            
			while (true) {
				int x = fileReader.read();
                p++;
				System.out.println(x + "\n");
				if (x == -1){
					//hamingstring[0]='x';
					break;
				}

				String binary = Integer.toBinaryString(x);

				while (binary.length() < 8) {
					binary = '0' + binary;
				}
				System.out.println("ei 8 bit nia kaj korteci"+"\n" + binary + "\n");

				// 12 bit a sajabo
		
				for (int j = 0; j < 12; j++)
					hamingstring[j] = '0';
//				for (int j = 0; j < 13; j++)
//					System.out.println(hamingstring[j]);

				/*
				 * int p1=binary.charAt(2) int p = '1'^'1'^'1'^'1';
				 * System.out.println(p);
				 */
				int i = 0, c = 0;
				char[] binarychararray = binary.toCharArray();
				while (i <= 11) {
					//System.out.println("while loop er vitore");
					
					if (i == 0 || i == 1 || i == 3 || i == 7){
						i++;
						continue;
					}
						
					else

						hamingstring[i] = binarychararray[c];
					    //System.out.println("haming er "+i+" tomo index a "+binarychararray[c]+" bosalam");
						c++;
						i++;

				}
                System.out.println("12 bit bananor por ");
				System.out.println(hamingstring);
				System.out.println("\n");
				

				
				int p1=(hamingstring[2]-'0')^(hamingstring[4]-'0')^(hamingstring[6]-'0')^(hamingstring[8]-'0')^(hamingstring[10]-'0');
				System.out.println(p1);
				
//				 if(p1==0)System.out.println("1 ace even songkhok");
//			    else System.out.println("1 ace odd sonkhok");
				int p2=(hamingstring[2]-'0')^(hamingstring[5]-'0')^(hamingstring[6]-'0')^(hamingstring[9]-'0')^(hamingstring[10]-'0');
				int p4=(hamingstring[4]-'0')^(hamingstring[5]-'0')^(hamingstring[6]-'0')^(hamingstring[11]-'0');
				int p8=(hamingstring[8]-'0')^(hamingstring[9]-'0')^(hamingstring[10]-'0')^(hamingstring[11]-'0');
				//p er man gulu bosano
				
				hamingstring[0]=(char)(p1+48);
				hamingstring[1]=(char)(p2+48);
				hamingstring[3]=(char)(p4+48);
				hamingstring[7]=(char)(p8+48);
				System.out.println("parity bosanor por");
				System.out.println(hamingstring);
				System.out.println("\n");
				
				//error bosabo  3 number tay
				
				if(p==2){
			   if(hamingstring[2]=='1'){
				   hamingstring[2]='0';
			   }
			   else{
				   hamingstring[2]='1';
				   
			   }
				
				}
				String sent = new String(hamingstring);
				
				out.writeUTF(sent);
				
				
				
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
