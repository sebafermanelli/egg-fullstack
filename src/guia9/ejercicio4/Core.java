package guia9.ejercicio4;

import guia9.ejercicio4.services.FechaService;

import java.util.Date;

public class Core {
    public static void main(String[] args) {
        FechaService fs = new FechaService();

        Date nacimiento = fs.fechaNacimiento();
        Date actual = fs.fechaActual();

        System.out.println(fs.edad(nacimiento, actual));
    }
}
