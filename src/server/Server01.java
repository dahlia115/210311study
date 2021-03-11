package server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
	public static void main(String[] args) throws Exception {
		//네트워크 통신
		//외부와 통신할 소켓을 만들어야한다.
		ServerSocket server = new ServerSocket(12345);//포트번호(2byte)
		System.out.println("접속을 기다립니다");
		Socket clt_s = server.accept();	//다른 클라이언트로부터 접속이 이루어질 때 까지 대기
		System.out.println(clt_s.getInetAddress());//접속한 사용자의 주소를 가져온다
		//Socket clt_s01 = server.accept();
		//clt_s는 클라이언트의 정보를 받는다
		System.out.println("접속 되었습니다");
	
		//스트림생성(데이터 수신)
		InputStream in = clt_s.getInputStream();//연결된 클라이언트의 데이터를 수신
		int readData = in.read();//바이트만 처리해준다.
		System.out.println("수신 데이터 : "+readData);
		
		in.close();
		clt_s.close();
		server.close();
	}
}
