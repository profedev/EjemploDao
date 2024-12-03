package com.profedev.DaoJPA.Modelo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    public String email;
    public String password; 
    

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    // Constructor
    public Cliente(String nombre, String email, String password) {       
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }
    
    public Cliente(String nombre) {
        this.nombre = nombre;
    }
    
    // Constructor
    public Cliente() {}

    // Getters y Setters
    public int getId() {
        return id;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
