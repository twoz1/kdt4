use mydb;
select * from student;
Create Table test1 as select * from student;
select*from test1;
desc test1;
Create Table test3 as select * from student where sno >=2;
select * from test3;
create table test4 as select sno from student where sno < 7;
select * from test4;
create table test5 as select * from student where 1=2;
select * from test5;
desc test5;
insert into test5(sno,name) select sno,name from student;
select * from test5;
insert into test(name,age) select name,age from student;
select * from test;
rename table test to newtest;
select * from test;
select * from newtest;
truncate newtest;
select * from newtest;
desc new newtest;

