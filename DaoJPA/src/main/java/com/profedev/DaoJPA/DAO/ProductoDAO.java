package com.profedev.DaoJPA.DAO;

import com.profedev.DaoJPA.Modelo.Producto;
import java.util.List;

public interface ProductoDAO {
    void agregarProducto(Producto producto);
    List<Producto> obtenerTodosLosProductos();
}
