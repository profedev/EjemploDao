/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.profedev.DaoJPA.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase gestor de la conexión a la base de datos.
 * Esta clase se encarga de gestionar la instancia del EntityManager y las transacciones
 * necesarias para interactuar con la base de datos utilizando JPA.
 * 
 * Proporciona métodos estáticos para obtener un EntityManager, 
 * iniciar y finalizar transacciones, y cerrar la conexión con la base de datos.
 * 
 * Uso:
 * - Llamar a {@code DBService.getEntityManager()} para obtener una instancia de EntityManager.
 * - Usar {@code DBService.beginTransaction()} para iniciar una transacción.
 * - Usar {@code DBService.commitTransaction()} para confirmar la transacción.
 * - Llamar a {@code DBService.closeConnection()} para liberar los recursos al finalizar.
 * 
 * Nota:
 * Asegúrate de cerrar siempre la conexión cuando termines para evitar fugas de recursos.
 * 
 * @author faguirre
 */
public class DBService {

    // Factory que crea y administra las instancias de EntityManager.
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pedidos_pu");

    // Instancia compartida de EntityManager.
    private static EntityManager em = emf.createEntityManager();

    /**
     * Proporciona la instancia de EntityManager para realizar operaciones de persistencia.
     * @return la instancia de EntityManager.
     */
    public static EntityManager getEntityManager() {
        return em;
    }

    /**
     * Inicia una transacción en la base de datos.
     * Debe ser llamada antes de realizar cualquier operación que modifique el estado
     * de la base de datos (como INSERT, UPDATE o DELETE).
     */
    public static void beginTransaction() {
        em.getTransaction().begin();
    }

    /**
     * Confirma la transacción actual.
     * Debe ser llamada después de completar las operaciones en la base de datos
     * para guardar los cambios.
     */
    public static void commitTransaction() {
        em.getTransaction().commit();
    }

    /**
     * Cierra el EntityManager y el EntityManagerFactory.
     * Debe ser llamado al final de la ejecución para liberar los recursos
     * asociados con la conexión a la base de datos.
     */
    public static void closeConnection() {
        em.close();
        emf.close();
    }
}
