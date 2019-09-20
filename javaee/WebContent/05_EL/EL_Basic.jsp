<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${2+3}</h1>
	<h2>${2>3}</h2>
	<h3>${"!!"}</h3>
	<h4>나이:${param.age+10}</h4>
<%-- 	<h1><%=Integer.parseInt(request.getParameter("age")+10)%></h1> --%>
	<h1>이름:${param.name }</h1>
	<h1>이름:${params.name }</h1><!-- null 처리되어 예외 발생하지 않음. -->
</body>
</html>