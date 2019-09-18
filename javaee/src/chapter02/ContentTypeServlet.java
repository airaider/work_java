package chapter02;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/content2")
public class ContentTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloServlet doGet()...");
		response.setContentType("image/png;charset=utf-8");
		FileInputStream fis = null;
		ServletOutputStream out = null;
		try {
			fis = new FileInputStream("c:/ssafy/logo.png");
			out = response.getOutputStream();
			byte[] buf = new byte[1024];
			int len=0;
			while((len = fis.read(buf))!=-1) {
				out.write(buf, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fis.close();
			out.close();
		}
		
	}
	


}
