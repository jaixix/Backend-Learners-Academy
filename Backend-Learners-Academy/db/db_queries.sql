use bla;

--Latest Subject
create table subjects(id int, name varchar(20) not null, grade_points int not null,
PRIMARY KEY(id));

--Old Class
create table class(id int, sub_id int, name varchar(20),
primary key(id),
foreign key(sub_id) references subjects(id));

--Latest Class
create table class(id int, sub_id int, name varchar(20), section varchar(2),
primary key(id, sub_id),
foreign key(sub_id) references subjects(id));

--Old Student
create table students(id int, class_id int, name varchar(25), roll_no int,
primary key(id),
foreign key(class_id) references class(id));

--Latest Student
 create table students(id int, class_id int, firstName varchar(25), lastName varchar(25), roll_no int
 primary key(id)
 foreign key(class_id) references class(id));

--Old Teacher
create table teachers(id int, class_id int, sub_id int, name varchar(25), email_id varchar(25),
primary key(id),
foreign key(class_id) references class(id),
foreign key(sub_id) references subjects(id));

--Latest Teacher
create table teachers(id int, class_id int, sub_id int, firstName varchar(25), lastName varchar(25), emailId varchar(25),
primary key(id, class_id),
foreign key(class_id) references class(id),
foreign key(sub_id) references subjects(id));