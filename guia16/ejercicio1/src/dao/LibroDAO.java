package dao;

import entity.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class LibroDAO {
    private EntityManager entityManager;

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

    public List<Libro> obtenerLibrosDisponibles() {
        TypedQuery<Libro> query = entityManager.createQuery("SELECT l FROM Libro l WHERE l.alta = true AND NOT(l" +
                        ".ejemplares_restantes=0)",
                Libro.class);
        return query.getResultList();
    }
}
