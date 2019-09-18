package chapter02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Member;
import com.ssafy.model.service.MemberService;
import com.ssafy.model.service.MemberServiceImp;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/memberinsert.do")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService service = new MemberServiceImp();
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청 정보
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		Member member = new Member(id, pw, name, email, phone, address);
		//2. 모델 수행
		try {
			service.add(member);
			//insert, delete, update를 수행한 후 결과를 조회할 때는 redirect을 이용해서 이동
			response.sendRedirect("memberSearch.do?id="+id); 
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			//4. 페이지 이동
			request.getRequestDispatcher("memberSearch.jsp").forward(request, response);
		}
		
	}
}
