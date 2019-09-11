package com.ssafy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/hello.ssafy")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloServlet() {
    	System.out.println("HelloServlet()");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("HelloServlet init()...");
	}

	public void destroy() {
		System.out.println("HelloServlet destroy()...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloServlet doGet()...");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1 style='color:blue'>");
		out.println("Hello SSAFY");
		out.println("</h1>");
		out.println("<h2>");
		out.println(new Date());
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");
	
		
		out.close();
		
	}
	


}
