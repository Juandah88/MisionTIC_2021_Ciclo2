
--Seleccione el id del proyecto, la fecha, la constructora y el serial de los proyectos que tengan
--como id de proyecto los números menores a 15

SELECT ID_Proyecto, Fecha_Inicio, Constructora, Serial FROM Proyecto WHERE ID_Proyecto < 15

--Seleccione el id del proyecto y el área máxima del Tipo de los proyectos con construcciones con
--un numero de cuartos/habitaciones igual a 2.

SELECT Proyecto.ID_Proyecto,  Tipo.Area_Max FROM Proyecto INNER JOIN Tipo ON Proyecto.ID_Tipo = Tipo.ID_Tipo}

--Seleccione el id del proyecto y como segunda y última columna el nombre del Lider concatenado
--con su primer apellido separados por un espacio con el nombre de la columna como
--nombreapellido, y la condición deberá ser que todos los proyectos seleccionados pertenezcan al
--banco “Bancolombia”.

SELECT Proyecto.ID_Proyecto ,Lider.Nombre || " " || Lider.Primer_Apellido AS nombreapellido FROM Proyecto INNER JOIN Lider ON Proyecto.ID_Lider == Lider.ID_Lider WHERE Banco_Vinculado = 'Bancolombia'SELECT Proyecto.ID_Proyecto ,(Lider.Nombre || ' ' || Lider.Primer_Apellido) AS nombreapellido INNER JOIN Lider ON Proyecto.ID_Lider == Lider.ID_Lider
