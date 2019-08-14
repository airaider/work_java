select floor(3.14), ceil(3.1), round(3.1), round(3.5)
from dual;

select gno, brand, price
		,round(case when price <10000 then price*1.15
			when price <= 200000 then price*1.10
			else price*1.05
		end, 1) as IncPrice
from goods
order by IncPrice;

/*2. 문자 관련 함수
 문자열 연결
 concat ('문자열', '문자열', '문자열', ...) 
 - 주어진 인자를 모두 연결해서 하나의 문자열로 리턴
 - 기타 다른 DB : 문자열 || 문자열 || 문자열...
*/
select concat(brand, ' 상품은 ', maker, ' 제조사에서 새안한 제품입니다')
from goods;

/*
 문자열 추출
 left(문자열, 추출할 개수)
 - 왼쪽부터 지정한 개수까지 문자열을 추출
 right(문자열, 추출할 개수)
 - 오른쪽부터 지정한 개수까지 문자열을 추출
 substring(문자열, 시작위치, 추출할 개수)
 - 왼쪽부터 시작위치 까지 지정한 개수의 문자열을 추출
 - 시작 위치는 1부터
*/
select brand, right(brand, 2), left(brand, 2)
		,substr(brand, 1, 3)
        ,substring(brand, 1, 3)
from goods;

-- repeat(문자열, 숫자) : 지정한 수만큼 문자열을 반복
select repeat('hello ', 5)from dual;

-- length()		문자열 길이
-- reverse()	문자열을 거꾸로 변환
-- upper()		대문자로 변환
-- lower()		소문자로 변환
select length('Hello'), reverse('Hello'), upper('Hello'), lower('Hello')
from dual;

/*	공백삭세
 rtrim(문자열) : 오른쪽의 공백 삭제
 ltrim(문자열) : 왼쪽의 공백 삭제
 trim(문자열)  : 좌우의 공백 삭제
*/	
select rtrim('     hello     '), ltrim('     hello     '), trim('      hello     ')
from dual;


/*
	3. 논리 관력 함수
    if(논리식, 참일때, 거짓일 때)	=> case when~then을 대체하는 함수
    
    oracle - decode(논리식, 참일때, 거짓일 때)
			 decode(논리식, 참일때
				   ,논리식, 참일때
                   ,...
                   ,거짓일 때)
*/

select gno, brand, price as p
		,case when price <10000 then price*1.15
			when price <= 200000 then price*1.10
			else price*1.05
		end as IncPrice
from goods
order by IncPrice;

select gno, brand, price as p
	   , if( price < 10000, price*1.15
	   ,  if( price <=200000, price*1.1, price*1.05)) as IncPrice
from goods;

select gno, brand, price, cno
,if(cno = 10, '음식'
,if(cno = 20, '전자제품'
,if(cno = 30, '서적'
,if(cno = 40, '가구', '미분류')))) as '분류명'
from goods;

/*상품번호, 상품명, 분류 번호 조회, 단) 분류번호가 없는 상품은 미분류로 표시*/
select gno, brand, if(cno is null, '미분류', cno) as 'cno'
from goods;

/*
	ifnull(문자 or column, 대체 정보) : null인 경우 대체 정보로 조회
*/
/*상품번호, 상품명, 분류 번호 조회, 단) 분류번호가 없는 상품은 미분류로 표시*/
select gno, brand, ifnull(cno,'미분류') as cno
from goods;

/*
coalesce(값1, 값2, 값3,...)
값들 중 처음으로 null이 아닌 값을 리턴 전체가 null이면 null로 리턴
*/
select gno, brand, coalesce(cno,'미분류') as cno
from goods;

select * from goods;
select image, info, cno from goods;
select gno, brand, coalesce(info,image,cno) from goods;


/*
4. 날짜 관련 함수
*/

-- 오늘 날짜 추출
select now(), sysdate(), current_timestamp(), curdate(), curtime()
from dual;

/*
날짜 계산		'년월일'
date_add(날짜, interval 값 기준값)
date_sub(날짜, interval 값 기준값)
기준값 : year, month, day, gour, minute, second

oracle : 날짜 산술연산 수(일) sysdate()+1 : 내일
						 sysdate()-1 : 어제
		 달 연산 add_months(날짜, 숫자(달))
*/
-- 어제 내일, 저번달, 다음달
select date_add(sysdate(), interval 1 day) as 내일
	  ,date_sub(sysdate(), interval 1 day) as 어제
      ,date_add(sysdate(), interval 1 month) as 다음달
      ,date_sub(sysdate(), interval 1 month) as 지난달
from dual;

select year(sysdate()) as 올해
      ,month(sysdate()) as 이번달_숫자
      ,monthname(sysdate()) as 이번달_영어
      ,dayname(sysdate()) as 오늘
from dual;

/*
 dayofyear(날짜)	1월 1일 부터 해당 날짜까지의 날수를 반환
*/
select dayofyear(sysdate()) from dual;

/*d-day*/
select dayofyear('20191129') - dayofyear(sysdate()) from dual;
select to_days('20191129') - to_days(sysdate()) from dual;

select date_format(sysdate(), '%Y년 %m월 %d일 - %p %h시 %i분 %s초') as today
from dual;

/*
 group(aggregation)함수
 - 지정한 group에 함수 기능을 처리하여 1개의 데이터가 조회된다
 - max(), min(), avg(), sum() : null 값을 제외하고 그룹내의 모든 데이터를 처리
   count(*)	   : null값을 포함한 모든 행의 수를 조회
   count(컬럼명) : null값을 제외한 행의 수를 조회
 - 주의
   group의 수와 다른 데이터를 조회하면 mysql은 의미 없는 데이터로 결과가 조회
   다른 DB는 error 발생
 - group by로 지정하지 않으면 전체 데이터가 1개의 group으로 지정
*/

select count(*), count(cno)
	  ,max(price), min(price), sum(price), avg(price)
      from goods;

-- 데이터 수가 서로 다른 gno와 집계함수를 같이 조회하면 다른 DB는 error 발생
-- mysql은 error가 나지 않지만 gno라는 데이터는 의미 없음
select gno, count(*), count(cno)
	  ,max(price), min(price), sum(price), avg(price)
      from goods;
      
-- cno별 등록된 상품 개수, 최고가, 최저가, 평균 가격 조회
select cno, count(*), max(price), min(price), avg(price)
from goods
group by cno;
         
      