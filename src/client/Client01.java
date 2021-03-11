package client;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client01 {
	public static void main(String[] args) throws Exception {
		//서버먼저 실행 후 클라이언트 접속
		Socket s = new Socket("172.30.1.53",12345);//아이피주소, 포트번호
		
		//아웃풋스트림 생성(데이터 보내기)
		OutputStream os = s.getOutputStream();//서버로 데이터를 보내겠다
		
		Scanner input = new Scanner(System.in);
		System.out.print("데이터 입력 : ");
		int outData = input.nextInt();//입력받은 값
		os.write(outData);//입력받은 값을 서버로 write하겠다
		
		os.close();
		s.close();
	}
}
