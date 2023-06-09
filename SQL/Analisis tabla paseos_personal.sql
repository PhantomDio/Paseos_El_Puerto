SELECT per.id_personal FROM Paseos_Personal pp
                   INNER JOIN Paseos p ON pp.id_paseo = p.id_paseo
                   INNER JOIN Personal per ON pp.id_personal = per.id_personal
                   WHERE p.id_paseo = 1;