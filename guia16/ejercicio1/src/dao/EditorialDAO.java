package dao;

import entity.Autor;
import entity.Editorial;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EditorialDAO {
    private final EntityManager entityManager;

    public EditorialDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Editorial entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public void update(Editorial entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(Editorial entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public Editorial getOne(long id) {
        return entityManager.find(Editorial.class, id);
    }

    public List<Editorial> getAll() {
        TypedQuery<Editorial> query = entityManager.createQuery("SELECT e FROM Editorial e", Editorial.class);
        return query.getResultList();
    }
}
