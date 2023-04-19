package guia7.extras.ejercicio4;

public class Cuenta {

    private int saldo;
    private String titular;

    Cuenta() {
    }

    Cuenta(int saldo, String titular) {
        this.saldo = saldo;
        this.titular = titular;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void retirar_dinero(int retiro) {
        if (retiro <= this.saldo) {
            this.saldo -= retiro;
            System.out.println("Se ha realizado un retiro de la cuenta de " + this.titular);
            System.out.println("Monto retiro: $" + retiro);
            System.out.println("Saldo actual disponible: $" + this.saldo);
        }
        else {
            System.out.println("El monto que desea retirar no esta disponible en la cuenta de " + this.titular);
            System.out.println("Saldo actual disponible: $" + this.saldo);
        }
    }
}