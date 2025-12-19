package com.salmontt.model.OC;

import java.util.UUID;

public class Producto {
    private final UUID id;
    private String nombre;
    private int precio;

    public Producto() {
        this.id = UUID.randomUUID();
    }

    public Producto(String nombre, int precio) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre +
                ", precio='" + precio + '\'';
    }
}
