CREATE DATABASE HIBERNATE;
CREATE TABLE PERSON(
  id  SERIAL PRIMARY KEY,
  last_name VARCHAR(20) DEFAULT NULL,
  first_name VARCHAR(20) DEFAULT NULL,
  middle_name VARCHAR(20) DEFAULT NULL,
  birthday DATE DEFAULT NULL,
  house_no VARCHAR(10) DEFAULT NULL,
  street VARCHAR(10) DEFAULT NULL,
  barangay VARCHAR(20) DEFAULT NULL,
  subdivision VARCHAR(20) DEFAULT NULL,
  municipality VARCHAR(20) DEFAULT NULL,
  province VARCHAR(20) DEFAULT NULL,
  zipcode INT DEFAULT NULL,
  gwa FLOAT DEFAULT NULL,
  employment_status VARCHAR(15) DEFAULT NULL
);

CREATE TABLE CONTACTINFO(
  contact_id SERIAL PRIMARY KEY,
  contact_type VARCHAR(9) DEFAULT NULL,
  contact_info varchar(40) DEFAULT NULL,
  person_id int DEFAULT NULL REFERENCES PERSON(id) ON DELETE CASCADE
);