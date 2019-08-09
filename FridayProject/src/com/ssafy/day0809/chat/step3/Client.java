package com.ssafy.day0809.chat.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
	Socket s = null;
	BufferedReader kin = null, in=null;
	PrintWriter out = null;

	public void go() {
		String str = null, msg = null;;
		try {
			s = new Socket("127.0.0.1", 6767);
			out = new PrintWriter(s.getOutputStream(),true);
			kin = new BufferedReader(new InputStreamReader(System.in ));
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
//			in = new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
			
			while(!(str = kin.readLine()).equals("x")) {
				out.println(str);
				msg = in.readLine();
				System.out.println(msg);
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
