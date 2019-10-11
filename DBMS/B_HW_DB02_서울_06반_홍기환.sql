create table product(
	p_code int primary key,
    p_name varchar(50) not null,
    p_price int not null
);

insert into product (p_code, p_name, p_price) values(100, 'TV', 180000);
insert into product (p_code, p_name, p_price) values(200, '냉장고', 1500000);
insert into product (p_code, p_name, p_price) values(300, '모니터', 230000);
insert into product (p_code, p_name, p_price) values(400, '마우스', 30000);
insert into product (p_code, p_name, p_price) values(500, '키보드', 60000);

select p_price*0.85
from product;

update product set p_price= p_price * 0.80
where p_name='TV';

select sum(p_price) from product;

select * from product;                                                                                                                                                                         
