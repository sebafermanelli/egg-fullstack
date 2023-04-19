package guia3.extras;

import java.util.Scanner;

public class ejercicio12 {

    public static void main(String[] args) {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    String str = String.format("%d-%d-%d", i, j, k);

                    if (str.contains("3")) {
                        str = str.replace("3", "E");
                    }
                    System.out.println(str);
                }
            }
        }
    }
}