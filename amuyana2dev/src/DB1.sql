-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: amuyana
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.17.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_conjunction`
--

DROP TABLE IF EXISTS `tbl_conjunction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_conjunction` (
  `id_conjunction` int(11) NOT NULL AUTO_INCREMENT,
  `orientation` int(1) NOT NULL,
  `prop_formulation` varchar(45) NOT NULL,
  `description` varchar(500) NOT NULL,
  `id_fcc` int(11) NOT NULL,
  PRIMARY KEY (`id_conjunction`),
  KEY `fk_tbl_conjunction_tbl_fcc1_idx` (`id_fcc`),
  CONSTRAINT `fk_tbl_conjunction_tbl_fcc1` FOREIGN KEY (`id_fcc`) REFERENCES `tbl_fcc` (`id_fcc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_conjunction`
--

LOCK TABLES `tbl_conjunction` WRITE;
/*!40000 ALTER TABLE `tbl_conjunction` DISABLE KEYS */;
INSERT INTO `tbl_conjunction` VALUES (1,0,'La persona 1 sin vida propia','El compuesto energético que constituye la persona mientras esta está muerta',1),(2,1,'La persona 1 con vida propia','El compuesto energético que constituye la persona mientras está viva',1),(3,2,'La persona 1 al nacimiento o en agonía','El compuesto energético que constituye la persona mientras está naciendo o está agonizando',1),(4,0,'La persona 1 al estar dormida','El dinamismo que es la persona mientras esta durmiendo, es decir su “consciencia replegada”',2),(5,1,'La persona 1 al estar despierta','El dinamismo que es la persona mientras esta despierta, aun si esta echada en la cama o con los ojos cerrados',2),(6,2,'La persona 1 al despertarse o dormirse','El dinamismo que es la persona mientras se esta despertando o se esta durmiendo, una situacion de la cual el sujeto no llega a ser consciente',2),(7,0,'La persona 1 en un lugar','Mientras la persona esta en un lugar, como en su casa o en su lugar de trabajo, a pesar de que se mueve dentro de ese lugar',3),(8,1,'La persona 1 desplazandose','Mientras la persona se esta moviendo, de un lugar a otro por las vias publicas',3),(9,2,'La persona 1 ni quedandose ni desplazandose','Mientras la persona se alista para salir o se despoja de sus cosas al llegar, hacia y de un lugar (dentro del cual se puede definir un dinamismo analogo)',3),(10,0,'La persona 1 trabajando en el trabajo','El dinamismo -complejo- que es el ejercer una labor en un lugar de trabajo',4),(11,1,'La persona 1 no trabajando en el trabajo','El dinamismo que no es ejercer su labor, sino otra cosa, pero en el lugar de trabajo',4),(12,2,'La persona 1 preparandose','El dinamismo que es el prepararse para trabajar, o el prepararse para partir',4),(13,0,'La persona 2 sin vida propia','El compuesto energético que constituye la persona mientras esta está muerta',5),(14,1,'La persona 2 con vida propia','El compuesto energético que constituye la persona mientras está viva',5),(15,2,'La persona 2 al nacimiento o en agonía','El compuesto energético que constituye la persona mientras está naciendo o está agonizando',5),(16,0,'La persona 2 trabajando en el trabajo','El dinamismo -complejo- que es el ejercer una labor en un lugar de trabajo',6),(17,1,'La persona 2 no trabajando en el trabajo','El dinamismo que no es ejercer su labor, sino otra cosa, pero en el lugar de trabajo',6),(18,2,'La persona 2 preparandose','El dinamismo que es el prepararse para trabajar, o el prepararse para partir',6),(19,0,'La persona 3 sin vida propia','El compuesto energético que constituye la persona mientras esta está muerta',7),(20,1,'La persona 3 con vida propia','El compuesto energético que constituye la persona mientras está viva',7),(21,2,'La persona 3 al nacimiento o en agonía','El compuesto energético que constituye la persona mientras está naciendo o está agonizando',7),(22,0,'La persona 3 trabajando en el trabajo','El dinamismo -complejo- que es el ejercer una labor en un lugar de trabajo',8),(23,1,'La persona 3 no trabajando en el trabajo','El dinamismo que no es ejercer su labor, sino otra cosa, pero en el lugar de trabajo',8),(24,2,'La persona 3 preparandose','El dinamismo que es el prepararse para trabajar, o el prepararse para partir',8),(25,0,'La persona 4 sin vida propia','El compuesto energético que constituye la persona mientras esta está muerta',9),(26,1,'La persona 4 con vida propia','El compuesto energético que constituye la persona mientras está viva',9),(27,2,'La persona 4 al nacimiento o en agonía','El compuesto energético que constituye la persona mientras está naciendo o está agonizando',9),(28,0,'La persona 4 trabajando en el trabajo','El dinamismo -complejo- que es el ejercer una labor en un lugar de trabajo',10),(29,1,'La persona 4 no trabajando en el trabajo','El dinamismo que no es ejercer su labor, sino otra cosa, pero en el lugar de trabajo',10),(30,2,'La persona 4 preparandose','El dinamismo que es el prepararse para trabajar, o el prepararse para partir',10),(31,0,'La persona 5 sin vida propia','El compuesto energético que constituye la persona mientras esta está muerta',11),(32,1,'La persona 5 con vida propia','El compuesto energético que constituye la persona mientras está viva',11),(33,2,'La persona 5 al nacimiento o en agonía','El compuesto energético que constituye la persona mientras está naciendo o está agonizando',11),(34,0,'La persona 5 trabajando en el trabajo','El dinamismo -complejo- que es el ejercer una labor en un lugar de trabajo',12),(35,1,'La persona 5 no trabajando en el trabajo','El dinamismo que no es ejercer su labor, sino otra cosa, pero en el lugar de trabajo',12),(36,2,'La persona 5 preparandose','El dinamismo que es el prepararse para trabajar, o el prepararse para partir',12),(37,0,'Estar programando','Mientras se programa en el sentido general, escribir código fuente, ejecutar el programa para hacer pruebas, etc.',16),(38,1,'No estar programando','Mientras no se programa o se hace algo relacionado con Amuyaña, pero se está en la misma posición que al programar, por ejemplo se ve un video',16),(39,2,'El cambiar de ventana','Lo que se hace para cambiar de una actividad a otra, de un programa a otro, del programar al hacer otra cosa',16),(94,0,'positive','comment',37),(95,1,'negative','desc',37),(96,2,'symmetric','test',37);
/*!40000 ALTER TABLE `tbl_conjunction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_deduction`
--

DROP TABLE IF EXISTS `tbl_deduction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_deduction` (
  `id_fcc` int(11) NOT NULL,
  `id_implication` int(11) NOT NULL,
  PRIMARY KEY (`id_fcc`,`id_implication`),
  KEY `fk_tbl_deduction_tbl_implication1_idx` (`id_implication`),
  KEY `fk_tbl_deduction_tbl_fcc1_idx` (`id_fcc`),
  CONSTRAINT `fk_tbl_deduction_tbl_fcc1` FOREIGN KEY (`id_fcc`) REFERENCES `tbl_fcc` (`id_fcc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_deduction_tbl_implication1` FOREIGN KEY (`id_implication`) REFERENCES `tbl_implication` (`id_implication`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_deduction`
--

LOCK TABLES `tbl_deduction` WRITE;
/*!40000 ALTER TABLE `tbl_deduction` DISABLE KEYS */;
INSERT INTO `tbl_deduction` VALUES (2,2),(3,5),(4,7),(1,9),(2,9),(5,10);
/*!40000 ALTER TABLE `tbl_deduction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_dialectic`
--

DROP TABLE IF EXISTS `tbl_dialectic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_dialectic` (
  `id_dialectic` int(11) NOT NULL,
  `orientation` tinyint(4) NOT NULL,
  `level` int(11) NOT NULL,
  PRIMARY KEY (`id_dialectic`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dialectic`
--

LOCK TABLES `tbl_dialectic` WRITE;
/*!40000 ALTER TABLE `tbl_dialectic` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_dialectic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_element`
--

DROP TABLE IF EXISTS `tbl_element`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_element` (
  `id_element` int(11) NOT NULL AUTO_INCREMENT,
  `symbol` varchar(5) NOT NULL,
  `polarity` int(11) NOT NULL,
  `id_fcc` int(11) NOT NULL,
  PRIMARY KEY (`id_element`),
  KEY `fk_tbl_element_tbl_fcc_idx` (`id_fcc`),
  CONSTRAINT `fk_tbl_element_tbl_fcc` FOREIGN KEY (`id_fcc`) REFERENCES `tbl_fcc` (`id_fcc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_element`
--

LOCK TABLES `tbl_element` WRITE;
/*!40000 ALTER TABLE `tbl_element` DISABLE KEYS */;
INSERT INTO `tbl_element` VALUES (1,'1',0,1),(2,'-1',1,1),(3,'1d',0,2),(4,'-1d',1,2),(5,'1de',0,3),(6,'-1de',1,3),(7,'1t',0,4),(8,'-1t',1,4),(9,'2',0,5),(10,'-2',1,5),(11,'2t',0,6),(12,'-2t',1,6),(13,'3',0,7),(14,'-3',1,7),(15,'3t',0,8),(16,'-3t',1,8),(17,'4',0,9),(18,'-4',1,9),(19,'4t',0,10),(20,'-4t',1,10),(21,'5',0,11),(22,'-5',1,11),(23,'5t',0,12),(24,'-5t',1,12),(27,'p',0,16),(28,'-p',1,16);
/*!40000 ALTER TABLE `tbl_element` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_fcc`
--

DROP TABLE IF EXISTS `tbl_fcc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_fcc` (
  `id_fcc` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(30) NOT NULL,
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id_fcc`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_fcc`
--

LOCK TABLES `tbl_fcc` WRITE;
/*!40000 ALTER TABLE `tbl_fcc` DISABLE KEYS */;
INSERT INTO `tbl_fcc` VALUES (1,'Persona 1','La persona 1 desde el punto de vista del estar viva o muerta'),(2,'1 despierta','La dualidad se da entre el estar dormida y el estar despierta'),(3,'1 desplazándose','La dualidad se da entre el estar en un lugar, quedarse ahí, y el estar en movimiento, desplazándose'),(4,'1 trabajando','La dualidad se da entre el estar trabajando y el estar haciendo otra cosa'),(5,'Persona 2','La persona 2 desde el punto de vista del estar viva o muerta'),(6,'2 trabajando','La dualidad se da entre el estar trabajando y el estar haciendo otra cosa'),(7,'Persona 3','La persona 3 desde el punto de vista del estar viva o muerta'),(8,'3 trabajando','La dualidad se da entre el estar trabajando y el estar haciendo otra cosa'),(9,'Persona 4','La persona 4 desde el punto de vista del estar viva o muerta'),(10,'4 trabajando','La dualidad se da entre el estar trabajando y el estar haciendo otra cosa'),(11,'Persona 5','La persona 5 desde el punto de vista del estar viva o muerta'),(12,'5 trabajando','La dualidad se da entre el estar trabajando y el estar haciendo otra cosa'),(16,'Programar Amuyaña','Mientras programo Amuyaña'),(37,'test','test');
/*!40000 ALTER TABLE `tbl_fcc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_fcc_has_tbl_dialectic`
--

DROP TABLE IF EXISTS `tbl_fcc_has_tbl_dialectic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_fcc_has_tbl_dialectic` (
  `id_fcc` int(11) NOT NULL,
  `id_dialectic` int(11) NOT NULL,
  PRIMARY KEY (`id_fcc`,`id_dialectic`),
  KEY `fk_tbl_fcc_has_tbl_dialectic_tbl_dialectic1_idx` (`id_dialectic`),
  KEY `fk_tbl_fcc_has_tbl_dialectic_tbl_fcc1_idx` (`id_fcc`),
  CONSTRAINT `fk_tbl_fcc_has_tbl_dialectic_tbl_dialectic1` FOREIGN KEY (`id_dialectic`) REFERENCES `tbl_dialectic` (`id_dialectic`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_fcc_has_tbl_dialectic_tbl_fcc1` FOREIGN KEY (`id_fcc`) REFERENCES `tbl_fcc` (`id_fcc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_fcc_has_tbl_dialectic`
--

LOCK TABLES `tbl_fcc_has_tbl_dialectic` WRITE;
/*!40000 ALTER TABLE `tbl_fcc_has_tbl_dialectic` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_fcc_has_tbl_dialectic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_fcc_has_tbl_logic_system`
--

DROP TABLE IF EXISTS `tbl_fcc_has_tbl_logic_system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_fcc_has_tbl_logic_system` (
  `id_fcc` int(11) NOT NULL,
  `id_logic_system` int(11) NOT NULL,
  PRIMARY KEY (`id_fcc`,`id_logic_system`),
  KEY `fk_tbl_fcc_has_tbl_logic_system_tbl_logic_system1_idx` (`id_logic_system`),
  KEY `fk_tbl_fcc_has_tbl_logic_system_tbl_fcc1_idx` (`id_fcc`),
  CONSTRAINT `fk_tbl_fcc_has_tbl_logic_system_tbl_fcc1` FOREIGN KEY (`id_fcc`) REFERENCES `tbl_fcc` (`id_fcc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_fcc_has_tbl_logic_system_tbl_logic_system1` FOREIGN KEY (`id_logic_system`) REFERENCES `tbl_logic_system` (`id_logic_system`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_fcc_has_tbl_logic_system`
--

LOCK TABLES `tbl_fcc_has_tbl_logic_system` WRITE;
/*!40000 ALTER TABLE `tbl_fcc_has_tbl_logic_system` DISABLE KEYS */;
INSERT INTO `tbl_fcc_has_tbl_logic_system` VALUES (1,1),(2,1),(3,1),(4,1),(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(4,3),(5,3),(7,3),(9,3),(11,3),(1,5),(12,5),(4,6),(6,6),(8,6),(4,7),(10,7),(12,7);
/*!40000 ALTER TABLE `tbl_fcc_has_tbl_logic_system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_fcc_has_tbl_user`
--

DROP TABLE IF EXISTS `tbl_fcc_has_tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_fcc_has_tbl_user` (
  `id_user` int(11) NOT NULL,
  `id_fcc` int(11) NOT NULL,
  `permission` int(11) NOT NULL,
  PRIMARY KEY (`id_user`,`id_fcc`),
  KEY `fk_tbl_user_has_tbl_fcc_tbl_fcc1_idx` (`id_fcc`),
  KEY `fk_tbl_user_has_tbl_fcc_tbl_user1_idx` (`id_user`),
  CONSTRAINT `fk_tbl_user_has_tbl_fcc_tbl_fcc1` FOREIGN KEY (`id_fcc`) REFERENCES `tbl_fcc` (`id_fcc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_user_has_tbl_fcc_tbl_user1` FOREIGN KEY (`id_user`) REFERENCES `tbl_user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='permissions:\n0 - user can only read the system\n1 - user can create, modify and delete its own FCC\n2 - user can create , modify and delete any FCC\n3 - user has privileges of level 2 and can also attribute permissions. \nExceptions: Only someone who has level 3 can attribute permission 3 to someone of level 2, but only oneself can downgrade himself from level 3 to level 2 permission.\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_fcc_has_tbl_user`
--

LOCK TABLES `tbl_fcc_has_tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_fcc_has_tbl_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_fcc_has_tbl_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_implication`
--

DROP TABLE IF EXISTS `tbl_implication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_implication` (
  `id_implication` int(11) NOT NULL AUTO_INCREMENT,
  `orientation` tinyint(4) NOT NULL,
  `id_fcc` int(11) NOT NULL,
  PRIMARY KEY (`id_implication`),
  KEY `fk_tbl_implication_tbl_fcc1_idx` (`id_fcc`),
  CONSTRAINT `fk_tbl_implication_tbl_fcc1` FOREIGN KEY (`id_fcc`) REFERENCES `tbl_fcc` (`id_fcc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_implication`
--

LOCK TABLES `tbl_implication` WRITE;
/*!40000 ALTER TABLE `tbl_implication` DISABLE KEYS */;
INSERT INTO `tbl_implication` VALUES (1,0,1),(2,1,1),(3,2,1),(4,0,2),(5,1,2),(6,2,2),(7,0,3),(8,1,3),(9,2,3),(10,0,4),(11,1,4),(12,2,4),(13,0,5),(14,1,5),(15,2,5),(16,0,6),(17,1,6),(18,2,6),(19,0,7),(20,1,7),(21,2,7),(22,0,8),(23,1,8),(24,2,8),(25,0,9),(26,1,9),(27,2,9),(28,0,10),(29,1,10),(30,2,10),(31,0,11),(32,1,11),(33,2,11),(34,0,12),(35,1,12),(36,2,12),(40,0,16),(41,1,16),(42,2,16);
/*!40000 ALTER TABLE `tbl_implication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_inclusion`
--

DROP TABLE IF EXISTS `tbl_inclusion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_inclusion` (
  `id_inclusion` int(11) NOT NULL AUTO_INCREMENT,
  `particular_notion` int(11) NOT NULL,
  `general_notion` int(11) NOT NULL,
  PRIMARY KEY (`id_inclusion`),
  KEY `fk_tbl_inclusion_tbl_conjunction1_idx` (`particular_notion`),
  KEY `fk_tbl_inclusion_tbl_conjunction2_idx` (`general_notion`),
  CONSTRAINT `fk_tbl_inclusion_tbl_conjunction1` FOREIGN KEY (`particular_notion`) REFERENCES `tbl_conjunction` (`id_conjunction`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_inclusion_tbl_conjunction2` FOREIGN KEY (`general_notion`) REFERENCES `tbl_conjunction` (`id_conjunction`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_inclusion`
--

LOCK TABLES `tbl_inclusion` WRITE;
/*!40000 ALTER TABLE `tbl_inclusion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_inclusion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_log`
--

DROP TABLE IF EXISTS `tbl_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_log` (
  `id_log` int(11) NOT NULL AUTO_INCREMENT,
  `date` timestamp NULL DEFAULT NULL,
  `type` varchar(30) NOT NULL,
  `message` varchar(200) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_log`),
  KEY `fk_tbl_log_tbl_user1_idx` (`id_user`),
  CONSTRAINT `fk_tbl_log_tbl_user1` FOREIGN KEY (`id_user`) REFERENCES `tbl_user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_log`
--

LOCK TABLES `tbl_log` WRITE;
/*!40000 ALTER TABLE `tbl_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_logic_system`
--

DROP TABLE IF EXISTS `tbl_logic_system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_logic_system` (
  `id_logic_system` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(45) NOT NULL,
  `description` varchar(500) NOT NULL,
  `creation_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_logic_system`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_logic_system`
--

LOCK TABLES `tbl_logic_system` WRITE;
/*!40000 ALTER TABLE `tbl_logic_system` DISABLE KEYS */;
INSERT INTO `tbl_logic_system` VALUES (1,'Universe system :O','The logic system describing the whole thing, the Universe, this is the most general system, everything belongs to this system','2018-05-08 02:30:00'),(2,'Life system of Tahuantinsuyo','Everything occuring in the territory of Tahuantinsuyo belongs to this system, as life and not-life are two related aspects (rocks too are \"alive\")','2018-05-08 02:32:00'),(3,'Social system of Tahuantinsuyo :)','We consider only dynamisms related to human activity, in Tahuantinsuyo','2018-05-08 02:34:00'),(4,'Education system of Tahuantinsuyo','Dynamisms related to education (courses, lectures, exams, etc)','2018-05-08 02:37:00'),(5,'Health system of Tahuantinsuyo','Dynamisms related to health (production of drugs, services by doctors, nurses, etc)','2018-05-08 02:40:00'),(6,'Food system of Tahuantinsuyo','Dynamisms related to food (production, distribution, consumption)','2018-05-08 02:45:00'),(7,'Housing system of Tahuantinsuyo','Dynamisms related to housing, attributing and building houses for all members of Tahuantinsuyo','2018-05-08 02:55:00'),(8,'Production of whool in Sajama','The production of whool: the sheeps, machines, human actions, etc.','2018-05-08 02:56:00'),(10,'Geological system of Earth','This is equivalent to Life system in what respects the non-living dynamisms','2018-05-10 19:28:31');
/*!40000 ALTER TABLE `tbl_logic_system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_logic_system_has_tbl_user`
--

DROP TABLE IF EXISTS `tbl_logic_system_has_tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_logic_system_has_tbl_user` (
  `id_logic_system` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `permission` int(1) NOT NULL DEFAULT '5',
  PRIMARY KEY (`id_logic_system`,`id_user`),
  KEY `fk_tbl_system_has_tbl_user_tbl_user1_idx` (`id_user`),
  KEY `fk_tbl_system_has_tbl_user_tbl_system1_idx` (`id_logic_system`),
  CONSTRAINT `fk_tbl_system_has_tbl_user_tbl_system1` FOREIGN KEY (`id_logic_system`) REFERENCES `tbl_logic_system` (`id_logic_system`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_system_has_tbl_user_tbl_user1` FOREIGN KEY (`id_user`) REFERENCES `tbl_user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='permissions:\n0 - user can only read the system\n1 - user can create, modify and delete its own FCC\n2 - user can create , modify and delete any FCC\n3 - user has privileges of level 2 and can also attribute permissions. \nExceptions: Only someone who has level 3 can attribute permission 3 to someone of level 2, but only oneself can downgrade himself from level 3 to level 2 permission.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_logic_system_has_tbl_user`
--

LOCK TABLES `tbl_logic_system_has_tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_logic_system_has_tbl_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_logic_system_has_tbl_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_quantum`
--

DROP TABLE IF EXISTS `tbl_quantum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_quantum` (
  `id_quantum` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(30) NOT NULL,
  `description` varchar(500) NOT NULL,
  `unit` varchar(5) NOT NULL,
  PRIMARY KEY (`id_quantum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_quantum`
--

LOCK TABLES `tbl_quantum` WRITE;
/*!40000 ALTER TABLE `tbl_quantum` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_quantum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_quantum_has_tbl_register`
--

DROP TABLE IF EXISTS `tbl_quantum_has_tbl_register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_quantum_has_tbl_register` (
  `id_quantum_register` int(11) NOT NULL AUTO_INCREMENT,
  `id_quantum` int(11) NOT NULL,
  `id_register` int(11) NOT NULL COMMENT ' ',
  PRIMARY KEY (`id_quantum_register`,`id_quantum`,`id_register`),
  KEY `fk_tbl_quantum_has_tbl_register_tbl_register1_idx` (`id_register`),
  KEY `fk_tbl_quantum_has_tbl_register_tbl_quantum1_idx` (`id_quantum`),
  CONSTRAINT `fk_tbl_quantum_has_tbl_register_tbl_quantum1` FOREIGN KEY (`id_quantum`) REFERENCES `tbl_quantum` (`id_quantum`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_quantum_has_tbl_register_tbl_register1` FOREIGN KEY (`id_register`) REFERENCES `tbl_register` (`id_register`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_quantum_has_tbl_register`
--

LOCK TABLES `tbl_quantum_has_tbl_register` WRITE;
/*!40000 ALTER TABLE `tbl_quantum_has_tbl_register` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_quantum_has_tbl_register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_register`
--

DROP TABLE IF EXISTS `tbl_register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_register` (
  `id_register` int(11) NOT NULL AUTO_INCREMENT,
  `date` timestamp NULL DEFAULT NULL,
  `value` double NOT NULL,
  `id_conjunction` int(11) NOT NULL,
  PRIMARY KEY (`id_register`),
  KEY `fk_tbl_register_tbl_conjunction1_idx` (`id_conjunction`),
  CONSTRAINT `fk_tbl_register_tbl_conjunction1` FOREIGN KEY (`id_conjunction`) REFERENCES `tbl_conjunction` (`id_conjunction`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_register`
--

LOCK TABLES `tbl_register` WRITE;
/*!40000 ALTER TABLE `tbl_register` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_settings`
--

DROP TABLE IF EXISTS `tbl_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_settings` (
  `id_settings` int(11) NOT NULL AUTO_INCREMENT,
  `url_database` varchar(100) DEFAULT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_settings`),
  KEY `fk_settings_tbl_user1_idx` (`id_user`),
  CONSTRAINT `fk_settings_tbl_user1` FOREIGN KEY (`id_user`) REFERENCES `tbl_user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_settings`
--

LOCK TABLES `tbl_settings` WRITE;
/*!40000 ALTER TABLE `tbl_settings` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_space`
--

DROP TABLE IF EXISTS `tbl_space`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_space` (
  `id_space` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(30) NOT NULL,
  `description` varchar(500) NOT NULL,
  PRIMARY KEY (`id_space`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_space`
--

LOCK TABLES `tbl_space` WRITE;
/*!40000 ALTER TABLE `tbl_space` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_space` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_space_has_tbl_register`
--

DROP TABLE IF EXISTS `tbl_space_has_tbl_register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_space_has_tbl_register` (
  `id_space` int(11) NOT NULL,
  `id_register` int(11) NOT NULL,
  PRIMARY KEY (`id_space`,`id_register`),
  KEY `fk_tbl_space_has_tbl_register_tbl_register1_idx` (`id_register`),
  KEY `fk_tbl_space_has_tbl_register_tbl_space1_idx` (`id_space`),
  CONSTRAINT `fk_tbl_space_has_tbl_register_tbl_register1` FOREIGN KEY (`id_register`) REFERENCES `tbl_register` (`id_register`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_space_has_tbl_register_tbl_space1` FOREIGN KEY (`id_space`) REFERENCES `tbl_space` (`id_space`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_space_has_tbl_register`
--

LOCK TABLES `tbl_space_has_tbl_register` WRITE;
/*!40000 ALTER TABLE `tbl_space_has_tbl_register` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_space_has_tbl_register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_syllogism`
--

DROP TABLE IF EXISTS `tbl_syllogism`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_syllogism` (
  `id_syllogism` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(30) NOT NULL,
  PRIMARY KEY (`id_syllogism`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_syllogism`
--

LOCK TABLES `tbl_syllogism` WRITE;
/*!40000 ALTER TABLE `tbl_syllogism` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_syllogism` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_syllogism_has_tbl_inclusion`
--

DROP TABLE IF EXISTS `tbl_syllogism_has_tbl_inclusion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_syllogism_has_tbl_inclusion` (
  `id_syllogism_inclusion` int(11) NOT NULL AUTO_INCREMENT,
  `id_syllogism` int(11) NOT NULL,
  `id_inclusion` int(11) NOT NULL,
  PRIMARY KEY (`id_syllogism_inclusion`,`id_syllogism`,`id_inclusion`),
  KEY `fk_tbl_syllogism_has_tbl_inclusion_tbl_inclusion1_idx` (`id_inclusion`),
  KEY `fk_tbl_syllogism_has_tbl_inclusion_tbl_syllogism1_idx` (`id_syllogism`),
  CONSTRAINT `fk_tbl_syllogism_has_tbl_inclusion_tbl_inclusion1` FOREIGN KEY (`id_inclusion`) REFERENCES `tbl_inclusion` (`id_inclusion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_syllogism_has_tbl_inclusion_tbl_syllogism1` FOREIGN KEY (`id_syllogism`) REFERENCES `tbl_syllogism` (`id_syllogism`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_syllogism_has_tbl_inclusion`
--

LOCK TABLES `tbl_syllogism_has_tbl_inclusion` WRITE;
/*!40000 ALTER TABLE `tbl_syllogism_has_tbl_inclusion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_syllogism_has_tbl_inclusion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_time`
--

DROP TABLE IF EXISTS `tbl_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_time` (
  `id_time` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(30) NOT NULL,
  `description` varchar(30) NOT NULL,
  `start` timestamp NULL DEFAULT NULL,
  `end` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_time`
--

LOCK TABLES `tbl_time` WRITE;
/*!40000 ALTER TABLE `tbl_time` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_time_has_tbl_register`
--

DROP TABLE IF EXISTS `tbl_time_has_tbl_register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_time_has_tbl_register` (
  `id_time` int(11) NOT NULL,
  `id_register` int(11) NOT NULL,
  PRIMARY KEY (`id_time`,`id_register`),
  KEY `fk_tbl_time_has_tbl_register_tbl_register1_idx` (`id_register`),
  KEY `fk_tbl_time_has_tbl_register_tbl_time1_idx` (`id_time`),
  CONSTRAINT `fk_tbl_time_has_tbl_register_tbl_register1` FOREIGN KEY (`id_register`) REFERENCES `tbl_register` (`id_register`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_time_has_tbl_register_tbl_time1` FOREIGN KEY (`id_time`) REFERENCES `tbl_time` (`id_time`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_time_has_tbl_register`
--

LOCK TABLES `tbl_time_has_tbl_register` WRITE;
/*!40000 ALTER TABLE `tbl_time_has_tbl_register` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_time_has_tbl_register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL,
  `joined_date` date NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-11  7:07:41
