/*
  날짜 기본값 설정 	5.6.5 미만 now()
				5.6.5 이상 current_timestamp 
                => 년,월,일,시,분,초로 설정되므로 타입은 datetime 또는 timestamp
*/

CREATE TABLE semp (
    empno INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    sal INT,
    hiredate DATETIME DEFAULT CURRENT_TIMESTAMP,
    deptno INT
);

desc semp;

CREATE TABLE member (
    id VARCHAR(30) PRIMARY KEY,
    password VARCHAR(30) NOT NULL,
    email VARCHAR(50),
    phone VARCHAR(16),
    address VARCHAR(200)
);

CREATE TABLE orders (
    ono INT AUTO_INCREMENT PRIMARY KEY,
    odate DATETIME DEFAULT CURRENT_TIMESTAMP,
    id VARCHAR(30),
    gno INT NOT NULL,
    quantity INT DEFAULT 1,
    address VARCHAR(200),
    FOREIGN KEY (id)
        REFERENCES member (id),
    FOREIGN KEY (gno)
        REFERENCES goods (gno)
);

/*
  check 제약 조건
  - insert, update할 때 지정한 조건에 맞지 않으면 error 발생
  형식]
  [constraint 제약조건명] check(컬럼명 조건)
*/
CREATE TABLE cemp (
    empno INT PRIMARY KEY,
    ename VARCHAR(30) NOT NULL,
    sal INT DEFAULT 1500,
    commission_pct NUMERIC(4 , 2 ),
    CONSTRAINT CHECK (commission_pct IN (10 , 10.5, 12, 12.5, 15)),
    CONSTRAINT CHECK (sal >= 1000)
);

/*
  테이블 변셩
  alter table 테이블명 add|modify|change|drop 컬럼명
*/

-- 컬럼 추가 alter table 테이블명 add 컬럼명 타입 [제약조건]
alter table cemp add deptno int;
desc cemp;

-- 컬럼 타입 변경 alter table 테이블명 modify 컬럼명 타입
alter table cemp modify deptno varchar(30);

-- 컬럼 이름 및 타입 변경
-- alter table 테이블명 change 이전컬럼명 변경할_컬럼이름 변경할타입;
alter table cemp change deptno address varchar(30);

-- 컬럼 삭제 alter table 테이블명 drop 컬럼명;
alter table cemp drop address;
desc cemp;

/*
  형식] drop table 테이블명;
  주의점] 자식테이블이 있emp는 부모테이블인 경우 삭제 안됨
		=>자식테이블을 삭제 후 부모테이블을 삭제해야한다
*/
drop table goods;	-- orders 테이블이 참조하고 있어서 삭제 안됨

drop table cemp;	-- 참조하는 테이블이 없어서 무리 없이 삭제

CREATE TABLE cemp AS SELECT empno, ename, sal, deptno FROM
    emp;

SELECT 
    *
FROM
    cemp;

/*
  truncate
  - 테이블의 모든 데이터를 삭제
  - 복구할 수 없음
  형식] truncate 테이블명;
*/
 
truncate cemp;
select * from member;
select * from product;
drop table member;
select * from member;

select * from food_member;
select * from food;
drop table food;
CREATE TABLE `food` (
`code` int(11) NOT NULL,
`name` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
`supportpereat` double DEFAULT NULL,
`calory` double DEFAULT NULL,
`carbo` double DEFAULT NULL,
`protein` double DEFAULT NULL,
`fat` double DEFAULT NULL,
`sugar` double DEFAULT NULL,
`natrium` double DEFAULT NULL,
`chole` double DEFAULT NULL,
`fattyacid` double DEFAULT NULL,
`transfat` double DEFAULT NULL,
`maker` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
`material` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
`img` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
`allergy` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
PRIMARY KEY (`code`)
);
select * from food;
select * from food_member;

CREATE TABLE `ssafydb`.`user_food` (
`no` INT NOT NULL AUTO_INCREMENT,
`id` VARCHAR(45) NOT NULL,
`code` INT NOT NULL,
`cnt` INT NOT NULL,
PRIMARY KEY (`no`));

