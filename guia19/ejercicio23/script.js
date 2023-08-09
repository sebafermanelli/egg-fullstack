const texto = document.getElementById("texto");
const palabras = texto.innerHTML.split(" ");
var texto2 = "";
palabras.forEach((palabra) => {
    if (palabra.length > 8) {
        palabra = `<span class="subrayado">${palabra}</span> `;
        texto2 += palabra;
    } else {
        texto2 += `${palabra} `;
    }
});

texto.innerHTML = texto2;
