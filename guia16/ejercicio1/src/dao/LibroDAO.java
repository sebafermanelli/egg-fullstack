package dao;

import entity.Autor;
import entity.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class LibroDAO {
    private final EntityManager entityManager;

    public LibroDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Libro entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public void update(Libro entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(Libro entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public Libro getOne(long id) {
        return entityManager.find(Libro.class, id);
    }

    public List<Libro> getAll() {
        TypedQuery<Libro> query = entityManager.createQuery("SELECT l FROM Libro l", Libro.class);
        return query.getResultList();
    }

    public List<Libro> obtenerLibroPorTitulo(String titulo) {
        TypedQuery<Libro> query = entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE ?1",
                Libro.class);
        query.setParameter(1, "%"+ titulo +"%");
        return query.getResultList();
    }

    public List<Libro> obtenerLibroPorNombreAutor(String nombreAutor) {
        TypedQuery<Libro> query = entityManager.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre = ?1",
                Libro.class);
        query.setParameter(1, nombreAutor);
        return query.getResultList();
    }

    public List<Libro> obtenerLibroPorNombreEditorial(String nombreEditorial) {
        TypedQuery<Libro> query = entityManager.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre = ?1",
                Libro.class);
        query.setParameter(1, nombreEditorial);
        return query.getResultList();
    }
}
