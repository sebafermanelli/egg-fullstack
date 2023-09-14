package guia09.extras.ejercicio2.entities;

public class Ahorcado {
    private char[] palabra;
    private int cantLetrasEncontradas;
    private int cantJugadasMax;

    public Ahorcado() {
    }

    public Ahorcado(char[] palabra, int cantLetrasEncontradas, int cantJugadasMax) {
        this.palabra = palabra;
        this.cantLetrasEncontradas = cantLetrasEncontradas;
        this.cantJugadasMax = cantJugadasMax;
    }

    public char[] getPalabra() {
        return palabra;
    }

    public void setPalabra(char[] palabra) {
        this.palabra = palabra;
    }

    public int getCantLetrasEncontradas() {
        return cantLetrasEncontradas;
    }

    public void setCantLetrasEncontradas(int cantLetrasEncontradas) {
        this.cantLetrasEncontradas = cantLetrasEncontradas;
    }

    public int getCantJugadasMax() {
        return cantJugadasMax;
    }

    public void setCantJugadasMax(int cantJugadasMax) {
        this.cantJugadasMax = cantJugadasMax;
    }


}
