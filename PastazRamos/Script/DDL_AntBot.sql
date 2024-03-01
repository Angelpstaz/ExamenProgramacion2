-- database: ../database/ANTBOT.sqlite

DROP TABLE IF EXISTS RegistroHormigas;
DROP TABLE IF EXISTS AntBot;
DROP TABLE IF EXISTS Hormiga;
DROP TABLE IF EXISTS ExpertoIdiomas;
DROP TABLE IF EXISTS FuentePoder;
DROP TABLE IF EXISTS Pata;
DROP TABLE IF EXISTS CircuitoCarga;
DROP TABLE IF EXISTS Camara;
DROP TABLE IF EXISTS Antena;
DROP TABLE IF EXISTS SensorOptico;
DROP TABLE IF EXISTS Tenaza;
DROP TABLE IF EXISTS CircuitoAnillado;
DROP TABLE IF EXISTS Procesador;
DROP TABLE IF EXISTS Ala;
DROP TABLE IF EXISTS HormigaTipo;
DROP TABLE IF EXISTS IABot;
DROP TABLE IF EXISTS Radio;
DROP TABLE IF EXISTS CuentaAdmin;

CREATE  TABLE IABot(
    idIABot INTEGER PRIMARY KEY AUTOINCREMENT
    ,nombre VARCHAR(60) NOT NULL UNIQUE
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,Observacion    TEXT
    ,FechaCrea      DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP
    ,FechaMOdifica  DATETIME
    );

CREATE  TABLE FuentePoder(
    idFuentePoder INTEGER PRIMARY KEY AUTOINCREMENT
    ,nombre VARCHAR(60) NOT NULL UNIQUE
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,Observacion    TEXT
    ,FechaCrea      DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP
    ,FechaMOdifica  DATETIME
    );
CREATE  TABLE Pata(
    idPata INTEGER PRIMARY KEY AUTOINCREMENT
    ,nombre VARCHAR(60) NOT NULL UNIQUE
    ,numeroPatas     INT 
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,Observacion    TEXT
    ,FechaCrea      DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP
    ,FechaMOdifica  DATETIME
    );
CREATE  TABLE Radio(
    idRadio INTEGER PRIMARY KEY AUTOINCREMENT
    ,nombre VARCHAR(60) NOT NULL UNIQUE
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,Observacion    TEXT
    ,FechaCrea      DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP
    ,FechaMOdifica  DATETIME
    );
CREATE  TABLE CircuitoCarga(
    idCircuitoCarga INTEGER PRIMARY KEY AUTOINCREMENT
    ,nombre VARCHAR(60) NOT NULL UNIQUE
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,Observacion    TEXT
    ,FechaCrea      DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP
    ,FechaMOdifica  DATETIME
    );
CREATE  TABLE Camara(
    idCamara INTEGER PRIMARY KEY AUTOINCREMENT
    ,nombre VARCHAR(60) NOT NULL UNIQUE
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,Observacion    TEXT
    ,FechaCrea      DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP
    ,FechaMOdifica  DATETIME
    );
CREATE  TABLE Antena(
    idAntena INTEGER PRIMARY KEY AUTOINCREMENT
    ,nombre VARCHAR(60) NOT NULL UNIQUE
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,Observacion    TEXT
    ,FechaCrea      DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP
    ,FechaMOdifica  DATETIME
    );
CREATE  TABLE SensorOptico(
    idSensorOptico INTEGER PRIMARY KEY AUTOINCREMENT
    ,nombre VARCHAR(60) NOT NULL UNIQUE
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,Observacion    TEXT
    ,FechaCrea      DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP
    ,FechaMOdifica  DATETIME
    );
CREATE  TABLE Tenaza(
    idTenaza INTEGER PRIMARY KEY AUTOINCREMENT
    ,nombre VARCHAR(60) NOT NULL UNIQUE
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,Observacion    TEXT
    ,FechaCrea      DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP
    ,FechaMOdifica  DATETIME
    );
CREATE  TABLE CircuitoAnillado(
    idCircuitoAnillado INTEGER PRIMARY KEY AUTOINCREMENT
    ,nombre VARCHAR(60) NOT NULL UNIQUE
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,Observacion    TEXT
    ,FechaCrea      DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP
    ,FechaMOdifica  DATETIME
    );
CREATE  TABLE Procesador(
    idProcesador INTEGER PRIMARY KEY AUTOINCREMENT
    ,nombre VARCHAR(60) NOT NULL UNIQUE
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,Observacion    TEXT
    ,FechaCrea      DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP
    ,FechaMOdifica  DATETIME
    );
CREATE  TABLE Ala(
    idAla INTEGER PRIMARY KEY AUTOINCREMENT
    ,nombre VARCHAR(60) NOT NULL UNIQUE
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,Observacion    TEXT
    ,FechaCrea      DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP
    ,FechaMOdifica  DATETIME
    );
CREATE  TABLE HormigaTipo(
    idHormigaTipo INTEGER PRIMARY KEY AUTOINCREMENT
    ,nombre VARCHAR(60) NOT NULL UNIQUE
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,Observacion    TEXT
    ,FechaCrea      DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP
    ,FechaMOdifica  DATETIME
    );
CREATE  TABLE Hormiga(
    idHormiga INTEGER PRIMARY KEY AUTOINCREMENT
    , idHormigaTipo INTEGER NOT NULL REFERENCES HormigaTipo  (idHormigaTipo)
    ,nombre VARCHAR(60) NOT NULL 
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,Observacion    TEXT
    ,FechaCrea      DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP
    ,FechaMOdifica  DATETIME
    );


CREATE  TABLE ExpertoIdiomas(
    idExpertoIdiomas INTEGER PRIMARY KEY AUTOINCREMENT
    ,nombre VARCHAR(60) NOT NULL UNIQUE
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,Observacion    TEXT
    ,FechaCrea      DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP
    ,FechaMOdifica  DATETIME
    );
CREATE  TABLE AntBot(
    idAntBot INTEGER PRIMARY KEY AUTOINCREMENT
    , idIABot INTEGER NOT NULL REFERENCES IABot  (idIABot)
    , idHormiga INTEGER NOT NULL REFERENCES Hormiga  (idHormiga)
    , idAla INTEGER NOT NULL REFERENCES Ala  (idAla) DEFAULT 1
    , idProcesador INTEGER NOT NULL REFERENCES Procesador  (idProcesador) DEFAULT 1
    , idCircuitoAnillado INTEGER NOT NULL REFERENCES CircuitoAnillado  (idCircuitoAnillado) DEFAULT 1
    , idTenaza INTEGER NOT NULL REFERENCES Tenaza  (idTenaza) DEFAULT 1
    , idRadio INTEGER NOT NULL REFERENCES Radio  (idRadio) DEFAULT 1
    , idSensorOptico INTEGER NOT NULL REFERENCES SensorOptico  (idSensorOptico) DEFAULT 1
    , idAntena INTEGER NOT NULL REFERENCES Antena  (idAntena) DEFAULT 1
    , idCamara INTEGER NOT NULL REFERENCES Camara  (idCamara) DEFAULT 1
    , idCircuitoCarga INTEGER NOT NULL REFERENCES CircuitoCarga  (idCircuitoCarga) DEFAULT 1
    , idPata INTEGER NOT NULL REFERENCES Pata  (idPata) DEFAULT 1
    , idFuentePoder INTEGER NOT NULL REFERENCES FuentePoder  (idFuentePoder) DEFAULT 1
    , idExpertoIdiomas INTEGER  REFERENCES ExpertoIdiomas  (idExpertoIdiomas)
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,Observacion    TEXT
    ,FechaCrea      DATETIME NOT NULL DEFAULT  CURRENT_TIMESTAMP
    ,FechaMOdifica  DATETIME
    );


CREATE TABLE CuentaAdmin (

    IdCuentaUsuario         INTEGER PRIMARY KEY AUTOINCREMENT
    ,Correo                 VARCHAR(50)  NOT NULL UNIQUE
    ,Password               VARCHAR(16)  NOT NULL
    ,Observacion            TEXT
    ,Estado                 CHAR NOT NULL DEFAULT ('A')
    ,FechaCrea              DATETIME NOT NULL  DEFAULT (datetime('now'))
    ,FechaModifica          DATE
);


CREATE TABLE RegistroHormigas (

    IdRegistroHormigas      INTEGER PRIMARY KEY AUTOINCREMENT
    ,IdHormiga              INTEGER  NOT NULL   REFERENCES Hormiga (IdHormiga)
    ,idHormigaTipo          INTEGER   NOT NULL REFERENCES HormigaTipo(idHormigaTipo)
    ,Comió                TEXT  
    ,Recogió                TEXT  
    ,Estado                 CHAR NOT NULL DEFAULT ('A')
    ,Observacion            TEXT
    ,FechaCrea              DATETIME NOT NULL  DEFAULT (datetime('now'))
    ,FechaModifica          DATE
);