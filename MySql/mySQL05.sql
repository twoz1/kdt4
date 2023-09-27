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
 
 
        