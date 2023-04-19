package guia7.ejercicio3;

public class Core {
    
    public static void main(String[] args) {
        Operacion operacion1 = new Operacion();

        operacion1.crearOperacion();

        System.out.println("La suma es: " + operacion1.sumar());
        System.out.println("La resta es: " + operacion1.restar());
        System.out.println("La multiplicacion es: " + operacion1.multiplicar());
        System.out.println("La division es: " + operacion1.dividir());
    }
}