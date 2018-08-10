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
-- Table structure for table `tbl_c_class`
--

DROP TABLE IF EXISTS `tbl_c_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_c_class` (
  `id_c_class` int(11) NOT NULL AUTO_INCREMENT,
  `label` mediumtext NOT NULL,
  PRIMARY KEY (`id_c_class`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='Contradictional Classes table\nCollection of FCC that have at least one -contradictional- conjunction \nthat is included in the same general notion -another contradictional conjunction-. ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_c_class`
--

LOCK TABLES `tbl_c_class` WRITE;
/*!40000 ALTER TABLE `tbl_c_class` DISABLE KEYS */;
INSERT INTO `tbl_c_class` VALUES (42,'test');
/*!40000 ALTER TABLE `tbl_c_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_c_class_has_tbl_fcc`
--

DROP TABLE IF EXISTS `tbl_c_class_has_tbl_fcc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_c_class_has_tbl_fcc` (
  `id_c_class_has_fcc` int(11) NOT NULL AUTO_INCREMENT,
  `id_c_class` int(11) NOT NULL,
  `id_fcc` int(11) NOT NULL,
  PRIMARY KEY (`id_c_class_has_fcc`,`id_c_class`,`id_fcc`),
  KEY `fk_tbl_c_class_has_tbl_fcc_tbl_fcc1_idx` (`id_fcc`),
  KEY `fk_tbl_c_class_has_tbl_fcc_tbl_c_class1_idx` (`id_c_class`),
  CONSTRAINT `fk_tbl_c_class_has_tbl_fcc_tbl_c_class1` FOREIGN KEY (`id_c_class`) REFERENCES `tbl_c_class` (`id_c_class`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_c_class_has_tbl_fcc_tbl_fcc1` FOREIGN KEY (`id_fcc`) REFERENCES `tbl_fcc` (`id_fcc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_c_class_has_tbl_fcc`
--

LOCK TABLES `tbl_c_class_has_tbl_fcc` WRITE;
/*!40000 ALTER TABLE `tbl_c_class_has_tbl_fcc` DISABLE KEYS */;
INSERT INTO `tbl_c_class_has_tbl_fcc` VALUES (81,42,15);
/*!40000 ALTER TABLE `tbl_c_class_has_tbl_fcc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_conjunction`
--

DROP TABLE IF EXISTS `tbl_conjunction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_conjunction` (
  `id_conjunction` int(11) NOT NULL AUTO_INCREMENT,
  `orientation` int(1) NOT NULL,
  `prop_formulation` mediumtext NOT NULL,
  `description` mediumtext NOT NULL,
  `id_fcc` int(11) NOT NULL,
  PRIMARY KEY (`id_conjunction`),
  KEY `fk_tbl_conjunction_tbl_fcc1_idx` (`id_fcc`),
  CONSTRAINT `fk_tbl_conjunction_tbl_fcc1` FOREIGN KEY (`id_fcc`) REFERENCES `tbl_fcc` (`id_fcc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_conjunction`
--

LOCK TABLES `tbl_conjunction` WRITE;
/*!40000 ALTER TABLE `tbl_conjunction` DISABLE KEYS */;
INSERT INTO `tbl_conjunction` VALUES (34,0,'Global political unification','Whenever there\'s a unification between political entities. The asymptotic case would consist on a planet Earth under a unique Government, the case of pure interventionism without free-exchange.',11),(35,1,'Global political desintegration','Whenever the territory is divided, when one group proclaims its independance or autonomy. The asymptotic case consists on the absence of governement, each person would impose its own law to the others, pure liberalism or anarchism.',11),(36,2,'Global political equilibrium','Whenever there are evidences of both the unification and desintegration of the territory. For instance, this is the case we are today, there are signs of political unification at the planetarian level (the UN and other international institutions), but also signs of desintegration (each territory belongs to independent states).\nWe have not seen any radical change in the composition of countries in our planet for a few decades, probably the african revolutions of the 20th century are the last evidence of a desintegration process at the planetarian level, in particular african. We could divide the planet into continents and arrange the countries in the continent they belong.\nAs there\'s no signs of change, neither of unification nor desintegration (significantly enough to have an impact on a global scale) for a long time, that is why we consider this is the \"path\" or \"branch\" or dialectic towards which this dynamism tends with statistical dominance.\nIn practice we are constantly oscilating between the three orientations, although some events might have a low impact on this so we might not \"see\" the energy developing towards the positive or negative orientations.',11),(37,0,'Bolivia politically centralized','This is the case when the political power gets centralized in the plurinational State.',12),(38,1,'Bolivia politically descentralized','The asymptotic case consists on the absense of any political organization acting on behalf of the collectivity, each person would do as he seems convinient. This was probably the case during the middle age in Europe, where little we now about a large period called obsurentism. ',12),(39,2,'Bolivia with Autonomías','Just like at the international level the Plurinational State of Bolivia is part of a political equilibrium at the global scale, the Autonomías are part of the unified territory that we call Bolivia. \nIn theory there\'s an equilibrium of equally distributed power between the Plurinational State and the Autonomías, however we think there are more evidences suggesting the centralization of power.',12),(41,0,'Belgium politically centralized','This is the case when the political power gets centralized in the federal government',14),(42,1,'Belgium politically descentralized','The asymptotic case consists on the absense of any political organization acting on behalf of the collectivity, each person would do as he seems convinient. This was probably the case during the middle age in Europe, where little we now about a large period called obsurentism. \nThis is the case when each regional or communitary entity has more political power opposed to the federal government.',14),(43,2,'Belgium\'s political equilibrium','We think this is the situation we are in. There\'s a complex but well functioning distribution of political roles and power between federal entity and the regional and communitary entities. ',14),(44,0,'Centralized political system of Machareti','This is the case when the autonomy\'s government (the GAIOC) has total authority. The asymptotic case (impossible) consists on a unique political entity making the desicions for everybody.',15),(45,1,'Descentralized political system of Macharetí','This is the case when the GAIOC tranfers all of its rights and obligations to the members of the autonomy. The assymptotic case (also impossible) consists on the absense of political entities representing any group of persons. ',15),(46,2,'Equilibrated political system of Macharetí','This process corresponds to the conversion to a AIOC, it is the transition process, but also corresponds to the situation of equilibrium for the semi-actualized and semi-potentialized antagonic terms, whereas the transition is the equilibrium for the neither-actualized neither-potentialized antagonic terms.',15),(47,0,'Neguentropic social organization','The situation when there are as many person as there are positions in the structure of reciprocity, and there are no changes in the composition.\nBelong to the statistical domain the fact that all public functions are occupied by the members of the autonomy.\nMeasures:\n- \"speed of rotation\": the highest the highest the entropy\n- \"density=#ocuppied positions/#total positions\" : the lowest the higuest the entropy',16),(48,1,'Entropic social organization','When there would only be one person in a many-positions structure. There are many possibilities for that person to be in any position.',16),(49,2,'Social organization in equilibrium','Equilibrium between the entropic and neguentropic tendencies',16),(50,0,'Chile politically centralized','This is the case when the political power gets centralized in the central government',17),(51,1,'Chile politically descentralized','The asymptotic case consists on the absense of any political organization acting on behalf of the collectivity, each person would do as he seems convinient. This was probably the case during the middle age in Europe, where little we now about a large period called obsurentism. ',17),(52,2,'Chile in equilibrium of powers','Chile is not going under any profound change or whatsovever of its political system, they play with the rules of the free-exchange sysem and in that sense they tend to let the markets do their job. It is an equilibrium between a complete interventionism and complete free-exchange.',17),(53,0,'Neguentropic cattle structure','The persons who are interested in the same activity, cattle raising in this case, occcupy the different positions needed to be occupied in order for the activity to be feasible, the way the different possitions are occupied detemines the orientation of this structure of reciprocity in the sense of the antagonism between entropic and neguentropic measures, here being: \n- \"speed of rotation\": the highest the highest the entropy\n- \"density=#ocuppied positions/#total positions\" : the lowest the higuest the entropy\nFor example, if only one person takes the decisions, that means low speed of rotation, and hence low entropy (or high neguentropy). Entropy is when the economy gets dynamic, it transforms, by the redistribution of political power to all the citizens, the assymptotic case of neguentropy is when all the power is centralized in one position occupied by one person.',18),(54,1,'Entropic cattle structure','When there would only be one person in a many-positions structure. There are many possibilities for that person to be in any position.',18),(55,2,'Cattle structure in equilibrium','Equilibrium between the entropic and neguentropic tendencies, for example if everybody agrees with the distribution of power, that is of obligations and rights.',18);
/*!40000 ALTER TABLE `tbl_conjunction` ENABLE KEYS */;
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
  `symbol` mediumtext NOT NULL,
  `polarity` int(11) NOT NULL,
  `id_fcc` int(11) NOT NULL,
  PRIMARY KEY (`id_element`),
  KEY `fk_tbl_element_tbl_fcc_idx` (`id_fcc`),
  CONSTRAINT `fk_tbl_element_tbl_fcc` FOREIGN KEY (`id_fcc`) REFERENCES `tbl_fcc` (`id_fcc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_element`
--

LOCK TABLES `tbl_element` WRITE;
/*!40000 ALTER TABLE `tbl_element` DISABLE KEYS */;
INSERT INTO `tbl_element` VALUES (23,'PE',0,11),(24,'-PE',1,11),(25,'bo',0,12),(26,'bo',1,12),(29,'be',0,14),(30,'be',1,14),(31,'AIOC_MA',0,15),(32,'-AIOC_MA',1,15),(33,'GU_MA',0,16),(34,'-GU_MA',1,16),(35,'cl',0,17),(36,'cl',1,17),(37,'e',0,18),(38,'-e',1,18);
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
  `label` varchar(200) NOT NULL,
  `description` varchar(500) NOT NULL,
  PRIMARY KEY (`id_fcc`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_fcc`
--

LOCK TABLES `tbl_fcc` WRITE;
/*!40000 ALTER TABLE `tbl_fcc` DISABLE KEYS */;
INSERT INTO `tbl_fcc` VALUES (11,'Planet Earth','<html dir=\"ltr\"><head></head><body contenteditable=\"true\"><h1><font face=\"Tlwg Typist\" size=\"6\">General Definition</font></h1><p>We define the planet Earth with respect to the political organization of the territory. </p></body></html>'),(12,'Bolivia','<html dir=\"ltr\"><head></head><body contenteditable=\"true\">This is the political organization named Plurinational State of Bolivia</body></html>'),(14,'Belgium','<html dir=\"ltr\"><head></head><body contenteditable=\"true\">This is the political organization named Kingdom of Belgium</body></html>'),(15,'AIOC Macharetí','<html dir=\"ltr\"><head></head><body contenteditable=\"true\">This is the autonomous political organization named Autonomía Indígena Originario Campesina Macharetí</body></html>'),(16,'Macharetí\'s gubernatorial structure of reciprocity','<html dir=\"ltr\"><head></head><body contenteditable=\"true\">Consists on the group of persons who take care of political matters at the level of the autonomy. The first ones are those who formed the General Assembly, then this structure of reciprocity gets renewed continually according to the norms and procedures proper to the people of the Macharetí nation.</body></html>'),(17,'Chile','<html dir=\"ltr\"><head></head><body contenteditable=\"true\">This is the political organization named Republic of Chile</body></html>'),(18,'Macharetí\'s cattle rancher structure of reciprocity','<html dir=\"ltr\"><head></head><body contenteditable=\"true\">Consists on the group of persons who take care of the cattle in the territory of the autonomy.&nbsp;</body></html>');
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
INSERT INTO `tbl_fcc_has_tbl_logic_system` VALUES (11,2),(12,2),(14,2),(15,2),(16,2),(17,2);
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
-- Table structure for table `tbl_general`
--

DROP TABLE IF EXISTS `tbl_general`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_general` (
  `id_conjunction` int(11) NOT NULL,
  `id_inclusion` int(11) NOT NULL,
  PRIMARY KEY (`id_conjunction`,`id_inclusion`),
  KEY `fk_table2_tbl_inclusion1_idx` (`id_inclusion`),
  CONSTRAINT `fk_table2_tbl_conjunction1` FOREIGN KEY (`id_conjunction`) REFERENCES `tbl_conjunction` (`id_conjunction`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_table2_tbl_inclusion1` FOREIGN KEY (`id_inclusion`) REFERENCES `tbl_inclusion` (`id_inclusion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_general`
--

LOCK TABLES `tbl_general` WRITE;
/*!40000 ALTER TABLE `tbl_general` DISABLE KEYS */;
INSERT INTO `tbl_general` VALUES (46,12),(46,13),(39,14),(36,15),(46,16),(36,17),(36,18),(46,19);
/*!40000 ALTER TABLE `tbl_general` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_inclusion`
--

DROP TABLE IF EXISTS `tbl_inclusion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_inclusion` (
  `id_inclusion` int(11) NOT NULL AUTO_INCREMENT,
  `id_conjunction` int(11) NOT NULL,
  PRIMARY KEY (`id_inclusion`,`id_conjunction`),
  KEY `fk_tbl_inclusion_tbl_conjunction1_idx` (`id_conjunction`),
  CONSTRAINT `fk_tbl_inclusion_tbl_conjunction1` FOREIGN KEY (`id_conjunction`) REFERENCES `tbl_conjunction` (`id_conjunction`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_inclusion`
--

LOCK TABLES `tbl_inclusion` WRITE;
/*!40000 ALTER TABLE `tbl_inclusion` DISABLE KEYS */;
INSERT INTO `tbl_inclusion` VALUES (15,39),(17,43),(14,46),(16,47),(12,48),(13,49),(18,52),(19,55);
/*!40000 ALTER TABLE `tbl_inclusion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_inclusion_has_tbl_syllogism`
--

DROP TABLE IF EXISTS `tbl_inclusion_has_tbl_syllogism`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_inclusion_has_tbl_syllogism` (
  `id_inclusion` int(11) NOT NULL,
  `id_syllogism` int(11) NOT NULL,
  PRIMARY KEY (`id_inclusion`,`id_syllogism`),
  KEY `fk_tbl_inclusion_has_tbl_syllogism_tbl_syllogism1_idx` (`id_syllogism`),
  KEY `fk_tbl_inclusion_has_tbl_syllogism_tbl_inclusion1_idx` (`id_inclusion`),
  CONSTRAINT `fk_tbl_inclusion_has_tbl_syllogism_tbl_inclusion1` FOREIGN KEY (`id_inclusion`) REFERENCES `tbl_inclusion` (`id_inclusion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_inclusion_has_tbl_syllogism_tbl_syllogism1` FOREIGN KEY (`id_syllogism`) REFERENCES `tbl_syllogism` (`id_syllogism`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_inclusion_has_tbl_syllogism`
--

LOCK TABLES `tbl_inclusion_has_tbl_syllogism` WRITE;
/*!40000 ALTER TABLE `tbl_inclusion_has_tbl_syllogism` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_inclusion_has_tbl_syllogism` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_logic_system`
--

DROP TABLE IF EXISTS `tbl_logic_system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_logic_system` (
  `id_logic_system` int(11) NOT NULL AUTO_INCREMENT,
  `label` mediumtext NOT NULL,
  `description` mediumtext NOT NULL,
  `creation_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_logic_system`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_logic_system`
--

LOCK TABLES `tbl_logic_system` WRITE;
/*!40000 ALTER TABLE `tbl_logic_system` DISABLE KEYS */;
INSERT INTO `tbl_logic_system` VALUES (2,'Social organization','This is a dummy system used for the purposes of the description of the economic system under the perspective of the dynamic logic of the contradictory','2018-08-05 20:50:11');
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
  `label` varchar(50) NOT NULL,
  `description` varchar(500) NOT NULL,
  `unit` varchar(30) NOT NULL,
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
  `id_quantum` int(11) NOT NULL,
  `id_register` int(11) NOT NULL COMMENT ' ',
  PRIMARY KEY (`id_quantum`,`id_register`),
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
  `id_syllogism` int(11) NOT NULL,
  PRIMARY KEY (`id_register`),
  KEY `fk_tbl_register_tbl_syllogism1_idx` (`id_syllogism`),
  CONSTRAINT `fk_tbl_register_tbl_syllogism1` FOREIGN KEY (`id_syllogism`) REFERENCES `tbl_syllogism` (`id_syllogism`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
-- Table structure for table `tbl_time`
--

DROP TABLE IF EXISTS `tbl_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_time` (
  `id_time` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(500) NOT NULL,
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

-- Dump completed on 2018-08-08 18:55:51
