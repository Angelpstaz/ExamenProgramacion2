-- database: ../database/ANTBOT.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| pdavila0113@gmail.com      BaphomeT-T  |
|----------------------------------------|
Autor : BaphomeT-T
Fecha : 25.feb.2k24
*/
INSERT INTO FuentePoder(
    Nombre
    ,Observacion
) VALUES(
    "FuentePoder MK1"
    ,"FuentePoder Creada"
);
INSERT INTO Pata(
    Nombre
    ,numeroPatas
    ,Observacion
) VALUES(
    "Patas completas"
    ,6
    ,"Pata Creada"
);
INSERT INTO CircuitoCarga(
    Nombre
    ,Observacion
) VALUES(
    "CircuitoCarga MK1"
    ,"CircuitoCarga Creada"
);
INSERT INTO Camara(
    Nombre
    ,Observacion
) VALUES(
    "Camara MK1"
    ,"Camara Creada"
);
INSERT INTO Antena(
    Nombre
    ,Observacion
) VALUES(
    "Antena MK1"
    ,"Antena Creada"
);
INSERT INTO SensorOptico(
    Nombre
    ,Observacion
) VALUES(
    "SensorOptico MK1"
    ,"SensorOptico Creada"
);
INSERT INTO Radio(
    Nombre
    ,Observacion
) VALUES(
    "Radio MK1"
    ,"Radio Creada"
);
INSERT INTO Tenaza(
    Nombre
    ,Observacion
) VALUES(
    "Tenaza MK1"
    ,"Tenaza Creada"
);
INSERT INTO CircuitoAnillado(
    Nombre
    ,Observacion
) VALUES(
    "CircuitoAnillado MK1"
    ,"CircuitoAnillado Creada"
);
INSERT INTO Procesador(
    Nombre
    ,Observacion
) VALUES(
    "Procesador MK1"
    ,"Procesador Creada"
);
INSERT INTO Ala(
    Nombre
    ,Observacion
) VALUES(
    "Ala MK1"
    ,"Ala Creada"
);
INSERT INTO HormigaTipo(
    Nombre
    ,Observacion
) VALUES(
    "soldado"
    ,"HormigaTipo Creada"
);
INSERT INTO HormigaTipo(
    Nombre
    ,Observacion
) VALUES(
    "rastreadora"
    ,"HormigaTipo Creada"
);
INSERT INTO HormigaTipo(
    Nombre
    ,Observacion
) VALUES(
    "zángano"
    ,"HormigaTipo Creada"
);
INSERT INTO HormigaTipo(
    Nombre
    ,Observacion
) VALUES(
    "larva"
    ,"HormigaTipo Creada"
);
INSERT INTO HormigaTipo(
    Nombre
    ,Observacion
) VALUES(
    "reina "
    ,"HormigaTipo Creada"
);
INSERT INTO ExpertoIdiomas(
    Nombre
    ,Observacion
) VALUES(
    "Experto Ruso"
    ,"ExpertoIdiomas Creado"
);
INSERT INTO ExpertoIdiomas(
    Nombre
    ,Observacion
) VALUES(
    "Experto Ingles"
    ,"ExpertoIdiomas Creado"
);
INSERT INTO IABot(
    Nombre
    ,Observacion
)VALUES(
    "IABOT"
    ,"IA BOT esta activo"
);
INSERT INTO Hormiga(
    idHormigaTipo
    ,Nombre
    
)VALUES(
    "1"
    ,"Flick"
    
);

INSERT INTO Hormiga(
    idHormigaTipo
    ,Nombre
    
)VALUES(
    "2"
    ,"MAX"
    
);
INSERT INTO Hormiga(
    idHormigaTipo
    ,Nombre
    
)VALUES(
    "3"
    ,"Kratos"
    
);
INSERT INTO Hormiga(
    idHormigaTipo
    ,Nombre
    
)VALUES(
    "4"
    ,"Missy"
    
);
INSERT INTO Hormiga(
    idHormigaTipo
    ,Nombre
    
)VALUES(
    "5"
    ,"Cori"
    
);
INSERT INTO AntBot(
    idIABot
    ,idHormiga
    ,idAla
    ,idProcesador
    ,idCircuitoAnillado
    ,idTenaza
    ,idRadio
    ,idSensorOptico
    ,idAntena
    ,idCamara
    ,idCircuitoCarga
    ,idPata
    ,idFuentePoder
    ,idExpertoIdiomas

)VALUES (
    "1"
    ,"1"
    ,"1"
    ,"1"
    ,"1"
    ,"1"
    ,"1"
    ,"1"
    ,"1"
    ,"1"
    ,"1"
    ,"1"
    ,"1"
    ,"1"
);
INSERT INTO CuentaAdmin
    ( Correo, Password)
VALUES
     ( "paul", "12345")
    ,( "sebastian", "12345")
    ,( "mateo", "12345") 
    ,( "jahir", "12345")
    ,( "isacc", "12345");