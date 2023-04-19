package guia5;

public class ejercicio4 {

    public static void main(String[] args) {
        int[][] matriz = new int[4][4];

        System.out.println("Matriz:");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = (int)(Math.random() * 10);
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Matriz traspuesta:");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[j][i] + " ");
            }
            System.out.println();
        }
    }
}