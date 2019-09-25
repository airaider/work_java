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
import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.PageBean;
import com.ssafy.model.service.BoardService;
import com.ssafy.model.service.BoardServiceImpl;
import com.ssafy.model.service.MemberService;
import com.ssafy.model.service.MemberServiceImp;

@WebServlet({"/main.do","/logcheck.do"})
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImpl();
	private MemberService memberService=new MemberServiceImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "index.jsp";
		String action = request.getParameter("action");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
//		HttpSession session = request.getSession();
//		session.setAttribute("id", "ssafy");
		System.out.println("action.........................."+action);
		try {
			if(action !=null) {
				if(action.endsWith("loginform.do")) {
					url ="/member/login.jsp";
				}else if(action.endsWith("login.do")) {
					url =login(request, response);
				}else if(action.endsWith("logout.do")) {
					url =logout(request, response);
				}else if(action.endsWith("memberUpdateForm.do")) {
					url =memberUpdateForm(request, response);
				}else if(action.endsWith("listBoard.do")) {
					url =listBoard(request, response);
				}else if(action.endsWith("searchBoard.do")) {
					url =searchBoard(request, response);
				}else if(action.endsWith("searchBoardAjax.do")) {
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
	private String searchBoardAjax(HttpServletRequest request, HttpServletResponse response) {
		String no = request.getParameter("no");
		Board board = boardService.search(no);
		Gson gson = new Gson();
		System.out.println(gson.toJson(board));
		return gson.toJson(board);
	}
	private String searchBoard(HttpServletRequest request, HttpServletResponse response) {
		String no = request.getParameter("no");
		request.setAttribute("board", boardService.search(no));
		return "/board/searchBoard.jsp";
	}
	private String listBoard(HttpServletRequest request, HttpServletResponse response) {
		String  key= request.getParameter("key");			//조회 조건
		String  word= request.getParameter("word");			//검색할 단어
		String  pageNo= request.getParameter("pageNo");		//현재 페이지 번호
		
		PageBean bean = new PageBean(key, word, pageNo);
		request.setAttribute("bean", bean);
		request.setAttribute("list", boardService.searchAll(bean));
		return "/board/listBoard.jsp";
	}
	private String memberUpdateForm(HttpServletRequest request, HttpServletResponse response) {
		String id =getId(request);
		request.setAttribute("member", memberService.search(id));
		return "/member/updateMember.jsp";
	}
	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:main.do?action=loginform.do";
	}
	private String login(HttpServletRequest request, HttpServletResponse response) {
		//1. 요청 데이타 추출 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String idsave = request.getParameter("idsave");
		String referer = request.getParameter("referer");
		
		//2. 데이타 처리 
		//2.1 id를 쿠키에 저장 또는 쿠키에서 삭제 
		Cookie cookie = new Cookie("id", id);
		if(idsave !=null) {
			cookie.setMaxAge(100000000);
		}else {
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		
		//2.2 인증 처리 
		try {
			memberService.login(id, pw);
			addToSession(request, "id", id);  //인증 정보를 session에 저장
			if(referer !=null) {
				return referer;
			}else {
				return "redirect:index.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return "main.do?action=loginform.do";
		}
	}
	private void addToSession(HttpServletRequest request, String key, Object value) {
		HttpSession session = request.getSession();
		session.setAttribute(key, value);
	}
	
	public String getId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (String)session.getAttribute("id");
	}
}











