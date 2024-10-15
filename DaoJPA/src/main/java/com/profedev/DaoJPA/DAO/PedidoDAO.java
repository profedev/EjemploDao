package com.profedev.DaoJPA.DAO;

import com.profedev.DaoJPA.Modelo.Pedido;
import java.util.List;

public interface PedidoDAO {
    void agregarPedido(Pedido pedido);
    List<Pedido> obtenerPedidosPorCliente(int clienteId);
}
