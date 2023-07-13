package dao;

import entity.Prestamo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PrestamoDAO {
    private final EntityManager entityManager;

    public PrestamoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Prestamo entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public void update(Prestamo entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(Prestamo entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public Prestamo getOneId(long id) {
        return entityManager.find(Prestamo.class, id);
    }

    public List<Prestamo> getAll() {
        TypedQuery<Prestamo> query = entityManager.createQuery("SELECT p FROM Prestamo p", Prestamo.class);
        return query.getResultList();
    }
}
