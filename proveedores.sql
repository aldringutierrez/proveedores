CREATE TABLE "proveedores" (
  "id" int(11) NOT NULL AUTO_INCREMENT,
  "nombre" varchar(128) NOT NULL,
  "numide" int(11) NOT NULL,
  "direccion" varchar(128) NOT NULL,
  "email" varchar(128) NOT NULL,
  "vehiculos" int(11) NOT NULL,
  PRIMARY KEY ("id"),
  UNIQUE KEY "numide_UNIQUE" ("numide")
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1