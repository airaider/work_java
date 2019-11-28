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



**AOP (Aspect Oriented Program)**

공통코드를 지향해주는 프로그램, Aspect가 기준으로 끌어다가 쓰겠다

핵심 모듈에서 공통코드를 끌어다가 사용하지 않는다

XML(조립기)를 통해 모듈마다 사용할 공통코드를 적용



**Bean**

기본 생성자가 있다

encapsulation되어 있는 속성들

속성에 대한 getter, setter가 있어야 한다



**Pojo class**

순수 자바로 작성한 클래스

객체 지향 언어로서 자바 Object의 특징을 가지고(확장과 리펙토링이 쉬운 구조)로 
작성된 클래스 





