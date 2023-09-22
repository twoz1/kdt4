use mydb;
SELECT 
    *
FROM
    student;
CREATE TABLE test1 AS SELECT * FROM
    student;
SELECT 
    *
FROM
    test1;
desc test1;
CREATE TABLE test3 AS SELECT * FROM
    student
WHERE
    sno >= 2;
SELECT 
    *
FROM
    test3;
CREATE TABLE test4 AS SELECT sno FROM
    student
WHERE
    sno < 7;
SELECT 
    *
FROM
    test4;
CREATE TABLE test5 AS SELECT * FROM
    student
WHERE
    1 = 2;
SELECT 
    *
FROM
    test5;
desc test5;
insert into test5(sno,name) select sno,name from student;
SELECT 
    *
FROM
    test5;
insert into test(name,age) select name,age from student;
SELECT 
    *
FROM
    test;
rename table test to newtest;
SELECT 
    *
FROM
    test;
SELECT 
    *
FROM
    newtest;
truncate newtest;
SELECT 
    *
FROM
    newtest;
desc new newtest;
show databases;
desc student;

create table student2 (
sno int auto_increment Primary key,  
name varchar(10) not null,
age int(3) Constraint sc03 check(age>15 and age<100),
jno int(1),
info varchar(30),
point float(5,2) default 100
) ;

SELECT 
    constraint_name, constraint_type
FROM
    information_schema.table_constraints
WHERE
    table_name = 'student';

SELECT 
    constraint_name, constraint_type
FROM
    information_schema.table_constraints
WHERE
    table_name = 'student2';

	CREATE TABLE friend (
    name VARCHAR(30),
    phone VARCHAR(16),
    addres VARCHAR(100),
    CONSTRAINT pk_friend PRIMARY KEY (name , phone)
);

desc friend;
insert into friend values ("햄스터","010-0000-0000","주소에욤");
-- insert into friend values ("햄스터","010-0000-0000","주소에욤"); 
-- -> primary key때문에 key가 중복되었기에 오류 발생

insert into friend values ("햄스터","010-1000-0000","주소에욤");     
 -- -> 이름하고 전화번호가 똑같이 일치하지 않았기에 오류 발생하지 않음 (번호가 다름)
 
insert into friend values ("햄스터람쥐","010-1000-0000","주소에욤");
-- -> 이름하고 전화번호가 똑같이 일치하지 않았기에 오류 발생하지 않음 (이름이 다름)

select * from student;

-- 참조관계 foreign key(외래키) ----- References key(참조키)
-- 참조당하는 key는 반드시 제약 조건을 가져야 함.
-- parent가 있어야 child 테이블이 Foreign Key(id) References parent(p_id) 이 구문이 
-- 실행될 수 있기에 parent 테이블 작성을 먼저해야 함.

   CREATE TABLE parent2(
         parent_id int(10) auto_increment,
         parent_name varchar(20) NOT NULL,
         phone varchar(13),
         CONSTRAINT pk_parent_id PRIMARY KEY(parent_id),
         CONSTRAINT un_parent_ph unique(phone)
      );
      -- -> unique OK
      
	    CREATE TABLE parent3(
         parent_id int(10) auto_increment,
         parent_name varchar(20) NOT NULL,
         phone varchar(13),
         PRIMARY KEY(parent_id),
         unique(phone)
      );
      -- -> OK ( 테이블 레벨로 정의하면서 제약조건명 생략)
      
      desc parent2;
      SELECT constraint_name, constraint_type
      FROM information_schema.table_constraints
      WHERE table_name = 'parent2' ;
      
	 CREATE TABLE parent(
         p_id int(10),
         p_name varchar(20) NOT NULL,
         phone varchar(13),
         CONSTRAINT pk_parent_id PRIMARY KEY(p_id)
      );
      -- child를 먼저 만들면 오류가 남.
	CREATE TABLE child (
				seq int(5) primary key,
				id int(10),
				title varchar(20), 
				CONSTRAINT fk_child_id Foreign Key(id) References parent(p_id) 
			);
    
     -- parent 제약조건    
	SELECT constraint_name, constraint_type
	FROM information_schema.table_constraints
	WHERE table_name = 'parent' ;
    
    -- child 제약조건 
    SELECT constraint_name, constraint_type
	FROM information_schema.table_constraints
	WHERE table_name = 'child' ;
    
insert into parent values(1,"햄스터",'010-1111-1111');
insert into parent values(2,"햄스터",'010-2222-1111');
insert into parent values(3,"햄스터",'010-3333-1111');
select * from parent;

insert into child values(1,1,'child insert test1');
insert into child values(2,2,'child insert test2');
insert into child values(3,3,'child insert test3');
insert into child values(4,1,'child insert test4');
insert into child values(5,4,'child insert test4');
select * from child;

update child set id=2 where seq=4;
select * from child;
 
-- update child set id=5 where seq=1; -> 오류코드

delete from child;
delete from child where seq=2;  -- child를 삭제할 때 문제 없음.

-- parent를 추가할 때 아무 문제 없음
insert into parent values(7,"햄스터",'010-7777-1111');
insert into parent values(8,"햄스터",'010-8888-1111');
insert into parent values(9,"햄스터",'010-9999-1111');

-- child 가 없는 경우
update parent set p_id = 5, p_name = '고양이' where p_id = 7;

-- child 가 있는 경우 
update parent set p_id = 6, p_name='강아지' where p_id = 3;

-- child가 있는 경우(참조관계가 없는 컬럼)p_name 수정
update parent set p_name = '다람쥐' where p_id=3;

--  child가 없는 경우 p_id =3 삭제 
delete from parent where p_id = 9; 
select * from parent;

-- - child가 있는 경우 p_id =3 삭제
-- delete from parent where p_id = 3; -> 오류

-- - child가 있는 경우 삭제 하려면 Child 먼저 삭제 후 Parent 먼저 삭제 
delete From child where id=3;
delete from parent where p_id = 3;

Drop Table child;  
Drop Table parent;  

CREATE TABLE parent(
         p_id int(10),
         p_name varchar(20) NOT NULL,
         phone varchar(13),
         CONSTRAINT pk_parent_id PRIMARY KEY(p_id)
      );
      
CREATE TABLE child (
    seq INT(5) PRIMARY KEY,
    id INT(10),
    title VARCHAR(20),
    FOREIGN KEY (id)
        REFERENCES parent (p_id)
        ON DELETE CASCADE ON UPDATE CASCADE
); -- Child Table 먼저 생성시 에러 
            
-- Parent에 Data 없는 상태에서 Child 입력
	Insert into child values(1,1,"parent Data 없는 상태"); -- 에러 

insert into parent values(1,"햄스터",'010-1111-1111');
insert into parent values(2,"햄스터",'010-2222-1111');
insert into parent values(3,"햄스터",'010-3333-1111');
select * from parent;

insert into child values(1,1,'child insert test1');
insert into child values(2,2,'child insert test2');
insert into child values(3,3,'child insert test3');
insert into child values(4,1,'child insert test4');

update parent set p_id = 5 where p_id = 1;   -- child도 같이 수정됨
select * from parent;
select * from child;

delete from parent where p_id=5;

drop table student2;

-- 3) 제약조건 수정
-- ** 복습 
-- => student Table 생성하기
Create Table student2 as select * from student;

 desc student;
 desc student2;
 
Alter table student2 add primary key (sno) ;

select * from student2;

alter table student2 add constraint ccc03 unique(name) ; 
Alter Table student2 Add Constraint ccc01 check(point between 100 and 5000); 

desc student2;
SELECT constraint_name, constraint_type 
FROM information_schema.table_constraints
WHERE table_name = 'student2';

Alter Table student2 Drop constraint ccc01 ;

SELECT constraint_name, constraint_type
FROM information_schema.table_constraints
WHERE table_name = 'parent';

SELECT constraint_name, constraint_type
FROM information_schema.table_constraints
WHERE table_name = 'child';

-- alter table parent drop constraint primary;  -> 오류
alter table child drop constraint child_ibfk_1;
insert into child values(55,55,"Drop constraint");  -- -> 더 이상 참조관계가 없기에 잘 들어감
alter table parent drop primary key;