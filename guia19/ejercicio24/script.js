const circleForm = document.getElementById("circleForm");
const diameter = document.getElementById("diameter");
const calculateButton = document.getElementById("calculateButton");
const result = document.getElementById("result");

calculateButton.addEventListener("click", () => {
    const diameterValue = parseFloat(diameter.value);

    if (!isNaN(diameterValue)) {
        const radio = diameterValue / 2;

        result.innerHTML = `El radio del círculo es: ${radio.toFixed(2)}`;
    } else {
        result.innerHTML = "Ingrese un valor valido del diametro";
    }
});
