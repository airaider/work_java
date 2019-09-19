package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.service.MemberService;
import com.ssafy.model.service.MemberServiceImp;
import com.ssafy.product.dto.Product;
import com.ssafy.product.service.ProductService;
import com.ssafy.product.service.ProductServiceImp;

@WebServlet("*.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service = new ProductServiceImp();
	private MemberService memberService=new MemberServiceImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "index.jsp";
		String action = request.getServletPath();
		System.out.println(action);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		try {
			if(action!=null) {
				if(action.endsWith("productinsert.do")) {
					url=productInsert(request,response);
				}
				else if(action.endsWith("memberRegit.do")) {
				
				}		
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			url = "ErrorHandler.jsp";
		}
		if(url.startsWith("redirect")) {
			response.sendRedirect(url.substring(url.indexOf(":")+1));
		}else {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
	private String productInsert(HttpServletRequest request, HttpServletResponse response){
		//1. 요청 데이터 추출
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String no = request.getParameter("no");
		String explain = request.getParameter("explain");
		Product product = new Product(no, name, price, explain);
		service.add(product);
		System.out.println("success");
		return "redirect:register.html";
	}
	
}











