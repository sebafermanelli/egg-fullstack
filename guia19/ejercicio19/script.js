var arregloA = [];
var arregloB = [];

for (let i = 0; i < 50; i++) {
    arregloA[i]= Math.round(Math.random() * 100);   
}

arregloA.sort((a, b) => {return a - b});

arregloB = arregloA.slice(0, 10);

for (let i = 10; i < 20; i++) {
    arregloB[i] = 0.5;
}

console.log(arregloA);
console.log(arregloB);