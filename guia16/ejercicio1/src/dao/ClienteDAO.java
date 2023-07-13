package dao;

import entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ClienteDAO {
    private final EntityManager entityManager;

    public ClienteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Cliente entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public void update(Cliente entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(Cliente entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public Cliente getOneId(long id) {
        return entityManager.find(Cliente.class, id);
    }

    public List<Cliente> getAll() {
        TypedQuery<Cliente> query = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class);
        return query.getResultList();
    }
}
