select * from dept;
select * from emp;

-- 3
select ename, sal, dname
from emp
join dept
using (deptno);

-- 4
select dname
from emp
join dept
using (deptno)
where ename = 'KING';

select dname as 부서명
from dept
where deptno = (select deptno from emp where ename = 'KING');

-- 5
select ename, e.deptno, dname, sal
from dept d
left join emp e
using (deptno);

-- 6
select if(e.mgr is null, concat(e.ename, '의 매니저는 없습니다')
					 , concat(e.ename, '의 매니저는 ', m.ename, '이다')) as '사원정보'
from emp e
left join emp m
on e.mgr = m.empno;

select concat(e.ename, '의 매니저는 ', m.ename, '이다') as '상사 정보'
from emp e, emp m
where e.mgr = m.empno;

-- 7
select ename, dname, sal, job
from emp
join dept
using(deptno)
where job = (select job from emp where ename = 'SCOTT');

-- 8
select EMPNO, ename, hiredate, sal
from emp
where deptno = (select deptno from emp where ename='SCOTT');

select EMPNO, ename, hiredate, sal
from emp, (select deptno as dno from emp where ename = 'SCOTT') n
where deptno=dno;

-- 9
select * from emp
where sal >= (select avg(sal) from emp);

select e.empno, e.ename, d.dname, e.hiredate, d.loc, e.sal
from dept d, emp e
where d.deptno=e.deptno and e.sal>(select avg(sal) from emp);

-- 10
select empno, ename, deptno, loc, sal
from emp
join dept
using (deptno)
where deptno = 30
order by sal desc;

-- 11
select empno, ename, dname, hiredate, loc
from emp e, dept d
where e.deptno = '10' and e.job not in(select job from emp m where deptno =30) and e.deptno=d.deptno;

-- 12
select empno, ename, sal
from emp
where sal in (select sal where ename='KING' or ename='JAMES');

-- 13
select empno, ename, sal
from emp
where sal > (select sal from emp where deptno=30
order by sal desc
limit 0,1);

-- 14
create index idx_ename on emp(ename);

-- 15
select ename, sal 
from emp 
where date_format(hiredate, '%y') in (select date_format(hiredate, '%y') from emp where ename = 'ALLEN');


-- 16
drop view salview;
create view salview
as select deptno, sum(sal) as sumsal from emp group by deptno;


-- 17
select *
from salview
group by deptno
order by sumsal desc
limit 0,3;