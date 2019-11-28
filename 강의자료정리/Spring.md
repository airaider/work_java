# Spring

Legacy

Boot



**다형성** 

- 재사용성
- 유지보수
- 수정이 용이
- 인자와 메소드, 리턴을 일치시켜서 코드를 수정하지 않고 변화된 내용을 사용 가능

**Factory Pattern**

객체 생성을 대신 수행

단점

- 객체의 라이프사이클 관리가 안됨

```java
public class ArticleFactory{
	public static ArticleDao getInstance(){
		return new MysqlArticleDao();
	}
}
public call XXXServiceImp{
	ArticleDao dao = ArticleFactory.getInstance();
}
```



**DI (Dependency Injection)**

의존 : 클래스 내에있는 함수나 속성이 아닌 다른 클래스의 함수나 속성을 사용

- 상속, 속성, 인자로 다른 클래스를 사용

- 의존하는 객체 (속성)을 직접 생성하지 않고 생성자나 setter매소드를 통해서 주입받는다 



**IOC (Inversion Object Control)**

사용하는 객체를 생성의 control을 직접 수행하지 않고 inversion

**IOC Container**

사용할 객체들을 미리 생성해서 관리하는 객체





**No Qualifying bean of type**

1. byType인 경우 해당 클래스의 객체가 2개이상 등록 된 경우 => byName

2. bean 등록이 안된 경우

   2.1 component-scane 을 하지 않았거나 또는 잘못된 package 지원

   2.2 bean 등록하는 Annotation을 작성하지 않은 경우



**AOP (Aspect Oriented Program) **

핵심 모듈이 있는 곳(PointCut)에서 공통코드Aspect)를 끌어다 쓰지 않는다

조립기를 통해 코드를 보내준다

간단하고 유지보수에도 뛰어나지만 성능은 느려진다

Aspect-j 표현식을 사용해서 핵심 모듈을 찾아온다

execution(modifier	returnType	패키지명	클래스명	매소드명(인자))

대체문자	생략			*					dept..,이름*	*			*			  ..

execution(* com.ssafy.model.service * ServiceImp * , search*(..))

연결 지점은 JoinPoint (핵심 모듈 정보)

- 메소드 이름, 인자, 리턴값



Advisor : Aspect(공통모듈)을 수행하는 시점

before, after, around 

|                |     첫번째인자      |                두번째인자                |                리턴                 |
| :------------: | :-----------------: | :--------------------------------------: | :---------------------------------: |
|     Before     |      JoinPoint      |                    X                     |                  X                  |
|     After      |      JoinPoint      |                    X                     |                  X                  |
| AfterReturning |      JoinPoint      |   Object<br />핵심 모듈을 수행한 결과    |                  X                  |
| AftherThrowing |      JoinPoint      | Throwable<br />핵심 모듈에서 발생한 오류 |                  x                  |
|     Around     | ProceedingJoinPoint |                    X                     | Object<br /> 핵심모듈을 수행한 결과 |

Spring이 Around를 제어할 수 없다, 언제 시작하고 끝나는지 모르니까 권한을 개발자에게 넘긴다

Around안에서 핵심 모듈을 직접 호출해야한다

Weaving : 공통 코드를 적용



web.xml

```
DispatcherServlet{
	web beanConfiguration
	일반 beanConfiguration
}
```



DispatcherServlet



SpringContainer

​	-> web beanConfiguration

​	-> 일반 beanConfiguration



```java
@Controller
public class MainController{
	@RequestMapping("hello")
    public String hello(){
        return "hello.jsp";
    }
}
```



HandlerMapper

| key        | value                  |
| ---------- | ---------------------- |
| "hello.do" | MainController.hello() |
| ...        | ...                    |



reflection을 통해 인자정보, 리턴정보를 건네주게된다



ViewResolver

1. url에 해당하는 view를 찾는다
2. view를 생성해서 응답



**Restful API**

자원의 표현에 의한 상태 전달

service할 대상(ex android,ios,타이젠,...)에 따른 서버가 각각 필요하다

서비스할 자원을 통일시키자

xml로 표현하는 통합 서버 하나만 필요하다

각 단에서 알아서 parsing해서 데이터를 접근한다

후에 json으로 넘어갔다 (공공데이터는 xml)



**Spring 프로젝트 순서**

1. web.xml 설정 
   - ContextConfigLocation 경로 설정 및 파악
   - encoding filter 설정
2. ContextConfigLocation 설정
   - mvc-config.xml
   - controller scan
   - resolver를 설정
   - application-config.xml
   - dao, service scan
   - db 설정
   - myBatis 설정

3. myBatis 환경 설정
   - Alias 설정
   - query xml 경로 설정
4. query xml 작성
5. dao, service, controller
6. 화면



**Error 종류**

No qualifying bean of type

1. byType()인 경우 해당 클래스의 객체가 2개 이상 등록 된 경우 => byName
2. bean 등록이 안된 경우
   - component-scan을 하지 않았거나 또는 잘못된 package 지정
   - bean을 등록하는 Annotation을 작성하지 않은 경우



Mapped Statements collection does not contain value

- DAO에서 Query.xml에 작성 query 수행할 namespace.id가 틀린 경우



jsp 실행시 404 나는 경우

1. server오류
   - Query.xml과 SqlMapConfig.xml에 잘못 작성
   - type Alias 잘 설정했는지 확인
2. 배포가 안된 경우(교수 호출)



servlet Path(listBoard.do) 수행 시 404 나는 경우

1. url mapping이 잘못된 경우
2. @Controller가 생략됐는지 확인
3. mvc-config.xml에 scan 됐는지 확인