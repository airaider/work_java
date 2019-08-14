-- 1
show tables;

desc emp;

select *
from emp;

-- 2
select empno, ename, hiredate, sal
from emp
where ename like 'K%';

-- 3
select *
from emp
where hiredate like '2000%';

-- 4
select *
from emp
where comm is not null;

-- 5
select ename, deptno, sal
from emp
where deptno = 30 and sal>=1500;

-- 6
select empno
from emp
where deptno = 30
order by empno;

-- 7
select *
from emp
order by sal desc;

-- 8
select *
from emp
order by deptno, sal desc;

-- 9
select *
from emp
order by deptno desc, ename, sal desc;

-- 10
select ename, sal
,(sal*comm/100) as com
,(sal+comm) as total
from emp
where comm is not null;

-- 11
select ename, sal
,round(sal*0.13,2) as bonus
,deptno
from emp;

-- 12
select ename, sal
,round(sal/60) as money
from emp
where deptno = 20;

-- 13
select ename, sal
,case when sal between 1500 and 3000 then round(sal*0.15,2) end as '회비'
from emp;

-- 14
select ename, sal
,(sal*0.9) as '실수령액'
from emp
order by sal desc;

-- 15
select ename
,lower(left(ename,3)) as '줄임'
from emp
where ename like '______%';

-- 16
select avg(sal), max(sal), min(sal), count(empno)
from emp
where deptno = 10;

-- 17
select deptno, job, count(*) as '인원수'
from emp
group by deptno, job
order by deptno, '인원수';

-- 18

-- 19
select ename, hiredate
,to_days(sysdate()) - to_days(hiredate) as '근무일수'
from emp;

-- 20
select ename
,year(sysdate())-year(hiredate) as '근속년수'
from emp;