create table reply_tbl(
  rno number(10,0),
  bno number(10,0) not null,
  reply varchar2(1000) not null,
  replyer varchar2(50) not null,
  replyDate date default sysdate,
  updateDate date default sysdate
);

create sequence reply_num;

alter table reply_tbl add constraint pk_reply primary key(rno);

alter table reply_tbl add constraint fk_reply
foreign key (bno) references board_tbl(bno);

INSERT INTO reply_tbl
		(rno, bno, reply, replyer) 
			values
		(reply_num.nextval,311353 , '¾È³ç', 'ÇÏ¼¼¿ä');
        
SELECT rownum, rowid, reply_tbl.* FROM reply_tbl;


alter sequence reply_num nocache;
