package guia7.ejercicio4;

public class Core {
    
    public static void main(String[] args) {
        Rectangulo rect = new Rectangulo();

        rect.crearRectangulo();

        System.out.println("La superficie es: " + rect.superficie());
        System.out.println("El perimetro es: " + rect.perimetro());

        System.out.println();

        rect.crearRectanguloAsteriscos();
    }
}
