package DAO;

import Modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteDAOImpl implements ClienteDAO {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Optional<Cliente> obtenerClientePorId(int id) {
        return clientes.stream().filter(cliente -> cliente.getId() == id).findFirst();
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        return new ArrayList<>(clientes);
    }
}