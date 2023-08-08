let n = prompt("Ingrese un numero");

if (n == 0) {
    console.log("El numero no es par ni impar");
} else {
    if (parseInt(n) % 2 === 0) {
        console.log("El numero es par");
    } else {
        console.log("El numero es impar");
    }
}
