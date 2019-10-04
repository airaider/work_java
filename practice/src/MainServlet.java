

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="Main.jsp";
		String action=request.getServletPath();
		System.out.println(action);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			if(action.endsWith("submit.do")) {
				url=submit(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			url="ErrorHandler.jsp";
		}
		if(url.startsWith("{") || url.startsWith("(")) {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().append(url);
		}else if(url.startsWith("redirect")) {
			response.sendRedirect(url.substring(url.indexOf(":")+1));
		}
		else {
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	}
	private String submit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
