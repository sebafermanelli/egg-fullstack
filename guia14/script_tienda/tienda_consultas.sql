-- 1
SELECT nombre FROM producto;

-- 2
SELECT nombre, precio FROM producto;

-- 3
SELECT * FROM producto;

-- 4
SELECT nombre, ROUND(precio) FROM producto;

-- 5
SELECT codigo_fabricante FROM producto;

-- 6
SELECT DISTINCT codigo_fabricante FROM producto;

-- 7
SELECT nombre FROM fabricante ORDER BY nombre ASC;

-- 8
SELECT * FROM producto ORDER BY nombre ASC;
SELECT * FROM producto ORDER BY precio DESC;

-- 9
SELECT * FROM fabricante LIMIT 5;

-- 10
SELECT nombre, precio FROM producto ORDER BY precio ASC LIMIT 1;

-- 11
SELECT nombre, precio FROM producto ORDER BY precio DESC LIMIT 1;

-- 12
SELECT * FROM producto WHERE precio<=120;

-- 13
SELECT * FROM producto WHERE precio BETWEEN 60 AND 200;

-- 14
SELECT * FROM producto WHERE codigo_fabricante IN (1,3,5);

-- 15
SELECT nombre FROM producto WHERE nombre LIKE '%Portátil%';

-- Consultas multitabla
-- 1
SELECT p.codigo, p.nombre AS producto_nombre, p.codigo_fabricante, f.nombre AS fabricante_nombre FROM producto p INNER JOIN fabricante f WHERE p.codigo_fabricante = f.codigo;

-- 2
SELECT p.nombre AS producto_nombre, p.precio, f.nombre AS fabricante_nombre FROM producto p INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo ORDER BY f.nombre ASC;

-- 3
SELECT p.nombre AS producto_nombre, p.precio, f.nombre AS fabricante_nombre FROM producto p INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo ORDER BY p.precio ASC LIMIT 1;

-- 4
SELECT p.* FROM producto p INNER JOIN fabricante f ON p.codigo_fabricante=f.codigo AND f.nombre='Lenovo';

-- 5
SELECT p.* FROM producto p INNER JOIN fabricante f ON p.codigo_fabricante=f.codigo AND f.nombre='Crucial' AND precio>200;

-- 6
SELECT p.* FROM producto p INNER JOIN fabricante f ON p.codigo_fabricante=f.codigo AND f.nombre IN('Asus','Hewlett-Packard');

-- 7
SELECT p.nombre AS producto_nombre, p.precio, f.nombre AS fabricante_nombre FROM producto p INNER JOIN fabricante f ON p.codigo_fabricante=f.codigo AND precio>=180 ORDER BY precio DESC;
SELECT p.nombre AS producto_nombre, p.precio, f.nombre AS fabricante_nombre FROM producto p INNER JOIN fabricante f ON p.codigo_fabricante=f.codigo AND precio>=180 ORDER BY p.nombre ASC;

-- Consultas multitabla con LEFT JOIN y RIGHT JOIN
-- 1
SELECT f.*, p.* FROM fabricante f LEFT JOIN producto p ON f.codigo=p.codigo_fabricante;

-- 2
SELECT f.*, p.* FROM fabricante f LEFT JOIN producto p ON f.codigo=p.codigo_fabricante WHERE p.codigo_fabricante IS NULL;

-- Subconsultas
-- 1
SELECT * FROM producto WHERE codigo_fabricante=(SELECT codigo FROM fabricante WHERE nombre='Lenovo');

-- 2
SELECT * FROM producto WHERE precio=(SELECT precio FROM producto WHERE codigo_fabricante=(SELECT codigo FROM fabricante WHERE nombre='Lenovo') ORDER BY precio DESC LIMIT 1);

-- 3
SELECT nombre FROM producto WHERE codigo_fabricante=(SELECT codigo FROM fabricante WHERE nombre='Lenovo') ORDER BY precio DESC LIMIT 1;

-- 4
SELECT * FROM producto WHERE precio>(SELECT AVG(precio) FROM producto WHERE codigo_fabricante=(SELECT codigo FROM fabricante WHERE nombre='Asus'));

-- Subconsultas con IN y NOT IN
-- 1
SELECT nombre FROM fabricante WHERE codigo IN (SELECT codigo_fabricante FROM producto);

-- 2
SELECT nombre FROM fabricante WHERE codigo NOT IN (SELECT codigo_fabricante FROM producto);

-- Subconsultas con HAVING
-- 1
SELECT nombre FROM fabricante WHERE codigo IN (SELECT codigo_fabricante FROM producto GROUP BY codigo_fabricante HAVING COUNT(*)=(SELECT COUNT(*) AS cant_productos FROM producto WHERE codigo_fabricante=(SELECT codigo FROM fabricante WHERE nombre='Lenovo')));