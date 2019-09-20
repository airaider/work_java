<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String loginId = (String)session.getAttribute("id");
	if(loginId!=null){
%>
<h1> <%=loginId %>님이 로그인 되었습니다</h1><%} %>
    <fieldset>
        <legend>기능을 선택해 주세요</legend>
				<a href="register.html">상품등록</a>
				<br>
				<a href="#">상품목록</a>
				<br>
				<a href="lastproduct.do">마지막 등록한 상품</a>
				<br>
    </fieldset>
    <a href="logout.do">로그아웃</a>
</body>

</html>