# DataBase

데이터베이스의 기본 단위는 entity

무결성 : 어딜 가든 데이터는 일치해야한다, 업데이트, 중복성은 최소한으로

select로 테이블에서 불러온 data는 임시 테이블에 저장된다

select [distinct] * | 컬럼명 [as Alias] (★매우 중요★)

from table명

[where 조건]

[group by 칼럼명]

[order by 칼럼명 [asc|dsc]]



like

_ : 한 문자 대체

%: 문자 개수 상관없이 대체



having

조건 : 집계 함수 결과

group by랑 같이 사용 가능

mySQL에서만 임의로 선언한 변수명 사용 가능



foreign key

없는값 참조 불가능



SubQuery

select [distinct] *| column [as Alias] or (SubQuery)

from 테이블명[Alias] or (SubQuery) Alias

where 조건 비교연산자 (SubQuery)

** 불가능 group by 컬럼명

having 조건 비교연산자 (SubQuery)

order by 컬럼명 or (SubQuery)

create table 테이블명 as SubQuery

insert into 테이블명 values( (SubQuery), ...)

delete from 테이블명 where 컬럼 비교조건 SubQuery

update table명 set  (컬럼의 값에 사용 가능)

where 컬럼 비교조건 SubQuery



1. Query 분석
2. Query 수행할 프로시져 생성
3. 프로시져 수행
4. 프로시져 저장



MVC(Model-View-Controller)

View : jsp, html, javascript

Controller : servlet

Model : DAO(Data Access Object) - select, insert, delete, update

​			  Service - transaction, service에 필요한 기능, network, 보안

​			  Process - RUCD

​			  DTO(Data Transfer Object) 