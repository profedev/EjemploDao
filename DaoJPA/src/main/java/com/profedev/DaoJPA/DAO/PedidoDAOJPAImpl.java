package com.profedev.DaoJPA.DAO;

import com.profedev.DaoJPA.Modelo.Pedido;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Implementación de la interfaz PedidoDAO utilizando JPA.
 * Esta clase proporciona métodos para realizar operaciones relacionadas con la entidad Pedido.
 * 
 * Utiliza un EntityManager proporcionado por DBService para gestionar la persistencia.
 * 
 * @see PedidoDAO
 * @see DBService
 */
public class PedidoDAOJPAImpl implements PedidoDAO {

    // Instancia del EntityManager para realizar operaciones de la base de datos.
    @PersistenceContext
    private EntityManager entityManager = DBService.getEntityManager();

    /**
     * Agrega un nuevo pedido a la base de datos.
     * @param pedido El pedido que se desea agregar.
     */
    @Override
    public void agregarPedido(Pedido pedido) {
        entityManager.persist(pedido);
    }

    /**
     * Obtiene una lista de pedidos asociados con un cliente específico.
     * @param clienteId El ID del cliente cuyos pedidos se desean obtener.
     * @return Una lista de pedidos asociados con el cliente.
     */
    @Override
    public List<Pedido> obtenerPedidosPorCliente(int clienteId) {
        return entityManager.createQuery("SELECT p FROM Pedido p WHERE p.cliente.id = :clienteId", Pedido.class)
                            .setParameter("clienteId", clienteId)
                            .getResultList();
    }
}
