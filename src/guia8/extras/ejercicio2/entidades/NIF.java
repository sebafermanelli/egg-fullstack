package guia8.extras.ejercicio2.entidades;

public class NIF {
    long dni;
    char letra;

    public NIF() {}

    public NIF(long dni, char letra) {
        this.dni = dni;
        this.letra = letra;
    }

    public long getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }

    public char getLetra() {
        return letra;
    }
    public void setLetra(char letra) {
        this.letra = letra;
    }

    public String getNIF() {
        return (dni + "-" + letra);
    }

    @Override
    public String toString() {
        return "NIF{" + "dni=" + dni + ", letra=" + letra + '}';
    }
}
