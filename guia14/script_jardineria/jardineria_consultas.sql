-- 1
SELECT codigo_oficina, ciudad FROM oficina;

-- 2
SELECT ciudad, telefono FROM oficina WHERE pais LIKE 'España';

-- 3
SELECT nombre, apellido1, apellido2, email FROM empleado WHERE codigo_jefe=7;

-- 4
SELECT puesto, nombre, apellido1, apellido2, email FROM empleado WHERE codigo_jefe IS NULL;

-- 5
SELECT nombre, apellido1, apellido2, puesto FROM empleado WHERE puesto NOT LIKE 'Representante Ventas';

-- 6
SELECT nombre_cliente, pais FROM cliente WHERE pais LIKE 'Spain';

-- 7
SELECT estado FROM pedido GROUP BY estado;

-- 8
-- YEAR
SELECT c.codigo_cliente FROM cliente c INNER JOIN pago p ON c.codigo_cliente=p.codigo_cliente WHERE 2008=YEAR(p.fecha_pago) GROUP BY p.codigo_cliente;
-- DATE_FORMAT
SELECT c.codigo_cliente FROM cliente c INNER JOIN pago p ON c.codigo_cliente=p.codigo_cliente WHERE DATE_FORMAT(p.fecha_pago, '%Y')=2008 GROUP BY p.codigo_cliente;
-- SIN FUNCIONES
SELECT c.codigo_cliente FROM cliente c INNER JOIN pago p ON c.codigo_cliente=p.codigo_cliente WHERE p.fecha_pago LIKE '2008%' GROUP BY p.codigo_cliente;

-- 9
SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega FROM pedido WHERE fecha_entrega>fecha_esperada AND estado LIKE 'Entregado';

-- 10
SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega FROM pedido WHERE DATEDIFF(fecha_esperada, fecha_entrega)<=2 AND 0<=DATEDIFF(fecha_esperada, fecha_entrega) AND estado LIKE 'Entregado';

-- 11
SELECT * FROM pedido WHERE 2009=YEAR(fecha_pedido) AND estado LIKE 'Rechazado';

-- 12
SELECT * FROM pedido WHERE DATE_FORMAT(fecha_entrega, '%m')=01 AND estado LIKE 'Entregado';

-- 13
SELECT * FROM pago WHERE 2008=YEAR(fecha_pago) AND forma_pago LIKE 'Paypal' ORDER BY total DESC;

-- 14
SELECT forma_pago FROM pago GROUP BY forma_pago;

-- 15
SELECT * FROM producto WHERE gama LIKE 'Ornamentales' AND cantidad_en_stock>100 ORDER BY precio_venta DESC;

-- 16
SELECT * FROM cliente WHERE ciudad LIKE 'Madrid' AND (codigo_empleado_rep_ventas=11 OR codigo_empleado_rep_ventas=30);

-- Consultas multitabla (Composicion interna) INNER JOIN
-- 1
SELECT c.nombre_cliente, r.nombre, r.apellido1, r.apellido2 FROM cliente c
	INNER JOIN empleado r ON c.codigo_empleado_rep_ventas=r.codigo_empleado;
    
-- 2
SELECT c.nombre_cliente, r.nombre, r.apellido1, r.apellido2 FROM cliente c
	INNER JOIN pago p ON c.codigo_cliente=p.codigo_cliente
	INNER JOIN empleado r ON c.codigo_empleado_rep_ventas=r.codigo_empleado;
    
-- 3
SELECT c.nombre_cliente, r.nombre, r.apellido1, r.apellido2 FROM cliente c
	LEFT JOIN pago p ON c.codigo_cliente=p.codigo_cliente
	INNER JOIN empleado r ON c.codigo_empleado_rep_ventas=r.codigo_empleado
    WHERE p.codigo_cliente IS NULL;

-- 4
SELECT c.nombre_cliente, r.nombre, r.apellido1, r.apellido2, o.ciudad FROM cliente c
	INNER JOIN pago p ON c.codigo_cliente=p.codigo_cliente
	INNER JOIN empleado r ON c.codigo_empleado_rep_ventas=r.codigo_empleado
    INNER JOIN oficina o ON r.codigo_oficina=o.codigo_oficina;
    
-- 5
SELECT c.nombre_cliente, r.nombre, r.apellido1, r.apellido2, o.ciudad FROM cliente c
	LEFT JOIN pago p ON c.codigo_cliente=p.codigo_cliente
	INNER JOIN empleado r ON c.codigo_empleado_rep_ventas=r.codigo_empleado
	INNER JOIN oficina o ON r.codigo_oficina=o.codigo_oficina
    WHERE p.codigo_cliente IS NULL;
    
-- 6
SELECT o.linea_direccion1, o.linea_direccion2 FROM oficina o
	INNER JOIN empleado r ON r.codigo_oficina=o.codigo_oficina
    INNER JOIN cliente c ON c.codigo_empleado_rep_ventas=r.codigo_empleado
    WHERE c.ciudad LIKE 'Fuenlabrada';
    
-- 7
SELECT c.nombre_cliente, r.nombre, o.ciudad FROM oficina o
	INNER JOIN empleado r ON r.codigo_oficina=o.codigo_oficina
    INNER JOIN cliente c ON c.codigo_empleado_rep_ventas=r.codigo_empleado;
    
-- 8
SELECT e.nombre, j.nombre AS jefe FROM empleado e
	INNER JOIN empleado j ON e.codigo_jefe=j.codigo_empleado;
    
-- 9
SELECT c.nombre_cliente FROM cliente c
	INNER JOIN pedido p ON c.codigo_cliente=p.codigo_cliente
    WHERE p.fecha_entrega>p.fecha_esperada GROUP BY c.codigo_cliente;
    
-- 10
SELECT DISTINCT c.nombre_cliente, g.gama FROM cliente c
	INNER JOIN pedido ped ON c.codigo_cliente=ped.codigo_cliente
    INNER JOIN detalle_pedido det_ped ON ped.codigo_pedido=det_ped.codigo_pedido
    INNER JOIN producto prod ON det_ped.codigo_producto=prod.codigo_producto
    INNER JOIN gama_producto g ON prod.gama=g.gama;
    
-- Consultas multitabla (Composicion externa) LEFT JOIN, RIGHT JOIN, JOIN
-- 1
SELECT c.* FROM cliente c
	LEFT JOIN pago p ON c.codigo_cliente=p.codigo_cliente
    WHERE p.codigo_cliente IS NULL;
    
-- 2
SELECT c.* FROM cliente c
	LEFT JOIN pedido p ON c.codigo_cliente=p.codigo_cliente
    WHERE p.codigo_cliente IS NULL;
    
-- 3
SELECT c.* FROM cliente c
	LEFT JOIN pedido ped ON c.codigo_cliente=ped.codigo_cliente
    LEFT JOIN pago pag ON c.codigo_cliente=pag.codigo_cliente
    WHERE pag.codigo_cliente IS NULL AND ped.codigo_cliente IS NULL;
    
-- 4
SELECT e.* FROM empleado e
	LEFT JOIN oficina o ON e.codigo_oficina=o.codigo_oficina
    WHERE e.codigo_oficina IS NULL;
    
-- 5
SELECT e.* FROM empleado e
	LEFT JOIN cliente c ON c.codigo_empleado_rep_ventas=e.codigo_empleado
    WHERE c.codigo_cliente IS NULL;
    
-- 6
SELECT e.* FROM empleado e
	LEFT JOIN oficina o ON e.codigo_oficina=o.codigo_oficina
    LEFT JOIN cliente c ON c.codigo_empleado_rep_ventas=e.codigo_empleado
    WHERE e.codigo_oficina IS NULL AND c.codigo_cliente IS NULL;
    
-- 7
SELECT prod.* FROM pedido ped
	INNER JOIN detalle_pedido det_ped ON ped.codigo_pedido=det_ped.codigo_pedido
    RIGHT JOIN producto prod ON det_ped.codigo_producto=prod.codigo_producto
    WHERE det_ped.codigo_producto IS NULL;

-- 8
SELECT o.* FROM oficina o WHERE o.codigo_oficina IN (
	SELECT e.codigo_oficina FROM empleado e
		WHERE e.codigo_empleado NOT IN (
			SELECT DISTINCT c.codigo_empleado_rep_ventas FROM cliente c
				INNER JOIN pedido ped ON ped.codigo_cliente=c.codigo_cliente
				INNER JOIN detalle_pedido det_ped ON det_ped.codigo_pedido=ped.codigo_pedido
				INNER JOIN producto prod ON prod.codigo_producto=det_ped.codigo_producto
				WHERE prod.gama LIKE 'Frutales')
);

-- 9
SELECT DISTINCT c.* FROM cliente c
	LEFT JOIN pago pago ON pago.codigo_cliente=c.codigo_cliente
    INNER JOIN pedido ped ON ped.codigo_cliente=c.codigo_cliente
    WHERE pago.codigo_cliente IS NULL;
    
-- 10
SELECT e.*, j.nombre FROM empleado e
	LEFT JOIN cliente c ON c.codigo_empleado_rep_ventas=e.codigo_empleado
    INNER JOIN empleado j ON j.codigo_empleado=e.codigo_jefe
    WHERE c.codigo_cliente IS NULL;

-- Consultas resumen