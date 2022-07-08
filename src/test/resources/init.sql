DROP TABLE IF EXISTS `STUDENTS`;
CREATE TABLE `STUDENTS` (
                            `ID` int NOT NULL AUTO_INCREMENT,
                            `FIRST_NAME` varchar(25) NOT NULL,
                            `MIDDLE_NAME` varchar(25) DEFAULT NULL,
                            `LAST_NAME` varchar(25) NOT NULL,
                            `DATE_OF_BIRTH` date NOT NULL,
                            PRIMARY KEY (`ID`)
)




/*CREATE SCHEMA IF NOT EXIST test
CREATE TABLE STUDENTS (ID  SMALLINT NOT NULL, FIRST_NAME VARCHAR(40), MIDDLE_NAME VARCHAR(40), LAST_NAME VARCHAR(40), DATE_OF_BIRTH DATE)
CREATE USER 'root'@'localhost' IDENTIFIED BY 'rootpassword';
GRANT ALL PRIVILEGES ON test.* TO 'root'@'%' */