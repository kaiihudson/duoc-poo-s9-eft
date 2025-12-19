package com.salmontt.model.persona;

import com.salmontt.utils.exceptions.InvalidPersonType;

public class Tarjeta {
    private String numeroTarjeta;
    private String vencimiento;
    private String cvv;
    private Persona persona;

    public Tarjeta(String numeroTarjeta, String vencimiento, String cvv, Persona persona) {
        if (validatePersonType(persona)) {
            this.numeroTarjeta = numeroTarjeta;
            this.vencimiento = vencimiento;
            this.cvv = cvv;
            this.persona = persona;
        } else {
            throw new InvalidPersonType("Invalid person type");
        }
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public String getCvv() {
        return cvv;
    }

    public Persona getPersona() {
        return persona;
    }

    public boolean validatePersonType(Persona persona) {
        return persona instanceof Cliente;
    }

    @Override
    public String toString() {
        return "numeroTarjeta='" + numeroTarjeta + '\'' +
                ", vencimiento='" + vencimiento + '\'' +
                ", cvv='" + cvv + '\'' +
                ", " + persona.showContableData();
    }
}
