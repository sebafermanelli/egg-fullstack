function obtenerFraseConEspacios(frase) {
    return frase.split("").join(" ");
}

const frase = prompt("Ingrese una frase");

console.log(`${obtenerFraseConEspacios(frase)}`);
