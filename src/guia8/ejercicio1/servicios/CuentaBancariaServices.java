package guia8.ejercicio1.servicios;

import guia8.ejercicio1.entidades.CuentaBancaria;

import java.util.Scanner;

public class CuentaBancariaServices {

    static Scanner scanner = new Scanner(System.in);

    public static CuentaBancaria crearCuentaBancaria() {
        System.out.print("Ingrese el número de cuenta: ");
        int numeroCuenta = scanner.nextInt();
        System.out.print("Ingrese el DNI del cliente: ");
        long dniCliente = scanner.nextLong();
        System.out.print("Ingrese el saldo actual: ");
        double saldoActual = scanner.nextDouble();
        return new CuentaBancaria(numeroCuenta, dniCliente, saldoActual);
    }

    public static void ingresarSaldo(CuentaBancaria cuenta, double cantidad) {
        cuenta.setSaldoActual(cuenta.getSaldoActual() + cantidad);
        System.out.println("Se ha ingresado $" + cantidad + " a la cuenta. Saldo actual: $" + cuenta.getSaldoActual());
    }

    public static void retirarSaldo(CuentaBancaria cuenta, double cantidad) {
        if (cantidad > cuenta.getSaldoActual()) {
            cantidad = cuenta.getSaldoActual();
        }
        cuenta.setSaldoActual(cuenta.getSaldoActual() - cantidad);
        System.out.println("Se ha retirado $" + cantidad + " a la cuenta. Saldo actual: $" + cuenta.getSaldoActual());
    }

    public static void extraccionRapida(CuentaBancaria cuenta, double cantidad) {
        if (cantidad > (cuenta.getSaldoActual() * 0.2)) {
            cantidad = (cuenta.getSaldoActual() * 0.2);
        }
        cuenta.setSaldoActual(cuenta.getSaldoActual() - cantidad);
        System.out.println("Se ha retirado $" + cantidad + " a la cuenta por extraccion rapida (max. 20% del saldo). Saldo actual: $" + cuenta.getSaldoActual());
    }

    public static void consultarSaldo(CuentaBancaria cuenta) {
        System.out.println("Saldo actual: $" + cuenta.getSaldoActual());
    }

    public static void consultarDatos(CuentaBancaria cuenta) {
        System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("DNI del cliente: " + cuenta.getDniCliente());
        System.out.println("Saldo actual: $" + cuenta.getSaldoActual());
    }
}
