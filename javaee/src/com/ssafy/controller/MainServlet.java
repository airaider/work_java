package com.ssafy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.domain.Goods;
import com.ssafy.model.dto.Member;
import com.ssafy.model.service.MemberService;
import com.ssafy.model.service.MemberServiceImp;

@WebServlet("*.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
				if(action.endsWith("memberRegitForm.do")) {
					url="member/memberRegister.html";
				}
				else if(action.endsWith("memberRegit.do")) {
					url=memberRegit(request, response);
				}		
				else if(action.endsWith("memberSearch.do")) {
					url=memberSearch(request, response);
				}
				else if(action.endsWith("cookietest.do")) {
					url=cookietest(request, response);
				}
				else if(action.endsWith("cookielogin.do")) {
					url=cookielogin(request, response);
				}
				else if(action.endsWith("loginForm.do")) {
					url="member/Login.jsp";
				}
				else if(action.endsWith("login.do")) {
					url=login(request, response);
				}
				else if(action.endsWith("logout.do")) {
					url=logout(request, response);
				}
				else if(action.endsWith("goodsList.do")) {
					url="cart1/book.html";
				}
				else if(action.endsWith("insertcart.do")) {
					url=insertCart(request, response);
				}
				else if(action.endsWith("OrderPreview.do")) {
					url="cart1/OrderPreview.jsp";
				}
				else if(action.endsWith("memberUpdate.do")) {
					url=update(request, response);
				}
				else if(action.endsWith("memberlist.do")) {
					url=getlist(request, response);
				}
				else if(action.endsWith("memSearch.do")) {
					url=search(request, response);
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
	private String getlist(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("list", memberService.searchAll());
		System.out.println("saved member into list");
		return "memberlist.jsp";
	}
	private String search(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		request.setAttribute("member", memberService.search(id));
		return "memberlist2.jsp";
	}
	private String update(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		Member member = new Member(id, pw, name, email, phone, address);
		memberService.update(member);
		return "redirect:memberSearch.do?id="+id;
	}
	private String insertCart(HttpServletRequest request, HttpServletResponse response) {
		//1. 요청 정보 파악
		String proname = request.getParameter("proname");
		int no = Integer.parseInt(request.getParameter("no"));
		int proprice = Integer.parseInt(request.getParameter("proprice"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		HttpSession session = request.getSession();
		//2. 장바구니 확인
		HashMap<Integer, Goods> cart = (HashMap<Integer, Goods>)session.getAttribute("cart");
		if(cart==null) { //장바구니에 상품을 처음 넣는 상황, session에 장바구니가 없음
			cart = new HashMap<>();
			session.setAttribute("cart", cart);
		}
		Goods find = cart.get(no);
		if(find!=null) { //장바구니에 상품이 있음. 수량만 변경
			find.setQuantity(find.getQuantity()+quantity);
		}else {
			Goods goods = new Goods(no, proname, proprice, quantity, 0);
			cart.put(no, goods);
		}
		System.out.println(cart);
		return "redirect:goodsList.do";
	}
	private String logout(HttpServletRequest request, HttpServletResponse response) {
		/*로그아웃
		 * 1. invalidate() : session에 인증 정보만 있을 때
		 *    - session에 인증 정보만 있을 떄
		 * 2. 인증정보 제거
		 *    - session에 인증 정보 외에 다른 정보가 저장된 경우 (장바구니, 최근 본 상품)
		 * */
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		
		return "redirect:loginForm.do";
	}
	private String login(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
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
//			return "redirect:loginForm.do";
			return "redirect:memberSearch.do?id="+id;
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			return "member/Login.jsp";
		}
	}
	private String cookielogin(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String idSave = request.getParameter("idsave");
		Cookie cookie = new Cookie("id", id);
		if(idSave!=null) {	//checked박스가 선택된 상황 => cookie를 통해 id 유지
			cookie.setMaxAge(50000000);
		}else {				//checked박스가 선택되지 않은 상황 => 기존에 발생한 쿠디가 있다면 삭제
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		return "redirect:CookieLogin.jsp";
	}
	private String cookietest(HttpServletRequest request, HttpServletResponse response) {
		String cookieName = request.getParameter("cookiename");
		String cookieValue = request.getParameter("cookievalue");
		Cookie cookie = new Cookie(cookieName, cookieValue);
		/*쿠키 유효 시간 설정
		 * -1 : 메모리에만 저장 => 브라우져 종료시 쿠키가 삭제굄
		 *  0 : 기존에 발행한 쿠키를 삭제
		 * 양수 : 지정한 시간 만큼 메모리에 저장됨
		 * */
		cookie.setMaxAge(0);
		
		//쿠키 발행
		response.addCookie(cookie);
		return "CookieTest.jsp";
	}
	private String memberSearch(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		request.setAttribute("member", memberService.search(id));
		return "member/memberSearch.jsp";
	}
	private String memberRegit(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		Member member = new Member(id, pw, name, email, phone, address);
		memberService.add(member);
		
		return "redirect:memberSearch.do?id="+id;
	}
	
}











