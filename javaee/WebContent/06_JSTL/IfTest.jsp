<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${param.user eq 'member'}">
	<h1>환영합니다.</h1>
</c:if>

<c:choose>
	<%-- <!-- 조건1 --> : 출력문으로 생성괴므로 분기에 논리적 오류 --%>	
	<c:when test="${param.age lt 20}">애기.</c:when>
	<c:when test="${param.age lt 40}">청년.</c:when>
	<c:otherwise>인생은 지금부터.</c:otherwise>
</c:choose>

<br/>
<a href="IfTest.html">다시 입력하기.</a>
</body>
</html>







