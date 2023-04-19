package guia8.ejercicio1;

import guia8.ejercicio1.entidades.CuentaBancaria;
import guia8.ejercicio1.servicios.CuentaBancariaServices;

public class Core {
    public static void main(String[] args) {
        CuentaBancaria cuenta = CuentaBancariaServices.crearCuentaBancaria();

        CuentaBancariaServices.ingresarSaldo(cuenta, 5000);
        CuentaBancariaServices.retirarSaldo(cuenta, 1000);
        CuentaBancariaServices.consultarSaldo(cuenta);
        CuentaBancariaServices.extraccionRapida(cuenta, 10000);
        CuentaBancariaServices.consultarDatos(cuenta);
    }
}
