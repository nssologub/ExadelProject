CREATE DATABASE IF NOT EXISTS ExadelProject;
USE ExadelProject;
DROP TABLE IF EXISTS Person;
CREATE TABLE Person(
id int(11) NOT NULL AUTO_INCREMENT,
firstname varchar(30),
  lastname varchar(30),
  dateOfBirth date,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee(
  id int(11) NOT NULL AUTO_INCREMENT,
  person_id int(11),
  depart_id int(11),
  PRIMARY KEY (id),
  FOREIGN KEY (person_id) REFERENCES person(id),
  FOREIGN KEY (depart_id) REFERENCES Depart(id)
);

DROP TABLE IF EXISTS Depart;
CREATE TABLE Depart (
  id int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id),
  name varchar(30)
);

DROP TABLE IF EXISTS Meetings;
CREATE TABLE Meetings (
  id int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id),
  topic varchar(30),
  description VARCHAR(30)
);

DROP TABLE IF EXISTS Meet_and_empl;
CREATE TABLE Meet_and_empl (
  empl_id INT(11),
  meet_id int(11),
  FOREIGN KEY (empl_id) REFERENCES Employee(id),
  FOREIGN KEY (meet_id) REFERENCES Meetings(id)
);

