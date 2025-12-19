package com.salmontt.model.persona;

import java.util.UUID;

public class Proveedor extends Persona {
    private final UUID id;
    private String compania;
    private String fechaContratacion;
    private int UFContrato;

    public Proveedor() {
        this.id = UUID.randomUUID();
    }

    public Proveedor(Direccion direccion, Rut rut, String nombre, String apellido, String compania, String fechaContratacion, int UFContrato) {
        super(direccion, rut, nombre, apellido);
        this.id = UUID.randomUUID();
        this.compania = compania;
        this.fechaContratacion = fechaContratacion;
        this.UFContrato = UFContrato;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public void setUFContrato(int UFContrato) {
        this.UFContrato = UFContrato;
    }

    @Override
    public String showContableData() {
        return compania + " - " + getRut() + " - " + fechaContratacion + ", " + UFContrato;
    }
}
