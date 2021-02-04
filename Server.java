import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.Scanner;
public class Server {
	
	public static void main(String[] args) {
			
			 int i=0;
			
			System.out.println("Server is Started..!");
			
			 String  welocomeNote= "Hello Client....!";
			
			Scanner scr = new Scanner(System.in);
		
		try {
			ServerSocket src = new ServerSocket(3400);
			Socket sc = src.accept();
			DataInputStream dis = new DataInputStream(sc.getInputStream());
			DataOutputStream dout=new DataOutputStream(sc.getOutputStream());
			dout.writeUTF(welocomeNote);
			String str = (String)dis.readUTF();
			System.out.println(str);
		
			System.out.println("1: send message");
			System.out.println("2: Read Message");
			System.out.println("3: Close Server");
			while(i<4){
				i = scr.nextInt();
				switch(i){
					case 1: System.out.println("Enter Your Message"); 
							String message =  scr.next();
							dout.writeUTF(message);
							break;
					case 2: String reply = (String) dis.readUTF();
							System.out.println(reply);
							break;
					case 3: System.exit(0);
							break; 
					
				}
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}