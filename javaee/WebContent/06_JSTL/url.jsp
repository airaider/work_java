<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/a/b.jsp"/>
	<br>
	<%=request.getContextPath()%>/a/b.jsp<br/>
	<img src="<c:url value='/images/ok.gif'/>">
</body>
</html>