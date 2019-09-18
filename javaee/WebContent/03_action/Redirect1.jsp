<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      
<%
	request.setAttribute("msg", "Redirect로 이동하므로 msg는 공유 되지 않음");
	response.sendRedirect("Redirect2.jsp");
%>