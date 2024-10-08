-- database: ../DataBase/GJEcuaFauna.sqlite

INSERT INTO GJLocalidadEstructura
(IdLocalidadEstructuraPadre, Nombre) VALUES
(NULL                     ,"Pais"     ),
(1                        ,"Region"),
(2                        ,"Provincia"   );

INSERT INTO GJLocalidad (IdLocalidadPadre, IdLocalidadEstructura, Nombre) VALUES
(NULL,1,"Euador"),
(1,2,"Costa"),
(1,2,"Sierra"),
(1,2,"Oriente"),
(1,2,"Galapagos"),
--Costa
(2,3,'Esmeraladas'                   ),
(2,3,'Manabi'                        ),
(2,3,'Guayas'                        ),
(2,3,'Santa Elena'                   ),
(2,3,'Los Rios'                      ),
(2,3,'El Oro'                        ),
(2,3,'Santo Domingo de los Tsachilas'),
--Sierra
(3,3,'Carchi'    ),
(3,3,'Imbabura'  ),
(3,3,'Pichincha' ),
(3,3,'Cotopaxi'  ),
(3,3,'Tungurahua'),
(3,3,'Chimborazo'),
(3,3,'Bolivar'   ),
(3,3,'Caniar'    ),
(3,3,'Azuay'     ),
(3,3,'Loja'      ),
--Oriente
(4,3,'Sucumbios'       ),
(4,3,'Orellana'        ),
(4,3,'Napo'            ),
(4,3,'Pastaza'         ),
(4,3,'Morona Santiago' ),
(4,3,'Zamora Chinchipe'),
--Galapagos
(5,3,'Galapagos');

INSERT INTO GJAlimento
(IDAlimentoPadre,Nombre)VALUES
(NULL           ,'Ingesta Nativa'),
(NULL           ,'GenoAlimento'),
(NULL           ,'Vacio'),
(1              ,'Carnivoro'),
(1              ,'Herbivoro'),
(1              ,'Omnivoro'),
(1              ,'Insectivoro'),
(1              ,'Nectanivoro'),
(2              ,'X'),
(2              ,'XX'),
(2              ,'XY');

INSERT INTO GJSexo (NOMBRE) VALUES
 ("Macho")
,("Hembra")
,("Asexual");

INSERT INTO GJHormiga
(TipoHormiga,Sexo,Provincia,GenoAlimento,IngestaNativa,EstadoCondicion)VALUES
('Larva'    ,1   ,7        , 8          , 7           ,'Viva'),
('Larva'    ,1   ,8        , 9          , 5           ,'Viva')
;


SELECT ROW_NUMBER () OVER ( ORDER BY IDHormiga ) RowNum
,h.IDHormiga
,h.TipoHormiga
,a1.Nombre
,a2.Nombre
,s.Nombre
,l.Nombre
,h.EstadoCondicion
FROM GJHormiga h
JOIN GJAlimento a1 ON h.GenoAlimento  = a1.IDAlimento
JOIN GJAlimento a2 ON h.IngestaNativa = a2.IDAlimento
JOIN GJSexo s ON h.Sexo = s.IdSexo
JOIN GJLocalidad l ON h.Provincia = l.IdLocalidad
WHERE h.Estado = 'A';
SELECT * FROM GJHormiga;

UPDATE GJHormiga
SET Estado = 'X'
WHERE IDHormiga = 1;

SELECT RowNum
    ,sub.IDHormiga
    ,sub.TipoHormiga
    ,sub.NombreAlimento1
    ,sub.NombreAlimento2
    ,sub.Sexo
    ,sub.provincia
    ,sub.estadoCondicion
FROM (
    SELECT ROW_NUMBER() OVER (ORDER BY h.IDHormiga) AS RowNum
        ,h.IDHormiga
        ,h.TipoHormiga
        ,a1.Nombre AS NombreAlimento1
        ,a2.Nombre AS NombreAlimento2
        ,l.Nombre AS provincia
        ,s.Nombre AS Sexo
        ,h.EstadoCondicion AS estadoCondicion
    FROM GJHormiga h
    JOIN GJAlimento a1 ON h.GenoAlimento = a1.IDAlimento
    JOIN GJAlimento a2 ON h.IngestaNativa = a2.IDAlimento
    JOIN GJSexo s ON h.Sexo = s.IdSexo
    JOIN GJLocalidad l ON h.Provincia = l.IdLocalidad
    WHERE h.Estado = 'A'
) sub
WHERE RowNum = 1;

SELECT COUNT (*) TotalRegistros
FROM GJHormiga
WHERE Estado = 'A';

UPDATE GJHormiga
SET GenoAlimento = 10,
Sexo = 1
WHERE IDHormiga = 2;

UPDATE GJHormiga
SET IngestaNativa = 6,
TipoHormiga = 'Carpinero'
WHERE IDHormiga = 2;