package guia7.extras.ejercicio2;

public class Core {
    
    public static void main(String[] args) {
        Puntos p = new Puntos();

        System.out.println("Ingrese las coordenadas de los puntos:");
        p.crearPuntos();

        System.out.println("La distancia entre el punto P1(" + p.getX1() + "," + p.getY1() + ") y P2(" + p.getX2() + "," + p.getY2() + ") es: " + p.distancia());
    }
}