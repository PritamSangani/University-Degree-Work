--Drop all tables
DROP TABLE reservationRecord;
DROP TABLE enquiryRecord;
DROP TABLE rentalRecord;
DROP TABLE customersRecord;
DROP TABLE soldbikesRecord;
DROP TABLE maintenanceRecord;
DROP TABLE suppliedPartsRecord;
DROP TABLE orderedPartsRecord;
DROP TABLE bikePartsRecord;
DROP TABLE dealerRecord;
DROP TABLE faultReportRecord;
DROP TABLE bikeRecord;
DROP TABLE classSizeRecord;
DROP TABLE manufacturerRecord;

--Script to create all tables in the database
alter session set nls_date_format = 'DD-MM-YYYY HH24:MI';
CREATE TABLE customersRecord
(
    customerID NUMBER(9) PRIMARY KEY,
    customerSurname VARCHAR2(30) NOT NULL,
    customerForename VARCHAR2(30),
    customerAddress VARCHAR2(45),
    customerPostcode VARCHAR2(8) NOT NULL,
    customerPhoneNumber NUMBER(13) NOT NULL UNIQUE,
    customerEmail VARCHAR2(45) UNIQUE
);

CREATE TABLE enquiryRecord
(
    enquiryID    NUMBER(9)    PRIMARY KEY,
    customerID    NUMBER(9)    REFERENCES customersRecord(customerID),
    enquiryDate    DATE,
    enquiryDesc    VARCHAR2(140)
);

CREATE TABLE classSizeRecord
(
    classSizeID		NUMBER(9)	PRIMARY KEY,
    bikeClass    	VARCHAR2(15),	
    bikeSize		  VARCHAR2(20),	
    fullDayRate		DECIMAL(5,2),
    halfDayRate		DECIMAL(5,2)
);

CREATE TABLE reservationRecord
(
	reservationID	NUMBER(9)	PRIMARY KEY,
	customerID	NUMBER(9)	REFERENCES customersRecord(customerID),
	classSizeID	NUMBER(9)	REFERENCES classSizeRecord(classSizeID),
	bikeQuantity	NUMBER(3)
);

CREATE TABLE manufacturerRecord
(
    manufacturerID    NUMBER(9)    PRIMARY KEY,
    manufacturerName    VARCHAR2(45)    NOT NULL,
    manufacturerAddress    VARCHAR2(45)    NOT NULL,
    manufacturerPhoneNumber    NUMBER(13)    NOT NULL UNIQUE
);

CREATE TABLE bikeRecord
(
	bikeID		    NUMBER(9)	PRIMARY KEY,
    classSizeID    NUMBER(9)    REFERENCES classSizeRecord(classSizeID),
    manufacturerID    NUMBER(9)    REFERENCES manufacturerRecord(manufacturerID),
	bikeModel		VARCHAR2(20)    NOT NULL,
    bikePurchaseDate	DATE    NOT NULL,
 	bikeCost		DECIMAL(7)
);

CREATE TABLE rentalRecord
(
	rentalID		NUMBER(9)	PRIMARY KEY,
    bikeID          NUMBER(9)    REFERENCES bikeRecord(bikeID),
    customerID      NUMBER(9)    REFERENCES customersRecord(customerID),
	timeCheckedOut	DATE	NOT NULL,
    timeCheckedIn	DATE    NOT NULL,
 	timeDue		    DATE	NOT NULL,
 	amountPaid		DECIMAL(5,2)
);

CREATE TABLE dealerRecord
(
	dealerID		NUMBER(9)	PRIMARY KEY,
	dealerName		VARCHAR2(30)	NOT NULL,
	dealerAddress	VARCHAR2(45),
	dealerPhoneNumber NUMBER	NOT NULL UNIQUE
);

CREATE TABLE soldBikesRecord
(
    soldBikeID    NUMBER(9)    PRIMARY KEY,
    dealerID    NUMBER(9)    REFERENCES dealerRecord(dealerID),
    bikeID    NUMBER(9)    REFERENCES bikeRecord(bikeID),
    dateSold    DATE    NOT NULL,
    bikeSalePrice    DECIMAL(7,2)
);

CREATE TABLE bikePartsRecord
(
    partID        NUMBER(9)    PRIMARY KEY,
    manufacturerID    NUMBER(9)    REFERENCES manufacturerRecord(manufacturerID),
    partName      VARCHAR2(30) NOT NULL,
    partQuantity    NUMBER(5)  NOT NULL  
);

CREATE TABLE faultReportRecord
(
	faultID		NUMBER(9)	PRIMARY KEY,
    bikeID    NUMBER(9)    REFERENCES bikeRecord(bikeID),
	faultDate		DATE,
	faultDesc		VARCHAR2(140)
);

CREATE TABLE maintenanceRecord
(
	maintenanceID	NUMBER(9)	PRIMARY KEY,
    bikeID    NUMBER(9)    REFERENCES bikeRecord(bikeID),
    partID    NUMBER(9)    REFERENCES bikePartsRecord(partID),
    faultID    NUMBER(9)    REFERENCES faultReportRecord(faultID),
    dateOfAction	DATE,
 	actionTaken		VARCHAR2(140)
);

CREATE TABLE orderedPartsRecord
(
	orderID	  NUMBER(9)	PRIMARY KEY,
    partID    NUMBER(9)    REFERENCES bikePartsRecord(partID),
	partsQtyOrdered    NUMBER(30)    NOT NULL,
    dateBought    DATE
);

CREATE TABLE suppliedPartsRecord
(
    suppliedPartsID    NUMBER(9)    PRIMARY KEY,
    orderID    NUMBER(9)    REFERENCES orderedPartsRecord(orderID),
    partID    NUMBER(9)    REFERENCES bikePartsRecord(partID)
);

-- script to populate data into tables

--INSERT INTO customersRecord

INSERT INTO customersRecord
VALUES (1, 'Myers', 'Maddison', '8 Scrimshire Lane, Aston','CW5 5RL', '07802228593', 'MaddisonMyers@gmail.com');
INSERT INTO customersRecord
VALUES (2, 'Holmes', 'Ella', '82 Spilman Street, Gowkhall', 'KY12 2WA', '07944216052', 'ella.holmes@hotmail.co.uk');
INSERT INTO customersRecord
VALUES (3, 'Marshall', 'Jamie', '10 Town Lane, South Kirkton', 'AB32 2PW', '07974196960', 'jmarshall@yahoo.co.uk');
INSERT INTO customersRecord
VALUES(4, 'Kennedy', 'James', '5 Front Street, Hemington', 'PE8 2AQ', '07979699371', 'jamesk@gmail.com');
INSERT INTO customersRecord
VALUES(5, 'Evans', 'Isabel', '78 Wartnaby Road, Adlington', 'SK10 9AF', '07007669494', 'i.evans@gmail.com');
INSERT INTO customersRecord
VALUES(6, 'Booth', 'Victoria', '3 Thornton Street, Hunstrete', 'BS18 6HG', '07044126449', 'vickybooth@gmail.com');
INSERT INTO customersRecord
VALUES(7, 'Whittaker', 'Archie', '49 Nenthead Road, High Buston', 'NE66 8YY', '07818590823', 'archie66@hotmail.co.uk');
INSERT INTO customersRecord
VALUES(8, 'Henderson', 'Alicia', '25 Eastbourne Road, ColdHarbour', 'RH5 6FS', '07844271893', 'aliciaHenderson@gmail.com');
INSERT INTO customersRecord
VALUES(9, 'Metcalfe', 'Rachel', '92 South Western Terrace, Milton', 'FK21 5ZT', '07853525568', 'rachelmetcalfe@hotmail.co.uk');
INSERT INTO customersRecord
VALUES(10, 'Lovecraft', 'Howard', '45 RedBrick Road, Arkham', 'SN8 7HP', '07835051890', 'hpLoveCraft@gmail.com');

--INSERT INTO enquiryRecord

INSERT INTO enquiryRecord
VALUES (1,1,(TO_DATE('02212017', 'MMDDYYYY')),'What types of bikes do you have?');
INSERT INTO enquiryRecord
VALUES (2,2,(TO_DATE('03102016', 'MMDDYYYY')),'Do you have a half day rate?');
INSERT INTO enquiryRecord
VALUES (3,6,(TO_DATE('10202016', 'MMDDYYYY')),'Can we reserve more than 10 bikes?');
INSERT INTO enquiryRecord
VALUES (4,9,(TO_DATE('11012016', 'MMDDYYYY')),'Are there any special offers?');

--INSERT INTO classSizeRecord

INSERT INTO  classSizeRecord
VALUES (1,'Mountain', 'Standard Male','20.00','12.50');
INSERT INTO  classSizeRecord
VALUES (2,'Mountain','Large Male','21.00','13.00');
INSERT INTO  classSizeRecord
VALUES (3,'Mountain','Standard Female','18.00','11.00');
INSERT INTO  classSizeRecord
VALUES (4,'Mountain','Child','15.00','8.00');
INSERT INTO  classSizeRecord
VALUES (5,'Road','Standard Male','22.00','14.00');
INSERT INTO  classSizeRecord
VALUES (6,'Road','Large Male','23.00','15.00');
INSERT INTO  classSizeRecord
VALUES (7,'Road','Standard Female','20.00','13.00');
INSERT INTO  classSizeRecord
VALUES (8,'Road','Child','17.00','10.00');
INSERT INTO  classSizeRecord
VALUES (9,'Tandem','Standard Male','22.00','14.00');
INSERT INTO  classSizeRecord
VALUES (10,'Tandem','Standard Female','20.00','13.00');

--INSERT INTO reservationRecord

INSERT INTO reservationRecord
VALUES (1,1,1,5);
INSERT INTO reservationRecord
VALUES (2,2,2,1);
INSERT INTO reservationRecord
VALUES (3,3,3,4);
INSERT INTO reservationRecord
VALUES (4,4,4,8);
INSERT INTO reservationRecord
VALUES (5,5,5,3);
INSERT INTO reservationRecord
VALUES (6,6,6,2);
INSERT INTO reservationRecord
VALUES (7,7,7,10);
INSERT INTO reservationRecord
VALUES (8,8,8,3);
INSERT INTO reservationRecord
VALUES (9,9,9,4);
INSERT INTO reservationRecord
VALUES (10,10,10,2);

--INSERT INTO manufacturerRecord

INSERT INTO manufacturerRecord
VALUES (1,'Cycleurope', 'Lantmannagatan 59, Stockholm', '0427719314');
INSERT INTO manufacturerRecord
VALUES (2,'Pashley', '174 Margaret Street, Stratford-upon-Avon', '1789292263');
INSERT INTO manufacturerRecord
VALUES (3,'Bromton', '64 Guild Street, London', '07071989349');
INSERT INTO manufacturerRecord
VALUES (4,'Brooks', '97 Crown Street, London', '07042992306');
INSERT INTO manufacturerRecord
VALUES (5,'MiddleBurn', '56 Cunnery Rd, Manchester', '07080425568');

--INSERT INTO bikeRecord

INSERT INTO bikeRecord
VALUES (1,2,1,'Activ I',(TO_DATE('02212017', 'MMDDYYYY')),'350');
INSERT INTO bikeRecord
VALUES (2,2,2,'Sportsman Ladies',(TO_DATE('06102016', 'MMDDYYYY')),'170');
INSERT INTO bikeRecord
VALUES (3,2,1,'Activ II',(TO_DATE('05022016', 'MMDDYYYY')),'450');
INSERT INTO bikeRecord
VALUES (4,1,5,'Apollo',(TO_DATE('11222015', 'MMDDYYYY')),'670');
INSERT INTO bikeRecord
VALUES (5,2,4,'Teman',(TO_DATE('11232015', 'MMDDYYYY')),'300');
INSERT INTO bikeRecord
VALUES (6,2,2,'Sportsman Men',(TO_DATE('01122017', 'MMDDYYYY')),'175');
INSERT INTO bikeRecord
VALUES (7,4,4,'Ribble',(TO_DATE('01122017', 'MMDDYYYY')),'1229');
INSERT INTO bikeRecord
VALUES (8,4,5,'Mtrax',(TO_DATE('08012016', 'MMDDYYYY')),'900');
INSERT INTO bikeRecord
VALUES (9,2,1,'Ribble II',(TO_DATE('10202016', 'MMDDYYYY')),'3450');
INSERT INTO bikeRecord
VALUES (10,5,5,'Viking',(TO_DATE('04162014', 'MMDDYYYY')),'300');
INSERT INTO bikeRecord
VALUES (11, 4, 3, 'Carerra Subway 1', (TO_DATE('01202015', 'MMDDYYYY')), '400');

--INSERT INTO rentalRecord

INSERT INTO rentalRecord
VALUES (1,2,1,TO_DATE('21/02/2017 09:00', 'DD-MM-YYYY HH24:MI') ,TO_DATE('21/02/2017 15:00', 'DD-MM-YYYY HH24:MI'),TO_DATE('21/02/2017 15:30', 'DD-MM-YYYY HH24:MI'), 22.00);
INSERT INTO rentalRecord
VALUES (2,3,1,TO_DATE('21/02/2017 09:00', 'DD-MM-YYYY HH24:MI') ,TO_DATE('21/02/2017 15:00', 'DD-MM-YYYY HH24:MI'),TO_DATE('21/02/2017 15:30', 'DD-MM-YYYY HH24:MI'),22.00);
INSERT INTO rentalRecord
VALUES (3,4,2,TO_DATE('21/02/2017 11:00', 'DD-MM-YYYY HH24:MI') ,TO_DATE('21/02/2017 19:00', 'DD-MM-YYYY HH24:MI'),TO_DATE('21/02/2017 19:30', 'DD-MM-YYYY HH24:MI'),32.00);
INSERT INTO rentalRecord
VALUES (4,5,3,TO_DATE('21/02/2017 07:00', 'DD-MM-YYYY HH24:MI') ,TO_DATE('21/02/2017 13:00', 'DD-MM-YYYY HH24:MI'),TO_DATE('21/02/2017 13:30', 'DD-MM-YYYY HH24:MI'),21.00);


--INSERT INTO dealerRecord

INSERT INTO dealerRecord
VALUES (1, 'Joes Junk', '15 Back Lane, Buxton', '0736553422');
INSERT INTO dealerRecord
VALUES (2, 'Bad Ass Bikes', '6 Ham Link, Bristol', '01761462011');
INSERT INTO dealerRecord
VALUES (3, 'Dales Cycles', '150 Dobbies Loan, Glasgow', '01413322705');
INSERT INTO dealerRecord
VALUES (4, 'Hargroves Cycles', '106 - 108 The Hornet, West Sussex', '01243537337');
        
--INSERT INTO soldBikesRecord
        
INSERT INTO soldBikesRecord
VALUES(1, 1, 10, (TO_DATE('04202016','MMDDYYYY')), '50.50');
INSERT INTO soldBikesRecord
VALUES(2, 3, 11, (TO_DATE('02252017', 'MMDDYYYY')), '60.50');
        
--INSERT INTO bikePartsRecord
        
INSERT INTO bikePartsRecord
VALUES (1,2,'Frame','10');
INSERT INTO bikePartsRecord
VALUES (2,1,'Brakes','50');
INSERT INTO bikePartsRecord
VALUES (3,4,'Wheels','60');
INSERT INTO bikePartsRecord
VALUES (4,5,'Pedals','80');
INSERT INTO bikePartsRecord
VALUES (5,3,'Handlebar','15');

--INSERT INTO faultReportRecord

INSERT INTO faultReportRecord
VALUES (1,1,(TO_DATE('10022017','MMDDYYYY')),'faulty brakes');
INSERT INTO faultReportRecord
VALUES (2,4,(TO_DATE('01222017','MMDDYYYY')),'faulty pedals');

--INSERT INTO maintenanceRecord

INSERT INTO maintenanceRecord
VALUES (1,3,5,2,(TO_DATE('01122017','MMDDYYYY')),'parts havent arrived yet');
INSERT INTO maintenanceRecord
VALUES (4,2,1,2,(TO_DATE('01122017','MMDDYYYY')),'bike 100% fixed');

--INSERT INTO orderedPartsRecord

INSERT INTO orderedPartsRecord
VALUES (1,2,'30',(TO_DATE('07122016', 'MMDDYYYY')));
INSERT INTO orderedPartsRecord
VALUES (2,5,'10',(TO_DATE('11102016', 'MMDDYYYY')));
INSERT INTO orderedPartsRecord
VALUES (3,3,'15',(TO_DATE('03022016', 'MMDDYYYY')));
INSERT INTO orderedPartsRecord
VALUES (4,1,'10',(TO_DATE('10092016', 'MMDDYYYY')));
INSERT INTO orderedPartsRecord
VALUES (5,4,'20',(TO_DATE('04062016', 'MMDDYYYY')));

--INSERT INTO suppliedPartsRecord

INSERT INTO suppliedPartsRecord
VALUES (1,3,5);
INSERT INTO suppliedPartsRecord
VALUES (3,1,3);
        
 --QUERIES 
alter session set nls_date_format = 'DD-MM-YYYY';
--Yusof Bandar
SELECT (BIKERECORD.BIKEMODEL || '  '|| CLASSSIZERECORD.BIKECLASS || ' Bike') AS "Bike Model", ('£'||CLASSSIZERECORD.FULLDAYRATE) AS "Full Day Rate", ('£'||CLASSSIZERECORD.HALFDAYRATE) AS "Half Day Rate"
FROM BIKERECORD
INNER JOIN CLASSSIZERECORD
ON BIKERECORD.CLASSSIZEID = CLASSSIZERECORD.CLASSSIZEID;

SELECT BIKEID AS "Bike ID", ('£' ||BIKECOST) AS "Bike Cost", BIKEPURCHASEDATE AS "Bike Purchase Date"
FROM BIKERECORD
WHERE BIKEPURCHASEDATE <= add_months( sysdate, -12*2 )
ORDER BY BIKEPURCHASEDATE;
--Pritam Sangani
SELECT BIKERECORD.BIKEID AS "Bike ID", BIKERECORD.BIKEMODEL AS "Bike Model",MAINTENANCERECORD.DATEOFACTION AS "Date of Action", MAINTENANCERECORD.ACTIONTAKEN AS "Action Taken"
FROM BIKERECORD
INNER JOIN MAINTENANCERECORD
ON BIKERECORD.BIKEID = MAINTENANCERECORD.BIKEID
ORDER BY MAINTENANCERECORD.DATEOFACTION DESC;

SELECT (CUSTOMERFORENAME ||' ' ||CUSTOMERSURNAME  ) AS "Customer Name", ('0'||CUSTOMERPHONENUMBER) AS "Customer Phone Number", (CUSTOMERADDRESS ||', '|| CUSTOMERPOSTCODE) AS "Customer Address" 
FROM CUSTOMERSRECORD
ORDER BY CUSTOMERSURNAME;
--Naim Ahmed
SELECT MANUFACTURERNAME AS "Manufacturer Name", MANUFACTURERADDRESS AS "Manufacturer Address", ('0'||MANUFACTURERPHONENUMBER) AS "Manufacturer Phone Number"
FROM MANUFACTURERRECORD;
--Faran Azadi
SELECT ('£' ||SUM(BIKESALEPRICE)) AS "Total Money From Bike Sales" FROM SOLDBIKESRECORD;
--Aamer Atique
SELECT ENQUIRYDATE AS "Date of Enquiry", ENQUIRYDESC AS "Enquiry Description"
FROM ENQUIRYRECORD
ORDER BY ENQUIRYDATE;       
