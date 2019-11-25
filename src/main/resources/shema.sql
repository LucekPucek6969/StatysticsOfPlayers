

DROP TABLE IF EXISTS Player;

CREATE TABLE Player (
                        ID INT AUTO_INCREMENT  PRIMARY KEY,
                        NAME VARCHAR(100) DEFAULT NULL,
                        SURNAME VARCHAR(100)DEFAULT NULL,
                        SEX VARCHAR(10) DEFAULT NULL,
                        LOCATION VARCHAR(250) DEFAULT NULL,
                        TEL VARCHAR(20) DEFAULT NULL,
                        DATEOFBIRTH DATE DEFAULT NULL,
                        LICENCENUMBER VARCHAR(50) DEFAULT NULL);

