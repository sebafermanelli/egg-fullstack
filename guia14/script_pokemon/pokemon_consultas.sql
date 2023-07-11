-- 1
SELECT 
    nombre
FROM
    pokemon;

-- 2
SELECT 
    *
FROM
    pokemon
WHERE
    peso < 10;

-- 3
SELECT 
    p.*, t.nombre AS tipo
FROM
    pokemon p
        INNER JOIN
    pokemon_tipo pt ON p.numero_pokedex = pt.numero_pokedex
        INNER JOIN
    tipo t ON t.id_tipo = pt.id_tipo
WHERE
    t.nombre = 'Agua';
    
-- 4
SELECT 
    p.*, t.nombre AS tipo
FROM
    pokemon p
        INNER JOIN
    pokemon_tipo pt ON p.numero_pokedex = pt.numero_pokedex
        INNER JOIN
    tipo t ON t.id_tipo = pt.id_tipo
WHERE
    t.nombre = 'Agua' OR t.nombre = 'Fuego'
        OR t.nombre = 'Tierra'
ORDER BY tipo;

-- 5
SELECT 
    p.*, t.nombre AS tipo
FROM
    pokemon p
        INNER JOIN
    pokemon_tipo pt ON p.numero_pokedex = pt.numero_pokedex
        INNER JOIN
    tipo t ON t.id_tipo = pt.id_tipo
WHERE
    t.nombre = 'Fuego'
        OR t.nombre = 'Volador';
        
-- 6
SELECT 
    p.*
FROM
    pokemon p
        INNER JOIN
    estadisticas_base eb ON p.numero_pokedex = eb.numero_pokedex
WHERE
    eb.ps > 200;
    
-- 7
SELECT 
    nombre, peso, altura
FROM
    pokemon
WHERE
    numero_pokedex = (SELECT 
            ed.pokemon_origen
        FROM
            pokemon p
                INNER JOIN
            evoluciona_de ed ON p.numero_pokedex = ed.pokemon_evolucionado
        WHERE
            p.nombre = 'Arbok');
    
-- 8
SELECT 
    p.*, te.tipo_evolucion
FROM
    pokemon p
        INNER JOIN
    pokemon_forma_evolucion pfe ON p.numero_pokedex = pfe.numero_pokedex
        INNER JOIN
    forma_evolucion fe ON fe.id_forma_evolucion = pfe.id_forma_evolucion
        INNER JOIN
    tipo_evolucion te ON te.id_tipo_evolucion = fe.tipo_evolucion
WHERE
    te.tipo_evolucion = 'Intercambio';
    
-- 9
SELECT 
    nombre, prioridad
FROM
    movimiento
WHERE
    prioridad = (SELECT 
            MAX(prioridad)
        FROM
            movimiento);
            
-- 10
SELECT 
    *
FROM
    pokemon
WHERE
    peso = (SELECT 
            MAX(peso)
        FROM
            pokemon);
            
-- 11
SELECT 
    ta.id_tipo_ataque, ta.tipo
FROM
    tipo_ataque ta
        INNER JOIN
    tipo t ON t.id_tipo_ataque = ta.id_tipo_ataque
WHERE
    t.id_tipo = (SELECT 
            id_tipo
        FROM
            movimiento
        WHERE
            potencia = (SELECT 
                    MAX(potencia)
                FROM
                    movimiento));
                    
-- 12
SELECT 
    t.id_tipo, t.nombre, COUNT(*)
FROM
    movimiento m
        INNER JOIN
    tipo t ON t.id_tipo = m.id_tipo
GROUP BY m.id_tipo;

-- 13
SELECT 
    *
FROM
    movimiento
WHERE
    descripcion LIKE '%Envenena%';
    
-- 14
SELECT 
    *
FROM
    movimiento
WHERE
    descripcion LIKE '%Daño%'
ORDER BY nombre;

-- 15
SELECT 
    m.*
FROM
    movimiento m
        INNER JOIN
    pokemon_movimiento_forma pmf ON pmf.id_movimiento = m.id_movimiento
        INNER JOIN
    pokemon p ON p.numero_pokedex = pmf.numero_pokedex
WHERE
    p.nombre = 'Pikachu';
    
-- 16
SELECT 
    m.*, tfa.tipo_aprendizaje
FROM
    movimiento m
        INNER JOIN
    pokemon_movimiento_forma pmf ON pmf.id_movimiento = m.id_movimiento
        INNER JOIN
    pokemon p ON p.numero_pokedex = pmf.numero_pokedex
        INNER JOIN
    forma_aprendizaje fa ON fa.id_forma_aprendizaje = pmf.id_forma_aprendizaje
        INNER JOIN
    tipo_forma_aprendizaje tfa ON tfa.id_tipo_aprendizaje = fa.id_tipo_aprendizaje
WHERE
    p.nombre = 'Pikachu'
        AND tfa.tipo_aprendizaje = 'MT';
        
-- 17
SELECT 
    m.*, tfa.tipo_aprendizaje
FROM
    movimiento m
        INNER JOIN
    pokemon_movimiento_forma pmf ON pmf.id_movimiento = m.id_movimiento
        INNER JOIN
    pokemon p ON p.numero_pokedex = pmf.numero_pokedex
        INNER JOIN
    forma_aprendizaje fa ON fa.id_forma_aprendizaje = pmf.id_forma_aprendizaje
        INNER JOIN
    tipo_forma_aprendizaje tfa ON tfa.id_tipo_aprendizaje = fa.id_tipo_aprendizaje
        INNER JOIN
    tipo t ON t.id_tipo = m.id_tipo
WHERE
    p.nombre = 'Pikachu'
        AND tfa.tipo_aprendizaje = 'Nivel'
        AND t.nombre = 'Normal';
        
-- 18
SELECT 
    m.*
FROM
    movimiento m
        INNER JOIN
    movimiento_efecto_secundario mes ON mes.id_movimiento = m.id_movimiento
WHERE
    mes.probabilidad > 30;
    
-- 19
SELECT 
    p.*, te.tipo_evolucion
FROM
    pokemon p
        INNER JOIN
    pokemon_forma_evolucion pfe ON p.numero_pokedex = pfe.numero_pokedex
        INNER JOIN
    forma_evolucion fe ON pfe.id_forma_evolucion = fe.id_forma_evolucion
        INNER JOIN
    tipo_evolucion te ON fe.tipo_evolucion = te.id_tipo_evolucion
WHERE
    te.tipo_evolucion = 'Piedra';
    
-- 20
SELECT 
    p.*
FROM
    pokemon p
        LEFT JOIN
    evoluciona_de ed ON ed.pokemon_evolucionado = p.numero_pokedex
WHERE
    pokemon_evolucionado IS NULL;
    
-- 21
SELECT 
    t.*, COUNT(*)
FROM
    tipo t
        INNER JOIN
    pokemon_tipo pt ON t.id_tipo = pt.id_tipo
        INNER JOIN
    pokemon p ON pt.numero_pokedex = p.numero_pokedex
GROUP BY t.id_tipo;