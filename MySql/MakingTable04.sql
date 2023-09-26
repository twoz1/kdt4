create table student(
sno int auto_increment,
name varchar(10) not null,
age int(3),
jno int(1),
info varchar(30),
point float(5,2) default 100,
primary key(sno),
check(age > 15 and age < 100)
);

	create table jo (
	jno int(1),
	jname varchar(10) not null,
	captain int not null,
	project varchar(20) not null,
	slogan varchar(30) not null,
	Primary Key(jno)
	);

insert into student(name, age , jno, info, point ) values("김이지렁이",27,4,"햄스터 좋아해용",999.99);
select * from student;
delete from student where sno=1;
select * from student;
drop table jo;
drop table student;

insert into jo values(4,"최고조",2,"tbtConcept","열정빼면 시체");

insert into student(name, age, jno, info) values("김소라",28,1,"1조");
insert into student(name, age , jno, info, point ) values("김이지렁이",27,4,"햄스터 좋아해용",999.99);
insert into student (name, age, jno, info) values("김진휘",  27, 4 ,"4조의 비둘기" );
insert into student(name, age, jno, info) values("김찬미", 22, 4, "4조의 학생");
insert into student(name, age, jno, info) values('김해림', 29, 2, '2조 조장');
insert into student(name, age, jno, info) values("남우리", 29, 3, "i4");
insert into student (name,age,jno,info,point) values('배정현', 36, 1, '준우 아빠', 99.9);
insert into student(name, age, jno, info) values("설수현", 27, 3, "i4");
insert into student(name, age, jno, info) values("신혜진", 27, 3, "I4");
insert into student(name, age, jno, info) values("안진혁", 26, 2, "학생");
insert into student(name, age, jno, info) values("양세현", 33, 2, "여우조");
insert into student(name, age, jno, info) values("성은",25,5,"성은 어");
insert into student(name, age, jno, info) value("연제승", 27, 3, "i4");
insert into student (name, age, jno, info) values ("오원희", 30, 5, "5조의 폭주기관차");
insert into student (name, age, jno, info) values("유희상", 35, 5, "5조의 학생");
insert into student(name, age, jno, info) values ("은희상", 27, 1, "1조의 학생");
insert into student(name ,age ,jno,info) values("이성룡",27,2,"CastleDragon");
insert into student(name, age, jno, info) values("이진기", 38, 5, "505호 학생중 나이 제일 많음yo...");
insert into student(name, age, jno, info) values("조현주", 48, 4, "다신 학원을 빠지지 않겠습니다.");
insert into student(name, age, jno, info) values("최승호", 25, 1, "1조의 학생");

insert into jo(jno,jname,captain,project,slogan) values(1, '119', 7, '펫밀리', '애완동물을 위한 홈페이지');
insert into jo values(2, '여우', 5, '여우책방', '책으로 마음의 양식을♡');
insert into jo values(3, "i4", 13, "단Dog", "반려동물 한마리 한마리 모두 소중하다");
insert into jo values(5, "오조", 14, "Ojoa", "완주 아니면 죽음뿐");
select * from jo;
select s.sno, s.name, s.jno, j.project from student s, jo j where s.jno = j.jno; 

select s.sno, s.name, s.jno, j.project
from student s, jo j 
where s.jno = j.jno
order by jno;

select j.jno, j.jname, j.captain , s.name from student s , jo j where j.captain = s.sno;
insert into student(name,age, jno, info) values ("햄스터", 22 , 7,"joTable에 없는 조");
update jo set jno=6  where jno = 5;
update jo set jno=5  where jno = 6;

    	create table student2(
	sno int  auto_increment,
	name varchar(10) not null,
	age int(3),
	jno int(1),
	info varchar(30),
	point float(5,2) default 100,
	Primary Key(sno),
	Check(age>15 and age<100)
   	);
    
	create table jo2 (
	jno int(1),
	jname varchar(10) not null,
	captain int not null,
	project varchar(20) not null,
	slogan varchar(30) not null,
	Primary Key(jno),
	Foreign Key(captain) References student2(sno)
	);
    
SELECT constraint_name, constraint_type
FROM information_schema.table_constraints
WHERE table_name = 'jo2' ;

insert into student2 select * from student;
insert into jo2 select * from jo;

select * from student2;
select * from jo2;

update student2 set sno = 100 where sno = 22; -- 참조값이 아니기에 상관없음
update student2 set sno = 101 where sno = 2; -- 조장. 참조값이기에 바꾸면 오류가 남.
update student2 set sno = 300  where name = "연제승";  -- Error sno로 찾지 않아두..

	create table student3(
	sno int  auto_increment,
	name varchar(10) not null,
	age int(3),
	jno int(1),
	info varchar(30),
	point float(5,2) default 100,
	Primary Key(sno),
	Check(age>15 and age<100)
   	);
    
	create table jo3 (
	jno int(1),
	jname varchar(10) not null,
	captain int not null,
	project varchar(20) not null,
	slogan varchar(30) not null,
	Primary Key(jno),
	Foreign Key(captain) References student3(sno)
			On Delete Cascade
			On Update Cascade
	);

insert into student3 select * from student2;
insert into jo3 select * from jo2;
select * from student3;

insert into jo3 values(7,"test",55,"project","slogan");

update student3 set sno=999 where sno=2;	
select * from jo3;
update student3 set sno =2  where sno=999;	
delete from student3 where sno = 2;

select j.jno, j.jname, j.captain, s.name from student3 s, jo3 j where j.captain = s.sno;


	create table jo4 (
	jno int(1),
	jname varchar(10) not null,
	captain int not null,
	project varchar(20) not null,
	slogan varchar(30) not null,
	Primary Key(jno)
	);

	create table student4(
	sno int  auto_increment,
	name varchar(10) not null,
	age int(3),
	jno int(1),
	info varchar(30),
	point float(5,2) default 100,
	Primary Key(sno),
	Check(age>15 and age<100),
    foreign key(jno) references jo4(jno)
		on delete cascade
        on update cascade
   	);
    
    drop table student4;
    drop table jo4;

    insert into jo4 select * from jo2;
    insert into student4 select * from student2 where jno <= 6;
    select * from student4;
    select * from jo4;
    
	select s.sno , s.name , s.jno , j.captain , j.project , j.slogan from student4 s , jo4 j where j.jno = s.jno ;

	update jo4 set jno=6 where jno = 4;
    update jo4 set jno=4 where jno = 6;
    
    delete from jo4 where jno = 5;
    select * from student4 order by jno ,age;
	
	update student4 set jno = 3 where sno = 8;
	delete from student4 where sno = 21;
    
	update student2 set info = "햄스터 좋아용" where sno =2 ;
	rollback;
    commit;
    select * from student2;
    update student2 set sno = 22 where sno = 100;
    update student2 set info = "Transaction Test" where sno =22 ;
    
	start transaction;
	update student2 set name = "햄스터" where jno = 3 ;
    select * from student2 where jno = 3;
    rollback;

select * from student2 where jno = 2;
truncate student2;
update student2 set name = "김해림" where sno = 5 ;
update student2 set name = "안진혁" where sno = 10 ;
update student2 set name = "이성룡" where sno = 17 ;
update student2 set name = "양세현" where sno = 11 ;

select  sno, name, s.jno, j.jno, j.jname from student s, jo j ;   -- 
select sno, name, s.jno, j.jno, jname from student s, jo j  where s.jno=j.jno ; 
select * from student2;
delete from student where sno=21;
update student set sno =21 where sno = 22; 
select  sno, name, s.jno, j.jno, jname from student s LEFT OUTER JOIN jo j ON s.jno=j.jno ;


select  sno, name, s.jno, j.jno, jname from student s RIGHT OUTER JOIN jo j ON s.jno=j.jno ;

insert into jo values(7,"test조",55,"project","slogan");
update jo set jno= 9 where jno=7;



select j.jno, j.jname, j.captain, s.name , s.age from jo j Left Outer Join student2 s On j.captain=s.sno;

select j.jno, j.jname, j.captain, s.name , s.age from jo j right Outer Join student2 s On j.captain=s.sno;

-- alter table student2 ADD rno int default sno; --컬럼을 디폴트 값으로 줄 수 없음 
alter table student2 ADD rno int default 21 ; 

    update student2 set rno = 5 where sno = 17;
	update student2 set rno = 12 where sno=13;
	update student2 set rno = 5 where sno = 17;
	update student2 set rno = 9 where sno = 3 ;
	update student2 set rno=10 where sno=6;
	UPDATE student2 SET rno = 8 WHERE sno=14;
	UPDATE student2 SET rno = 14 WHERE sno=8;
	update student2 set rno = 6 where sno = 10;
	update student2 set rno = 1 where sno=7;
	update student2 set rno = 3 where sno = 9; 
	update student2 set rno = 7 where sno =1;
	update student2 set rno = 2 where sno = 16 ;
	update student2 set rno = 15 where sno = 4;
	update student2 set rno=17 where sno=5;
	Update student2 set Rno=18 where sno=11;
	Update student2 set Rno=11 where sno=18;
	update student2 set rno = 13 where sno =12;
	update student2 set rno = 4 where sno = 15;
    
delete from student2 where sno=22;
alter table student2 ADD rno int default 21 ; 
select s1.sno, s1.name, s1.jno, s1.rno, s2.name as 짝꿍이름 from student2 s1, student2 s2 where s1.rno=s2.sno ;
select s1.sno, s1.name, s1.jno, j.jname, s2.name as cname, j.captain from student2 s1, jo2 j , student2 s2 where s1.jno=j.jno  AND j.captain = s1.sno ;

select * from student;

alter table student2 add 메롱 int default 22;
delete from student2 where (메롱);
alter table student2 drop column 메롱;


select * from student;
select * from jo;

start transaction;
select * from jo4;
select * from student4;
delete from student where sno=13;
select * from jo;
rollback;


select sno, name, s.jno, jname,  project from student3 s , jo3 j ;  -- 조건이 없을 때 : 크로스 조인
select id, name, s.jno, jname from student s JOIN jo j On s.jno=j.jno ;  -- Ansi Join
 
 select * from student where jno = (select jno from student where name = "김진휘");
 
update student set jno = 3 where sno = 8;   

select sno, name, jno from student where jno = (select jno from jo where jname = "오조" );

select * from student where age >= (select age from student where name = "조현주");

select * from student where age < (select age from student where name = "조현주");

select * from student where age < (select age from student where name = "조현주") order by age desc; 

select jno, jname, captain, (select name from student where sno = captain) 조장이름 from jo j;

select sno, name , jno ,(select jname from jo j where s.jno = j.jno ) 조이름  from student s;
 
update student set age = 28 where sno = 19;
select sno, name, age, s.jno, j.jname from student s, jo j where s.jno = j.jno
and age <= ( select age from student where name ="조현주");

select count(*), sum(age),avg(age),max(age),min(age) from student;

insert into student(name, age ,jno) values ("햄찌",77,7);
select * from student;

select count(*), count(info),sum(age),avg(age),max(age),min(age) from student;

select count(*), count(info),sum(age),avg(age),max(age) + min(age) from student;

select jno, count(*), sum(age) , avg(age), max(age), min(age) from student GROUP BY jno order by jno ;

select jno, name, count(*), sum(age) , avg(age), max(age), min(age) from student GROUP BY jno order by jno ;

	select jno, count(*), sum(age) , avg(age), max(age), min(age) from student
	where jno >2 
	GROUP BY jno 
	order by jno ; 
    
    select jno, count(*), sum(age) , avg(age), max(age), min(age) from student
	where age >=28 
	GROUP BY jno 
	order by jno ; 
    
    
    -- 조별 인원이 4인 경우만 출력  
    select jno, count(*), sum(age) , avg(age), max(age), min(age) from student
	GROUP BY jno having  count(*)=4
	order by jno ;  
    
    
    
	select jno, count(*), sum(age) , avg(age), max(age), min(age) 
	from student
	where age >= 22
	GROUP BY jno Having count(*)>=3;
    
    
	select jno, count(*), sum(age) , avg(age), max(age), min(age) 
	from student
	where age >= 22
	GROUP BY jno Having count(*)>=3
	order by count(*) desc;
    

    -- jname 해결(join)
    select s.jno,j.jname,count(*),sum(age),avg(age), max(age),min(age)
    from student s , jo j 
    where s.jno = j.jno
    group by jno;
    
    
    -- jname 해결(sub Query)
    select jno, (select jname from jo j where s.jno = j.jno) jname ,count(*),sum(age),avg(age), max(age),min(age)
    from student s 
    group by jno;
    
    select * from student;
    
    desc student;
    
    update student set sno=22 where name="햄찌";
     create table test select * from student;
     select * from test;
     desc test; -- 제약조건은 복사 불가. default 와 not null은 복사 가능
     alter table test add primary key(sno);
	 desc test;
     
     alter table test add unique(name);
     
     alter table test add foreign key(jno) references jo(jno);
     -- 오류가 남 student에 jo 테이블에 없는 데이터가 있음 참조 불가.
     
     select * from jo;
     
     alter table test add address varchar(30) not null default "경기도 성남시 분당구";
     
     alter table test drop column age;
     
     alter table test rename column point to score;
     alter table test rename column sno to idno;
     update test set score = 300.00 where idno=2 or idno = 7;
     
     alter table test modify score int(20); 
     desc test;
     
     alter table test rename to newtest;
     alter table newtest rename to test;
     alter table test modify idno float(7,3);
     alter table test modify score varchar(3);
     alter table test modify score int(10) ; 
     
     
     drop table student2;
     drop table student3;
     truncate student2; 
     truncate student3;
     
     delete from student3;
     
     -- 동시접속자 10만명을 예상 -> 컬럼을 따지고 최종적으로 데이터베이스는 몇 기가, 테라여야 합니다 -> 용량산정
     -- db용량, 서버 용량 -> 필요한 테이블만을 계산뿐만 아니라 다른 요소 용량산정해야함.
     -- view는 논리적으로 만들어지는 가상 테이블 -> 용량산정할 때 필요하지는 않음
     
     
     CREATE VIEW myview01 AS select sno, name, jno from student ; 
     select * from myview01; -- 테이블 처럼 사용
     
     update myview01 set name ="냥냥이" where sno = 22;
     
	create view myview02 As 
	select s.sno, s.name, s.jno , j.jname , j.captain
	from student s left Outer join jo j
	on s.jno = j.jno; 
    
    select * from myview02 ;
    
    
   select v1.sno, v1.name, v1.jno , v1.jname , v1.captain , v2.name 조장이름
   from myview02 v1 , myview02 v2 where v1.captain = v2.sno; 

	create view myview01 as select sno, name, jno from student order by jno; -- 있는 이름으로 사용했기에 오류
    
    create or replace view myview01 as select sno, name, jno from student order by jno;
    
    Drop View myview01;
    Drop View myview02;
    
    show index from test;
    
-- => 생성
-- CREATE INDEX 인덱스명 ON 테이블명(컬럼명)
--  ALTER TABLE 테이블명 ADD INDEX 인덱스명(컬럼명)
-- -> student 의 name으로 myindex01 만들기
create index namei on student(name) ;

-- -> create or replace 적용
-- Create or replace index namei on student(name) ;
-- // 지원안됨 ERROR 1064 (42000): You have an error in your SQL syntax;……

-- => 삭제
-- DROP INDEX md01 ; // Mysql 은 Error
ALTER TABLE 테이블명 DROP INDEX 인덱스명;
alter table student drop index namei;
show index from student;
    