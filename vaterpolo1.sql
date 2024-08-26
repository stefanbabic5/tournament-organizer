/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 10.4.28-MariaDB : Database - vaterpolo1
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
  `SlobodanProlaz` varchar(200) NOT NULL,
  `GradID` bigint(10) unsigned NOT NULL,
  `AdministratorID` bigint(10) unsigned NOT NULL,
  `Pobednik` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TurnirID`),
  KEY `fk_grad2_id` (`GradID`),
  KEY `fk_admin_id` (`AdministratorID`),
  CONSTRAINT `fk_admin_id` FOREIGN KEY (`AdministratorID`) REFERENCES `administrator` (`AdministratorID`),
  CONSTRAINT `fk_grad2_id` FOREIGN KEY (`GradID`) REFERENCES `grad` (`GradID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `turnir` */

insert  into `turnir`(`TurnirID`,`NazivTurnira`,`DatumPocetka`,`DatumKraja`,`SlobodanProlaz`,`GradID`,`AdministratorID`,`Pobednik`) values 
(1,'Liga Sampiona 2022','2022-04-10','2022-06-10','N/A',8,1,'Partizan'),
(2,'Liga Sampiona 2023','2023-04-10','2023-06-10','N/A',8,1,'Barseloneta'),
(3,'Kup Srbije 2023','2023-09-10','2023-11-10','N/A',1,1,'');

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
(3,'1',2,NULL,NULL,3,4,0,NULL,NULL);

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

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
