package guia11.extras.ejercicio4.model;

import java.util.HashSet;

public class Voto {
    private Alumno alumno;
    private HashSet<Alumno> alumnoList;

    public Voto() {
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public HashSet<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(HashSet<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    @Override
    public String toString() {
        return "Voto{" +
                "alumno=" + alumno +
                ", alumnoList=" + alumnoList +
                '}';
    }
}
