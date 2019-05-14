CREATE database maryandamy;

CREATE TABLE `baker` (
    `bakerID` int(10) NOT NULL AUTO_INCREMENT,
    `companyName` varchar(50) NOT NULL,
    `password` varchar(50) NOT NULL,
    `addressLine1` varchar(50) NOT NULL,
    `addressLine2` varchar(50) NOT NULL,
    `county` varchar(50) NOT NULL,
    `postcode` varchar(15) NOT NULL,
    `pictureCount` int(50) NOT NULL,
    `isApproved` tinyint(1) NOT NULL,
    `servedArea` int(2) NOT NULL,
    `logo` varchar(255),
    `website` varchar(255),
    `shopPhoneNumber` varchar(11) NOT NULL,
    `businessType` varchar(50) NOT NULL,
    `minNoticeTime` int(2),
    `adminName` varchar(50) NOT NULL,
    `adminEmail` varchar(50) NOT NULL,
    `contactName` varchar(50) NOT NULL,
    `contactEmail` varchar(50) NOT NULL,
    `facebookPage` varchar(50),
    PRIMARY KEY (bakerID));

CREATE TABLE `customer` (
  `customerID` int(10) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `addressLine1` varchar(50) NOT NULL,
  `addressLine2` varchar(50),
  `county` varchar(50) NOT NULL,
  `postcode` varchar(55) NOT NULL,
  PRIMARY KEY (customerID));

CREATE TABLE `product` (
    `productID` int(10) NOT NULL AUTO_INCREMENT,
    `bakerID` int(10) NOT NULL,
    `price` int(10) NOT NULL,
    `description` varchar(1000),
    PRIMARY KEY (productID),
    CONSTRAINT FK_BakerProduct FOREIGN KEY (bakerID) REFERENCES baker(bakerID));

CREATE TABLE `enquiry` (
    `enquiryID` int(10) NOT NULL AUTO_INCREMENT,
    `customerID` int(10) NOT NULL,
    `description` varchar(1000) NOT NULL,
    `priceRange` int(10),
    `dueBy` DATE,
    PRIMARY KEY (enquiryID),
    CONSTRAINT FK_CustomerEnquiry FOREIGN KEY (customerID) REFERENCES customer(customerID));

CREATE TABLE `job` (
    `jobID` int(10) NOT NULL AUTO_INCREMENT,
    `bakerID` int(10) NOT NULL,
    `customerID` int(10) NOT NULL,
    `productID` int(10),
    `enquiryID` int(10) NOT NULL,
    `price` int(10) NOT NULL,
    `isComplete` TINYINT(1),
    PRIMARY KEY(jobID),
    CONSTRAINT FK_BakerJob FOREIGN KEY (bakerID) REFERENCES baker(bakerID),
    CONSTRAINT FK_CustomerJob FOREIGN KEY (customerID) REFERENCES customer(customerID),
    CONSTRAINT FK_ProductJob FOREIGN KEY (productID) REFERENCES product(productID),
    CONSTRAINT FK_EnquiryJob FOREIGN KEY (enquiryID) REFERENCES enquiry(enquiryID));

CREATE TABLE `review` (
    `reviewID` int(10) NOT NULL AUTO_INCREMENT,
    `jobID` int(10) NOT NULL,
    `description` varchar(1000),
    `rating` int(10) NOT NULL,
    `date` DATE NOT NULL,
    PRIMARY KEY (reviewID),
    CONSTRAINT FK_JobReview FOREIGN KEY (jobID) REFERENCES job(jobID));

CREATE TABLE `enquireBaker` (
    `enquireBakerID` int(10) NOT NULL AUTO_INCREMENT,
    `bakerID` int(10) NOT NULL,
    `enquiryID` int(10) NOT NULL,
    `customerAccept` TINYINT(1),
    `bakerAccept` TINYINT(1),
    PRIMARY KEY (enquireBakerID),
    CONSTRAINT FK_EnquiryEnquire FOREIGN KEY (enquiryID) REFERENCES enquiry(enquiryID),
    CONSTRAINT FK_BakerEnquire FOREIGN KEY (bakerID) REFERENCES  baker(bakerID));

CREATE TABLE `payment` (
    `paymentID` int(10) NOT NULL AUTO_INCREMENT,
    `jobID` int(10) NOT NULL,
    `isPaid` TINYINT(1) NOT NULL,
    `date` DATE NOT NULL,
    PRIMARY KEY (paymentID),
    CONSTRAINT FK_JobPayment FOREIGN KEY (jobID) REFERENCES job(jobID));

CREATE TABLE `admin` (
    `adminID` int(11) NOT NULL AUTO_INCREMENT,
    `username` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `email` varchar(255),
    `phoneNumber` varchar(11),
    PRIMARY KEY(`adminID`));

CREATE TABLE `picture` (
    `pictureID` int(10) NOT NULL AUTO_INCREMENT,
    `directory` varchar(255) NOT NULL,
    `productID` int(10) NOT NULL,
    PRIMARY KEY(`pictureID`),
    CONSTRAINT FK_ProductPicture FOREIGN KEY (productID) REFERENCES product(productID));
