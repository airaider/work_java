
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.product.IProductMgr;
import com.ssafy.product.Product;
import com.ssafy.product.ProductMgrImpl;

/**
 * Servlet implementation class MemberSearchServlet
 */
@WebServlet("/ProductSearch.do")
public class ProductSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductMgr service = new ProductMgrImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청 데이터 추출
		String no = request.getParameter("no");
		try {
			//2. 모델 수행
			Product product = service.search_no(no);
			//3. 수행결과물 request에 담기
			request.setAttribute("product", product);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
		}
		
		//4. 페이지 이동
		request.getRequestDispatcher("Forward.jsp").forward(request, response);
	
	}

	

}
