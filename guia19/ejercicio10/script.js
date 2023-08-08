const fraseAlReves = (frase) => {
    return frase.split("").reverse().join("");
};

const frase = prompt("Ingrese una frase");

console.log(`${fraseAlReves(frase)}`);
