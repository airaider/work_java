
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.ssafy.product.dto.Product"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  Product product = (Product)session.getAttribute("product");
	
%>
<table  align='center' >
	<tr><td class="caption" colspan='2'><h1>마지막 등록된 상품</h1></td></tr>
	<tr><td class='tbasic'><b>상품번호</b></td>
	    <td class='tbasic'><%=product.getNo()%></td>
	</tr>
	<tr><td class='tbasic'><b>상품명</b></td>
	    <td class='tbasic'><%=product.getName()%></td>
	</tr>
	<tr><td class='tbasic'><b>상품가격</b></td>
	    <td class='tbasic'><%=product.getPrice()%></td>
	</tr>
	<tr><td class='tbasic'><b>상품설명</b></td>
	    <td class='tbasic'><%=product.getDescrip()%></td>
	</tr>
	<tr><td><a href = "#">상품 수정</a></td></tr>
	<tr><td><a href = "#">상품 삭제</a></td></tr>
	<tr><td><a href = "Login.jsp">상품 목록</a></td></tr>
	
	
	
</table>

</body>
</html>