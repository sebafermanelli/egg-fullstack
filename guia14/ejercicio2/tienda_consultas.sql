-- 1
select nombre from producto;

-- 2
select nombre, precio from producto;

-- 3
select * from producto;

-- 4
select nombre, round(precio) from producto;

-- 5
select codigo_fabricante from producto;

-- 6
select distinct codigo_fabricante from producto;

-- 7
select nombre from fabricante order by nombre asc;

-- 8
select * from producto order by nombre asc;
select * from producto order by precio desc;

-- 9
select * from fabricante limit 5;

-- 10
select nombre, precio from producto order by precio asc limit 1;

-- 11
select nombre, precio from producto order by precio desc limit 1;

-- 12
select * from producto where precio<=120;

-- 13
select * from producto where precio between 60 and 200;

-- 14
select * from producto where codigo_fabricante in (1,3,5);

-- 15
select nombre from producto where nombre like '%Portátil%';

-- consultas multitabla
-- 1
select p.codigo, p.nombre as producto_nombre, p.codigo_fabricante, f.nombre as fabricante_nombre from producto p inner join fabricante f where p.codigo_fabricante = f.codigo;

-- 2
select p.nombre as producto_nombre, p.precio, f.nombre as fabricante_nombre from producto p inner join fabricante f on p.codigo_fabricante = f.codigo order by f.nombre asc;

-- 3
select p.nombre as producto_nombre, p.precio, f.nombre as fabricante_nombre from producto p inner join fabricante f on p.codigo_fabricante = f.codigo order by p.precio asc limit 1;

-- 4
select p.* from producto p inner join fabricante f on p.codigo_fabricante=f.codigo and f.nombre='Lenovo';

-- 5
select p.* from producto p inner join fabricante f on p.codigo_fabricante=f.codigo and f.nombre='Crucial' and precio>200;

-- 6
select p.* from producto p inner join fabricante f on p.codigo_fabricante=f.codigo and f.nombre in('Asus','Hewlett-Packard');

-- 7
select p.nombre as producto_nombre, p.precio, f.nombre as fabricante_nombre from producto p inner join fabricante f on p.codigo_fabricante=f.codigo and precio>=180 order by precio desc;
select p.nombre as producto_nombre, p.precio, f.nombre as fabricante_nombre from producto p inner join fabricante f on p.codigo_fabricante=f.codigo and precio>=180 order by p.nombre asc;

-- consultas multitabla left join y right join
-- 1
select f.*, p.* from fabricante f left join producto p on f.codigo=p.codigo_fabricante;

-- 2
select f.*, p.* from fabricante f left join producto p on f.codigo=p.codigo_fabricante where p.codigo_fabricante is null;

-- subconsultas
-- 1
select * from producto where codigo_fabricante=(select codigo from fabricante where nombre='Lenovo');

-- 2
select * from producto where precio=(select precio from producto where codigo_fabricante=(select codigo from fabricante where nombre='Lenovo') order by precio desc limit 1);

-- 3
select nombre from producto where codigo_fabricante=(select codigo from fabricante where nombre='Lenovo') order by precio desc limit 1;

-- 4
select * from producto where precio>(select avg(precio) from producto where codigo_fabricante=(select codigo from fabricante where nombre='Asus'));

-- subconsulas con in y not in
-- 1
select nombre from fabricante where codigo in (select codigo_fabricante from producto);

-- 2
select nombre from fabricante where codigo not in (select codigo_fabricante from producto);

-- subconsultas con having
-- 1
select nombre from fabricante where codigo in (select codigo_fabricante from producto group by codigo_fabricante having count(*)=(select count(*) as cant_productos from producto where codigo_fabricante=(select codigo from fabricante where nombre='Lenovo')));