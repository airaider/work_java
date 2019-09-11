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
@WebServlet("/param.do")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String[] favorite = request.getParameterValues("favorite");

		out.println("<html>");
		out.println("<body>");
		out.println("<h1 style='color:blue'>");
		out.println("입력하신 정보는 다음과 같아요~");
		out.println("</h1>");
		out.println("<h2>이름 : " + name + "</h2>");
		out.println("<h2>성별 : " + gender + "</h2>");
		if (favorite != null) {
			for (String f : favorite) {
				out.println("<h2>좋아하는 것 : " + f + "</h2>");
			}
		}
		out.println("</body>");
		out.println("</html>");

		out.close();

	}

}
