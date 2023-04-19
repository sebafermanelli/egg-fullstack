package guia5.extras;

public class ejercicio3 {

    public static void main(String[] args) {
        int[] enterosAleatorios = new int[5];

        GenerarVector(enterosAleatorios);

        MostrarVector(enterosAleatorios);
    }

    public static void GenerarVector(int[] enterosAleatorios) {
        for (int i = 0; i < enterosAleatorios.length; i++) {
            enterosAleatorios[i] = (int)(Math.random() * 10);
        }
    }

    public static void MostrarVector(int[] enterosAleatorios) {
        for (int i = 0; i < enterosAleatorios.length; i++) {
            if (i == (enterosAleatorios.length-1)) {
                System.out.print(enterosAleatorios[i]);
            }
            else {
                System.out.print(enterosAleatorios[i] + " - ");
            }
        }
    }
}
