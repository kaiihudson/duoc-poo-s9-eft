package com.salmontt.model.persona;

import com.salmontt.utils.exceptions.InvalidRutException;

public class Rut {
    private final String numeros;
    private final String dv;

    public Rut(String numeros, String dv) {
        this.numeros = numeros;
        if (validarRut(numeros, dv)){
            this.dv = dv;
        } else {
            throw new InvalidRutException("Rut invalido");
        }
    }

    public boolean validarRut(String numeros, String dv) {
        boolean validacion = false;
        try {
            int rutAux = Integer.parseInt(numeros);
            char charDv = dv.toUpperCase().charAt(0);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if ( charDv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return validacion;
    }

    public String getNumeros() {
        return numeros;
    }

    @Override
    public String toString() {
        return numeros + "-" + dv;
    }
}
