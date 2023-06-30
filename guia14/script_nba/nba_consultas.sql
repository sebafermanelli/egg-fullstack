-- 1
SELECT nombre FROM jugadores ORDER BY nombre ASC;

-- 2
SELECT nombre FROM jugadores WHERE posicion LIKE '%C%' AND peso>200 ORDER BY nombre ASC;

-- 3
SELECT nombre FROM equipos ORDER BY nombre ASC;

-- 4
SELECT nombre FROM equipos WHERE conferencia LIKE 'East';

-- 5
SELECT * FROM equipos WHERE ciudad LIKE 'C%' ORDER BY nombre ASC;

-- 6
SELECT j.*, e.* FROM jugadores j INNER JOIN equipos e ON j.nombre_equipo=e.nombre ORDER BY e.nombre ASC;

-- 7
SELECT * FROM jugadores WHERE nombre_equipo LIKE 'Raptors' ORDER BY nombre ASC;

-- 8
SELECT puntos_por_partido FROM estadisticas WHERE jugador=(SELECT codigo FROM jugadores WHERE nombre LIKE 'Pau Gasol');

-- 9
SELECT puntos_por_partido FROM estadisticas WHERE jugador=(SELECT codigo FROM jugadores WHERE nombre LIKE 'Pau Gasol') AND temporada LIKE '04/05';

-- 10
SELECT j.nombre, jugador, SUM(puntos_por_partido) FROM estadisticas e INNER JOIN jugadores j ON e.jugador=j.codigo GROUP BY e.jugador ORDER BY e.jugador ASC;

-- 11
SELECT e.nombre, COUNT(j.nombre_equipo) FROM jugadores j INNER JOIN equipos e ON j.nombre_equipo=e.nombre GROUP BY e.nombre;

-- 12
SELECT j.nombre, jugador, SUM(puntos_por_partido) FROM estadisticas e INNER JOIN jugadores j ON e.jugador=j.codigo GROUP BY e.jugador ORDER BY SUM(e.puntos_por_partido) DESC LIMIT 1;

-- 13
SELECT * FROM equipos WHERE nombre=(SELECT nombre_equipo FROM jugadores ORDER BY altura DESC LIMIT 1);

-- 14
SELECT *, ABS(puntos_local-puntos_visitante) AS diferencia_puntos FROM partidos ORDER BY ABS(diferencia_puntos) DESC LIMIT 10;

-- 15
SELECT *,
	CASE
		WHEN puntos_local > puntos_visitante THEN equipo_local
        WHEN puntos_visitante > puntos_local THEN equipo_visitante
		ELSE NULL
	END
	AS equipo_ganador FROM partidos;