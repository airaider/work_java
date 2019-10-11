select * from dept;
select * from emp;
 
 -- 1 부서위치가CHICAGO인모든사원에대해이름,업무,급여출력하는SQL을작성하세요
 select ename, job, sal
 from emp
 where deptno = (select deptno from dept where loc='CHICAGO');
 
 -- 2 부하직원이없는사원의사원번호,이름,업무,부서번호출력하는SQL을작성하세요.
select empno, ename, job,deptno from emp e
where not exists (select 1 from emp m where e.mgr = m.empno);

-- 3 BLAKE와같은상사를가진사원의이름,업무,상사번호출력하는SQL을작성하세요.
select ename, job, mgr from emp e
where mgr in (select mgr from emp where ename = 'BLAKE');

-- 4 입사일이가장오래된사람5명을검색하세요.
select * from emp
order by hiredate is null, hiredate asc
limit 0,5;

-- 5 JONES 의부하직원의이름, 업무, 부서명을검색하세요.
select e.ename, e.job, d.dname
from emp e
left join dept d
using (deptno)
where mgr in (select empno from emp where ename='JONES');
