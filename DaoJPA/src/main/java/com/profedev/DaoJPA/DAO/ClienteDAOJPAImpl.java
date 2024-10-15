package com.profedev.DaoJPA.DAO;

import com.profedev.DaoJPA.Modelo.Cliente;
import java.util.List;
import java.util.Optional;
import javax.persistence.*;

public class ClienteDAOJPAImpl implements ClienteDAO {
    private EntityManager entityManager;
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
   
    @Override
    public void agregarCliente(Cliente cliente) {
        entityManager.persist(cliente);
    }

    @Override
    public Optional<Cliente> obtenerClientePorId(int id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        return Optional.ofNullable(cliente);
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    /**
     * @param entityManager the entityManager to set
     */
    
}
