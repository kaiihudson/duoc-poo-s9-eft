package com.salmontt.model.persona;

public class Direccion {
    private final String calle;
    private final String numero;
    private final String ciudad;

    public Direccion(String calle, String numero, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }
    public String getCalle() {
        return calle;
    }

    public String getNumero() {
        return numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String toString() {
        return "Direccion: " +
                "'" + calle + '\'' +
                ", numero: '" + numero + '\'' +
                ", '" + ciudad + '\'';
    }
}
