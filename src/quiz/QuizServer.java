package quiz;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

class UserThread extends Thread {
	Socket sock = null;

	public UserThread(Socket sock) {
		System.out.println(sock.getInetAddress() + " 님이 접속했습니다.");
		this.sock = sock;
		start();
	}

	@Override
	public void run() {
		InputStream in;
		String readData = null;
		try {
			in = sock.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			while (true) {
				readData = dis.readUTF();
				for (Socket s : QuizServer.s) {
					OutputStream out = s.getOutputStream();
					DataOutputStream dos = new DataOutputStream(out);
					dos.writeUTF(readData);
				}
			}
		} catch (IOException e) {
			//e.printStackTrace();
			//System.out.println(QuizServer.s.size());
			//System.out.println(QuizServer.s.contains(sock));
			QuizServer.s.remove(sock);
			//System.out.println(QuizServer.s.size());
			//System.out.println(sock.getInetAddress()+"님이 퇴장 하셨습니다");
			try {
				sock.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		System.out.println("수신 데이터 : " + readData);
	}
}

public class QuizServer {
	public static ArrayList<Socket> s = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12345);
		int i = 0;
		while (true) {
			System.out.println("접속을 기다립니다");
			s.add(server.accept());
			new UserThread(s.get(i));
			i++;
		}
	}
}
