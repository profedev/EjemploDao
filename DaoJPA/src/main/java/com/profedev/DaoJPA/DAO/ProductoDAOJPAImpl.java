package com.profedev.DaoJPA.DAO;

import com.profedev.DaoJPA.Modelo.Producto;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ProductoDAOJPAImpl implements ProductoDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public void agregarProducto(Producto producto) {
        entityManager.persist(producto);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return entityManager.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
    }
}
