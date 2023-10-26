select sno, jno AS 조번호 from student;

select sno, name, jno, point, jno*point 보너스 from student;
select sno, name, jno, point, jno+point 보너스 from student;

-- 문자열 연산은 허용하지 않음.
select sno, name or info 나의정보 from student;

select sno, concat(name,info) 나의정보 from student;

select sno, name, concat("만",(age-1), "세") 나이 from student;

select * from student;

select sno, concat("김이지렁이빼고 ",name," 바보래용 ",name," 미아내요 ") 풉 from student;

-- 만드는 과정에서는 컬럼이 된 것이 아니기에 사용할 수 없음. Error! 
select sno, name, age, jno, (age*jno) Bonus,  Bonus+point Ytotal, Ytotal/12 Montly from student;

select sno, name, age, jno, (age*jno) 보너스,  (age*jno)+point 년합계, ((age*jno)+point)/12 월간 from student;

update student set point=point+(sno*jno) where point < 200;

select sno, name, age, jno, (age*jno) Test, point  from student Order By Test ; 

select max(point) from student;

select sno, name, point from student where point = (select max(point) from student);

select sno,name , point from student where point = (select min(point) from student);

select sno, name , point from student where point >= (select avg(point) from student);

select * from student where  sno>=15 AND  sno<=20 order by age;
select * from student where sno between 15 and 20 order by age; -- 편리한 연산
select * from student where  sno>=15 &&  sno<=20 order by age;

select * from student where  15 <= sno <= 20 ;  -- 허용안됨

select * from student where  age < 25   OR  age > 30 ;

select *  from student where jno != 7 ;
select *  from student where jno <> 7 ;
select *  from student where Not  jno=7 ; -- Not은 컬럼 앞에 와야함 아니면 에러

select *  from student where info != "i4" ;
select *  from student where info <> "i4" ;

alter table student add address varchar(20);
update student set address = null;
select * from student;
 -- update문에서는 자신 테이블에서 불러 올 수 없음. 
 
update student set address = "분당구 미금역" where not sno % 3 = 0; 

select sno, name from student where name BETWEEN "남" AND "안" order by name;

select * from student where jno IN(1, 4, 5) order by jno ;

select * from student where info IN("학생", "CastleDragon", "성은 어"); 

select * from student where name  =  "_진%" ; 

select * from student where name  LIKE  "_진%" ;

select * from student where name  LIKE  "__지%" ;

select * from student where name  =  "_진%" ;

select * from student where info IN ("%학생%", "%Dragon%", "%성은%");

select * from student where info Like "%연%" || info Like "%학생%" || info Like "%Dragon%";

select * from student where name Not Like "김%";
select * from student where Not name Like "김%";

-- select * from student where name Like Not "김%";

select * from student where age between 27 and 33 && info like "%학생%";

CREATE TABLE IF NOT EXISTS divisions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    belts VARCHAR(200) NOT NULL
);

INSERT INTO divisions(name,belts)
VALUES ('O-1','white,yellow,orange'),
    ('O-2','purple,green,blue'),
    ('O-3','brown,red,black'),
    ('O-4','white,yellow,orange'),
    ('O-5','purple,green,blue'),
    ('O-6','brown,red'),
    ('O-7','black'),
    ('O-8','white,yellow,orange'),
    ('O-9','purple,green,blue'),
    ('O-10','brown,red');

select * from divisions;

SELECT name, belts from divisions where FIND_IN_SET('red', belts);
select * from divisions where FIND_IN_SET('Yellow', belts);

SELECT * from divisions where belts like '%ORANGE%' ;

select *, FIND_IN_SET('red', belts) from divisions;  

select * from student  LIMIT 3 ; 

select * from student LIMIT 2,3;

select * from student  LIMIT 5, 5 ;  

select * from student order by name desc; -- ㅎ부터 나옴

select * from student order by name desc LIMIT 3, 3;

select jno, name from student order by jno ;

select DISTINCT jno, name from student order by jno;

select DISTINCT jno from student order by jno;

select jno from student order by jno ;

select jno, age from student order by jno, age ; 
select DISTINCT jno, age from student order by jno, age ;
select DISTINCT jno, age from student order by jno;

select DISTINCT age from student order by age; 

select sno, jno, age, name from student order by jno, age desc, sno desc; 

select 24*60*365;

select sno, name , age , (3*5000*365*age) 내밥값 from student;

select -10, ABS(-10) ;

select sno, name, age, point, (sno-point),  ABS(sno-point) from student;

select 34.56789, FLOOR(34.56789);

select FLOOR(-34.56789), FLOOR(-34.1);

select 34.56789, Truncate(34.56789, 3);

select Truncate(-34.56789, 3), Truncate(-34.1, 3);

select Truncate(-34.56789, 0), Truncate(-34.1, 0);

 select 34.56789, ROUND(34.56789), ROUND(34.123) ; 

 select ROUND(1477.56789, 3), ROUND(1577.56789, -3), ROUND(1277.56789, -3), 
		ROUND(1277.56789, -2), ROUND(1277.56789, 2) ;
        

select name, point, Floor(point), Truncate(point,1), Round(point, -2) from student;   

SELECT CEIL(10.0), CEIL(10.0423), CEIL(10.789) ;

SELECT CEIL(21/4) ; 

select name, point, age, (point/age), ceil(point/age), round(point/age) from student;

select mod(27,2);



select sno, name, age from student where not mod(age,3) = 0;

select sno,name, point,  floor(point) from student where mod(floor(point),2)=0;

select 'MySql' , UPPER('MySql'), LOWER('MySql'), LENGTH('MySql'), length('마이에스큐엘') ;

select LENGTH('My Sql'), CHAR_LENGTH('My Sql'), length('마이 에스큐엘'), CHAR_LENGTH('마이 에스큐엘') ;

select upper(name), lower(name),length(name),char_length(name) from student;

select SUBSTR('WELCOME TO MySql' , 4, 3), SUBSTR('WELCOME TO MySql' , -4, 3) ;

alter table student ADD birthday varchar(10) default "1999-09-27";
 
select * FROM student;

update student set birthday ="2001-04-06" where mod(jno , 2) = 0;

select sno, name, age, birthday from student where substr(birthday,6,2)="09" and substr(birthday,9,2)="27";

select sno, name, age from student where substr(name,1,1) in ("김","이","박");

select replace('abcd', 'a', '-xyz-') , replace('가나다라','나','-대한민국-');

SELECT LPAD('ABC',10,'#') ; 

select sno, rpad(substr(name,1,1), char_length(name),"*") name from student;

select sysdate(), now(), current_timestamp();

select DATE_FORMAT(now(), '%Y-%m-%d %H:%i:%s') as "now 24",  
	   DATE_FORMAT(now(), '%Y년 %m월 %d일 %H시 %i분 %s초') as "now 24",  	
	   DATE_FORMAT(now(), '%Y%m%d%H%i%s') as "now 24",  
	   DATE_FORMAT(sysdate(), '%Y%m%d%H%i%s') as "sysdate 24";
       

 select  sno, name, birthday, DATE_FORMAT(birthday, '%Y년 %m월 %d일') 생일 from student;     
 
 select * from student;
 select sno, name, concat(substr(name,1,1),'**') from student;
 select sno, name, replace(name,substr(name,2, (char_length(name)-1)),'**') from student;
 
 select sno, name, jno, if(jno%2=0,'짝수조','홀수조') iftest from student;
 
 select sno, name, jno, if(jno=1, '일조', if(jno=2, '이조',if(jno=3, '삼조', if(jno=4,'사조',if(jno=5,'오조','칠조'))))) 
 from student;
 
 select IFNull(Null, 123) , IFNull('Test', 123);
 
 select sno, name, address, IfNull(address,'Error') from student;

create table student5 select * from student where 1=2; -- 컬럼은 모두 오지만 데이터는 갖고 올 수 없음
select * from student5;
desc student5;

select max(sno), max(sno)+1 from student5; 

select max(sno), max(sno)+1, IfNull( max(sno),0) from student5; 

insert into student5 (sno, name, age, jno) 
values((select * from (select ifnull(max(sno),0)+1 from student5 ) as temp),"멍멍이",22,7); 
 -- 방금 만든 key 값을 알아야할 필요가 있음
 -- auto increment 는 잘 전달이 안 됨......

select sno, name , concat(point,'점'), 
case when point > 200 and point <= 500 then 'VVIP'
     when point >= 150 and point <= 200 then 'VIP'
     when point < 150 then '일반'
else 'ERROR'
end grade
from student;


select sno, name , concat(point,'점'),
case When point between  201 and 500 then 'VVIP'
     when point between 150 and 200 then 'VIP'
	 when point between 0 and 149 then '일반'
     else 'ERROR'
     end grade
     from student;

select sno, name, s.jno from student s where EXISTS ( select jno from jo j where j.jno=s.jno ); 

select sno, name, jno from student s where EXISTS (select * from jo j where j.captain = s.sno);
-- 존재 여부를 따지는 것이기에 EXISTS (select * from jo where captain = sno);에서 컬럼명은 중요하지 않음.

select sno, name, jno, replace(info, info, '조 없음') from student s 
where not exists (select * from jo j where j.jno = s.jno);

select sno, name, jno, '조없음' info from student s where not exists (select * from jo j where j.jno = s.jno);

update student s set info='조 없음' where not exists (select * from jo j where j.jno = s.jno);
select * from student;

select sno, name, jno from student where jno = 1 or jno =4 or jno = 5;

select sno, name, jno from student where jno in(1,4,5);   -- in은 or 조건식

select sno, name, jno from student where  sno IN ( select captain from jo where captain=sno );

select sno, name, jno from student where  sno IN ( select captain from jo) ;

select sno, name, s.jno, 
	Case When Exists(select 1 from jo where captain = sno ) Then  "조장"
		 Else "조원"
	End 구성	
 	from student s;
    
    select sno, name, s.jno from student s, jo j where s.sno=j.captain ;
    select * from student;
    update student set sno = 65 where sno=71;
    delete from student where sno between 34 and 36; 
    
    alter table student drop column address;
    
    start transaction;
    update student set name='홍길동';
    select sno, name from student;
    rollback;
    select * from student;
    delete from student where sno between 62 and 68;
    
ALTER TABLE student AUTO_INCREMENT=1;
SET @COUNT = 0;
UPDATE student SET sno = @COUNT:=@COUNT+1;
delete from student where sno = 25;
 
create table member(
id varchar(10) primary key,
password varchar(10) not null,
name varchar(10),
age int(3),
jno int(3),
info varchar(30),
point float(5,2),
birthday varchar(10),
rid varchar(10)
);


insert into member(id,password,name,age,jno,info,point,birthday)
select s.sno,'12345!', s.name, s.age,s.jno, s.info, s.point, s.birthday
from student s;

update member set id='csh98' where id='20';
update member set id='haerim' where id='5';
update member set id='silver' where id='16';
update member set id = "hyejin11" where name = "신혜진";
update member set id='sora' where id='1';
update member set id='ajh97' where id='10';
update member set id='ruhappy' where id='12';
update member set id="suehyun" where id='8';
update member set id="ezirenge" where id='2';
update member set id='kongbori' where id='19';
update member set id='wonee512' where id='14';
update member set id='memoire' where id='18';
update member set id='jekichan' where name='이성룡';
update member set id='papipu' where id='15';
update member set id='ajh97' where id='10';
update member set id = "nameground" where id ='3';
update member set id='jeseung' where id='13';
update member set id="ysh" where id='11';
update member set id='papipu' where id='15';
update member set id='bae87' where id='7';
update member set id='wri' where id='6';
update member set id = "zzaeminy" where id = "4";

select * from student;
select * from member;

delete from member where jno=7;

insert into student select * from student2;

create  table board (    
seq int(5) primary key AUTO_Increment,
id varchar(10) not null,
title varchar(200) not null,
content Text(2000),
regdate  datetime DEFAULT CURRENT_TIMESTAMP,
cnt int default 0
); 

insert into board(id, title, content) values("banana","Spring 이란? ","처음에 복잡하고 난해하지만 친해지면 매우 편리하다.");
insert into board(id, title, content) values("apple","spring IOC/DI? ","dependency injection_객체간의 의존관계를 객체 자신이 아닌 외부의 조립기가 수행한다.");
insert into board(id, title, content) values("coffee","스프링의 의존성 주입","설정파일은 Spring Conatainer가 어떻게 일할 지를 설정하는 파일");
insert into board(id, title, content) values("green","Spring 의 AOP? ","객체는 인터페이스에 의한 의존 관계만을 알고 있으며....");
insert into board(id, title, content) values("admin","Spring 재밌어요~~","Spring Container가 DI 조립기(Assembler)를 제공");

insert into board(id, title, content) values("banana","Spring 이란? ","처음에 복잡하고 난해하지만 친해지면 매우 편리하다.");
insert into board(id, title, content) values("apple","spring IOC/DI? ","dependency injection_객체간의 의존관계를 객체 자신이 아닌 외부의 조립기가 수행한다.");
insert into board(id, title, content) values("coffee","스프링의 의존성 주입","설정파일은 Spring Conatainer가 어떻게 일할 지를 설정하는 파일");
insert into board(id, title, content) values("green","Spring 의 AOP? ","객체는 인터페이스에 의한 의존 관계만을 알고 있으며....");
insert into board(id, title, content) values("admin","Spring 재밌어요~~","Spring Container가 DI 조립기(Assembler)를 제공");

select * from board;

select * from jo;

drop table jo;
create table jo (
   jno int(1),
   jname varchar(10) not null,
   id varchar(10) not null,  
   project varchar(20) not null,
   slogan varchar(30) not null,
   Primary Key(jno)
);

insert into jo values(1, '119', 'bae87', '펫밀리', '애완동물을 위한 홈페이지');
insert into jo values(2, '여우', 'haerim', '여우책방', '책으로 마음의 양식을♡');
insert into jo values(3, "i4", 'jeseung', "단Dog", "반려동물 한마리 한마리 모두 소중하다");
insert into jo values(4,"최고조", 'ezirenge',"tbtConcept","열정빼면 시체");
insert into jo values(5, "오조", 'wonee512', "Ojoa", "완주 아니면 죽음뿐");
insert into jo values(7, "칠면조", 'admin', "관리팀", "열심히 일하자 !!!");
select * from jo;
