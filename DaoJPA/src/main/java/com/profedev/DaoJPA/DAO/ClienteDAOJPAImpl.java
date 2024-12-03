package com.profedev.DaoJPA.DAO;

import com.profedev.DaoJPA.Modelo.Cliente;
import java.util.List;
import java.util.Optional;
import javax.persistence.*;

/**
 * Implementación de la interfaz ClienteDAO utilizando JPA.
 * Esta clase proporciona métodos para realizar operaciones CRUD sobre la entidad Cliente.
 * 
 * Utiliza un EntityManager proporcionado por DBService para manejar las operaciones de persistencia.
 * 
 * @see ClienteDAO
 * @see DBService
 */
public class ClienteDAOJPAImpl implements ClienteDAO {

    // Instancia del EntityManager para gestionar las operaciones de la base de datos.
    private EntityManager entityManager = DBService.getEntityManager();

    /**
     * Agrega un nuevo cliente a la base de datos.
     * @param cliente El cliente a persistir.
     */
    @Override
    public void agregarCliente(Cliente cliente) {
        entityManager.persist(cliente);
    }

    /**
     * Obtiene un cliente de la base de datos por su ID.
     * @param id El ID del cliente a buscar.
     * @return Un Optional que contiene el cliente si se encuentra, o está vacío si no.
     */
    @Override
    public Optional<Cliente> obtenerClientePorId(int id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        return Optional.ofNullable(cliente);
    }

    /**
     * Obtiene todos los clientes almacenados en la base de datos.
     * @return Una lista de clientes.
     */
    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    /**
     * Busca un cliente en la base de datos por su email.
     * @param email El email del cliente.
     * @return El cliente si se encuentra, o null si no existe.
     */
    @Override
    public Cliente obtenerClienteByEmail(String email) {
        try {
            return entityManager.createQuery("SELECT c FROM Cliente c WHERE c.email = :email", Cliente.class)
                                .setParameter("email", email)
                                .getSingleResult();
        } catch (NoResultException e) {
            return null; // Retorna null si no se encuentra un cliente con el email dado.
        }
    }

    /**
     * Actualiza los datos de un cliente existente en la base de datos.
     * @param cliente El cliente con los datos actualizados.
     */
    @Override
    public void actualizarCliente(Cliente cliente) {
        entityManager.merge(cliente);
    }

    /**
     * Elimina un cliente de la base de datos.
     * @param cliente El cliente a eliminar.
     */
    @Override
    public void eliminarCliente(Cliente cliente) {
        // Asegurarse de que el cliente esté administrado antes de eliminarlo.
        if (!entityManager.contains(cliente)) {
            cliente = entityManager.merge(cliente);
        }
        entityManager.remove(cliente);
    }

    /**
     * Verifica las credenciales de un usuario (email y contraseña).
     * @param email El email del cliente.
     * @param password La contraseña del cliente.
     * @return true si las credenciales son correctas, false en caso contrario.
     */
    @Override
    public boolean autenticarUsuario(String email, String password) {
        Cliente cliente = this.obtenerClienteByEmail(email);
        return cliente != null && cliente.getPassword().equals(password);
    }
}

