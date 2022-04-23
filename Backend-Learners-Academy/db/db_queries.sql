use bla;

create table subjects(id int, name varchar(20) not null, grade_points int not null,
PRIMARY KEY(id));

create table class(id int, sub_id int, name varchar(20),
primary key(id),
foreign key(sub_id) references subjects(id));
//Latest Class
create table class(id int, sub_id int, name varchar(20), section varchar(2),
primary key(id, sub_id),
foreign key(sub_id) references subjects(id));

create table students(id int, class_id int, name varchar(25), roll_no int,
primary key(id),
foreign key(class_id) references class(id));

create table teachers(id int, class_id int, sub_id int, name varchar(25), email_id varchar(25),
primary key(id),
foreign key(class_id) references class(id),
foreign key(sub_id) references subjects(id));