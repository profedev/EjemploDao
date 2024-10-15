package DAO;

import Modelo.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoDAOImpl implements PedidoDAO {
    private List<Pedido> pedidos = new ArrayList<>();

    @Override
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
        pedido.getCliente().getPedidos().add(pedido);
    }

    @Override
    public List<Pedido> obtenerPedidosPorCliente(int clienteId) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().getId() == clienteId) {
                resultado.add(pedido);
            }
        }
        return resultado;
    }
}