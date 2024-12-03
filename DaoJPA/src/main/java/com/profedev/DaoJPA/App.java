package com.profedev.DaoJPA;

import com.profedev.DaoJPA.DAO.*;
import com.profedev.DaoJPA.Modelo.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {
    public static void main(String[] args) {
     
        ClienteDAOJPAImpl cliented = new ClienteDAOJPAImpl();
        PedidoDAOJPAImpl pedidod = new PedidoDAOJPAImpl();
        ProductoDAOJPAImpl productod = new ProductoDAOJPAImpl();
        
        DBService.beginTransaction();

        // Crear clientes
        Cliente cliente1 = new Cliente("Juan Perez","jperez@contoso.com","password1");
        Cliente cliente2 = new Cliente("Maria Lopez","mlopez@contoso.com","password2");
        cliented.agregarCliente(cliente1);
        cliented.agregarCliente(cliente2);     
        
        System.out.println(cliented.obtenerClienteByEmail("jperez@contoso.com").password);
        System.out.println(cliented.autenticarUsuario("mlopez@contoso.com","iii"));
              
        // Crear productos
        Producto producto1 = new Producto("Laptop", 1500.0);
        Producto producto2 = new Producto("Mouse", 25.0);
        productod.agregarProducto(producto1);
        productod.agregarProducto(producto2);

        // Crear pedidos
        Pedido pedido1 = new Pedido(cliente1);
        pedido1.setProductos(List.of(producto1, producto2));
        pedidod.agregarPedido(pedido1);

        DBService.commitTransaction();

        // Mostrar pedidos de un cliente
        List<Pedido> pedidosCliente1 = pedidod.obtenerPedidosPorCliente(cliente1.getId());
        System.out.println("Pedidos del cliente " + cliente1.getNombre() + ":");
        for (Pedido pedido : pedidosCliente1) {
            System.out.println("Pedido ID: " + pedido.getId());
            for (Producto producto : pedido.getProductos()) {
                System.out.println("\tProducto: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
            }
        }
        
        DBService.closeConnection();
      
    }
}
