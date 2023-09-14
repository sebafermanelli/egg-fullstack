package guia09.ejercicio6;

import guia09.ejercicio6.entities.Curso;
import guia09.ejercicio6.services.CursoService;

public class Core {
    public static void main(String[] args) {
        Curso A = CursoService.crearCurso();

        System.out.println("La ganancia semanal de " + A.getNombreCurso() + " es de $" + CursoService.calcularGananciaSemanal(A));
    }
}
