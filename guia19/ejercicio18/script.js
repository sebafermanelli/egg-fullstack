var valores = [true, 5, false, "hola", "adios", 2];

//a
var texto1 = valores[3];
var texto2 = valores[4];

var comparacion = texto1.localeCompare(texto2);

if (comparacion < 0) {
    console.log(`${texto1} es mayor que ${texto2}`);
} else if (comparacion > 0) {
    console.log(`${texto2} es mayor que ${texto1}`);
} else {
    console.log(`${texto1} y ${texto2} son iguales`);
}

//b
var booleano1 = valores[0];
var booleano2 = valores[2];

var resultadoTrue = booleano1 || booleano2;
var resultadoFalse = booleano1 && booleano2;

console.log(`Resultado True: ${resultadoTrue}`);
console.log(`Resultado False: ${resultadoFalse}`);

//c
var numero1 = valores[1];
var numero2 = valores[5];

var suma = numero1 + numero2;
var resta = numero1 - numero2;
var multiplicacion = numero1 * numero2;
var division = numero1 / numero2;
var modulo = numero1 % numero2;

console.log(`Suma: ${suma}`);
console.log(`Resta: ${resta}`);
console.log(`Multiplicación: ${multiplicacion}`);
console.log(`División: ${division}`);
console.log(`Modulo: ${modulo}`);