const rta = 0;
const op = prompt(
    `Ingrese:
S para sumar
R para restar
M para multiplicar
D para dividir`
);
const n1 = prompt("Ingrese el primer numero");
const n2 = prompt("Ingrese el segundo numero");

switch (op) {
    case "S":
        rta = parseInt(n1) + parseInt(n2);
        break;
    case "s":
        rta = parseInt(n1) + parseInt(n2);
        break;
    case "R":
        rta = parseInt(n1) - parseInt(n2);
        break;
    case "r":
        rta = parseInt(n1) - parseInt(n2);
        break;
    case "M":
        rta = parseInt(n1) * parseInt(n2);
        break;
    case "m":
        rta = parseInt(n1) * parseInt(n2);
        break;
    case "D":
        rta = parseInt(n1) / parseInt(n2);
        break;
    case "d":
        rta = parseInt(n1) / parseInt(n2);
        break;
    default:
        break;
}

console.log(`El resultado es: ${rta}`);
