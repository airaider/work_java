# Servlet



MVC1 : Controller - jsp

MVC2 : Controller - servlet



java <= html

```java
XXXServlet.java

class XXX Servlet extends httpServlet{

	doGet(){
		out.print("<html>")
	}

} 
```

html <= javaBrowser -> request

​	/xxx.html 호출

​	response ->



Servlet programming

Servlet

`init()` 초기화, `service()` 요청, `destroy()` 소멸자

`getServletConfig()`, `getServletInfo()`

GenericServlet	(abstract method)

`service();`

HttpServlet	(abstract method)

`doget();`

`dopost();`

`doput();`

HelloServlet



응답 메세지

================================

| 프로토콜 상태 메세지                             |		상태 라인

================================

| 헤더명 : 값												|

| 응답하는 내용에 관련된 것들				 |

| (관련 컨텐츠 같은 img, mp3, 크기	 	|

| 서버측 정보 											 |

================================

|		CRLF                                  