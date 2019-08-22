CREATE TABLE board (
    no INT PRIMARY KEY,
    id VARCHAR(30) NOT NULL,
    title VARCHAR(300) not null,
    contents VARCHAR(3000),
    regdate DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY fk_board_id(id)
        REFERENCES member (id)
);

CREATE TABLE boardfile (
    no INT PRIMARY KEY AUTO_INCREMENT,
    rfilename VARCHAR(100),
    sfilename VARCHAR(100),
    bno INT,
    FOREIGN KEY fk_boardfile_bno(bno)
        REFERENCES board (no) on delete cascade
);

insert into board(no, id, title, contents)
values(1, 'jaen', 'hello', '처음하는 게시판');
insert into board(no, id, title, contents)
values(2, 'jaen', 'hello', '처음하는 게시판2');
insert into board(no, id, title, contents)
values(3, 'ssafy', 'jdbc?', 'Java Database Connectivity');
insert into board(no, id, title, contents)
values(4, 'ssafy', 'MySql', 'Database 한 종류');

select * from emp;
select * from boardfile;

