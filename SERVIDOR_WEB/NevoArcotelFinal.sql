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

-- La exportación de datos fue deseleccionada.

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

-- La exportación de datos fue deseleccionada.

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

-- La exportación de datos fue deseleccionada.

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

-- La exportación de datos fue deseleccionada.

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

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla arcoteldb.ni_device_information
CREATE TABLE IF NOT EXISTS `ni_device_information` (
  `di_id_informacion_dispositivo` int(11) NOT NULL,
  `di_IMEI_dispositivo` varchar(50) COLLATE utf8_bin NOT NULL,
  `di_nombre_dispositivo` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`di_id_informacion_dispositivo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla arcoteldb.ni_log
CREATE TABLE IF NOT EXISTS `ni_log` (
  `lg_id_log` int(11) NOT NULL,
  `lg_codigo_resultado` varchar(20) COLLATE utf8_bin NOT NULL,
  `lg_mensaje_resultado` varchar(500) COLLATE utf8_bin NOT NULL,
  `lg_metodo` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `lg_fecha_registro` datetime NOT NULL,
  PRIMARY KEY (`lg_id_log`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla arcoteldb.ni_origen_informacion
CREATE TABLE IF NOT EXISTS `ni_origen_informacion` (
  `oi_id_origen_informacion` int(11) NOT NULL,
  `oi_descripcion_origen_informacionl` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`oi_id_origen_informacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- La exportación de datos fue deseleccionada.

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

-- La exportación de datos fue deseleccionada.

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

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla arcoteldb.ni_tipo_tecnologia
CREATE TABLE IF NOT EXISTS `ni_tipo_tecnologia` (
  `tt_id_tipo_tecnologia` int(11) NOT NULL,
  `tt_nombre_tecnologia` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`tt_id_tipo_tecnologia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
