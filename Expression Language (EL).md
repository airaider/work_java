# Expression Language (EL)



EL => ${		}

Java 코드가 아닌 jsp의 구성요소

**사용목적**

1. HTML 출력위치 => 출력 역할
2. JSTL 태그내 속성값 위치 => 표현식 처리, 결과 전달

**firstThing**

- EL내장객체 여부
- 판단
- JX
- 4n scope 영역에 저장된 Attribute key (page, request, session, application)



JSP pageContext를 제외한 모든 type가 Map 타입이다

```cookie.XXX(string).value```

