package com.salmontt.model.persona;

import com.salmontt.model.common.RegistroContable;

import java.util.UUID;

public class Cliente extends Persona {
    private final UUID idCliente;

    public Cliente() {
        super();
        this.idCliente = UUID.randomUUID();
    }

    public Cliente(Direccion direccion, Rut rut, String nombre, String apellido) {
        super(direccion, rut, nombre, apellido);
        this.idCliente = UUID.randomUUID();
    }

}
