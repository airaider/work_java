<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.model.dto.Member"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="memSearch.do">
	<input type="text" name="id">회원 아이디
	<input type="submit" value="검색">
	</form>
	<h1>회원 리스트</h1>
	<table  border="1">
	<tr><th width="100">ID</th>
        <th width="100">이름</th>
        <th width="200">email</th>
    </tr>   
	<c:forEach items="${requestScope.list}" var="g">
	<tr>
	<td>${pageScope.g.id}</td>
	<td>${g.name}</td>
	<td>${g.email}</td>
	</c:forEach>
	</table>
	<a href="index.jsp">뒤로가기</a>
</body>
</html>