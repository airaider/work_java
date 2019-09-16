package com.ssafy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
@WebServlet("/book.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String catalogue = request.getParameter("catalogue");
		String nation = request.getParameter("nation");
		String publisheDate = request.getParameter("publisheDate");
		String publisher = request.getParameter("publisher");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		price += request.getParameter("currency");
		String description = request.getParameter("description");

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Book Registration</title>");
		out.println("</head>");
		out.println("<body> " + "<table border=\"1\">" + "<tr>" + "<th colspan=\"2\">도서 정보</th>" + "</tr>" + "<tr>"
				+ "<td >도서명</td>" + "<td >");
		out.println(isbn + "</td>" + "</tr>" + "<tr>" + " <td >도서번호</td>" + "<td >");
		out.println(title + "</td>" + "</tr>" + "<tr>" + "<td >도서분류</td>" + "<td >");
		out.println(catalogue + "</td>" + "</tr>" + "<tr>" + "<td >도서국가</td>" + "<td >");
		out.println(nation + "</td>" + "</tr>" + "<tr>" + "<td >출판일</td>" + "<td >");
		out.println(publisheDate + "</td>" + "</tr>" + "<tr>" + "  <td >출판사</td>" + " <td >");
		out.println(publisher + "</td>" + "</tr>" + "<tr>" + "<td >저 자</td>" + "<td >");
		out.println(author + "</td>" + "</tr>" + "<tr>" + " <td >도서가격</td>" + " <td >");
		out.println(price + "</td>" + " </tr>" + " <tr>" + "  <td >도서설명</td>" + " <td >");
		out.println(description + "</td>" + "  </tr>" + "</table>" + "</body>");
		out.println("<a href=\"book.html\">도서 등록</a>");
	}

}