<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<article id="logo"><img src="images/logo.png"/></article>
<nav id="private">
 	<ul>
	<c:choose>
	   <c:when test="${empty id}">
		<li><a href="main.do?action=loginform.do">로그인</a></li>
	   </c:when>
	   <c:otherwise>
	     <li><a href="main.do?action=logout.do">로그아웃</a></li>
	     <li><a href="logcheck.do?action=memberUpdateForm.do">회원정보수정</a></li>
	     <li><a href="logcheck.do?action=myPage.do">myPage</a></li>
	   </c:otherwise>
	</c:choose>
</ul>
</nav>








