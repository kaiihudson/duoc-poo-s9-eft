package com.salmontt.model.persona;

import com.salmontt.model.common.RegistroContable;

public abstract class Persona implements RegistroContable {
    private Direccion direccion;
    private Rut rut;
    private String nombre;
    private String apellido;

    public Persona() {
    }

    public Persona(Direccion direccion, Rut rut, String nombre, String apellido) {
        this.direccion = direccion;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Rut getRut() {
        return rut;
    }

    public void setRut(Rut rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "direccion=" + direccion +
                ", rut=" + rut +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    @Override
    public String showData() {
        return "Nombre: " + nombre + " " + apellido + ", Direccion: " + direccion;
    }

    @Override
    public String showContableData() {
        return rut + " - " + apellido + ", " + nombre + ". " + direccion ;
    }
}
