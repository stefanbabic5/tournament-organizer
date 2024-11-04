/*
SQLyog Community v13.3.0 (64 bit)
MySQL - 10.4.32-MariaDB : Database - vaterpolo1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vaterpolo1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `vaterpolo1`;

/*Table structure for table `administrator` */

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `AdministratorID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `Ime` varchar(30) NOT NULL,
  `Prezime` varchar(30) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  PRIMARY KEY (`AdministratorID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `administrator` */

insert  into `administrator`(`AdministratorID`,`Ime`,`Prezime`,`Username`,`Password`) values 
(1,'Stefan','Babic','stefan','stefan123'),
(2,'Admin','Admin','admin','admin123');

/*Table structure for table `grad` */

DROP TABLE IF EXISTS `grad`;

CREATE TABLE `grad` (
  `GradID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `NazivGrada` varchar(30) NOT NULL,
  PRIMARY KEY (`GradID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `grad` */

insert  into `grad`(`GradID`,`NazivGrada`) values 
(0,'N/A'),
(1,'Beograd'),
(2,'Kragujevac'),
(3,'Budimpesta'),
(4,'Djenova'),
(5,'Barselona'),
(6,'Atina'),
(7,'Pirej'),
(8,'Bresa');

/*Table structure for table `igrac` */

DROP TABLE IF EXISTS `igrac`;

CREATE TABLE `igrac` (
  `TimID` bigint(10) unsigned NOT NULL,
  `BrojKapice` int(7) NOT NULL,
  `Pozicija` varchar(70) NOT NULL,
  `VaterpolistaID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`TimID`,`BrojKapice`),
  KEY `fk_vaterpolista_id` (`VaterpolistaID`),
  CONSTRAINT `fk_tim_id` FOREIGN KEY (`TimID`) REFERENCES `tim` (`TimID`) ON DELETE CASCADE,
  CONSTRAINT `fk_vaterpolista_id` FOREIGN KEY (`VaterpolistaID`) REFERENCES `vaterpolista` (`VaterpolistaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `igrac` */

insert  into `igrac`(`TimID`,`BrojKapice`,`Pozicija`,`VaterpolistaID`) values 
(1,1,'Golman',1),
(1,2,'Bek',2),
(2,1,'Golman',3),
(2,2,'Bek',4),
(3,1,'Golman',5),
(3,2,'Bek',6),
(4,1,'Golman',7),
(4,2,'Bek',8),
(5,1,'Golman',9),
(5,2,'Bek',10),
(6,1,'Golman',11),
(6,2,'Bek',12),
(7,1,'Golman',13),
(7,2,'Bek',14),
(8,1,'Golman',15),
(8,2,'Bek',16),
(9,1,'Golman',17),
(9,2,'Bek',18),
(10,1,'Golman',19),
(10,2,'Bek',20);

/*Table structure for table `tabela` */

DROP TABLE IF EXISTS `tabela`;

CREATE TABLE `tabela` (
  `TurnirID` bigint(10) unsigned NOT NULL,
  `TimID` bigint(10) unsigned NOT NULL,
  `homeWins` int(7) DEFAULT NULL,
  `homeWinsPenalty` int(7) DEFAULT NULL,
  `homeLossesPenalty` int(7) DEFAULT NULL,
  `homeLosses` int(7) DEFAULT NULL,
  `awayWins` int(7) DEFAULT NULL,
  `awayWinsPenalty` int(7) DEFAULT NULL,
  `awayLossesPenalty` int(7) DEFAULT NULL,
  `awayLosses` int(7) DEFAULT NULL,
  `scoredHome` int(7) DEFAULT NULL,
  `allowedHome` int(7) DEFAULT NULL,
  `scoredAway` int(7) DEFAULT NULL,
  `allowedAway` int(7) DEFAULT NULL,
  `pointsHome` int(7) DEFAULT NULL,
  `pointsAway` int(7) DEFAULT NULL,
  PRIMARY KEY (`TurnirID`,`TimID`),
  KEY `fk_tabelatim_id` (`TimID`),
  CONSTRAINT `fk_tabelatim_id` FOREIGN KEY (`TimID`) REFERENCES `tim` (`TimID`),
  CONSTRAINT `fk_tabelaturnir_id` FOREIGN KEY (`TurnirID`) REFERENCES `turnir` (`TurnirID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `tabela` */

insert  into `tabela`(`TurnirID`,`TimID`,`homeWins`,`homeWinsPenalty`,`homeLossesPenalty`,`homeLosses`,`awayWins`,`awayWinsPenalty`,`awayLossesPenalty`,`awayLosses`,`scoredHome`,`allowedHome`,`scoredAway`,`allowedAway`,`pointsHome`,`pointsAway`) values 
(52,1,1,0,0,2,2,0,0,1,30,34,27,30,3,6),
(52,2,1,0,0,2,0,0,0,3,35,34,16,30,3,0),
(52,3,2,0,1,0,2,0,0,1,36,27,37,31,7,6),
(52,4,2,0,0,1,2,0,0,1,21,25,37,32,6,6),
(52,5,1,1,0,1,1,0,0,2,26,26,32,34,5,3),
(52,6,2,0,0,1,1,1,1,0,33,24,37,29,6,6),
(52,7,1,0,0,2,1,0,0,2,34,38,22,29,3,3),
(53,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
(53,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
(53,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
(53,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
(53,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0);

/*Table structure for table `tim` */

DROP TABLE IF EXISTS `tim`;

CREATE TABLE `tim` (
  `TimID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `NazivTima` varchar(50) NOT NULL,
  `GradID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`TimID`),
  KEY `fk_grad_id` (`GradID`),
  CONSTRAINT `fk_grad_id` FOREIGN KEY (`GradID`) REFERENCES `grad` (`GradID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tim` */

insert  into `tim`(`TimID`,`NazivTima`,`GradID`) values 
(0,'N/A',0),
(1,'Partizan',1),
(2,'Crvena Zvezda',1),
(3,'Novi Beograd',1),
(4,'Radnicki',2),
(5,'Ferencvaros',3),
(6,'Pro Reko',4),
(7,'Barseloneta',5),
(8,'Panatanaikos',6),
(9,'Olympiakos',7),
(10,'Brescia',8);

/*Table structure for table `turnir` */

DROP TABLE IF EXISTS `turnir`;

CREATE TABLE `turnir` (
  `TurnirID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `NazivTurnira` varchar(50) NOT NULL,
  `DatumPocetka` date NOT NULL,
  `DatumKraja` date NOT NULL,
  `TipTurnira` enum('Liga','Kup') NOT NULL,
  `GradID` bigint(10) unsigned NOT NULL,
  `AdministratorID` bigint(10) unsigned NOT NULL,
  `Pobednik` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TurnirID`),
  KEY `fk_admin_id` (`AdministratorID`),
  KEY `fk_grad2_id` (`GradID`),
  CONSTRAINT `fk_admin_id` FOREIGN KEY (`AdministratorID`) REFERENCES `administrator` (`AdministratorID`),
  CONSTRAINT `fk_grad2_id` FOREIGN KEY (`GradID`) REFERENCES `grad` (`GradID`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `turnir` */

insert  into `turnir`(`TurnirID`,`NazivTurnira`,`DatumPocetka`,`DatumKraja`,`TipTurnira`,`GradID`,`AdministratorID`,`Pobednik`) values 
(1,'Liga Sampiona 2022','2022-04-10','2022-06-10','Kup',1,1,'Partizan'),
(2,'Liga Sampiona 2023','2023-04-10','2023-06-10','Kup',2,1,'Barseloneta'),
(3,'Kup Srbije 2023','2023-09-10','2023-11-10','Kup',3,1,''),
(52,'Turnir','2023-08-10','2023-08-20','Liga',1,1,'Novi Beograd'),
(53,'Turnir1','2023-08-10','2023-08-20','Liga',1,1,'');

/*Table structure for table `utakmica` */

DROP TABLE IF EXISTS `utakmica`;

CREATE TABLE `utakmica` (
  `TurnirID` bigint(10) unsigned NOT NULL,
  `Kolo` varchar(50) NOT NULL,
  `RbUtakmice` int(7) NOT NULL,
  `BrojGolovaPrviTim` int(7) DEFAULT NULL,
  `BrojGolovaDrugiTim` int(7) DEFAULT NULL,
  `PrviTimID` bigint(10) unsigned NOT NULL,
  `DrugiTimID` bigint(10) unsigned NOT NULL,
  `PobednikID` bigint(10) unsigned NOT NULL,
  `PenaliPrvi` int(7) DEFAULT NULL,
  `PenaliDrugi` int(7) DEFAULT NULL,
  PRIMARY KEY (`TurnirID`,`RbUtakmice`,`Kolo`),
  KEY `fk_prviTim_id` (`PrviTimID`),
  KEY `fk_drugiTim_id` (`DrugiTimID`),
  KEY `fk_pobednik_id` (`PobednikID`),
  CONSTRAINT `fk_drugiTim_id` FOREIGN KEY (`DrugiTimID`) REFERENCES `tim` (`TimID`),
  CONSTRAINT `fk_pobednik_id` FOREIGN KEY (`PobednikID`) REFERENCES `tim` (`TimID`),
  CONSTRAINT `fk_prviTim_id` FOREIGN KEY (`PrviTimID`) REFERENCES `tim` (`TimID`),
  CONSTRAINT `fk_turnir_id` FOREIGN KEY (`TurnirID`) REFERENCES `turnir` (`TurnirID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `utakmica` */

insert  into `utakmica`(`TurnirID`,`Kolo`,`RbUtakmice`,`BrojGolovaPrviTim`,`BrojGolovaDrugiTim`,`PrviTimID`,`DrugiTimID`,`PobednikID`,`PenaliPrvi`,`PenaliDrugi`) values 
(1,'1',1,0,2,3,1,1,0,0),
(1,'2',1,3,0,1,2,1,0,0),
(1,'Finale',1,10,9,1,6,1,0,0),
(1,'1',2,3,4,5,2,2,0,0),
(1,'2',2,5,6,4,6,6,0,0),
(1,'1',3,5,0,4,8,4,0,0),
(1,'1',4,4,4,6,7,6,2,0),
(2,'1',1,5,4,3,4,3,0,0),
(2,'2',1,0,10,3,1,1,0,0),
(2,'Finale',1,3,5,1,7,7,0,0),
(2,'1',2,2,3,6,1,1,0,0),
(2,'2',2,2,6,5,7,7,0,0),
(2,'1',3,2,2,2,5,5,0,1),
(2,'1',4,4,6,10,7,7,0,0),
(3,'1',1,NULL,NULL,2,1,0,NULL,NULL),
(3,'Finale',1,NULL,NULL,0,0,0,NULL,NULL),
(3,'1',2,NULL,NULL,3,4,0,NULL,NULL),
(52,'1',1,11,14,7,1,1,0,0),
(52,'2',1,12,15,2,3,3,0,0),
(52,'3',1,10,14,6,4,4,0,0),
(52,'4',1,11,14,1,4,4,0,0),
(52,'5',1,12,5,6,7,6,0,0),
(52,'6',1,12,5,1,2,1,0,0),
(52,'7',1,8,7,4,5,4,0,0),
(52,'1',2,12,14,2,5,5,0,0),
(52,'2',2,7,15,1,6,6,0,0),
(52,'3',2,9,13,7,3,3,0,0),
(52,'4',2,10,9,5,3,5,0,0),
(52,'5',2,13,6,3,1,3,0,0),
(52,'6',2,10,10,5,6,5,4,2),
(52,'7',2,12,12,3,6,6,1,4),
(52,'1',3,11,9,3,4,3,0,0),
(52,'2',3,14,11,7,5,7,0,0),
(52,'3',3,6,7,5,1,1,0,0),
(52,'4',3,11,5,6,2,6,0,0),
(52,'5',3,7,6,4,2,4,0,0),
(52,'6',3,6,12,4,7,7,0,0),
(52,'7',3,11,5,2,7,2,0,0),
(53,'1',1,NULL,NULL,5,1,0,NULL,NULL),
(53,'10',1,NULL,NULL,5,2,0,NULL,NULL),
(53,'2',1,NULL,NULL,1,4,0,NULL,NULL),
(53,'3',1,NULL,NULL,3,1,0,NULL,NULL),
(53,'4',1,NULL,NULL,4,5,0,NULL,NULL),
(53,'5',1,NULL,NULL,2,5,0,NULL,NULL),
(53,'6',1,NULL,NULL,1,5,0,NULL,NULL),
(53,'7',1,NULL,NULL,4,1,0,NULL,NULL),
(53,'8',1,NULL,NULL,1,3,0,NULL,NULL),
(53,'9',1,NULL,NULL,5,4,0,NULL,NULL),
(53,'1',2,NULL,NULL,2,3,0,NULL,NULL),
(53,'10',2,NULL,NULL,4,3,0,NULL,NULL),
(53,'2',2,NULL,NULL,5,3,0,NULL,NULL),
(53,'3',2,NULL,NULL,4,2,0,NULL,NULL),
(53,'4',2,NULL,NULL,1,2,0,NULL,NULL),
(53,'5',2,NULL,NULL,3,4,0,NULL,NULL),
(53,'6',2,NULL,NULL,3,2,0,NULL,NULL),
(53,'7',2,NULL,NULL,3,5,0,NULL,NULL),
(53,'8',2,NULL,NULL,2,4,0,NULL,NULL),
(53,'9',2,NULL,NULL,2,1,0,NULL,NULL);

/*Table structure for table `vaterpolista` */

DROP TABLE IF EXISTS `vaterpolista`;

CREATE TABLE `vaterpolista` (
  `VaterpolistaID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `ImeVaterpoliste` varchar(30) NOT NULL,
  `PrezimeVaterpoliste` varchar(30) NOT NULL,
  `DatumRodjenja` date NOT NULL,
  PRIMARY KEY (`VaterpolistaID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `vaterpolista` */

insert  into `vaterpolista`(`VaterpolistaID`,`ImeVaterpoliste`,`PrezimeVaterpoliste`,`DatumRodjenja`) values 
(1,'Slobodan','Soro','1978-12-23'),
(2,'Andrija','Prlainovic','1987-04-28'),
(3,'Milan','Aleksic','1986-05-13'),
(4,'Stefan','Mitrovic','1988-03-29'),
(5,'Radoslav','Filipovic','1997-08-19'),
(6,'Strahinja','Rasovic','1992-03-09'),
(7,'Filip','Filipovic','1987-05-02'),
(8,'Nikola','Jaksic','1997-01-17'),
(9,'Bendeguz','Sipos','2003-03-31'),
(10,'Stylianos','Argyropoulos','1996-08-02'),
(11,'Nemanja','Ubovic','1991-02-24'),
(12,'Dusan','Mandic','1994-06-16'),
(13,'Lazar','Dobozanov','1995-12-21'),
(14,'Filip','Jankovic','1996-10-05'),
(15,'Bogdan','Gavrilovic','2004-07-06'),
(16,'Milos','Cuk','1990-12-21'),
(17,'Stefano','Tempesti','1979-06-09'),
(18,'Vanja','Udovicic','1982-09-12'),
(19,'Danilo','Ikodinovic','1976-10-04'),
(20,'Danijel','Premus','1981-04-15'),
(21,'Nick','Porter','1998-06-23'),
(22,'Dusan','Matkovic','1999-02-01'),
(23,'Alejandro','Bustos','1997-03-17'),
(24,'Felipe','Perrone','1986-02-27');

/* Trigger structure for table `tabela` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `update_points_home_before_update` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `update_points_home_before_update` BEFORE UPDATE ON `tabela` FOR EACH ROW 
BEGIN
    SET NEW.pointsHome = 3 * NEW.homeWins
                   + 2 * NEW.homeWinsPenalty 
                   + NEW.homeLossesPenalty;
END */$$


DELIMITER ;

/* Trigger structure for table `tabela` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `update_points_away_before_update` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `update_points_away_before_update` BEFORE UPDATE ON `tabela` FOR EACH ROW 
BEGIN
    SET NEW.pointsAway = 3 * NEW.awayWins 
                   + 2 * NEW.awayWinsPenalty 
                   + NEW.awayLossesPenalty;
END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
