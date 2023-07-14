package dao;

import entity.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AutorDAO {
    private EntityManager entityManager;

    public AutorDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Autor entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public void update(Autor entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(Autor entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public Autor getOne(long id) {
        return entityManager.find(Autor.class, id);
    }

    public List<Autor> getAll() {
        TypedQuery<Autor> query = entityManager.createQuery("SELECT a FROM Autor a", Autor.class);
        return query.getResultList();
    }
}
