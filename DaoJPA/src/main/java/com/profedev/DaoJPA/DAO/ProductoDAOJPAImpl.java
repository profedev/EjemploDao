package com.profedev.DaoJPA.DAO;

import com.profedev.DaoJPA.Modelo.Producto;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Implementación de la interfaz ProductoDAO utilizando JPA.
 * Esta clase proporciona métodos para realizar operaciones relacionadas con la entidad Producto.
 * 
 * Utiliza un EntityManager proporcionado por DBService para gestionar las operaciones de persistencia.
 * 
 * @see ProductoDAO
 * @see DBService
 */
public class ProductoDAOJPAImpl implements ProductoDAO {

    // Instancia del EntityManager utilizada para interactuar con la base de datos.
    @PersistenceContext
    private EntityManager entityManager = DBService.getEntityManager();

    /**
     * Agrega un nuevo producto a la base de datos.
     * @param producto El producto que se desea agregar.
     */
    @Override
    public void agregarProducto(Producto producto) {
        entityManager.persist(producto);
    }

    /**
     * Obtiene todos los productos almacenados en la base de datos.
     * @return Una lista de todos los productos.
     */
    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return entityManager.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
    }
}
