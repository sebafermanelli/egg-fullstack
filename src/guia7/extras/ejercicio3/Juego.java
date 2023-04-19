package guia7.extras.ejercicio3;

import java.util.Scanner;

public class Juego {

    private String jugador1;
    private String jugador2;
    private int numero;
    private int intentos;
    private int prueba;
    private int ganaJ1;
    private int ganaJ2;
    private boolean ganar;
    Scanner leer = new Scanner(System.in);

    Juego() {
    }

    Juego(String jugador1, String jugador2, int numero, int intentos) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.numero = numero;
        this.intentos = intentos;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPrueba(int prueba) {
        this.prueba = prueba;
    }

    public void setGanaJ1(int ganaJ1) {
        this.ganaJ1 = ganaJ1;
    }

    public void setGanaJ2(int ganaJ2) {
        this.ganaJ2 = ganaJ2;
    }

    public void setGanar(boolean ganar) {
        this.ganar = ganar;
    }

    public String getJugador1() {
        return jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public int getIntentos() {
        return intentos;
    }

    public int getNumero() {
        return numero;
    }

    public boolean getGanar() {
        return ganar;
    }

    public int getPrueba() {
        return prueba;
    }

    public int getGanaJ1() {
        return ganaJ1;
    }

    public int getGanaJ2() {
        return ganaJ2;
    }

    public void cargar_jugadores() {
        System.out.print("Escribe el nombre del jugador 1:");
        this.setJugador1(leer.nextLine());

        System.out.print("Escribe el nombre del jugador 2:");
        this.setJugador2(leer.nextLine());
    }

    public void iniciar_juego() {
        boolean cambioTurno = true;
        String seguir;
        int contIntentos;

        this.setIntentos(3);
        do {
            Core.clearScreen();

            if (cambioTurno) {
                cambioTurno = false;
                System.out.println(this.getJugador1() + " elige un numero para que " + this.getJugador2() + " adivine:");
                this.setNumero(leer.nextInt());

                Core.clearScreen();
                contIntentos = 0;
                this.setGanar(false);

                do {
                    contIntentos++;
                    System.out.print("Prueba suerte: ");
                    this.setPrueba(leer.nextInt());
                    if (this.getPrueba() < this.getNumero()) {
                        System.out.println("El numero es mas alto");
                    }
                    else if (this.getPrueba() > this.getNumero()) {
                        System.out.println("El numero es mas bajo");
                    }
                    else {
                        this.setGanar(true);
                    }
                } while (!this.getGanar() && contIntentos < this.getIntentos());

                if (this.getGanar()) {
                    this.setGanaJ2(this.getGanaJ2() + 1);
                }
                else {
                    this.setGanaJ1(this.getGanaJ1() + 1);
                }
            }
            else {
                cambioTurno = true;
                System.out.println(this.getJugador2() + " elige un numero para que " + this.getJugador1() + " adivine:");
                this.setNumero(leer.nextInt());

                Core.clearScreen();
                contIntentos = 0;
                this.setGanar(false);

                do {
                    contIntentos++;
                    System.out.print("Prueba suerte: ");
                    this.setPrueba(leer.nextInt());
                    if (this.getPrueba() < this.getNumero()) {
                        System.out.println("El numero es mas alto");
                    }
                    else if (this.getPrueba() > this.getNumero()) {
                        System.out.println("El numero es mas bajo");
                    }
                    else {
                        this.setGanar(true);
                    }
                } while (!this.getGanar() && contIntentos < this.getIntentos());

                if (this.getGanar()) {
                    this.setGanaJ1(this.getGanaJ1() + 1);
                }
                else {
                    this.setGanaJ2(this.getGanaJ2() + 1);
                }
            }

            Core.clearScreen();

            if (this.getGanar()) {
                System.out.println("Acertaste!");
            }
            else {
                System.out.println("Perdiste!");
            }

            if ((this.getGanaJ1() != 3) && (this.getGanaJ2() != 3)) {
                System.out.println("El jugador " + this.getJugador1() + " gano: " + this.getGanaJ1());
                System.out.println("El jugador " + this.getJugador2() + " gano: " + this.getGanaJ2());

                System.out.println();
                System.out.println("¿Queres jugar de nuevo? (S/N)");
                do {
                    seguir = leer.nextLine().toUpperCase();
                } while (!seguir.equals("S") && !seguir.equals("N"));
            }
            else {
                seguir = "N";
            }
        } while (seguir.equals("S") && (this.ganaJ1 != 3) && (this.ganaJ2 != 3));

        if (this.getGanaJ1() > this.getGanaJ2()) {
            System.out.println(this.getJugador1() + " gano contra " + this.getJugador2() + " " +  this.getGanaJ1() + " rondas");
        }
        else if (this.getGanaJ2() > this.getGanaJ1()) {
            System.out.println(this.getJugador2() + " gano contra " + this.getJugador1() + " " + this.getGanaJ2() + " rondas");
        }
        else {
            System.out.println("Empate");
        }
    }
}