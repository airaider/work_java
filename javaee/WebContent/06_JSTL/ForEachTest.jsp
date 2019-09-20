<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList,com.ssafy.model.domain.Goods"
    %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  
<%
    String[] prices={"5000","3000","10000","500"};

    String  price2="5000,3000,10000,500";
	ArrayList<Goods> list = new ArrayList<Goods>();
	list.add(new Goods(1,"a1",500000,10,0));
	list.add(new Goods(2,"a2",1000000,100,0));
	list.add(new Goods(3,"a3",300000,50,0));
	list.add(new Goods(4,"a4",5000000,200,0));
	
	request.setAttribute("price2", price2);
	request.setAttribute("prices", prices);
	request.setAttribute("list", list);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String temp = "하하하";
	//pageContext.setAttribute("temp", temp);
%>
	${temp} <%-- 지역변수는 attribute가 아니므로 출력 불가. --%>
	<c:set var="message" value="불금" scope="request"/>
	${message} <br/>
	
	<c:forEach items="${requestScope.list}" var="g">
		<h1>${pageScope.g.no} : ${g.proname} ,
			<fmt:setLocale value="ko_KR"/>
			<fmt:formatNumber type="currency" value="${g.proprice}"/>
			  
			<fmt:formatNumber type="number" value="${g.proprice}"/>  
		</h1>
	</c:forEach>
	<hr/>	
	<c:forEach items="${requestScope.list}" var="g" 
		begin="0" end="2" step="2">
		<h1>${pageScope.g.no} : ${g.proname} </h1>
	</c:forEach>
	
	<c:forEach begin="1"  end="10" step="2" varStatus="status">
		<H1>${status.index} , ${status.count}  : 안녕.</H1>
		<c:if test="${status.count % 2 == 0 }">
			<hr/>
		</c:if>
	</c:forEach>
</body>
</html>















