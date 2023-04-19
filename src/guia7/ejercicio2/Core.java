package guia7.ejercicio2;

public class Core {

    public static void main(String[] args) {
        Circunferencia c = new Circunferencia();

        c.crearCircunferencia();

        System.out.println("El area es: " + c.area());
        System.out.println("El perimetro es: " + c.perimetro());
    }
}