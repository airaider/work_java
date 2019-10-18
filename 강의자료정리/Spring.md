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

