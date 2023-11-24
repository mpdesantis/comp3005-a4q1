-- reset.sql
-- COMP 3005: Assignment 4
-- Michael De Santis
-- CUID: 101213450

--drop table students;

-- Tables
create table students (
    student_id serial,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    email varchar(255) not null unique,
    enrollment_date date, 

    primary key (student_id)
);

-- Insertion
INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');

select * from students; 
