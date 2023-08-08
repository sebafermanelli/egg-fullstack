var numeros = [];
var num;

do {
    num = prompt("Ingrese un numero");
    if (num != 0) {
        numeros.push(num);
    }
} while (num != 0);

console.log(`Cantidad de numeros: ${numeros.length}`);
console.log(`El mayor es: ${Math.max(...numeros)}`);
console.log(`El menor es: ${Math.min(...numeros)}`);
