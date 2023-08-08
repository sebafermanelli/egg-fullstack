var suma=0;

const limite = prompt("Ingrese el limite maximo de la suma");
do {
    let num = prompt(`Ingrese un numero a sumar a ${suma}`);
    suma += parseInt(num);
} while(suma <= limite);

console.log(`La suma de los numeros supero el limite de ${limite} con un valor de ${suma}`);