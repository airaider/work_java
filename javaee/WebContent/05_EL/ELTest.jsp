<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.ssafy.member.domain.Goods" %>
<%
	Goods goods = new Goods(1,"hadoop",15000,10,0);
	request.setAttribute("goods", goods);
	
	String[] music={"디자이너","안녕하세요","빨간맛","야생화"};
	session.setAttribute("music",music);

	String[] music2={"워커홀릭","안녕","빨간맛"};
	application.setAttribute("music",music2);
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${goods.no} : ${goods.proname} <br/>
	${requestScope.goods.no} : ${requestScope.goods.proname} <br/>
	
	${music[0]}, ${music["1"]}, ${sessionScope.music[2]} <br/>
	${applicationScope.music[0]}
	 
</body>
</html>















