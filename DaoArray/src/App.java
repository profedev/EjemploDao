import DAO.*;
import Modelo.*;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAOImpl();
        PedidoDAO pedidoDAO = new PedidoDAOImpl();
        ProductoDAO productoDAO = new ProductoDAOImpl();

        // Crear clientes
        Cliente cliente1 = new Cliente(1, "Juan Perez");
        Cliente cliente2 = new Cliente(2, "Maria Lopez");
        clienteDAO.agregarCliente(cliente1);
        clienteDAO.agregarCliente(cliente2);

        // Crear productos
        Producto producto1 = new Producto(1, "Laptop", 1500.0);
        Producto producto2 = new Producto(2, "Mouse", 25.0);
        productoDAO.agregarProducto(producto1);
        productoDAO.agregarProducto(producto2);

        // Crear pedidos
        Pedido pedido1 = new Pedido(1, cliente1);
        pedido1.getProductos().add(producto1);
        pedido1.getProductos().add(producto2);
        pedidoDAO.agregarPedido(pedido1);

        // Mostrar pedidos de un cliente
        List<Pedido> pedidosCliente1 = pedidoDAO.obtenerPedidosPorCliente(cliente1.getId());
        System.out.println("Pedidos del cliente " + cliente1.getNombre() + ":");
        for (Pedido pedido : pedidosCliente1) {
            System.out.println("Pedido ID: " + pedido.getId());
            for (Producto producto : pedido.getProductos()) {
                System.out.println("\tProducto: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
            }
        }
    }
}
