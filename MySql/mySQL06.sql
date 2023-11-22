create database tbt_concept;
use tbt_concept;

create table QnA1on1(
qna_id varchar(10) primary key auto_increment,
product_id varchar(10),
user_id varchar(25),
qna_type varchar(4) not null,
qna_phoneNum int(11) not null,
qna_reply_check varchar(3)  not null,
qna_title varchar(40) not null,
qna_content varchar(500) not null,
qna_uploadFile varchar(100),
qna_answer varchar(700),
constraint userid_fk foreign key (user_id) references user(user_id)
 on delete cascade
);

create table FAQ(
faq_id varchar(10) primary key auto_increment,
faq_title varchar(50) not null,
faq_content varchar(1000) not null,
faq_type varchar(15) not null 
);

create table News(
news_id varchar(10) primary key auto_increment,
news_title varchar(50) not null,
news_content varchar(1000) not null
);

create table Store(
store_id varchar(10) primary key,
store_address varchar(50) not null,
store_telNum varchar(50),
store_x float(25,20),
store_y float(25,20)
);


create table order (
  order_id varchar(20) primary key,
  user_id varchar(25),
  order_date datatime not nulll,
  order_receiver varchar(10) not null,
  order_receiver_avc int(10) not null,
  order_receiver_city varchar(20) not null,
  order_receiver_detail varchar(40) not null,
  order_receiver_phoneNum int(11) not null,
  order_message varchar(30),
  order_pay varchar(10) not null,
  order_coupon varchar(20),
  order_total_eachQuan int(2) not null,
  order_totalPrice int(10) not null,
  order_state varchar(4) default"입금대기",
   order_delState varchar(4) default"배송대기",
   order_delNum varchar(30) not null,
  CONSTRAINT user_fk foreign key (user_id) references user(user_id)
  on update cascade on delete cascade 
);


create table order_detail (
  order_detail_id varchar(40) primary key auto_increment,
  order_id varchar(20),
  product_id varchar(10),
  order_quan int(4) not null,
  order_price int(4) not null,
  review_state varchar(4) not null default"작성하기",
  CONSTRAINT orderid_fk foreign key (order_id) references order(order_id) 
  on delete cascade ,
  CONSTRAINT productid_fk foreign key (product_id) references product(product_id)
  on delete cascade 
);