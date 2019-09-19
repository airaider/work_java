package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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











