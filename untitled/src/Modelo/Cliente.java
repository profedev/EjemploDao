package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nombre;
    private List<Pedido> pedidos;

    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.pedidos = new ArrayList<>();
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
