select * from dept;

drop table dept;

-- 1번
CREATE TABLE dept(
	dept_no char(8) primary key,
    dept_name varchar(100) not null,
    dept_loc varchar(100) not null,
    dept_tel_no varchar(100) not null
);

-- alter를 통해 제약 조건은 추가와 삭제만
-- 2번 dept_no에 primary key 추가
CREATE TABLE dept(
	dept_no char(8) not null,
    dept_name varchar(100) not null,
    dept_loc varchar(100) not null,
    dept_tel_no varchar(100) not null
);

alter table dept
add constraint dept_pk primary key(dept_no);
desc dept;
drop table emp;

-- 3번

insert into dept (dept_no, dept_name, dept_loc, dept_tel_no) values('10','sales', 'seoul', '02-671-1111');
insert into dept (dept_no, dept_name, dept_loc, dept_tel_no) values('20','finance', 'seoul', '02-862-2222');
insert into dept (dept_no, dept_name, dept_loc, dept_tel_no) values('30','hr', 'busan', '051-111-1111');
insert into dept (dept_no, dept_name, dept_loc, dept_tel_no) values('40','purchase', 'busan', '051-222-2222');
insert into dept (dept_no, dept_name, dept_loc, dept_tel_no) values('50','management', 'seoul', '02-383-3333');


-- 4번
create table emp(dept
	emp_no char(10),
    emp_name varchar(50) not null,
    emp_mge varchar(10),
	hiredate varchar(10) not null,
    sal int not null,
	dept_no char(8) not null
);


-- 5번
alter table emp
add constraint emp_pk primary key(emp_no);

alter table emp 
add constraint emp_fk foreign key(dept_no) references dept(dept_no);


-- 6번
insert into emp (emp_no, emp_name, emp_mge, hiredate, sal, dept_no) values('1001', 'kim', '1003', '2005-01-15', 4750, '20');
insert into emp (emp_no, emp_name, emp_mge, hiredate, sal, dept_no) values('1002', 'lee', '1003', '2008-06-05', 3000, '30');
insert into emp (emp_no, emp_name, emp_mge, hiredate, sal, dept_no) values('1003', 'park', '1001', '2007-11-28', 3500, '10');

-- 7번
update emp set dept_no = (select dept_no from dept where dept_name = 'management')
where dept_no = (select dept_no from dept where dept_name = 'hr');

-- 8번
delete from dept where dept_name = 'hr';

-- 9번
insert into emp (emp_no, emp_name, emp_mge, hiredate, sal, dept_no) values('2001', 'chung', '1001', current_date(), 3000, '50');


desc emp;
select * from emp;
select * from dept;

insert into emp (empno, ename, sal) values(2222, 'ddd', 2500);

update emp set sal=3500 where deptno=30;
update emp set sal = (select * from (select avg(sal) from emp) avgsal)
where deptno=10;

delete from emp where sal<2500;
rollback;
select * from emp;