-- --------------------------------------------------------
-- Host:                         192.168.1.50
-- Versión del servidor:         5.7.29-0ubuntu0.18.04.1 - (Ubuntu)
-- SO del servidor:              Linux
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para arcoteldb
CREATE DATABASE IF NOT EXISTS `arcoteldb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `arcoteldb`;

-- Volcando estructura para tabla arcoteldb.cellularscancdma
CREATE TABLE IF NOT EXISTS `cellularscancdma` (
  `scanid` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` varchar(20) NOT NULL,
  `countryISO` varchar(3) NOT NULL,
  `phoneOperatorId` varchar(20) NOT NULL,
  `simOperatorId` varchar(8) NOT NULL,
  `operatorMcc` varchar(5) NOT NULL,
  `operatorMnc` varchar(5) NOT NULL,
  `devManufacturer` varchar(20) NOT NULL,
  `devModel` varchar(20) NOT NULL,
  `isConected` varchar(15) NOT NULL,
  `phoneNetStandard` varchar(5) NOT NULL,
  `phoneNetTechnology` varchar(12) NOT NULL,
  `internetConNetwork` varchar(7) NOT NULL,
  `latitude` varchar(15) NOT NULL,
  `longitude` varchar(15) NOT NULL,
  `pingTimeMilis` varchar(15) NOT NULL,
  `downloadSpeed` varchar(15) NOT NULL,
  `uploadSpeed` varchar(15) NOT NULL,
  `phoneSignalStrength` int(11) NOT NULL,
  `phoneAsuStrength` int(11) NOT NULL,
  `phoneSignalLevel` int(11) NOT NULL,
  `cellBslat` int(11) NOT NULL,
  `cellBslon` int(11) NOT NULL,
  `cellSid` int(11) NOT NULL,
  `cellNid` int(11) NOT NULL,
  `cellBid` int(11) NOT NULL,
  `signalQuality` varchar(10) NOT NULL,
  `fieldIsRegistered` int(11) NOT NULL,
  PRIMARY KEY (`scanid`) USING BTREE,
  UNIQUE KEY `scanid_UNIQUE` (`scanid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla para almacenar informción lte';

-- Volcando datos para la tabla arcoteldb.cellularscancdma: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cellularscancdma` DISABLE KEYS */;
/*!40000 ALTER TABLE `cellularscancdma` ENABLE KEYS */;

-- Volcando estructura para tabla arcoteldb.cellularscangsm
CREATE TABLE IF NOT EXISTS `cellularscangsm` (
  `scanid` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` varchar(20) NOT NULL,
  `countryISO` varchar(3) NOT NULL,
  `phoneOperatorId` varchar(20) NOT NULL,
  `simOperatorId` varchar(8) NOT NULL,
  `operatorMcc` varchar(5) NOT NULL,
  `operatorMnc` varchar(5) NOT NULL,
  `devManufacturer` varchar(20) NOT NULL,
  `devModel` varchar(20) NOT NULL,
  `isConected` varchar(15) NOT NULL,
  `phoneNetStandard` varchar(5) NOT NULL,
  `phoneNetTechnology` varchar(12) NOT NULL,
  `internetConNetwork` varchar(7) NOT NULL,
  `latitude` varchar(15) NOT NULL,
  `longitude` varchar(15) NOT NULL,
  `pingTimeMilis` varchar(15) NOT NULL,
  `downloadSpeed` varchar(15) NOT NULL,
  `uploadSpeed` varchar(15) NOT NULL,
  `phoneSignalStrength` int(11) NOT NULL,
  `phoneAsuStrength` int(11) NOT NULL,
  `phoneSignalLevel` int(11) NOT NULL,
  `cellGsmLac` int(11) NOT NULL,
  `cellGsmCid` int(11) NOT NULL,
  `cellGsmArcfn` int(11) NOT NULL,
  `signalQuality` varchar(10) NOT NULL,
  `fieldIsRegistered` int(11) NOT NULL,
  PRIMARY KEY (`scanid`) USING BTREE,
  UNIQUE KEY `scanid_UNIQUE` (`scanid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla para almacenar informción lte';

-- Volcando datos para la tabla arcoteldb.cellularscangsm: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cellularscangsm` DISABLE KEYS */;
/*!40000 ALTER TABLE `cellularscangsm` ENABLE KEYS */;

-- Volcando estructura para tabla arcoteldb.cellularscanlte
CREATE TABLE IF NOT EXISTS `cellularscanlte` (
  `scanid` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` varchar(20) NOT NULL,
  `countryISO` varchar(3) NOT NULL,
  `phoneOperatorId` varchar(20) NOT NULL,
  `simOperatorId` varchar(8) NOT NULL,
  `operatorMcc` varchar(5) NOT NULL,
  `operatorMnc` varchar(5) NOT NULL,
  `devManufacturer` varchar(20) NOT NULL,
  `devModel` varchar(20) NOT NULL,
  `isConected` varchar(15) NOT NULL,
  `phoneNetStandard` varchar(5) NOT NULL,
  `phoneNetTechnology` varchar(12) NOT NULL,
  `internetConNetwork` varchar(7) NOT NULL,
  `latitude` varchar(15) NOT NULL,
  `longitude` varchar(15) NOT NULL,
  `pingTimeMilis` varchar(15) NOT NULL,
  `downloadSpeed` varchar(15) NOT NULL,
  `uploadSpeed` varchar(15) NOT NULL,
  `phoneSignalStrength` int(11) NOT NULL,
  `phoneAsuStrength` int(11) NOT NULL,
  `phoneSignalLevel` int(11) NOT NULL,
  `phoneRsrpStrength` int(11) NOT NULL,
  `phoneRsrqStrength` int(11) NOT NULL,
  `phoneRssnrStrength` varchar(15) NOT NULL,
  `phoneTimingAdvance` int(11) NOT NULL,
  `phoneCqiStrength` int(11) NOT NULL,
  `cellLtePci` int(11) NOT NULL,
  `cellLteTac` int(11) NOT NULL,
  `cellLteeNodeB` int(11) NOT NULL,
  `cellLteCid` int(11) NOT NULL,
  `cellLteEarfcn` int(11) NOT NULL,
  `signalQuality` varchar(10) NOT NULL,
  `fieldIsRegistered` int(11) NOT NULL,
  PRIMARY KEY (`scanid`) USING BTREE,
  UNIQUE KEY `scanid_UNIQUE` (`scanid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla para almacenar informción lte';

-- Volcando datos para la tabla arcoteldb.cellularscanlte: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cellularscanlte` DISABLE KEYS */;
/*!40000 ALTER TABLE `cellularscanlte` ENABLE KEYS */;

-- Volcando estructura para tabla arcoteldb.cellularscantb
CREATE TABLE IF NOT EXISTS `cellularscantb` (
  `scanid` int(11) NOT NULL AUTO_INCREMENT,
  `countryiso` varchar(3) NOT NULL,
  `operatorid` varchar(8) NOT NULL,
  `operatorname` varchar(20) NOT NULL,
  `isconected` varchar(15) NOT NULL,
  `phonesignaltype` varchar(5) NOT NULL,
  `phonenetworktype` varchar(12) NOT NULL,
  `signalquality` varchar(10) NOT NULL,
  `networkconectivitytype` varchar(7) NOT NULL,
  `phonesignalstrength` varchar(11) NOT NULL,
  `downloadmovilespeed` int(11) NOT NULL,
  `uploadmovilspeed` int(11) NOT NULL,
  `wifispeed` int(11) NOT NULL,
  `latitude` varchar(15) NOT NULL,
  `longitude` varchar(15) NOT NULL,
  PRIMARY KEY (`scanid`),
  UNIQUE KEY `scanid_UNIQUE` (`scanid`)
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8 COMMENT='Tabla para almacenar informción de la aplicación android';

-- Volcando datos para la tabla arcoteldb.cellularscantb: ~171 rows (aproximadamente)
/*!40000 ALTER TABLE `cellularscantb` DISABLE KEYS */;
INSERT INTO `cellularscantb` (`scanid`, `countryiso`, `operatorid`, `operatorname`, `isconected`, `phonesignaltype`, `phonenetworktype`, `signalquality`, `networkconectivitytype`, `phonesignalstrength`, `downloadmovilespeed`, `uploadmovilspeed`, `wifispeed`, `latitude`, `longitude`) VALUES
	(1, 'ec', '7400', '#QuedateEnCasa', 'Conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-77', 0, 0, 1, '', ''),
	(2, 'ec', '7400', '#QuedateEnCasa', 'Conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-77', 0, 0, 1, '', ''),
	(3, 'ec', '7400', '#QuedateEnCasa', 'Conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-77', 0, 0, 1, '', ''),
	(4, 'ec', '7400', '#QuedateEnCasa', 'Conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-77', 0, 0, 1, '', ''),
	(5, 'ec', '7400', '#QuedateEnCasa', 'Conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-77', 0, 0, 1, '', ''),
	(6, 'ec', '7400', '#QuedateEnCasa', 'Conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-77', 0, 0, 1, '', ''),
	(7, 'ec', '7400', '#QuedateEnCasa', 'Conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-77', 0, 0, 1, '', ''),
	(8, 'ec', '7400', '#QuedateEnCasa', 'Conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-77', 0, 0, 1, '', ''),
	(9, 'ec', '7400', '#QuedateEnCasa', 'Conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-77', 0, 0, 1, '', ''),
	(10, 'ec', '7400', '#QuedateEnCasa', 'Conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-77', 0, 0, 1, '', ''),
	(11, 'US', '7400', 'movistar', 'conected', 'GSM', 'UMTS', 'BUENA', 'WIFI', '-74', 30, 30, 2, '', ''),
	(12, 'US', '7400', 'claro', 'conected', 'GSM', 'UMTS', 'BUENA', 'WIFI', '-74', 30, 30, 2, '', ''),
	(13, 'US', '7400', 'cnt', 'conected', 'GSM', 'UMTS', 'BUENA', 'WIFI', '-74', 30, 30, 2, '', ''),
	(14, 'US', '7400', 'vodafone', 'conected', 'GSM', 'UMTS', 'BUENA', 'WIFI', '-74', 30, 30, 2, '', ''),
	(15, 'us', '310260', 'Android', 'conectado', 'GSM', 'GPRS', 'AVERAGE', 'MOBILE', '-77', 80, 80, 0, '', ''),
	(16, 'us', '310260', 'Android', 'conectado', 'GSM', 'GPRS', 'AVERAGE', 'MOBILE', '-77', 80, 80, 0, '', ''),
	(17, 'us', '310260', 'Android', 'conectado', 'GSM', 'GPRS', 'AVERAGE', 'MOBILE', '-77', 80, 80, 0, '', ''),
	(18, 'us', '310260', 'Android', 'conectado', 'GSM', 'GPRS', 'AVERAGE', 'MOBILE', '-77', 80, 80, 0, '', ''),
	(19, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'GOOD', 'WIFI', '-71', 0, 0, 4, '', ''),
	(20, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-77', 0, 0, 4, '', ''),
	(21, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-77', 0, 0, 4, '', ''),
	(22, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'BAD', 'WIFI', '-81', 0, 0, 4, '', ''),
	(23, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'BAD', 'WIFI', '-81', 0, 0, 4, '', ''),
	(24, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'GOOD', 'WIFI', '-71', 0, 0, 4, '', ''),
	(25, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-77', 0, 0, 4, '', ''),
	(26, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'GOOD', 'WIFI', '-75', 0, 0, 3, '', ''),
	(27, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-79', 0, 0, 4, '', ''),
	(28, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'GOOD', 'WIFI', '-75', 0, 0, 4, '', ''),
	(29, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'WIFI', '-79', 0, 0, 4, '', ''),
	(30, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'WIFI', '-79', 0, 0, 4, '', ''),
	(31, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-73', 0, 0, 4, '', ''),
	(32, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-75', 0, 0, 4, '', ''),
	(33, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'WIFI', '-79', 0, 0, 4, '', ''),
	(34, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'WIFI', '-77', 0, 0, 4, '', ''),
	(35, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-79', 0, 0, 4, '', ''),
	(36, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'GOOD', 'WIFI', '-75', 0, 0, 4, '', ''),
	(37, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-77', 0, 0, 4, '', ''),
	(38, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-77', 0, 0, 4, '', ''),
	(39, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'BAD', 'WIFI', '-81', 0, 0, 4, '', ''),
	(40, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-79', 0, 0, 4, '', ''),
	(41, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'VERY_GOOD', 'WIFI', '-69', 0, 0, 4, '', ''),
	(42, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'VERY_GOOD', 'WIFI', '-67', 0, 0, 4, '', ''),
	(43, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'VERY_GOOD', 'WIFI', '-69', 0, 0, 4, '', ''),
	(44, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'VERY_GOOD', 'WIFI', '-65', 0, 0, 4, '', ''),
	(45, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'VERY_GOOD', 'WIFI', '-69', 0, 0, 4, '', ''),
	(46, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'BAD', 'WIFI', '-81', 0, 0, 4, '', ''),
	(47, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-79', 0, 0, 4, '', ''),
	(48, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'GOOD', 'WIFI', '-75', 0, 0, 4, '', ''),
	(49, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-79', 0, 0, 4, '', ''),
	(50, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'BAD', 'WIFI', '-81', 0, 0, 4, '', ''),
	(51, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-77', 43008, 11264, 0, '', ''),
	(52, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-77', 43008, 11264, 0, '', ''),
	(53, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'BAD', 'MOBILE', '-81', 43008, 11264, 0, '', ''),
	(54, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'BAD', 'MOBILE', '-81', 43008, 11264, 0, '', ''),
	(55, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-77', 43008, 11264, 0, '', ''),
	(56, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-77', 43008, 11264, 0, '', ''),
	(57, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-79', 43008, 11264, 0, '', ''),
	(58, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-79', 43008, 11264, 0, '', ''),
	(59, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'BAD', 'MOBILE', '-83', 43008, 11264, 0, '', ''),
	(60, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'AVERAGE', 'MOBILE', '-79', 384, 384, 0, '', ''),
	(61, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-79', 0, 0, 4, '', ''),
	(62, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'GOOD', 'WIFI', '-73', 0, 0, 4, '', ''),
	(63, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-77', 0, 0, 4, '', ''),
	(64, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'GOOD', 'WIFI', '-75', 0, 0, 4, '', ''),
	(65, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'GOOD', 'WIFI', '-73', 0, 0, 4, '', ''),
	(66, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'GOOD', 'MOBILE', '-73', 384, 384, 0, '', ''),
	(67, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 43008, 11264, 0, '', ''),
	(68, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-75', 43008, 11264, 0, '', ''),
	(69, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-75', 43008, 11264, 0, '', ''),
	(70, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 43008, 11264, 0, '', ''),
	(71, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 43008, 11264, 0, '', ''),
	(72, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 43008, 11264, 0, '', ''),
	(73, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 2230, 44, 0, '', ''),
	(74, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 2230, 44, 0, '', ''),
	(75, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 2230, 44, 0, '', ''),
	(76, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 2230, 44, 0, '', ''),
	(77, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 2230, 44, 0, '', ''),
	(78, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 2230, 44, 0, '', ''),
	(79, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 2230, 44, 0, '', ''),
	(80, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 2230, 44, 0, '', ''),
	(81, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 2230, 44, 0, '', ''),
	(82, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 2230, 44, 0, '', ''),
	(83, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 2230, 44, 0, '', ''),
	(84, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 2230, 44, 0, '', ''),
	(85, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 2230, 44, 0, '', ''),
	(86, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 2230, 44, 0, '', ''),
	(87, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 2230, 44, 0, '', ''),
	(88, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 2230, 44, 0, '', ''),
	(89, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-73', 2230, 44, 0, '', ''),
	(90, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-73', 0, 0, 4, '', ''),
	(91, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-73', 0, 0, 4, '', ''),
	(92, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-71', 0, 0, 4, '', ''),
	(93, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'BAD', 'MOBILE', '-81', 5114, 178, 0, '', ''),
	(94, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-79', 5114, 0, 0, '', ''),
	(95, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-75', 5114, 19, 0, '', ''),
	(96, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'BAD', 'MOBILE', '-81', 43008, 11264, 0, '', ''),
	(97, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'BAD', 'MOBILE', '-81', 384, 384, 0, '', ''),
	(98, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-71', 5114, 185, 0, '', ''),
	(99, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'BAD', 'MOBILE', '-81', 5114, 56, 0, '', ''),
	(100, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-77', 5114, 243, 0, '', ''),
	(101, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'BAD', 'MOBILE', '-81', 43008, 11264, 0, '', ''),
	(102, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'GOOD', 'MOBILE', '-73', 384, 384, 0, '', ''),
	(103, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-71', 5114, 751, 0, '', ''),
	(104, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-77', 5114, 46, 0, '', ''),
	(105, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-77', 5114, 860, 0, '', ''),
	(106, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-77', 5114, 219, 0, '', ''),
	(107, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'VERY_GOOD', 'MOBILE', '-69', 5114, 219, 0, '', ''),
	(108, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-77', 5114, 219, 0, '', ''),
	(109, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'GOOD', 'WIFI', '-71', 0, 0, 3, '', ''),
	(110, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'GOOD', 'WIFI', '-75', 0, 0, 3, '', ''),
	(111, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'GOOD', 'WIFI', '-75', 0, 0, 3, '', ''),
	(112, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-77', 5114, 0, 0, '', ''),
	(113, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-79', 5114, 0, 0, '', ''),
	(114, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-75', 0, 0, 3, '', ''),
	(115, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-73', 0, 0, 4, '-0.34084', '-78.5302'),
	(116, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'VERY_GOOD', 'WIFI', '-69', 0, 0, 4, '-0.258898', '-78.5499'),
	(117, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'VERY_GOOD', 'WIFI', '-69', 0, 0, 4, '-0.270934', '-78.5519'),
	(118, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'VERY_GOOD', 'WIFI', '-69', 0, 0, 4, '-0.27762', '-78.5548'),
	(119, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'VERY_GOOD', 'WIFI', '-69', 0, 0, 4, '-0.280946', '-78.5495'),
	(120, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-71', 0, 0, 4, '-0.294926', '-78.5402'),
	(121, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-71', 0, 0, 4, '-0.305642', '-78.5432'),
	(122, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-71', 0, 0, 4, '-0.316798', '-78.5489'),
	(123, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'VERY_GOOD', 'WIFI', '-69', 0, 0, 4, '-0.338428', '-78.5496'),
	(124, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'VERY_GOOD', 'WIFI', '-69', 0, 0, 4, '-0.339597', '-78.5419'),
	(125, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'VERY_GOOD', 'WIFI', '-69', 0, 0, 4, '-0.341969', '-78.5301'),
	(126, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-78', 0, 0, 4, '-0.282966', '-78.5441'),
	(127, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'AVERAGE', 'WIFI', '-79', 0, 0, 4, '-0.286783', '-78.5414'),
	(128, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'BAD', 'WIFI', '-90', 0, 0, 4, '-0.308683', '-78.5451'),
	(129, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'BAD', 'WIFI', '-85', 0, 0, 4, '-0.329035', '-78.5332'),
	(130, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'GOOD', 'WIFI', '-75', 0, 0, 4, '-0.341349', '-78.5296'),
	(131, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'GOOD', 'WIFI', '-75', 0, 0, 4, '-0.341349', '-78.5296'),
	(132, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'GOOD', 'WIFI', '-75', 0, 0, 4, '-0.341349', '-78.5296'),
	(133, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'GOOD', 'WIFI', '-75', 0, 0, 4, '-0.341349', '-78.5296'),
	(134, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-75', 0, 0, 4, '-0.341349', '-78.5296'),
	(135, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-75', 0, 0, 4, '-0.341349', '-78.5296'),
	(136, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-75', 0, 0, 4, '-0.341176', '-78.5298'),
	(137, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-75', 0, 0, 4, '-0.341143', '-78.5298'),
	(138, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-75', 0, 0, 4, '-0.341143', '-78.5298'),
	(139, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-75', 0, 0, 4, '-0.341143', '-78.5298'),
	(140, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-75', 0, 0, 4, '-0.341143', '-78.5298'),
	(141, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-75', 0, 0, 4, '-0.341143', '-78.5298'),
	(142, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'WIFI', '-75', 0, 0, 4, '-0.341143', '-78.5298'),
	(143, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'UMTS', 'VERY_GOOD', 'WIFI', '-65', 0, 0, 4, '-0.340895', '-78.5298'),
	(144, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-79', 43008, 11264, 0, '-0.341101', '-78.5299'),
	(145, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-77', 0, 520, 0, '-0.341082', '-78.5299'),
	(146, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-77', 0, 520, 0, '-0.341082', '-78.5299'),
	(147, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-77', 0, 520, 0, '-0.341082', '-78.5299'),
	(148, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-77', 0, 520, 0, '-0.341082', '-78.5299'),
	(149, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-77', 0, 520, 0, '-0.341082', '-78.5299'),
	(150, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-77', 0, 520, 0, '-0.341082', '-78.5299'),
	(151, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-77', 0, 520, 0, '-0.341082', '-78.5299'),
	(152, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-79', 0, 223, 0, '-0.341087', '-78.5299'),
	(153, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-79', 0, 223, 0, '-0.341087', '-78.5299'),
	(154, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-79', 0, 223, 0, '-0.341087', '-78.5299'),
	(155, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-79', 0, 223, 0, '-0.341087', '-78.5299'),
	(156, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-75', 43008, 11264, 0, '-0.341082', '-78.5299'),
	(157, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-75', 43008, 11264, 0, '-0.341082', '-78.5299'),
	(158, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-75', 43008, 11264, 0, '-0.341082', '-78.5299'),
	(159, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-75', 43008, 11264, 0, '-0.341082', '-78.5299'),
	(160, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-75', 43008, 11264, 0, '-0.341082', '-78.5299'),
	(161, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-75', 43008, 11264, 0, '-0.341082', '-78.5299'),
	(162, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-75', 43008, 11264, 0, '-0.341082', '-78.5299'),
	(163, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-75', 43008, 11264, 0, '-0.341082', '-78.5299'),
	(164, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-75', 43008, 11264, 0, '-0.341082', '-78.5299'),
	(165, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-75', 43008, 11264, 0, '-0.341082', '-78.5299'),
	(166, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'GOOD', 'MOBILE', '-75', 43008, 11264, 0, '-0.341082', '-78.5299'),
	(167, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-79', 0, 196, 0, '-0.341081', '-78.5299'),
	(168, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-79', 0, 196, 0, '-0.341081', '-78.5299'),
	(169, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-79', 0, 196, 0, '-0.341081', '-78.5299'),
	(170, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-79', 0, 196, 0, '-0.341081', '-78.5299'),
	(171, 'ec', '74000', '#QuedateEnCasa', 'conectado', 'GSM', 'HSPA+', 'AVERAGE', 'MOBILE', '-79', 0, 196, 0, '-0.341081', '-78.5299');
/*!40000 ALTER TABLE `cellularscantb` ENABLE KEYS */;

-- Volcando estructura para tabla arcoteldb.cellularscanwcdma
CREATE TABLE IF NOT EXISTS `cellularscanwcdma` (
  `scanid` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` varchar(20) NOT NULL,
  `countryISO` varchar(3) NOT NULL,
  `phoneOperatorId` varchar(20) NOT NULL,
  `simOperatorId` varchar(8) NOT NULL,
  `operatorMcc` varchar(5) NOT NULL,
  `operatorMnc` varchar(5) NOT NULL,
  `devManufacturer` varchar(20) NOT NULL,
  `devModel` varchar(20) NOT NULL,
  `isConected` varchar(15) NOT NULL,
  `phoneNetStandard` varchar(5) NOT NULL,
  `phoneNetTechnology` varchar(12) NOT NULL,
  `internetConNetwork` varchar(7) NOT NULL,
  `latitude` varchar(15) NOT NULL,
  `longitude` varchar(15) NOT NULL,
  `pingTimeMilis` varchar(15) NOT NULL,
  `downloadSpeed` varchar(15) NOT NULL,
  `uploadSpeed` varchar(15) NOT NULL,
  `phoneSignalStrength` int(11) NOT NULL,
  `phoneAsuStrength` int(11) NOT NULL,
  `phoneSignalLevel` int(11) NOT NULL,
  `cellWcdmaLac` int(11) NOT NULL,
  `cellWcdmaUcid` int(11) NOT NULL,
  `cellWcdmaPsc` int(11) NOT NULL,
  `cellWcdmaCid` int(11) NOT NULL,
  `cellWcdmaRnc` int(11) NOT NULL,
  `cellWcdmaUarfcn` int(11) NOT NULL,
  `signalQuality` varchar(10) NOT NULL,
  `fieldIsRegistered` int(11) NOT NULL,
  PRIMARY KEY (`scanid`) USING BTREE,
  UNIQUE KEY `scanid_UNIQUE` (`scanid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8 COMMENT='Tabla para almacenar informción lte';

-- Volcando datos para la tabla arcoteldb.cellularscanwcdma: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `cellularscanwcdma` DISABLE KEYS */;
INSERT INTO `cellularscanwcdma` (`scanid`, `timestamp`, `countryISO`, `phoneOperatorId`, `simOperatorId`, `operatorMcc`, `operatorMnc`, `devManufacturer`, `devModel`, `isConected`, `phoneNetStandard`, `phoneNetTechnology`, `internetConNetwork`, `latitude`, `longitude`, `pingTimeMilis`, `downloadSpeed`, `uploadSpeed`, `phoneSignalStrength`, `phoneAsuStrength`, `phoneSignalLevel`, `cellWcdmaLac`, `cellWcdmaUcid`, `cellWcdmaPsc`, `cellWcdmaCid`, `cellWcdmaRnc`, `cellWcdmaUarfcn`, `signalQuality`, `fieldIsRegistered`) VALUES
	(172, '2020-04-27 01:25:22', 'ec', '#QuedateEnCasa', 'Movistar', '740', '00', 'Xiaomi', 'Redmi Note 8', 'conectado', 'GSM', 'UMTS', 'WIFI', '-0.34108', '-78.5299', '264.39', '2.21', '0.37', -83, 15, 4, 33101, 627144, 420, 37320, 9, 4436, 'BAD', 0);
/*!40000 ALTER TABLE `cellularscanwcdma` ENABLE KEYS */;

-- Volcando estructura para tabla arcoteldb.ni_device_information
CREATE TABLE IF NOT EXISTS `ni_device_information` (
  `di_id_informacion_dispositivo` int(11) NOT NULL,
  `di_IMEI_dispositivo` varchar(50) COLLATE utf8_bin NOT NULL,
  `di_nombre_dispositivo` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`di_id_informacion_dispositivo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla arcoteldb.ni_device_information: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `ni_device_information` DISABLE KEYS */;
INSERT INTO `ni_device_information` (`di_id_informacion_dispositivo`, `di_IMEI_dispositivo`, `di_nombre_dispositivo`) VALUES
	(1, '358212089945637', 'ASUS_X'),
	(2, '358212089944341', 'J5_PRO');
/*!40000 ALTER TABLE `ni_device_information` ENABLE KEYS */;

-- Volcando estructura para tabla arcoteldb.ni_log
CREATE TABLE IF NOT EXISTS `ni_log` (
  `lg_id_log` int(11) NOT NULL,
  `lg_codigo_resultado` varchar(20) COLLATE utf8_bin NOT NULL,
  `lg_mensaje_resultado` varchar(500) COLLATE utf8_bin NOT NULL,
  `lg_metodo` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `lg_fecha_registro` datetime NOT NULL,
  PRIMARY KEY (`lg_id_log`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla arcoteldb.ni_log: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `ni_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `ni_log` ENABLE KEYS */;

-- Volcando estructura para tabla arcoteldb.ni_origen_informacion
CREATE TABLE IF NOT EXISTS `ni_origen_informacion` (
  `oi_id_origen_informacion` int(11) NOT NULL,
  `oi_descripcion_origen_informacionl` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`oi_id_origen_informacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla arcoteldb.ni_origen_informacion: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `ni_origen_informacion` DISABLE KEYS */;
INSERT INTO `ni_origen_informacion` (`oi_id_origen_informacion`, `oi_descripcion_origen_informacionl`) VALUES
	(1, 'phone Info'),
	(2, 'signal Strength'),
	(3, 'Cell info'),
	(4, 'bandera');
/*!40000 ALTER TABLE `ni_origen_informacion` ENABLE KEYS */;


-- Volcando estructura para tabla arcoteldb.ni_tipo_tecnologia
CREATE TABLE IF NOT EXISTS `ni_tipo_tecnologia` (
  `tt_id_tipo_tecnologia` int(11) NOT NULL,
  `tt_nombre_tecnologia` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`tt_id_tipo_tecnologia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla arcoteldb.ni_tipo_tecnologia: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `ni_tipo_tecnologia` DISABLE KEYS */;
INSERT INTO `ni_tipo_tecnologia` (`tt_id_tipo_tecnologia`, `tt_nombre_tecnologia`) VALUES
	(1, 'LTE'),
	(2, 'CDMA'),
	(3, '3G'),
	(4, '2G'),
	(5, 'TODOS');
/*!40000 ALTER TABLE `ni_tipo_tecnologia` ENABLE KEYS */;


-- Volcando estructura para tabla arcoteldb.ni_tipo_informacion_recolectada
CREATE TABLE IF NOT EXISTS `ni_tipo_informacion_recolectada` (
  `ti_id_tipo_informacion_recolectada` int(11) NOT NULL,
  `ti_nombre_informacion_recolectada` varchar(50) COLLATE utf8_bin NOT NULL,
  `ti_descripcion_informacion_recolectada` varchar(50) COLLATE utf8_bin NOT NULL,
  `ti_id_tipo_tecnologia` int(11) NOT NULL,
  `ti_id_origen_informacion` int(11) NOT NULL,
  `ti_visible` bit(1) NOT NULL,
  PRIMARY KEY (`ti_id_tipo_informacion_recolectada`),
  KEY `ti_id_tipo_tecnologia_idx` (`ti_id_tipo_tecnologia`),
  KEY `ti_id_origen_informacion_idx` (`ti_id_origen_informacion`),
  CONSTRAINT `ti_id_origen_informacion` FOREIGN KEY (`ti_id_origen_informacion`) REFERENCES `ni_origen_informacion` (`oi_id_origen_informacion`),
  CONSTRAINT `ti_id_tipo_tecnologia` FOREIGN KEY (`ti_id_tipo_tecnologia`) REFERENCES `ni_tipo_tecnologia` (`tt_id_tipo_tecnologia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla arcoteldb.ni_tipo_informacion_recolectada: ~46 rows (aproximadamente)
/*!40000 ALTER TABLE `ni_tipo_informacion_recolectada` DISABLE KEYS */;
INSERT INTO `ni_tipo_informacion_recolectada` (`ti_id_tipo_informacion_recolectada`, `ti_nombre_informacion_recolectada`, `ti_descripcion_informacion_recolectada`, `ti_id_tipo_tecnologia`, `ti_id_origen_informacion`, `ti_visible`) VALUES
	(1, 'timestamp', 'timestamp', 5, 1, b'1'),
	(2, 'countryISO', 'countryISO', 5, 1, b'1'),
	(3, 'phoneOperatorId', 'phoneOperatorId', 5, 1, b'1'),
	(4, 'simOperatorId', 'simOperatorId', 5, 1, b'1'),
	(5, 'operatorMcc', 'operatorMcc', 5, 1, b'1'),
	(6, 'operatorMnc', 'operatorMnc', 5, 1, b'1'),
	(7, 'devManufacturer', 'devManufacturer', 5, 1, b'1'),
	(8, 'devModel', 'devModel', 5, 1, b'1'),
	(9, 'isConected', 'isConected', 5, 1, b'1'),
	(10, 'phoneNetStandard', 'phoneNetStandard', 5, 1, b'1'),
	(11, 'phoneNetTechnology', 'phoneNetTechnology', 5, 1, b'1'),
	(12, 'internetConNetwork', 'internetConNetwork', 5, 1, b'1'),
	(13, 'latitude', 'latitude', 5, 1, b'1'),
	(14, 'longitude', 'longitude', 5, 1, b'1'),
	(15, 'ping', 'ping', 5, 1, b'1'),
	(16, 'downloadSpeed', 'downloadSpeed', 5, 1, b'1'),
	(17, 'uploadSpeed', 'uploadSpeed', 5, 1, b'1'),
	(18, 'phoneSignalStrength', 'phoneSignalStrength', 5, 2, b'1'),
	(19, 'phoneAsuStrength', 'phoneAsuStrength', 5, 2, b'1'),
	(20, 'phoneSignalLevel', 'phoneSignalLevel', 5, 2, b'1'),
	(21, 'phoneRsrqStrength', 'phoneRsrqStrength', 1, 2, b'1'),
	(22, 'phoneRsrqStrength', 'phoneRsrqStrength', 1, 2, b'1'),
	(23, 'phoneRssnrStrength', 'phoneRssnrStrength', 1, 2, b'1'),
	(24, 'phoneTimingAdvance', 'phoneTimingAdvance', 1, 2, b'1'),
	(25, 'phoneCqiStrength', 'phoneCqiStrength', 1, 2, b'1'),
	(26, 'cellWcdmaLac', 'cellWcdmaLac', 3, 3, b'1'),
	(27, 'cellWcdmaUcid', 'cellWcdmaUcid', 3, 3, b'1'),
	(28, 'cellWcdmaPsc', 'cellWcdmaPsc', 3, 3, b'1'),
	(29, 'cellWcdmaCid', 'cellWcdmaCid', 3, 3, b'1'),
	(30, 'cellWcdmaRnc', 'cellWcdmaRnc', 3, 3, b'1'),
	(31, 'cellWcdmaUarfcn', 'cellWcdmaUarfcn', 3, 3, b'1'),
	(32, 'cellGsmLac', 'cellGsmLac', 4, 3, b'1'),
	(33, 'cellGsmCid', 'cellGsmCid', 4, 3, b'1'),
	(34, 'cellGsmArcfn', 'cellGsmArcfn', 4, 3, b'1'),
	(35, 'cellLtePci', 'cellLtePci', 1, 3, b'1'),
	(36, 'cellLteTac', 'cellLteTac', 1, 3, b'1'),
	(37, 'cellLteeNode', 'cellLteeNode', 1, 3, b'1'),
	(38, 'cellLteCid', 'cellLteCid', 1, 3, b'1'),
	(39, 'cellLteEarfcn', 'cellLteEarfcn', 1, 3, b'1'),
	(40, 'cellBslat', 'cellBslat', 2, 3, b'1'),
	(41, 'cellBslon', 'cellBslon', 2, 3, b'1'),
	(42, 'cellSid', 'cellSid', 2, 3, b'1'),
	(43, 'cellNid', 'cellNid', 2, 3, b'1'),
	(44, 'cellBid', 'cellBid', 2, 3, b'1'),
	(45, 'signalQuality', 'signalQuality', 5, 2, b'1'),
	(46, 'fieldIsRegistered', 'fieldIsRegistered', 5, 4, b'1');
/*!40000 ALTER TABLE `ni_tipo_informacion_recolectada` ENABLE KEYS */;


-- Volcando estructura para tabla arcoteldb.ni_registro_informacion_recolectada
CREATE TABLE IF NOT EXISTS `ni_registro_informacion_recolectada` (
  `ri_id_registro_informacion_red` int(11) NOT NULL AUTO_INCREMENT,
  `ri_id_tipo_informacion_recolectada` int(11) NOT NULL,
  `ri_valor` varchar(50) COLLATE utf8_bin NOT NULL,
  `ri_fecha_registro` datetime DEFAULT NULL,
  `ri_timespan` datetime DEFAULT NULL,
  PRIMARY KEY (`ri_id_registro_informacion_red`) USING BTREE,
  KEY `ri_id_tipo_informacion_recolectada` (`ri_id_tipo_informacion_recolectada`) USING BTREE,
  CONSTRAINT `ri_id_tipo_informacion_recolectada` FOREIGN KEY (`ri_id_tipo_informacion_recolectada`) REFERENCES `ni_tipo_informacion_recolectada` (`ti_id_tipo_informacion_recolectada`)
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla arcoteldb.ni_registro_informacion_recolectada: ~112 rows (aproximadamente)
/*!40000 ALTER TABLE `ni_registro_informacion_recolectada` DISABLE KEYS */;
INSERT INTO `ni_registro_informacion_recolectada` (`ri_id_registro_informacion_red`, `ri_id_tipo_informacion_recolectada`, `ri_valor`, `ri_fecha_registro`, `ri_timespan`) VALUES
	(29, 1, '2020-04-27 02:21:17', NULL, NULL),
	(30, 2, 'ec', NULL, NULL),
	(31, 3, '#QuedateEnCasa', NULL, NULL),
	(32, 4, 'Movistar', NULL, NULL),
	(33, 5, '740', NULL, NULL),
	(34, 6, '00', NULL, NULL),
	(35, 7, 'Xiaomi', NULL, NULL),
	(36, 8, 'Redmi Note 8', NULL, NULL),
	(37, 9, 'conectado', NULL, NULL),
	(38, 10, 'GSM', NULL, NULL),
	(39, 11, 'HSPA+', NULL, NULL),
	(40, 12, 'WIFI', NULL, NULL),
	(41, 13, '-0.341075', NULL, NULL),
	(42, 14, '-78.5299', NULL, NULL),
	(43, 15, '45.82', NULL, NULL),
	(44, 16, '5.27', NULL, NULL),
	(45, 17, '0.43', NULL, NULL),
	(46, 18, '-69', NULL, NULL),
	(47, 19, '22', NULL, NULL),
	(48, 20, '4', NULL, NULL),
	(49, 26, '33101', NULL, NULL),
	(50, 27, '624144', NULL, NULL),
	(51, 28, '420', NULL, NULL),
	(52, 29, '34320', NULL, NULL),
	(53, 30, '9', NULL, NULL),
	(54, 31, '512', NULL, NULL),
	(55, 45, 'VERY_GOOD', NULL, NULL),
	(56, 46, '0', NULL, NULL),
	(57, 1, '2020-04-27 02:27:19', NULL, NULL),
	(58, 2, 'ec', NULL, NULL),
	(59, 3, '#QuedateEnCasa', NULL, NULL),
	(60, 4, 'Movistar', NULL, NULL),
	(61, 5, '740', NULL, NULL),
	(62, 6, '00', NULL, NULL),
	(63, 7, 'Xiaomi', NULL, NULL),
	(64, 8, 'Redmi Note 8', NULL, NULL),
	(65, 9, 'conectado', NULL, NULL),
	(66, 10, 'GSM', NULL, NULL),
	(67, 11, 'HSPA+', NULL, NULL),
	(68, 12, 'MOBILE', NULL, NULL),
	(69, 13, '-0.341098', NULL, NULL),
	(70, 14, '-78.53', NULL, NULL),
	(71, 15, '57.22', NULL, NULL),
	(72, 16, '9.35', NULL, NULL),
	(73, 17, '1.07', NULL, NULL),
	(74, 18, '-71', NULL, NULL),
	(75, 19, '21', NULL, NULL),
	(76, 20, '4', NULL, NULL),
	(77, 26, '33101', NULL, NULL),
	(78, 27, '624144', NULL, NULL),
	(79, 28, '420', NULL, NULL),
	(80, 29, '34320', NULL, NULL),
	(81, 30, '9', NULL, NULL),
	(82, 31, '512', NULL, NULL),
	(83, 45, 'GOOD', NULL, NULL),
	(84, 46, '0', NULL, NULL),
	(85, 1, '2020-04-27 02:29:01', NULL, NULL),
	(86, 2, 'ec', NULL, NULL),
	(87, 3, '#QuedateEnCasa', NULL, NULL),
	(88, 4, 'Movistar', NULL, NULL),
	(89, 5, '740', NULL, NULL),
	(90, 6, '00', NULL, NULL),
	(91, 7, 'Xiaomi', NULL, NULL),
	(92, 8, 'Redmi Note 8', NULL, NULL),
	(93, 9, 'conectado', NULL, NULL),
	(94, 10, 'GSM', NULL, NULL),
	(95, 11, 'HSPA+', NULL, NULL),
	(96, 12, 'WIFI', NULL, NULL),
	(97, 13, '-0.34109', NULL, NULL),
	(98, 14, '-78.5299', NULL, NULL),
	(99, 15, '23.68', NULL, NULL),
	(100, 16, '5.28', NULL, NULL),
	(101, 17, '0.43', NULL, NULL),
	(102, 18, '-81', NULL, NULL),
	(103, 19, '16', NULL, NULL),
	(104, 20, '4', NULL, NULL),
	(105, 26, '33101', NULL, NULL),
	(106, 27, '624144', NULL, NULL),
	(107, 28, '420', NULL, NULL),
	(108, 29, '34320', NULL, NULL),
	(109, 30, '9', NULL, NULL),
	(110, 31, '512', NULL, NULL),
	(111, 45, 'BAD', NULL, NULL),
	(112, 46, '0', NULL, NULL),
	(113, 1, '2020-04-27 02:29:01', NULL, NULL),
	(114, 2, 'ec', NULL, NULL),
	(115, 3, '#QuedateEnCasa', NULL, NULL),
	(116, 4, 'Movistar', NULL, NULL),
	(117, 5, '740', NULL, NULL),
	(118, 6, '00', NULL, NULL),
	(119, 7, 'Xiaomi', NULL, NULL),
	(120, 8, 'Redmi Note 8', NULL, NULL),
	(121, 9, 'conectado', NULL, NULL),
	(122, 10, 'GSM', NULL, NULL),
	(123, 11, 'HSPA+', NULL, NULL),
	(124, 12, 'WIFI', NULL, NULL),
	(125, 13, '-0.34109', NULL, NULL),
	(126, 14, '-78.5299', NULL, NULL),
	(127, 15, '30.24', NULL, NULL),
	(128, 16, '5.24', NULL, NULL),
	(129, 17, '0.38', NULL, NULL),
	(130, 18, '-81', NULL, NULL),
	(131, 19, '16', NULL, NULL),
	(132, 20, '4', NULL, NULL),
	(133, 26, '33101', NULL, NULL),
	(134, 27, '624144', NULL, NULL),
	(135, 28, '420', NULL, NULL),
	(136, 29, '34320', NULL, NULL),
	(137, 30, '9', NULL, NULL),
	(138, 31, '512', NULL, NULL),
	(139, 45, 'BAD', NULL, NULL),
	(140, 46, '0', NULL, NULL);
/*!40000 ALTER TABLE `ni_registro_informacion_recolectada` ENABLE KEYS */;


/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
