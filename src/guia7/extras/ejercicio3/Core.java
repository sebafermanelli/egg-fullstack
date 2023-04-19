package guia7.extras.ejercicio3;

public class Core {

    public static void main(String[] args) {
        Juego juego1 = new Juego();

        juego1.cargar_jugadores();
        juego1.iniciar_juego();
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}