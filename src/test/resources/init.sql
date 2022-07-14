DROP TABLE IF EXISTS `STUDENTS`;
CREATE TABLE `STUDENTS` (
                            `ID` int NOT NULL AUTO_INCREMENT,
                            `FIRST_NAME` varchar(25) NOT NULL,
                            `MIDDLE_NAME` varchar(25) DEFAULT NULL,
                            `LAST_NAME` varchar(25) NOT NULL,
                            `DATE_OF_BIRTH` date NOT NULL,
                            PRIMARY KEY (`ID`)
)