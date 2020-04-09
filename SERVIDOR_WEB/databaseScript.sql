CREATE TABLE IF NOT EXISTS `arcoteldb`.`cellularscantb` (
  `scanid` INT(11) NOT NULL AUTO_INCREMENT,
  `countryiso` VARCHAR(3) NOT NULL,
  `operatorid` VARCHAR(8) NOT NULL,
  `operatorname` VARCHAR(20) NOT NULL,
  `isconected` VARCHAR(15) NOT NULL,
  `phonesignaltype` VARCHAR(5) NOT NULL,
  `phonenetworktype` VARCHAR(12) NOT NULL,
  `signalquality` VARCHAR(10) NOT NULL,
  `networkconectivitytype` VARCHAR(7) NOT NULL,
  `phonesignalstrength` VARCHAR(11) NOT NULL,
  `downloadmovilespeed` INT(11) NOT NULL,
  `uploadmovilspeed` INT(11) NOT NULL,
  `wifispeed` INT(11) NOT NULL,
  PRIMARY KEY (`scanid`),
  UNIQUE INDEX `scanid_UNIQUE` (`scanid` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 93
DEFAULT CHARACTER SET = utf8
COMMENT = 'Tabla para almacenar informción de la aplicación android'
