package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server02 {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(12345);
		System.out.println("연결 대기");
		Socket clt_s = server.accept();

		InputStream in = clt_s.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		System.out.println("데이터 수신 대기");
		String readData = dis.readUTF();
		System.out.print("수신 데이터 : " + readData);
		
		String test="서버에서 데이터 보낸다";
		OutputStream os = clt_s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF(test);
		
		dis.close();
		in.close();
		clt_s.close();
		server.close();
	}
}
