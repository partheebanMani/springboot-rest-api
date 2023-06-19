DROP TABLE IF EXISTS Student;
CREATE TABLE Student(
    id int auto_increment primary key,
    name varchar(50) not null,
    department varchar(50) not null,
    college varchar(50) not null
);