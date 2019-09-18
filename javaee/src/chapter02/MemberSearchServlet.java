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
 * Servlet implementation class MemberSearchServlet
 */
@WebServlet("/memberSearch.do")
public class MemberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberServiceImp();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청 데이터 추출
		String id = request.getParameter("id");
		try {
			//2. 모델 수행
			Member member = service.search(id);
			//3. 수행결과물 request에 담기
			request.setAttribute("member", member);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
		}
		
		//4. 페이지 이동
		request.getRequestDispatcher("memberSearch.jsp").forward(request, response);
	
	}

	

}
