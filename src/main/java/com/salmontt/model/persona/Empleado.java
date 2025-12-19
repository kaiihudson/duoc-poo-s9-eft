package com.salmontt.model.persona;

import com.salmontt.model.common.RegistroContable;

import java.util.UUID;

public class Empleado extends Persona {
    private final UUID idEmpleado;
    private String fechaContratacion;
    private int sueldo;

    public Empleado() {
        this.idEmpleado = UUID.randomUUID();
    }

    public Empleado(Direccion direccion, Rut rut, String nombre, String apellido, String fechaContratacion, int sueldo) {
        super(direccion, rut, nombre, apellido);
        this.idEmpleado = UUID.randomUUID();
        this.fechaContratacion = fechaContratacion;
        this.sueldo = sueldo;
    }

    public UUID getIdEmpleado() {
        return idEmpleado;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String showContableData() {
        return getApellido() + "," + getNombre() + ". " + fechaContratacion + ". Sueldo: " + sueldo;
    }
}
