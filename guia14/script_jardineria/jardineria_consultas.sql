-- 1
SELECT 
    codigo_oficina, ciudad
FROM
    oficina;

-- 2
SELECT 
    ciudad, telefono
FROM
    oficina
WHERE
    pais LIKE 'España';

-- 3
SELECT 
    nombre, apellido1, apellido2, email
FROM
    empleado
WHERE
    codigo_jefe = 7;

-- 4
SELECT 
    puesto, nombre, apellido1, apellido2, email
FROM
    empleado
WHERE
    codigo_jefe IS NULL;

-- 5
SELECT 
    nombre, apellido1, apellido2, puesto
FROM
    empleado
WHERE
    puesto NOT LIKE 'Representante Ventas';

-- 6
SELECT 
    nombre_cliente, pais
FROM
    cliente
WHERE
    pais LIKE 'Spain';

-- 7
SELECT 
    estado
FROM
    pedido
GROUP BY estado;

-- 8
-- YEAR
SELECT 
    c.codigo_cliente
FROM
    cliente c
        INNER JOIN
    pago p ON c.codigo_cliente = p.codigo_cliente
WHERE
    2008 = YEAR(p.fecha_pago)
GROUP BY p.codigo_cliente;
-- DATE_FORMAT
SELECT 
    c.codigo_cliente
FROM
    cliente c
        INNER JOIN
    pago p ON c.codigo_cliente = p.codigo_cliente
WHERE
    DATE_FORMAT(p.fecha_pago, '%Y') = 2008
GROUP BY p.codigo_cliente;
-- SIN FUNCIONES
SELECT 
    c.codigo_cliente
FROM
    cliente c
        INNER JOIN
    pago p ON c.codigo_cliente = p.codigo_cliente
WHERE
    p.fecha_pago LIKE '2008%'
GROUP BY p.codigo_cliente;

-- 9
SELECT 
    codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
FROM
    pedido
WHERE
    fecha_entrega > fecha_esperada
        AND estado LIKE 'Entregado';

-- 10
SELECT 
    codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
FROM
    pedido
WHERE
    DATEDIFF(fecha_esperada, fecha_entrega) <= 2
        AND 0 <= DATEDIFF(fecha_esperada, fecha_entrega)
        AND estado LIKE 'Entregado';

-- 11
SELECT 
    *
FROM
    pedido
WHERE
    2009 = YEAR(fecha_pedido)
        AND estado LIKE 'Rechazado';

-- 12
SELECT 
    *
FROM
    pedido
WHERE
    DATE_FORMAT(fecha_entrega, '%m') = 01
        AND estado LIKE 'Entregado';

-- 13
SELECT 
    *
FROM
    pago
WHERE
    2008 = YEAR(fecha_pago)
        AND forma_pago LIKE 'Paypal'
ORDER BY total DESC;

-- 14
SELECT 
    forma_pago
FROM
    pago
GROUP BY forma_pago;

-- 15
SELECT 
    *
FROM
    producto
WHERE
    gama LIKE 'Ornamentales'
        AND cantidad_en_stock > 100
ORDER BY precio_venta DESC;

-- 16
SELECT 
    *
FROM
    cliente
WHERE
    ciudad LIKE 'Madrid'
        AND (codigo_empleado_rep_ventas = 11
        OR codigo_empleado_rep_ventas = 30);

-- Consultas multitabla (Composicion interna) INNER JOIN
-- 1
SELECT 
    c.nombre_cliente, r.nombre, r.apellido1, r.apellido2
FROM
    cliente c
        INNER JOIN
    empleado r ON c.codigo_empleado_rep_ventas = r.codigo_empleado;
    
-- 2
SELECT 
    c.nombre_cliente, r.nombre, r.apellido1, r.apellido2
FROM
    cliente c
        INNER JOIN
    pago p ON c.codigo_cliente = p.codigo_cliente
        INNER JOIN
    empleado r ON c.codigo_empleado_rep_ventas = r.codigo_empleado;
    
-- 3
SELECT 
    c.nombre_cliente, r.nombre, r.apellido1, r.apellido2
FROM
    cliente c
        LEFT JOIN
    pago p ON c.codigo_cliente = p.codigo_cliente
        INNER JOIN
    empleado r ON c.codigo_empleado_rep_ventas = r.codigo_empleado
WHERE
    p.codigo_cliente IS NULL;

-- 4
SELECT 
    c.nombre_cliente,
    r.nombre,
    r.apellido1,
    r.apellido2,
    o.ciudad
FROM
    cliente c
        INNER JOIN
    pago p ON c.codigo_cliente = p.codigo_cliente
        INNER JOIN
    empleado r ON c.codigo_empleado_rep_ventas = r.codigo_empleado
        INNER JOIN
    oficina o ON r.codigo_oficina = o.codigo_oficina;
    
-- 5
SELECT 
    c.nombre_cliente,
    r.nombre,
    r.apellido1,
    r.apellido2,
    o.ciudad
FROM
    cliente c
        LEFT JOIN
    pago p ON c.codigo_cliente = p.codigo_cliente
        INNER JOIN
    empleado r ON c.codigo_empleado_rep_ventas = r.codigo_empleado
        INNER JOIN
    oficina o ON r.codigo_oficina = o.codigo_oficina
WHERE
    p.codigo_cliente IS NULL;
    
-- 6
SELECT 
    o.linea_direccion1, o.linea_direccion2
FROM
    oficina o
        INNER JOIN
    empleado r ON r.codigo_oficina = o.codigo_oficina
        INNER JOIN
    cliente c ON c.codigo_empleado_rep_ventas = r.codigo_empleado
WHERE
    c.ciudad LIKE 'Fuenlabrada';
    
-- 7
SELECT 
    c.nombre_cliente, r.nombre, o.ciudad
FROM
    oficina o
        INNER JOIN
    empleado r ON r.codigo_oficina = o.codigo_oficina
        INNER JOIN
    cliente c ON c.codigo_empleado_rep_ventas = r.codigo_empleado;
    
-- 8
SELECT 
    e.nombre, j.nombre AS jefe
FROM
    empleado e
        INNER JOIN
    empleado j ON e.codigo_jefe = j.codigo_empleado;
    
-- 9
SELECT 
    c.nombre_cliente
FROM
    cliente c
        INNER JOIN
    pedido p ON c.codigo_cliente = p.codigo_cliente
WHERE
    p.fecha_entrega > p.fecha_esperada
GROUP BY c.codigo_cliente;
    
-- 10
SELECT DISTINCT
    c.nombre_cliente, g.gama
FROM
    cliente c
        INNER JOIN
    pedido ped ON c.codigo_cliente = ped.codigo_cliente
        INNER JOIN
    detalle_pedido det_ped ON ped.codigo_pedido = det_ped.codigo_pedido
        INNER JOIN
    producto prod ON det_ped.codigo_producto = prod.codigo_producto
        INNER JOIN
    gama_producto g ON prod.gama = g.gama;
    
-- Consultas multitabla (Composicion externa) LEFT JOIN, RIGHT JOIN, JOIN
-- 1
SELECT 
    c.*
FROM
    cliente c
        LEFT JOIN
    pago p ON c.codigo_cliente = p.codigo_cliente
WHERE
    p.codigo_cliente IS NULL;
    
-- 2
SELECT 
    c.*
FROM
    cliente c
        LEFT JOIN
    pedido p ON c.codigo_cliente = p.codigo_cliente
WHERE
    p.codigo_cliente IS NULL;
    
-- 3
SELECT 
    c.*
FROM
    cliente c
        LEFT JOIN
    pedido ped ON c.codigo_cliente = ped.codigo_cliente
        LEFT JOIN
    pago pag ON c.codigo_cliente = pag.codigo_cliente
WHERE
    pag.codigo_cliente IS NULL
        AND ped.codigo_cliente IS NULL;
    
-- 4
SELECT 
    e.*
FROM
    empleado e
        LEFT JOIN
    oficina o ON e.codigo_oficina = o.codigo_oficina
WHERE
    e.codigo_oficina IS NULL;
    
-- 5
SELECT 
    e.*
FROM
    empleado e
        LEFT JOIN
    cliente c ON c.codigo_empleado_rep_ventas = e.codigo_empleado
WHERE
    c.codigo_cliente IS NULL;
    
-- 6
SELECT 
    e.*
FROM
    empleado e
        LEFT JOIN
    oficina o ON e.codigo_oficina = o.codigo_oficina
        LEFT JOIN
    cliente c ON c.codigo_empleado_rep_ventas = e.codigo_empleado
WHERE
    e.codigo_oficina IS NULL
        AND c.codigo_cliente IS NULL;
    
-- 7
SELECT 
    prod.*
FROM
    pedido ped
        INNER JOIN
    detalle_pedido det_ped ON ped.codigo_pedido = det_ped.codigo_pedido
        RIGHT JOIN
    producto prod ON det_ped.codigo_producto = prod.codigo_producto
WHERE
    det_ped.codigo_producto IS NULL;

-- 8
SELECT 
    o.*
FROM
    oficina o
WHERE
    o.codigo_oficina IN (SELECT 
            e.codigo_oficina
        FROM
            empleado e
        WHERE
            e.codigo_empleado NOT IN (SELECT DISTINCT
                    c.codigo_empleado_rep_ventas
                FROM
                    cliente c
                        INNER JOIN
                    pedido ped ON ped.codigo_cliente = c.codigo_cliente
                        INNER JOIN
                    detalle_pedido det_ped ON det_ped.codigo_pedido = ped.codigo_pedido
                        INNER JOIN
                    producto prod ON prod.codigo_producto = det_ped.codigo_producto
                WHERE
                    prod.gama LIKE 'Frutales'));

-- 9
SELECT DISTINCT
    c.*
FROM
    cliente c
        LEFT JOIN
    pago pago ON pago.codigo_cliente = c.codigo_cliente
        INNER JOIN
    pedido ped ON ped.codigo_cliente = c.codigo_cliente
WHERE
    pago.codigo_cliente IS NULL;
    
-- 10
SELECT 
    e.*, j.nombre
FROM
    empleado e
        LEFT JOIN
    cliente c ON c.codigo_empleado_rep_ventas = e.codigo_empleado
        INNER JOIN
    empleado j ON j.codigo_empleado = e.codigo_jefe
WHERE
    c.codigo_cliente IS NULL;

-- Consultas resumen
-- 1
SELECT 
    COUNT(*) AS cant_empleados
FROM
    empleado;

-- 2
SELECT 
    COUNT(*) AS cant_clientes_pais, pais
FROM
    cliente
GROUP BY pais;

-- 3
SELECT 
    AVG(total)
FROM
    pago
WHERE
    YEAR(fecha_pago) = 2009;

-- 4
SELECT 
    COUNT(estado), estado
FROM
    pedido
GROUP BY estado
ORDER BY COUNT(estado) DESC;

-- 5
SELECT 
    MAX(precio_venta), MIN(precio_venta)
FROM
    producto;

-- 6
SELECT 
    COUNT(*)
FROM
    CLIENTE;

-- 7
SELECT 
    COUNT(*)
FROM
    CLIENTE
WHERE
    ciudad = 'Madrid';

-- 8
SELECT 
    COUNT(*), ciudad
FROM
    cliente
WHERE
    ciudad LIKE 'M%'
GROUP BY ciudad;

-- 9
SELECT 
    r.nombre, COUNT(c.codigo_cliente)
FROM
    cliente c
        INNER JOIN
    empleado r ON r.codigo_empleado = c.codigo_empleado_rep_ventas
GROUP BY r.nombre;
        
-- 10
SELECT 
    COUNT(*)
FROM
    cliente c
        LEFT JOIN
    empleado r ON r.codigo_empleado = c.codigo_empleado_rep_ventas
WHERE
    r.codigo_empleado IS NULL;
        
-- 11
SELECT 
    c.codigo_cliente,
    c.nombre_cliente,
    MAX(fecha_pago),
    MIN(fecha_pago)
FROM
    cliente c
        INNER JOIN
    pago p ON p.codigo_cliente = c.codigo_cliente
GROUP BY c.codigo_cliente;

-- 12
SELECT 
    ped.codigo_pedido, COUNT(prod.codigo_producto)
FROM
    detalle_pedido dp
        INNER JOIN
    pedido ped ON dp.codigo_pedido = ped.codigo_pedido
        INNER JOIN
    producto prod ON dp.codigo_producto = prod.codigo_producto
GROUP BY ped.codigo_pedido;

-- 13
SELECT 
    ped.codigo_pedido, SUM(dp.cantidad)
FROM
    detalle_pedido dp
        INNER JOIN
    pedido ped ON dp.codigo_pedido = ped.codigo_pedido
        INNER JOIN
    producto prod ON dp.codigo_producto = prod.codigo_producto
GROUP BY ped.codigo_pedido;
        
-- 14
SELECT 
    SUM(dp.cantidad), dp.codigo_producto, p.nombre
FROM
    detalle_pedido dp
        INNER JOIN
    producto p ON dp.codigo_producto = p.codigo_producto
GROUP BY dp.codigo_producto
ORDER BY SUM(dp.cantidad) DESC
LIMIT 20;
        
-- 15
SELECT 
    SUM((dp.cantidad * dp.precio_unidad) + (dp.cantidad * dp.precio_unidad) * 0.21) AS total_facturacion
FROM
    pago p
        INNER JOIN
    pedido ped ON P.codigo_cliente = ped.codigo_cliente
        INNER JOIN
    detalle_pedido dp ON ped.codigo_pedido = dp.codigo_pedido;

-- 16
SELECT 
    dp.codigo_producto,
    SUM((dp.cantidad * dp.precio_unidad) + (dp.cantidad * dp.precio_unidad) * 0.21) AS total_facturacion
FROM
    pago p
        INNER JOIN
    pedido ped ON P.codigo_cliente = ped.codigo_cliente
        INNER JOIN
    detalle_pedido dp ON ped.codigo_pedido = dp.codigo_pedido
GROUP BY dp.codigo_producto;

-- 17
SELECT 
    dp.codigo_producto,
    SUM((dp.cantidad * dp.precio_unidad) + (dp.cantidad * dp.precio_unidad) * 0.21) AS total_facturacion
FROM
    pago p
        INNER JOIN
    pedido ped ON P.codigo_cliente = ped.codigo_cliente
        INNER JOIN
    detalle_pedido dp ON ped.codigo_pedido = dp.codigo_pedido
WHERE
    dp.codigo_producto LIKE 'OR%'
GROUP BY dp.codigo_producto;

-- 18
SELECT 
    dp.codigo_producto,
    SUM((dp.cantidad * dp.precio_unidad)) AS total_facturacion,
    SUM((dp.cantidad * dp.precio_unidad) + (dp.cantidad * dp.precio_unidad) * 0.21) AS total_facturacion_iva
FROM
    pago p
        INNER JOIN
    pedido ped ON P.codigo_cliente = ped.codigo_cliente
        INNER JOIN
    detalle_pedido dp ON ped.codigo_pedido = dp.codigo_pedido
GROUP BY dp.codigo_producto
HAVING SUM((dp.cantidad * dp.precio_unidad)) > 3000;
            
-- Subconsultas con operadores basicos de comparacion
-- 1
SELECT 
    nombre_cliente
FROM
    cliente
WHERE
    limite_credito = (SELECT 
            MAX(limite_credito)
        FROM
            cliente);

-- 2
SELECT 
    nombre
FROM
    producto
WHERE
    precio_venta = (SELECT 
            MAX(precio_venta)
        FROM
            producto);

-- 3
SELECT 
    p.nombre
FROM
    producto p
WHERE
    codigo_producto = (SELECT 
            codigo_producto
        FROM
            detalle_pedido
        GROUP BY codigo_producto
        ORDER BY SUM(cantidad) DESC
        LIMIT 1);
                
-- 4
SELECT 
    c.*
FROM
    cliente c,
    pago p
WHERE
    c.codigo_cliente = p.codigo_cliente
GROUP BY c.codigo_cliente , c.limite_credito
HAVING c.limite_credito > SUM(p.total);

-- 5
SELECT 
    *
FROM
    producto
WHERE
    cantidad_en_stock = (SELECT 
            MAX(cantidad_en_stock)
        FROM
            producto);
            
-- 6
SELECT 
    *
FROM
    producto
WHERE
    cantidad_en_stock = (SELECT 
            MIN(cantidad_en_stock)
        FROM
            producto);
            
-- 7
SELECT 
    e.nombre, e.apellido1, e.apellido2, e.email
FROM
    empleado e,
    empleado j
WHERE
    e.codigo_jefe = j.codigo_empleado
        AND j.nombre = 'Alberto'
        AND j.apellido1 = 'Soria';
-- Subconsultas con ALL y ANY
-- 1
SELECT 
    nombre_cliente
FROM
    cliente
WHERE
    limite_credito = ALL (SELECT 
            MAX(limite_credito)
        FROM
            cliente);
            
SELECT 
    nombre_cliente
FROM
    cliente
WHERE
    limite_credito = ANY (SELECT 
            MAX(limite_credito)
        FROM
            cliente);
            
-- 2
SELECT 
    nombre
FROM
    producto
WHERE
    precio_venta = ALL (SELECT 
            MAX(precio_venta)
        FROM
            producto);

SELECT 
    nombre
FROM
    producto
WHERE
    precio_venta = ANY (SELECT 
            MAX(precio_venta)
        FROM
            producto);

-- 3
SELECT 
    *
FROM
    producto
WHERE
    cantidad_en_stock = ALL (SELECT 
            MIN(cantidad_en_stock)
        FROM
            producto);

SELECT 
    *
FROM
    producto
WHERE
    cantidad_en_stock = ANY (SELECT 
            MIN(cantidad_en_stock)
        FROM
            producto);
            
-- Subconsultas con IN y NOT IN
-- 1
SELECT 
    nombre, apellido1, apellido2, puesto
FROM
    empleado
WHERE
    codigo_empleado NOT IN (SELECT 
            codigo_empleado_rep_ventas
        FROM
            cliente);
            
-- 2
SELECT 
    *
FROM
    cliente
WHERE
    codigo_cliente NOT IN (SELECT 
            codigo_cliente
        FROM
            pago);

-- 3
SELECT 
    *
FROM
    cliente
WHERE
    codigo_cliente IN (SELECT 
            codigo_cliente
        FROM
            pago);

-- 4
SELECT * FROM producto WHERE codigo_producto NOT IN (SELECT codigo_producto FROM detalle_pedido);

-- 5
SELECT 
    e.nombre, e.apellido1, e.apellido2, e.puesto, o.telefono
FROM
    empleado e
        INNER JOIN
    oficina o ON e.codigo_oficina = o.codigo_oficina
WHERE
    e.codigo_empleado NOT IN (SELECT 
            codigo_empleado_rep_ventas
        FROM
            cliente);
            
-- Subconsultas con EXISTS y NOT EXISTS
-- 1
SELECT 
    c.*
FROM
    cliente c
WHERE
    NOT EXISTS( SELECT 
            *
        FROM
            pago p
        WHERE
            c.codigo_cliente = p.codigo_cliente);
            
-- 2
SELECT 
    c.*
FROM
    cliente c
WHERE
    EXISTS( SELECT 
            *
        FROM
            pago p
        WHERE
            c.codigo_cliente = p.codigo_cliente);

-- 3
SELECT 
    *
FROM
    producto p
WHERE
    NOT EXISTS( SELECT 
            *
        FROM
            detalle_pedido dp
        WHERE
            p.codigo_producto = dp.codigo_producto);

-- 4
SELECT 
    *
FROM
    producto p
WHERE
    EXISTS( SELECT 
            *
        FROM
            detalle_pedido dp
        WHERE
            p.codigo_producto = dp.codigo_producto);
