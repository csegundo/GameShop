
CREATE DATABASE GameshopTest;
USE GameshopTest;
SET GLOBAL time_zone = '+3:00';

CREATE TABLE `empleado` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `NIF` varchar(9) NOT NULL,
  `turno` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `plataforma` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
);


CREATE TABLE `proveedor` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(50) NOT NULL,
  `NIF` varchar(9) NOT NULL,
  `telefono` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `producto` (
	`ID` int(11) NOT NULL AUTO_INCREMENT,
	`nombre` varchar(45) NOT NULL,
	`PVP` float NOT NULL,
	`descripcion` varchar(150) NOT NULL,
	`stock` int(11) NOT NULL,
	`tipo` varchar(45) NOT NULL,
	`genero` varchar(45) NOT NULL,
	`IDProveedor` int(11) NOT NULL,
	`IDPlataforma` int(11) NOT NULL,
	PRIMARY KEY (`ID`),
	KEY `IDPlataforma_idx` (`IDPlataforma`),
	KEY `IDProveedor_idx` (`IDProveedor`),
	CONSTRAINT `IDPlataforma` FOREIGN KEY (`IDPlataforma`) REFERENCES `plataforma` (`ID`),
	CONSTRAINT `IDProveedor` FOREIGN KEY (`IDProveedor`) REFERENCES `proveedor` (`ID`)
);


CREATE TABLE `ticket` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `precio_final` float NOT NULL,
  `fecha` date NOT NULL,
  `IDEmpleado` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDEmpleado_idx` (`IDEmpleado`),
  CONSTRAINT `IDEmpleado` FOREIGN KEY (`IDEmpleado`) REFERENCES `empleado` (`ID`)
);
