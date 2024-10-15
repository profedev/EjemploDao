package DAO;

import Modelo.Producto;

import java.util.List;

public interface ProductoDAO {
    void agregarProducto(Producto producto);
    List<Producto> obtenerTodosLosProductos();
}
