package com.profedev.DaoJPA.DAO;

import com.profedev.DaoJPA.Modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOArrayImpl implements ProductoDAO {
    private List<Producto> productos = new ArrayList<>();

    @Override
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return new ArrayList<>(productos);
    }
}