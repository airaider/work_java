<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String url = "../Login.jsp"; %>
	<table>
		<tr><td>html</td>
			<td><jsp:include page="../FileUpload.html"/></td>
		</tr>
		<tr><td>jsp</td>
			<td><jsp:include page="<%=url%>"/></td>
		</tr>
		<tr><td>servlet</td>
			<td><%-- <jsp:include page="/hello.do"/> --%></td>
		</tr>
	</table>	
</body>
</html>







