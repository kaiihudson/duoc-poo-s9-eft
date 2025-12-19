package com.salmontt.model.OC;

import com.salmontt.model.persona.Tarjeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrdenCompra {
    private UUID id;
    private Tarjeta tarjeta;
    private List<Producto> productos = new ArrayList<>();

    public OrdenCompra(Tarjeta tarjeta, List<Producto> productos) {
        this.id = UUID.randomUUID();
        this.tarjeta = tarjeta;
        this.productos = productos;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        return
                id + "\n" +
                "tarjeta=" + tarjeta.getNumeroTarjeta() + ", " +
                        tarjeta.getPersona().getNombre() + " " +  tarjeta.getPersona().getApellido() + "\n" +
                "productos=" + productos +
                '}';
    }
}
