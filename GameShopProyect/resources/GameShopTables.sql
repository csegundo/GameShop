CREATE TABLE `empleado` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `NIF` varchar(9) NOT NULL,
  `turno` varchar(15) NOT NULL,
  `activo` tinyint(1) NOT NULL,

  PRIMARY KEY (`ID`)
);

CREATE TABLE `plataforma` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
);


CREATE TABLE `proveedor` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(50) NOT NULL,
  `NIF` varchar(9) NOT NULL,
  `telefono` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
);



CREATE TABLE `producto` (
	`ID` int(11) NOT NULL AUTO_INCREMENT,
	`nombre` varchar(45) NOT NULL,
	`descripcion` varchar(150) NOT NULL,
	`PVP` float NOT NULL,
	`stock` int(11) NOT NULL,
	`IDProveedor` int(11) NOT NULL,
	`IDPlataforma` int(11) NOT NULL,
	`activo` tinyint(1) NOT NULL,
	`unidadesProv` int (11) NOT NULL,

	`genero` varchar(45) NOT NULL,

	`marca` varchar(45) NOT NULL,
	`color` varchar(45) NOT NULL,
    
    `tipo` varchar(30) NOT NULL,
	
	PRIMARY KEY (`ID`),
	KEY `IDPlataforma_idx` (`IDPlataforma`),
	KEY `IDProveedor_idx` (`IDProveedor`),
	CONSTRAINT `IDPlataformaP` FOREIGN KEY (`IDPlataforma`) REFERENCES `plataforma` (`ID`),
	CONSTRAINT `IDProveedorP` FOREIGN KEY (`IDProveedor`) REFERENCES `proveedor` (`ID`)
);

/*
CREATE TABLE `ticket` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDEmpl` int(11) NOT NULL,
  `fecha` timestamp NOT NULL,
  `precioFinal` float NOT NULL,
  `idProd`int(11) NOT NULL,
  `nombre`varchar(45) NOT NULL,
  `idPlat`int(11) NOT NULL,
  `cantidad`int(11) NOT NULL,
  `precio` float NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDEmpl_idx` (`IDEmpl`),
  CONSTRAINT `IDEmpl` FOREIGN KEY (`IDEmpl`) REFERENCES `empleado` (`ID`)
);
*/
