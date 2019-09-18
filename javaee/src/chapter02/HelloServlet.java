package chapter02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello.do")
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
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.print("<head>");
		out.print("<meta charset='UTF-8'>");
		out.print("<title>입력 양식 테스트 </title>");
		out.print("</head>");
		out.println("<body>");
		out.println("<h1 style='color:blue'>");
		out.println("Hello SSAFY");
		out.println("</h1>");
		out.println("<h2> 한글이 잘 나와요!!");
		out.println(new Date());
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");
	
		
		out.close();
		
	}
	


}
