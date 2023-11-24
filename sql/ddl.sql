-- ddl.sql
-- COMP 3005: Assignment 4
-- Michael De Santis
-- CUID: 101213450

-- Tables
create table students (
    student_id serial,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    email varchar(255) not null unique,
    enrollment_date date, 

    primary key (student_id)
);
