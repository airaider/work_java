CREATE TABLE book (
    isbn CHAR(8) PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    author VARCHAR(10) NOT NULL,
    publisher VARCHAR(15) NOT NULL,
    price INT NOT NULL,
    description VARCHAR(200)
);

insert into book values
('123-1-14','Java와 coffee','diana','자바닷컴',8000,'삶의 즐거움');
insert into book (isbn,title,author,publisher,price)
values ('555-23-2','AI와 미래','김현주','미래닷컴',20000);
insert into book (isbn,title,author,publisher,price,description)
values('123-2-15','Java와 놀기','김태희','자바닷컴',22000,'Java 정복');
insert into book (isbn,title,author,publisher,price,description)
values('123-6-24','Java와 알고리즘','서민규','자바닷컴',20000,'성능업!!');
insert into book (isbn,title,author,publisher,price)
values('423-5-36','IoT세상','이세준','미래닷컴',25000);

SELECT 
    *
FROM
    book;

UPDATE book 
SET 
    price = price * 0.9;

UPDATE book 
SET 
    price = price * 0.8
WHERE
    title LIKE '%Java%';

DELETE FROM book 
WHERE
    title LIKE '%Java%' AND price < 10000;

SELECT 
    publisher '출판사',
    COUNT(publisher) AS '도서개수',
    SUM(price) '총가격',
    ROUND(AVG(price)) '평균가격'
FROM
    book
GROUP BY publisher;