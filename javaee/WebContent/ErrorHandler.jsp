<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true" %>
<!DOCTYPE html>
<html><head><meta charset="UTF-8"><title>Insert title here</title></head>
<body>
	<table>
		<caption> 오류 발생</caption>
		<tr>
			<td>오류메세지</td>
			<td><%=request.getAttribute("msg")%> </td>
		</tr>
	</table>
</body>
</html>