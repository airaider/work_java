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





# MVC - Model 2



**View(UI)**

jsp, html



**FrontController**

```java
/요청 url

try{
	if(  )
	else if()
	else if()
}catch(exception e){

}

페이지 이동
```



**Controller**

Servlet 

1. 요청 데이터 추출
2. 모델 수행
3. request 수행
4. 체이지 이동

예외처리

주의사항 : servlet 앞에 / 쓰면 안된당 => ("*.do")



**Model**

Service, DAO, DTO <=> DB





# Cookie



http 프로토콜(TCP)

client => WAS

- Client Stateless 문제 발생
- Server push 불가능 (요청 시에만 정보 엡데이트 가능, 변한 상황을 푸시 불가)



사용자의 상태 정보를 따로 저장

Client에 따로 메모리 할당을 하여 정보를 저장(Cookie)

문자 Data만 name=value

경로당 20개, 4kb

Session 



`request.getCookies()` : 발행한 쿠키를 배열로 꺼내온다		

```Cookie c = new Cookie(name, value);```

name은 무조건 영문만 가능하다

`response.addCookie(c)`

`c.setMaxAge();`

- 음수(-1) : 메모리에만 저장, 브라우저 종료까지만 쿠키 유지
- 0 : 기존 발행 쿠키 삭제
- 양수(초) : 지정한 시간(sec) 만큼만 메모리에 저장됨, 지정한 시간이 남은 상태에서 브라우저 종료시 파일로 저장됨

jsessionid도 -1로 지정이 되어있다





# Session

Client 별로 WAS에 session이 만들어짐

JSESSIONID 라는 아이디를 통해 쿠키 형태로 사용자 구별

http요청에 jsessionid를 담아서 보냄

JSESSIONID는 -1로 지정이 되어있기 때문에 브라우저 재접속시에 새로운 SESSION방으로 접속한다

```request.getSession = request.getSession(true)```

session 만료를 설정함으로 로그아웃을 할 수 있다

```setMaxInactiveInterval``` 해당 Servlet만 만료 (잘 사용하지는 않는다)







