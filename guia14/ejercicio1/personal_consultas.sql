-- 1
select * from empleados;

-- 2
select * from departamentos;

-- 3
select nombre_depto from departamentos;

-- 4
select nombre, sal_emp from empleados;

-- 5
select comision_emp from empleados;

-- 6
select * from empleados where cargo_emp='Secretaria';

-- 7
select * from empleados where cargo_emp='Vendedor' order by nombre asc;

-- 8
select nombre, cargo_emp from empleados order by sal_emp;

-- 9
select nombre_jefe_depto from departamentos where ciudad='Ciudad Real';

-- 10
select nombre as Nombre, cargo_emp as Cargo from empleados;

-- 11
select sal_emp, comision_emp from empleados where id_depto=2000 order by comision_emp asc;

-- 12
select nombre, (sal_emp + comision_emp + 500) as total_pagar from empleados where id_depto=3000 order by nombre asc;

-- 13
select * from empleados where nombre like 'J%';

-- 14
select sal_emp, comision_emp, (sal_emp + comision_emp) as salario_total, nombre from empleados where comision_emp>1000;

-- 15
select sal_emp, comision_emp, (sal_emp + comision_emp) as salario_total, nombre from empleados where comision_emp=0;

-- 16
select * from empleados where comision_emp>sal_emp;

-- 17
select * from empleados where comision_emp<=(sal_emp*0.3);

-- 18
select * from empleados where nombre not like '%MA%';

-- 19
select nombre_depto from departamentos where nombre_depto='Ventas' or nombre_depto='Investigacion' or nombre_depto='Mantenimiento';

-- 20
select nombre_depto from departamentos where nombre_depto!='Ventas' and nombre_depto!='Investigacion' and nombre_depto != 'Mantenimiento';

-- 21
select * from empleados where sal_emp=(select MAX(sal_emp) from empleados);

-- 22
select * from empleados where nombre=(select max(nombre) from empleados);

-- 23
select max(sal_emp), min(sal_emp), (max(sal_emp)-min(sal_emp)) as diferencia_max_min from empleados;

-- 24
select avg(sal_emp) as salario_promedio, id_depto from empleados group by id_depto;

-- 25
select id_depto, count(*) as numero_emp from empleados group by id_depto having count(*)>3;

-- 26
select d.id_depto from departamentos d left join empleados e on d.id_depto = e.id_depto where e.id_depto is null;

-- 27
select * from empleados where sal_emp>=(select avg(sal_emp) from empleados) order by id_depto asc;