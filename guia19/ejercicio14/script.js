const libro = {
    ISBN: "",
    titulo: "",
    autor: "",
    numPaginas: 0,

    cargarLibro: function () {
        this.ISBN = prompt("Ingrese el numero de ISBN del libro");
        this.titulo = prompt("Ingrese el titulo del libro");
        this.autor = prompt("Ingrese el autor del libro");
        this.numPaginas = parseInt(
            prompt("Ingrese el numero de paginas del libro")
        );
    },

    mostrarInformacion: function () {
        console.log(`ISBN: ${this.ISBN}`);
        console.log(`Titulo: ${this.titulo}`);
        console.log(`Autor: ${this.autor}`);
        console.log(`Numero de paginas: ${this.numPaginas}`);
    },
};

libro.cargarLibro();

console.log("Información del libro:");
libro.mostrarInformacion();
