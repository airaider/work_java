# Get / Post



요청 데이터 추출

Get

Post

String getParameter("name");

String[] getParameterValue("name");

Get String GetQueryString();



hsp script 요소

1. Scriptlet

   <%java code %>

   _jspService(request, response)의 body로 구현

2. Declaration

   <%! //속성, 메서드 선언%> 선언부에 구현

3. Expression

   <%=	%>	out.print(); 출력 역할

4. Comment

   <%--	--%>



Page Context

request	HttpServletRequest

session	HttpSession : session이 유지되는 동안

application	HttpServletContext

