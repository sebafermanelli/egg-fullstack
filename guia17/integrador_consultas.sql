# Candado A
# Posicion 2
SELECT 
    COUNT(*) AS posicionA
FROM
    estadisticas
WHERE
    asistencias_por_partido = (SELECT 
            MAX(asistencias_por_partido)
        FROM
            estadisticas);

# Clave 14043
SELECT 
    SUM(j.peso) AS claveA
FROM
    jugadores j
        INNER JOIN
    equipos e ON j.nombre_equipo = e.nombre
WHERE
    e.conferencia = 'East'
        AND j.posicion LIKE '%C%';

# Candado B
# Posicion 3
SELECT 
    COUNT(*) AS posicionB
FROM
    jugadores j
        INNER JOIN
    estadisticas e ON j.codigo = e.jugador
WHERE
    e.asistencias_por_partido > (SELECT 
            COUNT(*)
        FROM
            jugadores
        WHERE
            nombre_equipo = 'Heat');

# Clave 3480
SELECT 
    COUNT(*) AS claveB
FROM
    partidos
WHERE
    temporada LIKE '%99%';

# Candado C
# Posicion 1
SELECT 
    (SELECT 
            (SELECT 
                        COUNT(*)
                    FROM
                        jugadores j
                            INNER JOIN
                        equipos e ON j.nombre_equipo = e.nombre
                    WHERE
                        j.procedencia = 'Michigan'
                            AND e.conferencia = 'West') / (SELECT 
                        COUNT(*)
                    FROM
                        jugadores
                    WHERE
                        peso >= 195)
        ) + 0.9945 AS posicionC;

# Clave 631
SELECT 
    FLOOR(AVG(e.puntos_por_partido) + COUNT(e.asistencias_por_partido) + SUM(e.tapones_por_partido)) AS claveC
FROM
    estadisticas e
        INNER JOIN
    jugadores j ON e.jugador = j.codigo
        INNER JOIN
    equipos eq ON j.nombre_equipo = eq.nombre
WHERE
    eq.division = 'Central';

# Candado D 
# Posicion 4
SELECT 
    ROUND(e.tapones_por_partido) AS posicionD
FROM
    estadisticas e
        INNER JOIN
    jugadores j ON e.jugador = j.codigo
        INNER JOIN
    equipos eq ON j.nombre_equipo = eq.nombre
        INNER JOIN
    partidos p ON eq.nombre = p.equipo_local
        OR eq.nombre = p.equipo_visitante
WHERE
    j.nombre = 'Corey Maggette'
        AND p.temporada = '00/01';

# Clave 191
SELECT 
    FLOOR(SUM(puntos_por_partido)) AS claveD
FROM
    estadisticas e
        INNER JOIN
    jugadores j ON e.jugador = j.codigo
WHERE
    j.procedencia = 'Argentina';