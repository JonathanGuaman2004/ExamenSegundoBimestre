-- database: ../DataBase/GJEcuaFauna.sqlite

DROP TABLE IF EXISTS GJHormiga;
DROP TABLE IF EXISTS GJLocalidad;
DROP TABLE IF EXISTS GJLocalidadEstructura;
DROP TABLE IF EXISTS GJAlimento;
DROP TABLE IF EXISTS GJSexo;

CREATE TABLE GJLocalidadEstructura (
     IdLocalidadEstructura      INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdLocalidadEstructuraPadre INTEGER REFERENCES  GJLocalidadEstructura(IdLocalidadEstructura)
    ,Nombre                    VARCHAR(10) NOT NULL
    ,Estado                    VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion             DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModificacion         DATETIME
);

CREATE TABLE GJLocalidad (
     IdLocalidad             INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdLocalidadPadre        INTEGER     REFERENCES  GJLocalidad (IdLocalidad)
    ,IdLocalidadEstructura   INTEGER     REFERENCES  GJLocalidadEstructura(IdLocalidadEstructura)
    ,Nombre                 VARCHAR(20) NOT NULL
    ,Estado                 VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCrea              DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica          DATETIME
);

CREATE TABLE GJSexo (
     IdSexo         INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre         VARCHAR(10) NOT NULL UNIQUE
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCrea      DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica  DATETIME
);


CREATE TABLE GJAlimento(
    IDAlimento          INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IDAlimentoPadre    INTEGER REFERENCES GJAlimento(IDAlimento)
    ,Nombre             VARCHAR(10) NOT NULL
    ,Estado             VARCHAR(1) NOT NULL DEFAULT('A')
    ,FechaCreacion      DATETIME DEFAULT(datetime('now','localtime'))
    ,FechaModificacion  DATETIME
);

CREATE TABLE GJHormiga
(
    IDHormiga       INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    TipoHormiga     VARCHAR(50),
    Sexo            INTEGER REFERENCES GJSexo(IdSexo),
    Provincia       INTEGER REFERENCES GJLocalidad(IdLocalidad),
    GenoAlimento    INTEGER REFERENCES GJAlimento(IDAlimento),
    IngestaNativa   INTEGER REFERENCES GJAlimento(IDAlimento),
    EstadoCondicion VARCHAR(10)  NOT NULL DEFAULT('Viva'),
    Estado          VARCHAR(1)  NOT NULL DEFAULT('A'),
    FechaCrea       DATETIME    DEFAULT(datetime('now','localtime')),
    FechaModifica   DATETIME
);

