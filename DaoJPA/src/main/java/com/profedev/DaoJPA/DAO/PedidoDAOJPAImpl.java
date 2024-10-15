package com.profedev.DaoJPA.DAO;

import com.profedev.DaoJPA.Modelo.Pedido;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PedidoDAOJPAImpl implements PedidoDAO {
    @PersistenceContext
    private EntityManager entityManager;
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void agregarPedido(Pedido pedido) {
        entityManager.persist(pedido);
    }

    @Override
    public List<Pedido> obtenerPedidosPorCliente(int clienteId) {
        return entityManager.createQuery("SELECT p FROM Pedido p WHERE p.cliente.id = :clienteId", Pedido.class)
                .setParameter("clienteId", clienteId)
                .getResultList();
    }
}
