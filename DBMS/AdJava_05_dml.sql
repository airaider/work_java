/*
  데이터 추가
  insert into 테이블명(컬럼명, ...) values(값, ...)
  - 지정한 칼럼 순서대로 데이터를 테이블에 추가
  insert into values(값, ...)
  - 테이블 구조에 설정된 모든 카럼에 구조에 지정된 순서대로 데이터를 추가
*/

insert into goods(brand, price, maker, cno) 
values ('핸디형선풍기',22000,'카카오프렌즈',20);
insert into member(id,password,email,phone,address)
values('ssafy','1111','ssafy@mulcam.com','010','강남구');
insert into member(id,password,email,phone,address)
values('jaen','1111','jaen@mulcam.com','010','서초구');

select * from goods;

/*
  orders테이블의 id 컬럼이 member 테이블의 id 컬럼을 참조
  member테이블에 id가 kkk가 없는 경우 데이터 추가나 update하면 error 발생
  insert into orders(id, gno, quantity)
  values('kdg',1,10);
*/

savepoint insertGoods;

/*
  delete문
  - 테이블에서 데이터 삭제
  - 전체 데이터 삭제
  delete from 테이블;
  - 조건에 맞는 데이터만 삭제
  delete from 테이블 where 조건;
*/
delete from goods;

select * from goods;

rollback to insertGoods;

delete from emp where empno=1111;

commit;

/*
  update : 데이터 수정
  - 전체 데이터 수정
  update 테이블명 set 컬럼명 =값, ...;
  
  - 조건에 맞는 데이터만 수정
  update 테이블명 set 컬럼명 =값, ...where 조건;
/
update emp set sal = 30000;
select * from emp;
rollback;

update emp set sal = 4500 where empno = 1111;

/*
  index
  - select문의 성능을 높이기 위해서 index 만든다.
  형식] create index 인덱스명 on 테이블명(컬럼명,...);
  
  --mysql은 primary key에 대해 클러스트 인덱스가 자동으로 생성된다
*/

-- good 테이블의 상품명에 indexing

create index idx_goods_brand on goods(brand);

select * from emp;
-- empno가 클러스터 인덱스이므로 저장된 값이 정렬된 형태
insert into emp(empno,ename,sal) values(1112,'ssafy',3000);

/**	View
	- Stored Query
    - 테이블과 달리 물리적인 저장공간을 가지지 않는다
    - view에 select문으로 질의를 할 때마다 Stored Query가 수행된다
    - 목적
		- 사용상의 편리성
		  복잡한 query를 view로 생성하고 단순 질의를 통해 결과를 조회할 수 있다
		- 수행속도 향상
		  복잡한 query를 성능 졸은 쿼리로 view를 생성한다
		- 보안 관리를 목적
		  테이블의 일부 컬럼만 엑세스하게 된다
	
    형식]
    create [or replace] view 뷰이름
    as
    select문
*/

create or replace view Employee
as select empno, ename, job, hiredate, sal, deptno, dname
from emp
left join dept
using (deptno);

select * from Employee;
select * from member;

