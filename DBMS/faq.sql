CREATE TABLE faq (
  no 		INT 		PRIMARY KEY AUTO_INCREMENT,
  id 		VARCHAR(45) NOT NULL,
  title 	VARCHAR(45) NOT NULL,
  contents 	VARCHAR(3000) NOT NULL,
  regdate 	DATETIME NULL,
  replay  	VARCHAR(3000) NULL,
  CONSTRAINT fk_faq_id  FOREIGN KEY (id)
    REFERENCES member (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    

    
describe faq;
select * from faq;
describe product;
select * from product;