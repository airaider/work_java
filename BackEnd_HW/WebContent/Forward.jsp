<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.ssafy.product.Product"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 조회</title>
<link href="css/basic.css" rel="stylesheet" type="text/css">
</head>
<body>
<%!
private int count=0;
%>
<%
	String msg = (String)request.getAttribute("msg");
Product product = (Product)request.getAttribute("product");
	
	if(msg!=null){
	%>
	<%=msg%>
	<%}else{%>
<form method="get" action="productinsert.do">
<table  align='center' >
	<tr><td class="caption" colspan='2'>상품이 저장되었습니다.</td></tr>
	<tr><td class='tbasic'>상품번호</td>
	    <td class='tbasic'><%=++count%></td>
	</tr>
	<tr><td class='tbasic'>상품명</td>
	    <td class='tbasic'><input type='text' name='id'  id='id' value='<%=product.getNo()%>'></td>
	</tr>
	<tr><td class='tbasic'>상품가격</td>
	    <td class='tbasic'><input type='text' name='name'  id='name' value='<%=product.getPrice2()%>'></td>
	</tr>
	<tr><td class='tbasic'>상품설명</td>
	    <td class='tbasic'><input type='text' name='pw'  id='pw' value='<%=product.getName()%>'></td>
	</tr>
	<tr><td><a href = "register.html">상품 목록</a></td>
	
	</tr>
	
</table>
</form>
<%}%>
</body>
</html>






