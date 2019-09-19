<%@ page import="java.util.Collection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="com.ssafy.model.domain.Goods"
    import ="java.util.*     "
    %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int totalPrice=0 ; 
HashMap<Integer, Goods> cart = (HashMap<Integer, Goods>)session.getAttribute("cart");
if(cart == null){%>
<center><h1>장바구니가 비어있습니다</h1></center>
<% }else{
	Collection<Goods> goods = cart.values();%>
<table align="center">
	<tr><td width="200">상품이름</td>
        <td width="100">단가</td>
        <td width="100">개수</td>
        <td width="100">금액</td>
    </tr>   
	<%for(Goods g : goods) {%>
    <tr><td><%=g.getNo()%></td>
    	<td><%=g.getProname()%></td> 
    	<td><%=g.getQuantity()%></td> 
    	<td><%=g.getProprice()%></td> 
    <% totalPrice+=g.getProprice()*g.getQuantity();} %>
    <tr><td colspan="3"  align="right">주문한 총 금액</td>
    	<td><%=totalPrice%></td>    
    </tr> 
   
    <tr><td colspan='4' align="center"><a href='book.html'>책</a></td></tr>
</table>
<%} %>
</body>



</html>


