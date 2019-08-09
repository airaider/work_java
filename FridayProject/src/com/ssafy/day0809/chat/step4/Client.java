package com.ssafy.day0809.chat.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	String name;
	Socket s = null;
	BufferedReader kin = null,in = null;
	PrintWriter out = null;

	class ClientThread extends Thread{

		@Override
		public void run() {
			String msg = null;
			
			try {
				while( (msg = in.readLine()) != null) {
					System.out.println(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(in != null)
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				if(s != null)
					try {
						s.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
		
	}
	

	public void go() {
		String str = null;
		try {
			s = new Socket("127.0.0.1", 6767);
			out = new PrintWriter(s.getOutputStream(),true);
			kin = new BufferedReader(new InputStreamReader(System.in ));
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
//			in = new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
			
			System.out.println(in.readLine());
			name = kin.readLine();
			out.println(name);
			new ClientThread().start();
			
			while(!(str = kin.readLine()).equals("x")) {
				out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(kin != null)
				try {
					kin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(out != null) out.close();
			if(s != null)
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public static void main(String[] args) {
		Client  client = new Client();
		client.go();
	}

}

