-- actividad 5
-- a
UPDATE personajes 
SET 
    aparicion = 1938
WHERE
    personaje = 'Superman';

-- b
DELETE p FROM personajes p 
WHERE
    p.personaje = 'Flash';

-- actividad 6
-- a
SELECT 
    *
FROM
    personajes;

-- b
SELECT 
    nombre_real
FROM
    personajes;

-- c
SELECT 
    nombre_real
FROM
    personajes
WHERE
    nombre_real LIKE 'B%';

-- actividad 7
-- a
SELECT 
    *
FROM
    personajes
ORDER BY inteligencia ASC;