package guia11.extras.ejercicio4;

import guia11.extras.ejercicio4.model.Alumno;
import guia11.extras.ejercicio4.model.Voto;
import guia11.extras.ejercicio4.services.Simulador;

import java.util.List;

public class Core {
    public static void main(String[] args) {

        Simulador s = new Simulador();
        List<Alumno> alumnos = s.generarAlumnos();
        List<Voto> votos =  s.votacion(alumnos);

        s.mostrarAlumnos(alumnos);
        System.out.println();

        s.mostrarVotos(votos);
        System.out.println();

        System.out.println(s.recuentoVotos(alumnos) + " votos efectivos de " + alumnos.size()*3 + " votos totales");
        System.out.println();

        List<Alumno> facilitadores = s.getFacilitadores(alumnos);
        s.mostrarFacilitadores(facilitadores);
    }
}
