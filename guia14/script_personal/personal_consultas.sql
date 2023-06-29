-- 1
SELECT * FROM empleados;

-- 2
SELECT * FROM departamentos;

-- 3
SELECT nombre_depto FROM departamentos;

-- 4
SELECT nombre, sal_emp FROM empleados;

-- 5
SELECT comision_emp FROM empleados;

-- 6
SELECT * FROM empleados WHERE cargo_emp='Secretaria';

-- 7
SELECT * FROM empleados WHERE cargo_emp='Vendedor' ORDER BY nombre ASC;

-- 8
SELECT nombre, cargo_emp FROM empleados ORDER BY sal_emp;

-- 9
SELECT nombre_jefe_depto FROM departamentos WHERE ciudad='Ciudad Real';

-- 10
SELECT nombre AS Nombre, cargo_emp AS Cargo FROM empleados;

-- 11
SELECT sal_emp, comision_emp FROM empleados WHERE id_depto=2000 ORDER BY comision_emp ASC;

-- 12
SELECT nombre, (sal_emp + comision_emp + 500) AS total_pagar FROM empleados WHERE id_depto=3000 ORDER BY nombre ASC;

-- 13
SELECT * FROM empleados WHERE nombre LIKE 'J%';

-- 14
SELECT sal_emp, comision_emp, (sal_emp + comision_emp) AS salario_total, nombre FROM empleados WHERE comision_emp>1000;

-- 15
SELECT sal_emp, comision_emp, (sal_emp + comision_emp) AS salario_total, nombre FROM empleados WHERE comision_emp=0;

-- 16
SELECT * FROM empleados WHERE comision_emp>sal_emp;

-- 17
SELECT * FROM empleados WHERE comision_emp<=(sal_emp*0.3);

-- 18
SELECT * FROM empleados WHERE nombre NOT LIKE '%MA%';

-- 19
SELECT nombre_depto FROM departamentos WHERE nombre_depto='Ventas' OR nombre_depto='Investigacion' OR nombre_depto='Mantenimiento';

-- 20
SELECT nombre_depto FROM departamentos WHERE nombre_depto!='Ventas' AND nombre_depto!='Investigacion' AND nombre_depto != 'Mantenimiento';

-- 21
SELECT * FROM empleados WHERE sal_emp=(SELECT MAX(sal_emp) FROM empleados);

-- 22
SELECT * FROM empleados WHERE nombre=(SELECT MAX(nombre) FROM empleados);

-- 23
SELECT MAX(sal_emp), MIN(sal_emp), (MAX(sal_emp)-MIN(sal_emp)) AS diferencia_max_min FROM empleados;

-- 24
SELECT AVG(sal_emp) AS salario_promedio, id_depto FROM empleados GROUP BY id_depto;

-- 25
SELECT id_depto, COUNT() AS numero_emp FROM empleados GROUP BY id_depto HAVING COUNT()>3;

-- 26
SELECT d.id_depto FROM departamentos d LEFT JOIN empleados e ON d.id_depto = e.id_depto WHERE e.id_depto IS NULL;

-- 27
SELECT * FROM empleados WHERE sal_emp>=(SELECT AVG(sal_emp) FROM empleados) ORDER BY id_depto ASC;