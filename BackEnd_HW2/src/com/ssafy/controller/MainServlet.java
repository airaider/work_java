package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.ssafy.member.service.MemberService;
import com.ssafy.member.service.MemberServiceImp;
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
		String url = "Main.jsp";
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
				else if(action.endsWith("login.do")) {
					url=login(request, response);
				}
				else if(action.endsWith("loginForm.do")) {
					url="Login.jsp";
				}
				else if(action.endsWith("logout.do")) {
					url=logout(request, response);
				}
				else if(action.endsWith("lastproduct.do")) {
					url=findlast(request, response);
				}
				else if(action.endsWith("memberlist.do")) {
					url=getlist(request, response);
				}
				else if(action.endsWith("memSearch.do")) {
					url=search(request, response);
				}
				else if(action.endsWith("update.do")) {
					url=update(request, response);
				}
				else if(action.endsWith("delete.do")) {
					url=delete(request, response);
				}
				else if(action.endsWith("searchBoardAjax.do")) {
					url =searchBoardAjax(request, response);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			url = "ErrorHandler.jsp";
		}
		if(url.startsWith("{") ||url.startsWith("[") ) {
			//url이 { 또는 [로 시작하면 JSON 데이타 이므로  contents타입 변경후 
			response.setContentType("application/json;charset=utf-8");
			//직접 출력 
			response.getWriter().append(url);
		}else if(url.startsWith("redirect")) {
			response.sendRedirect(url.substring(url.indexOf(":")+1));
		}else {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
	
	
	private String delete(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cookie: cookies){
				if(cookie.getName().equals("product1")) {
					HttpSession session = request.getSession();
					service.remove(cookie.getValue());
				}
			}
		}
		return "memberlist.do";
	}
	private String searchBoardAjax(HttpServletRequest request, HttpServletResponse response) {
		String no = request.getParameter("no");
		Product board = service.search(no);
		Gson gson = new Gson();
		System.out.println(gson.toJson(board));
		return gson.toJson(board);
	}
	private String update(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Product pro = new Product(id,pw,name,email);
		service.update(pro);
		return "memberlist.do";
	}
	private String search(HttpServletRequest request, HttpServletResponse response) {
		String no = request.getParameter("no");
		request.setAttribute("member", service.search(no));
		Cookie cookie1 = new Cookie("product1", no);
		cookie1.setMaxAge(5000);
		response.addCookie(cookie1);
		return "memberlist2.jsp";
	}
	private String getlist(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("list", service.searchAll());
		System.out.println("saved member into list");
		return "memberlist.jsp";
	}
	private String findlast(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cookie: cookies){
				if(cookie.getName().equals("product")) {
					HttpSession session = request.getSession();
					session.setAttribute("product",service.search(cookie.getValue()));
				}
			}
		}
		return "redirect:lastproduct.jsp";
	}
	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		
		return "redirect:Main.jsp";
	}
	private String login(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		String idSave = request.getParameter("idsave");
		Cookie cookie = new Cookie("id", id);
		if(idSave!=null) {	//checked박스가 선택된 상황 => cookie를 통해 id 유지
			cookie.setMaxAge(50000000);
		}else {				//checked박스가 선택되지 않은 상황 => 기존에 발생한 쿠디가 있다면 삭제
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		try {
			memberService.login(id, password);
			HttpSession session = request.getSession();
			//session에 인증 정보를 저장  ex) 아이디, 권한정보, 닉네임
			session.setAttribute("id", id);
			return "redirect:loginForm.do";
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			System.out.println(e);
			return "Main.jsp";
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
		Cookie cookie = new Cookie("product", no);
		cookie.setMaxAge(5000);
		response.addCookie(cookie);
		System.out.println("success");
		return "redirect:register.html";
	}
}











