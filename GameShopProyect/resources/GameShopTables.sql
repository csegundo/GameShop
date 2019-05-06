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


CREATE OR REPLACE TABLE ticket (
	ID VARCHAR2(10) NOT NULL,
	fecha TIMESTAMP NOT NULL,
	precioFinal NUMBER(6,2) NOT NULL,
	IDEmpleado VARCHAR2(5) REFERENCES empleado (ID),
	PRIMARY KEY(IDEmpleado, ID)
);

CREATE TABLE `asociado` (
  `IDProducto` INT(11) NOT NULL,
  `IDTicket` INT(11) NOT NULL,
  `IDEmpleado` INT(11) NOT NULL,
  `cantidad` INT(10) NOT NULL,
  PRIMARY KEY (`IDProducto`, `IDTicket`, `IDEmpleado`),
  
  KEY `IDEmpleado_idx` (`IDEmpleado`),
  KEY `IDTicket_idx` (`IDTicket`),
  KEY `IDProducto_idx` (`IDProducto`),

  CONSTRAINT `IDEmpleadoP` FOREIGN KEY (`IDEmpleado`) REFERENCES `empleado` (`ID`),
  CONSTRAINT `IDTicketP` FOREIGN KEY (`IDTicket`) REFERENCES `ticket` (`ID`),
  CONSTRAINT `IDProductoP` FOREIGN KEY (`IDProducto`) REFERENCES `producto` (`ID`)
);
