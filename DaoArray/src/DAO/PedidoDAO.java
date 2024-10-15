package DAO;

import Modelo.Pedido;

import java.util.List;

public interface PedidoDAO {
    void agregarPedido(Pedido pedido);
    List<Pedido> obtenerPedidosPorCliente(int clienteId);
}
