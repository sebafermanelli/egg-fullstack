package guia13.ejercicio2;

public class Main {
    public static void main(String[] args) {
        int[] posiciones = new int[3];

        try {
            for (int i = 0; i < 4; i++) {
                posiciones[i] = i*5;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Fuera de rango");
            System.out.println(e.toString());
        }

        for (int i = 0; i < posiciones.length; i++) {
            if (i != posiciones.length - 1) {
                System.out.print(posiciones[i] + ", ");
            } else {
                System.out.print(posiciones[i]);
            }
        }
    }
}
