use cms;

DROP TABLE IF EXISTS Menu;

CREATE TABLE Menu (
  MEN_ID int(10)  NOT NULL AUTO_INCREMENT,
  MEN_ITEM varchar(50) DEFAULT NULL,
  MEN_PRICE numeric(9,2),
  MEN_CALORIES double NOT NULL,
  MEN_SPECIALITY varchar(50) NOT NULL,
  PRIMARY KEY (MEN_ID)
);


insert into MENU set MEN_ITEM='CHICKEN BIRIYANI', MEN_CALORIES=750 , MEN_SPECIALITY='NON-VEG', MEN_PRICE=856;
insert into MENU set MEN_ITEM='CHICKEN 65', MEN_CALORIES=500 , MEN_SPECIALITY='NON-VEG',MEN_PRICE=674;
insert into MENU set MEN_ITEM='GOBI MANCHURIAN', MEN_CALORIES=650 , MEN_SPECIALITY='VEG',MEN_PRICE=684;
insert into MENU set MEN_ITEM='CHICKEN MANCHURIAN', MEN_CALORIES=750 , MEN_SPECIALITY='NON-VEG',MEN_PRICE=999;
insert into MENU set MEN_ITEM='FISH', MEN_CALORIES=850 , MEN_SPECIALITY='NON-VEG',MEN_PRICE=901;
insert into MENU set MEN_ITEM='DAHI BHALLE', MEN_CALORIES=150 , MEN_SPECIALITY='VEG',MEN_PRICE=111;
insert into MENU set MEN_ITEM='MIX PRANTHA', MEN_CALORIES=360 , MEN_SPECIALITY='VEG',MEN_PRICE=911;
insert into MENU set MEN_ITEM='GOL GAPPE', MEN_CALORIES=170 , MEN_SPECIALITY='VEG',MEN_PRICE=901;
insert into MENU set MEN_ITEM='PRAWN BIRYANI', MEN_CALORIES=580 , MEN_SPECIALITY='NON-VEG',MEN_PRICE=901;
insert into MENU set MEN_ITEM='THAI NOODLES', MEN_CALORIES=660 , MEN_SPECIALITY='VEG',MEN_PRICE=744;

SELECT * FROM Menu;

SELECT M.MEN_ID,M.MEN_ITEM,M.MEN_PRICE,M.MEN_CALORIES,M.MEN_SPECIALITY
FROM MENU M;

DROP TABLE IF EXISTS Customer;

-- Creating Customer table
 CREATE TABLE Customer (
  CUS_ID int(10) NOT NULL AUTO_INCREMENT,
  CUS_NAME varchar(50) NOT NULL,
  CUS_PHN_NO varchar(50) NOT NULL,
  CUS_USERNAME varchar(50) NOT NULL,
  CUS_PASSWORD varchar(50) NOT NULL,
  CUS_EMAIL varchar(50) NOT NULL,
  PRIMARY KEY (CUS_ID),
  UNIQUE KEY CUS_PHN_NO (CUS_PHN_NO),
  UNIQUE KEY CUS_USERNAME (CUS_USERNAME)
);

-- customer table 
INSERT INTO CUSTOMER(CUS_NAME,CUS_PHN_NO,CUS_USERNAME,CUS_PASSWORD,CUS_EMAIL) 
VALUES ('Prasanna Pappu','9381413089','prassucp','hexaware@', 'prassucp@gmail.com'),
       ('Krishna Kumar','8939391144','krishnak','chennai@123', 'krishnak@gmail.com'),
       ('Renu Srivastav','8755144556','Renu','ghazi@117', 'renusan@gmmail.com');

select C.CUS_ID,
	   C.CUS_NAME,C.CUS_PHN_NO,
       C.CUS_USERNAME,
       CUS_PASSWORD,
       CUS_EMAIL
FROM CUSTOMER C;

DROP TABLE IF EXISTS WALLET;
-- Creating Wallet table
 CREATE TABLE Wallet (
  CUS_ID int(10) unsigned DEFAULT NULL REFERENCES CUSTOMER(CUS_ID),
  WAL_ID int(10) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  WAL_AMOUNT double unsigned NOT NULL,
  WAL_SOURCE enum('PAYTM','CREDIT_CARD','DEBIT_CARD') DEFAULT 'DEBIT_CARD',
  UNIQUE KEY(CUS_ID,WAL_SOURCE)
);

-- wallet table
INSERT INTO WALLET(CUS_ID,WAL_AMOUNT,WAL_SOURCE) 
VALUES (1,2000.00,'PAYTM'),
       (1,3000.00,'DEBIT_CARD'),
       (1,5602.36,'CREDIT_CARD'),
       (2,4500.36,'DEBIT_CARD'),
       (3,485.23,'CREDIT_CARD'),
       (2,3000,'CREDIT_CARD'),
       (2,4560,'PAYTM'),
       (3,56.36,'PAYTM'),
       (3,4566,'DEBIT_CARD');


SELECT * FROM WALLET;



-- creating vendor table
 CREATE TABLE `vendor` (
  `VEN_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `VEN_NAME` varchar(50) NOT NULL,
  `VEN_PHN_NO` varchar(40) NOT NULL,
  `VEN_USERNAME` varchar(40) NOT NULL,
  `VEN_PASSWORD` varchar(30) NOT NULL,
  `VEN_EMAIL` varchar(50) NOT NULL,
  `VEN_BALANCE` double DEFAULT NULL,
  PRIMARY KEY (`VEN_ID`)
) ;