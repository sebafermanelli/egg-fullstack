package guia12.extras.ejercicio1;

import guia12.extras.ejercicio1.model.Alquiler;
import guia12.extras.ejercicio1.model.Cliente;
import guia12.extras.ejercicio1.service.ServicioCliente;
import guia12.extras.ejercicio1.service.ServicioAlquiler;

public class Main {
    public static void main(String[] args) {
        ServicioCliente serviceCliente = new ServicioCliente();
        ServicioAlquiler serviceAlquiler = new ServicioAlquiler();

        Cliente cliente = serviceCliente.crearCliente();
        Alquiler alquiler = serviceAlquiler.crearAlquiler(cliente);
        System.out.println(alquiler.toString());
        System.out.println(serviceAlquiler.calcularAlquiler(alquiler));
    }
}
