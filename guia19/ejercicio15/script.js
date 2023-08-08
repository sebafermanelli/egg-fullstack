class circulo {
    constructor(radio) {
        this.radio = radio;
    }

    calcularArea() {
        return Math.PI * Math.pow(this.radio, 2);
    }

    calcularPerimetro() {
        return 2 * Math.PI * this.radio;
    }
}

const radio = prompt("Ingrese el radio de la circunferencia:");

const circulo1 = new circulo(radio);

console.log(`El area es: ${circulo1.calcularArea()}`);

console.log(`El perimetro es: ${circulo1.calcularPerimetro()}`);
