/*
  group by
  - 데이터를 지정한 컬럼을 기준으로 데이터를 종류 별로 분류하여
	데이터 그룹을 나눠서 group 함수를 적용
  형식] group by 컬럼명, ...
*/

SELECT 
    cno, COUNT(*), MAX(price), MIN(price), AVG(price)
FROM
    goods
GROUP BY cno;

-- 업무별 평균 급여 조회 
SELECT 
    job, ROUND(AVG(sal)) avgSal
FROM
    emp
GROUP BY job;

-- 부서별, 업무별 급여 평균을 조회
SELECT 
    deptno, job, ROUND(AVG(sal)) avgSal
FROM
    emp
GROUP BY deptno , job
ORDER BY deptno;

-- 업무별 급여 평균이 2000이상인 업무들을 조회
select deptno, round(avg(sal)) as avgsal from emp
group by deptno
having avgsal>=2000;


-- 제조사별, 분류별 상품의 평균 가격을 조회
SELECT 
    maker, cno, ROUND(AVG(price)) acgPrice
FROM
    goods
GROUP BY maker , cno
ORDER BY cno;

/*
  having
  - group함수의 결과에 조건을 지정해서 데이터를 조회할 때 사용
  - 형식] group by 컬럼, ...
		 having 조건
*/
SELECT 
    deptno, ROUND(AVG(sal)) avgSal
FROM
    emp
GROUP BY deptno
HAVING avgSal >= 2500;

-- 분류별 가격 평균을 조회, 가격 평균이 50만원 이상인 분류는 제외하고 조회한다
SELECT 
    cno, ROUND(AVG(price)) avgPrice
FROM
    goods
GROUP BY cno
HAVING ROUND(AVG(price)) < 500000;

-- 급여가 1500이상인 사원들의 부서별 급여 평균을 조회
-- 단 급여 평균이 2000이상인 부서만 조회
SELECT 
    deptno, ROUND(AVG(sal)) avgSal
FROM
    emp
WHERE
    sal >= 1500
GROUP BY deptno
HAVING avgSal >= 2000
ORDER BY deptno;

/*
  rollup : group별 집계한 결과에 전체(중간) 집계를 추가로 조회
  형식] group by 컬럼명 with rollup;
  oracle] group by rollup(컬럼명);
*/

SELECT 
    IFNULL(job, 'total') AS job, ROUND(AVG(sal)) avgSal
FROM
    emp
GROUP BY job WITH ROLLUP;


/*
  grouping(컬럼)
  - rollup을 통해 나온 결과가 null이면 1,
    원래 값이 null이면 0을 리턴하는 함수
*/
SELECT 
    IF(GROUPING(cno) = 1,
        'total',
        IFNULL(cno, '미분류')) AS cno,
    ROUND(AVG(price)) avgPrice
FROM
    goods
GROUP BY cno WITH ROLLUP;

-- oracle 버전
SELECT 
    DECODE(GROUPING(cno) = 1,
            'total',
            NVL(cno, '미분류')) AS cno,
    ROUND(AVG(price)) avgPrice
FROM
    goods
GROUP BY cno WITH ROLLUP;

-- 부서별, 업무별 급여 평균을 조회, 부서별 급여 평균, 전체 급여 평균
SELECT 
    deptno, job, ROUND(AVG(sal)) avgSal
FROM
    emp
GROUP BY deptno , job WITH ROLLUP
ORDER BY deptno , job DESC;

insert into emp(empno, job, sal) values(1111, 'ANALYST', 3000);

-- 부서별, 업무별 급여 평균을 조회, 부서별 급여 평균, 전체 급여 평균을 Pivot 테이블로 조회
SELECT 
    IF(GROUPING(deptno) = 1,
        '전체통계',
        IFNULL(deptno, '신입사원')) AS deptno,
    IFNULL(ROUND(AVG(IF(job = 'CLERK', sal, NULL))),
            0) CLERK,
    IFNULL(ROUND(AVG(IF(job = 'SALESMAN', sal, NULL))),
            0) SALESMAN,
    IFNULL(ROUND(AVG(IF(job = 'MANAGER', sal, NULL))),
            0) MANAGER,
    IFNULL(ROUND(AVG(IF(job = 'ANALYST', sal, NULL))),
            0) ANALYST,
    IFNULL(ROUND(AVG(IF(job = 'PRESIDENT', sal, NULL))),
            0) PRESIDENT,
    ROUND(AVG(sal)) AS dept_Sal_avg
FROM
    emp
GROUP BY deptno WITH ROLLUP
ORDER BY deptno;











