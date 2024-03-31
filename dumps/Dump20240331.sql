CREATE DATABASE  IF NOT EXISTS `kevents` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `kevents`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: kevents
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `events` (
  `event_name` varchar(255) DEFAULT NULL,
  `society` varchar(255) DEFAULT NULL,
  `description` varchar(700) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `publish_date` date DEFAULT NULL,
  `event_bg` varchar(255) DEFAULT NULL,
  `event_id` int NOT NULL,
  `form_link` varchar(1200) DEFAULT NULL,
  `short_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES ('Greyhat','IOT LAB','Introducing our dynamic duo: Cristiano IJglova and Shakti Ranjan Mohanty from HackerOne! Cristiano, the trailblazing cybersecunty pioneer with over 1 5 years of industry domination.','2024-03-31','2024-03-31','2024-03-30','Greyhat.jpeg',1,'https://bit.ly/iotlabXhackerone','Free Cybersecurity Event! Get Hacked? Nah, Be a Hacker!'),('Automatrix','UIPath student community','In collaboration with UiPath, the renowned recruiter of KIIT University, Automatrix aims to introduce students to the dynamic world of automation. Our primary goal is to empower students to enhance their resumes with practical projects and official certifications from UiPath, opening doors to exciting career opportunities','2024-04-04','2024-04-04','2024-03-31','AutoMatrix.jpeg',2,'https://docs.google.com/forms/d/e/1FAIpQLSfQa0tVFEUhTlhM0iUNQxOcYtjdIuGYqCu624I-v8NJoDXw6g/viewform','Dive into UiPath\'s intuitive platform for robotic process automation'),('Defcon','MLSA','DEFCON is a workshop packed with exciting challenges and insightful talks designed to ignite your passion for cybersecurity. Whether you\'re a seasoned pro or just starting out.Put your skills to the test in a thrilling Capture-The-Flag (CTF) competition Collaborate and develop your teamwork skills alongside other participants.Participate in a Q&A session with the speaker and the Cyber Team to delve deeper into cybersecurity concepts and CTF challenges.\nDate: Sunday, March 31st, 2024\nTime: 10:30 AM - 5:00 PM (Lunch Break: 1:00 PM - 3:00 PM)\nLocation: Campus 17 Auditorium\nWho can participate: All KIIT students (No prior experience needed!)','2024-03-31','2024-03-31','2024-03-30','defcon.jpeg',3,'https://register.d3fc0n.tech/','an immersive learning experience brought to you by the MLSA'),('Kreative Kontrol','Electrical society','You were not supposed to open this.','2024-03-31','2024-03-31','2024-03-31','generic.jpeg',4,NULL,'This is a test event'),('Juggernaut racing','Official offroading','You were not supposed to open this.','2024-03-31','2024-03-31','2024-03-31','generic.jpeg',5,NULL,'This is a test event'),('Qutopia','Quizzing society','You were not supposed to open this.','2024-03-31','2024-03-31','2024-03-31','generic.jpeg',6,NULL,'This is a test event'),('test','Quizzing society','You were not supposed to open this.','2024-03-31','2024-03-31','2024-03-31','generic.jpeg',7,NULL,'This is a test event');
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-31 22:12:25
