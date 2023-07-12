package guia15.ejercicio2.service;

import guia15.ejercicio2.dao.*;
import guia15.ejercicio2.entity.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Map;

public class ConsultasService {

    private final CasaDAO casasDao = new CasaDAO();
    private final ClienteDAO clientesDao = new ClienteDAO();
    private final ComentarioDAO comentariosDao = new ComentarioDAO();
    private final EstanciaDAO estanciasDao = new EstanciaDAO();
    private final FamiliaDAO familiasDao = new FamiliaDAO();

    public void ejecutarConsultasEjercicio() {
        System.out.println("Enunciado A:");
        Collection<Familia> familiasA = familiasDao.enunciadoA(3, 10);
        for (Familia f : familiasA) {
            System.out.println(f.getNombre() + " - " + f.getNum_hijos() + " - " + f.getEdad_maxima());
        }

        System.out.println();

        System.out.println("Enunciado B:");
        String fechaDesde = "2020-08-01";
        String fechaHasta = "2020-08-31";
        Date fechaDesdeDate = Date.valueOf(fechaDesde);
        Date fechaHastaDate = Date.valueOf(fechaHasta);
        Collection<Casa> casasB = casasDao.enunciadoB(fechaDesdeDate, fechaHastaDate, "Reino Unido");
        for (Casa c : casasB) {
            System.out.println(c.getId() + " - " + c.getFecha_desde() + " - " + c.getFecha_hasta());
        }

        System.out.println();

        System.out.println("Enunciado C:");
        Collection<Familia> familiasC = familiasDao.enunciadoC("hotmail");
        for (Familia f : familiasC) {
            System.out.println(f.getNombre() + " - " + f.getEmail());
        }

        System.out.println();

        System.out.println("Enunciado D:");
        String fechaDesde2 = "2020-08-01";
        Date fechaDesdeDate2 = Date.valueOf(fechaDesde2);
        Collection<Casa> casasD = casasDao.enunciadoD(fechaDesdeDate, 160);
        for (Casa c : casasD) {
            System.out.println(c.getId() + " - " + c.getFecha_desde() + " - " + c.getFecha_hasta());
        }

        System.out.println();

        System.out.println("Enunciado E:");
        Collection<Estancia> estanciasE = estanciasDao.enunciadoE();
        for (Estancia e : estanciasE) {
            System.out.println(e.getId() + " - " + e.getCliente());
            System.out.println(e.getCasa());
            System.out.println();
        }

        System.out.println();

        System.out.println("Enunciado F:");
        Cliente c = clientesDao.obtenerClientePorId(5);
        Collection<Estancia> estanciasF = estanciasDao.enunciadoF(c);
        for (Estancia e : estanciasF) {
            System.out.println(e.getId() + " - " + e.getCliente());
            System.out.println(e.getCasa());
            System.out.println();
        }

        System.out.println();

        System.out.println("Enunciado G:");
        casasDao.enunciadoG(5, "Reino Unido");
        for (Casa c1 : casasDao.obtenerTodasLasCasas()) {
            System.out.println(c1.getPrecio_habitacion());
        }

        System.out.println();

        System.out.println("Enunciado H:");
        for (Map.Entry<String, Integer> cantCasasPorPais : casasDao.enunciadoH().entrySet()) {
            System.out.println(cantCasasPorPais.getKey() + " - " + cantCasasPorPais.getValue());
        }

        System.out.println();

        System.out.println("Enunciado I:");
        for (Comentario comentario : comentariosDao.enunciadoI("Reino Unido")) {
            System.out.println(comentario.getCasa().getPais() + " - " + comentario.getComentario());
        }

        System.out.println();

        System.out.println("Enunciado J:");
        Cliente cliente = clientesDao.obtenerClientePorId(1);
        Casa casa = casasDao.obtenerCasaPorId(4);
        Date desde = Date.valueOf("2020-08-10");
        Date hasta = Date.valueOf("2020-10-13");

        boolean disponible = casasDao.enunciadoJ(desde, hasta, casa);
        if (disponible) {
            Estancia nuevaEstancia = new Estancia(cliente, casa, cliente.getNombre(), desde, hasta);
            estanciasDao.insertEstancia(nuevaEstancia);
            System.out.println(nuevaEstancia);
            estanciasDao.deleteEstancia(nuevaEstancia);
        } else {
            System.out.println("La estancia no se pudo registrar correctamente");
        }
    }
}
