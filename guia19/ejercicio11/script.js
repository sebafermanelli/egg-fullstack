const obtenerPalabraMasLarga = (frase) => {
    const palabras = frase.split(" ");
    const palabraMasLarga = palabras.reduce(
        (palabraActual, palabraSiguiente) => {
            return palabraSiguiente.length > palabraActual.length
                ? palabraSiguiente
                : palabraActual;
        },
        ""
    );

    return palabraMasLarga;
};

const frase = prompt("Ingrese una frase");

console.log(`La palabra mas larga es ${obtenerPalabraMasLarga(frase)}`);
