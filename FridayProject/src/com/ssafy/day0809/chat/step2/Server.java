package com.ssafy.day0809.chat.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket ss = null;
	Socket s = null;
	BufferedReader in = null;
	PrintWriter out = null;

	public void go() {

		String str = null;
		try {
			ss = new ServerSocket(6767);
			System.out.println("서버2 : 접속준비중.......");
			s = ss.accept();
			System.out.println(s.getInetAddress()+"이(가) 접속했습니다.");
			
			
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
/*			in = new BufferedReader(new InputStreamReader
					(s.getInputStream(), "MS949"));*/
			out = new PrintWriter(s.getOutputStream(), true);
			
			while( (str = in.readLine()) != null) {
				System.out.println("서버2 : "+str);
				out.println("서버가 보냄 :"+str);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			if(in != null)
				try {
					in.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			if(out != null) out.close();
			
			if(s != null)
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(ss != null)
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.go();
	}

}








