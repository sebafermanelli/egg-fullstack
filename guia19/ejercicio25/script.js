const form = document.getElementById("form");
const nombre = document.getElementById("nombre");
const apellido = document.getElementById("apellido");

function getFormValores() {
    event.preventDefault();

    const persona = {
        nombre: "",
        apellido: "",
    }
    persona.nombre = nombre.value;
    persona.apellido = apellido.value;

    console.log(persona);

    return false;
}