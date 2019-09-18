
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
 * Servlet implementation class ProductInsertServlet
 */
@WebServlet("/productinsert.do")
public class ProductInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductMgr service = new ProductMgrImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청 데이터 추출
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String no = request.getParameter("no");
		Product product = new Product(no, name, price);
		try {
			//2. 모델 수행
			service.add(product);
			request.setAttribute("product", product);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
		}
		
		//4. 페이지 이동
		request.getRequestDispatcher("Forward.jsp").forward(request, response);
	
	}

}
