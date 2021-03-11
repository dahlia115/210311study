package mythread;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class MyThread extends Thread{
	Socket clt_s;
	public MyThread(Socket clt_s) {
		System.out.println(clt_s.getInetAddress()+"님이 접속했습니다");
		this.clt_s = clt_s;
		start();
	}
	
	public void run() {
		
		try {
			InputStream is = clt_s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			System.out.println("수신 데이터");
			System.out.println(dis.readUTF());
			System.out.println("종료되었습니다");
	
		}catch (Exception e) {
			
		}
	}
}




