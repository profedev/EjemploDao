package com.profedev.DaoJPA.DAO;

import com.profedev.DaoJPA.Modelo.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteDAO {
    void agregarCliente(Cliente cliente);
    Optional<Cliente> obtenerClientePorId(int id);
    List<Cliente> obtenerTodosLosClientes();
    Cliente obtenerClienteByEmail(String email);
    void actualizarCliente(Cliente cliente);
    void eliminarCliente(Cliente cliente);  
    boolean autenticarUsuario(String email, String password);
}
