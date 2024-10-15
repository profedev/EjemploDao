package com.profedev.DaoJPA.DAO;

import com.profedev.DaoJPA.Modelo.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteDAO {
    void agregarCliente(Cliente cliente);
    Optional<Cliente> obtenerClientePorId(int id);
    List<Cliente> obtenerTodosLosClientes();
}
