package client;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client03_1 {
	public static void main(String[] args) throws Exception{
		Socket s = new Socket("localhost",12345);
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		Scanner input = new Scanner(System.in);
		String sendData;
		System.out.print("송신 데이터 입력 : ");
		sendData = input.next();
		
		dos.writeUTF(sendData);
	}
}
