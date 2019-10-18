# MyBatis



**Java Reflection**

리플렉션은 구체적인 클래스 타입을 알지 못해도, 그 클래스의 메소드, 타입, 변수들을 접근할 수 있도록 해주는 자바 API



update

insert

delete



parameterType = data setting 할 type

parameterMap

* delete

> JDBC : delete from member where id = ?

> MyBatis : delete from member where id = #{data 이름}	이름은 상관이 없다

* insert

> JDBC : insert into member (id, password, name, email) values (?,?,?,?)

> MyBatis : insert into member (id, password, name, email) values (#{id}, #{password}, #{name}, #{email}) 객체의 속성명이 중요하다

`stmtsetString(1,member, getIO());`

+ select

`<select id="" paramteterType="" resultType="결과를 담을 type"`

resultType 대신에 resultMap을 사용하기도 한다 

1. 컬럼명과 속성명이 다를때
2. **join 때문에 사용한다**

> MyBatis : select * from member