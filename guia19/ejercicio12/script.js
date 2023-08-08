const tipoDato = (dato) => {
    return typeof dato;
};

const dato = prompt("Ingrese un dato");

console.log(`El tipo de dato es ${tipoDato(dato)}`);
