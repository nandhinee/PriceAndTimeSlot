# MySQL-Front 5.1  (Build 1.5)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: pricecloud
# ------------------------------------------------------
# Server version 5.0.24a-community-nt

#
# Source for table accept
#

DROP TABLE IF EXISTS `accept`;
CREATE TABLE `accept` (
  `username` varchar(100) NOT NULL default '',
  `password` varchar(100) default NULL,
  `price` varchar(100) default NULL,
  `status` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table accept
#
LOCK TABLES `accept` WRITE;
/*!40000 ALTER TABLE `accept` DISABLE KEYS */;

/*!40000 ALTER TABLE `accept` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table admin
#

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `AdminN` varchar(20) default NULL,
  `AdminP` varchar(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table admin
#
LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;

INSERT INTO `admin` VALUES ('admin','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table adminverify
#

DROP TABLE IF EXISTS `adminverify`;
CREATE TABLE `adminverify` (
  `username` varchar(22) NOT NULL default '',
  `password` varchar(22) default NULL,
  `startdate` varchar(22) default NULL,
  `enddate` varchar(22) default NULL,
  `starttime` varchar(11) default NULL,
  `endtime` varchar(11) default NULL,
  `totalsize` varchar(11) default NULL,
  `price` varchar(11) default NULL,
  `status` varchar(22) default NULL,
  `amount` varchar(5000) default NULL,
  `risk` varchar(33) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table adminverify
#
LOCK TABLES `adminverify` WRITE;
/*!40000 ALTER TABLE `adminverify` DISABLE KEYS */;

/*!40000 ALTER TABLE `adminverify` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table amountdetails
#

DROP TABLE IF EXISTS `amountdetails`;
CREATE TABLE `amountdetails` (
  `UserID` varchar(2000) default NULL,
  `Amount` varchar(2000) default NULL,
  `Balance` varchar(2000) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table amountdetails
#
LOCK TABLES `amountdetails` WRITE;
/*!40000 ALTER TABLE `amountdetails` DISABLE KEYS */;

/*!40000 ALTER TABLE `amountdetails` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table bankdetails
#

DROP TABLE IF EXISTS `bankdetails`;
CREATE TABLE `bankdetails` (
  `bankname` varchar(22) NOT NULL default '',
  `accno` varchar(22) default NULL,
  `cvvno` varchar(22) default NULL,
  `amount` varchar(1000) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table bankdetails
#
LOCK TABLES `bankdetails` WRITE;
/*!40000 ALTER TABLE `bankdetails` DISABLE KEYS */;

INSERT INTO `bankdetails` VALUES ('HDFC','12345','123','10000');
/*!40000 ALTER TABLE `bankdetails` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table cloudreq
#

DROP TABLE IF EXISTS `cloudreq`;
CREATE TABLE `cloudreq` (
  `userid` varchar(22) NOT NULL default '',
  `status` varchar(22) default NULL,
  `urllocation` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table cloudreq
#
LOCK TABLES `cloudreq` WRITE;
/*!40000 ALTER TABLE `cloudreq` DISABLE KEYS */;

/*!40000 ALTER TABLE `cloudreq` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table fileservice
#

DROP TABLE IF EXISTS `fileservice`;
CREATE TABLE `fileservice` (
  `filename` varchar(1000) NOT NULL default '',
  `fileid` varchar(1000) default NULL,
  `filepath` varchar(1000) default NULL,
  `userid` varchar(1000) default NULL,
  `password` varchar(1000) default NULL,
  `foldername` varchar(1000) default NULL,
  `filesize` varchar(1000) default NULL,
  `serverpath` varchar(99) default NULL,
  `filetype` varchar(1000) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table fileservice
#
LOCK TABLES `fileservice` WRITE;
/*!40000 ALTER TABLE `fileservice` DISABLE KEYS */;

/*!40000 ALTER TABLE `fileservice` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table timereq
#

DROP TABLE IF EXISTS `timereq`;
CREATE TABLE `timereq` (
  `Starttime` varchar(100) NOT NULL default '',
  `endtime` varchar(100) default NULL,
  `userid` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table timereq
#
LOCK TABLES `timereq` WRITE;
/*!40000 ALTER TABLE `timereq` DISABLE KEYS */;

/*!40000 ALTER TABLE `timereq` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table userdetails
#

DROP TABLE IF EXISTS `userdetails`;
CREATE TABLE `userdetails` (
  `username` varchar(22) NOT NULL default '',
  `userid` varchar(22) default NULL,
  `password` varchar(22) default NULL,
  `address` varchar(56) default NULL,
  `phone` varchar(22) default NULL,
  `email` varchar(44) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table userdetails
#
LOCK TABLES `userdetails` WRITE;
/*!40000 ALTER TABLE `userdetails` DISABLE KEYS */;

/*!40000 ALTER TABLE `userdetails` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
