# DataBase

데이터베이스의 기본 단위는 entity

무결성 : 어딜 가든 데이터는 일치해야한다, 업데이트, 중복성은 최소한으로

select로 테이블에서 불러온 data는 임시 테이블에 저장된다

select [distinct] * | 컬럼명 [as Alias] (★매우 중요★)

from table명

[where 조건]

[group by 칼럼명]

[order by 칼럼명 [asc|dsc]]



like

_ : 한 문자 대체

%: 문자 개수 상관없이 대체