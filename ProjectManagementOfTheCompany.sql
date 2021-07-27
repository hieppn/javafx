DROP DATABASE IF EXISTS PROJECT;
CREATE DATABASE PROJECT;
USE PROJECT;
 
CREATE TABLE USERS (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    FIRSTNAME VARCHAR(50) NOT NULL,
    LASTNAME VARCHAR(50) NOT NULL,
    EMAIL VARCHAR(50) NOT NULL,
    USERNAME VARCHAR(50) NOT NULL,
    PASSWORD VARCHAR(50) NOT NULL,
    POSITION VARCHAR(50) NOT NULL ,
    GENDER VARCHAR(50) NOT NULL CHECK(GENDER = "Male" or GENDER = "Female"),
    BIRTHDAY DATE,
    PHONE_NUMBER VARCHAR(15),
    ADDRESS VARCHAR(50)
);
INSERT INTO USERS VALUES(1,"June","June","admin@gmail.com","admin","admin", "Manager","Male", '2000-06-25', "0981536770", "Binh Dinh");
INSERT INTO USERS VALUES(2,"Ngan","Tran","ngantran@gmail.com","ngantran","123456", "Leader","Female", '2000-06-01', "0397739302", "Binh Dinh");
INSERT INTO USERS VALUES(3,"Nguyet","Nguyen","nguyetnguyen@yahoo.com","nguyetnguyen","123456", "Leader","Female", '2000-09-09', "0909768382", "Quang Tri");
INSERT INTO USERS VALUES(4,"Hiep","Bui","hiepbui@gmai.com","hiepbui","123456", "Team member","Male", '2000-06-25', "0981536770", "Binh Dinh");
INSERT INTO USERS VALUES(5,"Quang","Nguyen","quang.nguyen@gmail.com","quangnguyen","quang", "Leader","Male", '2000-07-25', "0981536770", "Quang Nam");
INSERT INTO USERS VALUES(6,"Hai","Tran","hai.tran@gmail.com","haitran","hai", "Leader","Male", '2000-06-25', "0981536770", "Hue");
INSERT INTO USERS VALUES(7,"Nguyen","Dang","nguyen.dang@gmail.com","nguyendang","nguyen", "Team Member","Male", '2000-06-2', "0942686710", "Ha Noi");
INSERT INTO USERS VALUES(8,"Tan","Nguyen","tan.nguyen@gmail.com","tannguyen","tan", "Team Member","Female", '2000-09-22', "0987541270", "Quang Tri");
INSERT INTO USERS VALUES(9,"Khoa","Dong","khoa.dong@gmail.com","khoadong","khoa", "Team Member","Male", '2000-06-19', "0981575421", "Da Nang");
INSERT INTO USERS VALUES(10,"Tung","Bui","tung.bui@gmail.com","tungbui","tung", "Team Member","Female", '2000-07-24', "0981575426", "Da Nang");
select*from USERS;

DROP table if exists PROJECT1;
CREATE TABLE PROJECT1(
PROJECTID int  auto_increment primary KEY,
PROJECTNAME VARCHAR(100),
LOCATION VARCHAR(100)
);

INSERT INTO PROJECT1( PROJECTNAME, LOCATION)
VALUES
('Website design for selling books', 'Hai Phong'),
('Web design English courses','Da Nang'),
('Mobile software development','TP.HCM'),
('Check out the mobile application','Ha Noi'),
('Smart application programming','Da Nang'),
('Grab application development','TP.Vinh'),
('Manage loan applications', 'Da Nang');

SELECT * FROM PROJECT1;

DROP table if exists ASSIGNMENT;
CREATE TABLE ASSIGNMENT(
EMPID int,
PROJECTID int 
);

INSERT INTO ASSIGNMENT(EMPID, PROJECTID)
VALUES 
(2,1),
(3,2),
(4,2),
(5,3),
(6,4),
(7,5),
(8,6),
(9,7),
(10,7);
SELECT * FROM ASSIGNMENT;

SELECT U.ID, U.FIRSTNAME, U.LASTNAME, U.EMAIL, U.POSITION, U.GENDER, U.BIRTHDAY, U.PHONE_NUMBER ,U.ADDRESS, A.PROJECTID
FROM USERS U, PROJECT1 P, ASSIGNMENT A
WHERE U.ID = A.EMPID AND P.PROJECTID = A.PROJECTID 

