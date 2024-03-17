-- MySQL dump 10.13  Distrib 8.3.0, for Win64 (x86_64)
--
-- Host: localhost    Database: managementsystem
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `Client_ID` varchar(11) NOT NULL,
  `Name` varchar(40) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Date_Added` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Client_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('C01','Remwell Pepito','remwellpepito@gmail.com','2024-03-16 16:28:52'),('C02','Mary Kate Saguin','katesaguin@gmail.com','2024-03-16 16:30:14'),('C03','Daren Jamito','darenjamito@gmail.com','2024-03-16 16:32:19'),('C04','Sefthon Bliss','sef@gmail.com','2024-03-17 04:00:53');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `services` (
  `Service_ID` varchar(15) NOT NULL,
  `Service_Type` varchar(30) NOT NULL,
  `Service_Price` int DEFAULT '0',
  `Service_Status` varchar(30) NOT NULL,
  `Invoice_Status` varchar(30) NOT NULL,
  `Date_Added` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `Client_ID` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`Service_ID`),
  KEY `Client_ID` (`Client_ID`),
  CONSTRAINT `services_ibfk_1` FOREIGN KEY (`Client_ID`) REFERENCES `client` (`Client_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES ('S01','Photoshoot',600,'Ongoing','Unpaid','2024-03-05 16:29:15','C01'),('S02','Social Media Managing',500,'Complete','Paid','2024-03-08 16:31:55','C02'),('S03','Video Editing',700,'Complete','Paid','2024-03-08 16:33:00','C02'),('S04','Photoshoot',600,'Complete','Unpaid','2024-03-10 16:33:22','C03'),('S05','Photoshoot',600,'Ongoing','unpaid','2024-03-17 04:02:39','C04'),('S06','Social Media Managing',500,'Ongoing','unpaid','2024-03-17 04:03:16','C04');
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-17 19:23:17
