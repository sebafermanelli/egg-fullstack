package guia7.extras.ejercicio5;

import java.util.Scanner;

public class Core {
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Empleado emp = new Empleado();
        System.out.println("Ingrese el nombre del empleado:");
        emp.setNombre(leer.nextLine());
        System.out.println("Ingrese la edad del empleado:");
        emp.setEdad(leer.nextInt());
        System.out.println("Ingrese el salario del empleado:");
        emp.setSalario(leer.nextDouble());

        System.out.println();
        emp.calcular_aumento();
        System.out.println("El salario con aumento es: " + emp.getSalario());
    }
}
