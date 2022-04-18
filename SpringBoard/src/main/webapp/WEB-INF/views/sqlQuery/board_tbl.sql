-- ���� ���� (0���� �����)
CREATE SEQUENCE board_num;

-- ���̺� ����
CREATE TABLE board_tbl(
    bno number(10, 0),
    title varchar2(200) not null,
    content varchar2(2000) not null,
    writer varchar2(50) not null,
    regdate date default sysdate,
    updatedate date default sysdate
    );
    
alter table board_tbl add constraint pk_board primary key(bno);

-- ����
INSERT INTO board_tbl (bno, title, content, writer) VALUES (board_num.nextval, '�׽�Ʈ��', '�׽�Ʈ����', '�۾���');

-- ��ȸ
SELECT * FROM board_tbl ORDER BY bno DESC;
SELECT rowid, rownum, board_tbl.* FROM board_tbl WHERE rownum <= 5;

-- commit ������ �����ؾ� ��μ� �����Ͱ� ������ (�ٵ� �� ���ߴµ��� ������ ����;;����)
commit;

-- BNO�� 20�� Ƣ�� ���� ���� ���ؼ� ���� ����
alter sequence board_num nocache;

-- ����
UPDATE board_tbl SET title='���񺯰�' WHERE bno='3';
UPDATE board_tbl SET title='07����', content='07����', updatedate=sysdate WHERE writer='���γִ� �۾���3';

insert into board_tbl (bno, title, content, writer) (select Board_NUM.nextval, title, content, writer from board_tbl);