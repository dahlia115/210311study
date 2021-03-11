package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client02 {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("172.30.1.53",12345);
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		Scanner input = new Scanner(System.in);
		System.out.print("송신 문자열 입력 : ");
		String sendData = input.next();
		
		dos.writeUTF(sendData);
		
		String test;
		InputStream is = s.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		test = dis.readUTF();
		System.out.println("수신 : "+test);
		
		dis.close();
		is.close();
		dos.close();
		os.close();
		s.close();
	}
}
