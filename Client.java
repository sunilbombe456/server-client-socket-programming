import java.io.*;  
import java.net.*;
import java.util.Scanner; 
import java.io.DataInputStream;
import java.io.DataOutputStream;
public class Client {  
	public static void main(String[] args) {
	
			 int i=0;
			
			 String  welocomeNote= "Hello Server..!";
			 
			 System.out.println("Client is Started..!");
			
			Scanner scr = new Scanner(System.in);
	
	try{      
		Socket s=new Socket("localhost",3400);  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
		DataInputStream dis = new DataInputStream(s.getInputStream());
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
		dout.flush();  
		dout.close();  
		s.close();  
	}catch(Exception e){
		System.out.println(e);
		}  
	}  
}  