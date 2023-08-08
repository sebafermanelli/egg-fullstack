const estadoDia = "";

do {
    estadoDia = prompt("¿Como esta el dia de hoy?");
} while (
    estadoDia != "soleado" &&
    estadoDia != "nublado" &&
    estadoDia != "lloviendo"
);

console.log(`El dia de hoy esta ${estadoDia}`);
