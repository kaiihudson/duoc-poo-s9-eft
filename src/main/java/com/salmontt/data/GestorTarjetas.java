package com.salmontt.data;

import com.salmontt.model.persona.Persona;
import com.salmontt.model.persona.Tarjeta;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Gestor tarjetas.
 */
public class GestorTarjetas {
    private final List<Tarjeta> tarjetas = new ArrayList<>();

    /**
     * Create dummy data for tarjetas.
     *
     * @param persona the persona
     */
    public void createDummyTarjetas(Persona persona) {
        Tarjeta tarjeta = new Tarjeta("0000 0000 0000 0000", "12/12/2000", "000", persona);
        addTarjeta(tarjeta);
    }

    /**
     * Gets tarjetas.
     *
     * @return the tarjetas
     */
    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    /**
     * Add tarjeta.
     *
     * @param tarjeta the tarjeta
     */
    public void addTarjeta(Tarjeta tarjeta) {
        tarjetas.add(tarjeta);
    }

    /**
     * Show tarjetas.
     */
    public void showTarjetas() {
        for (Tarjeta tarjeta : tarjetas) {
            System.out.println(tarjeta);
        }
    }


}
