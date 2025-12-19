package com.salmontt.data;

import com.salmontt.model.persona.Persona;
import com.salmontt.model.persona.Tarjeta;

import java.util.ArrayList;
import java.util.List;

public class GestorTarjetas {
    private final List<Tarjeta> tarjetas = new ArrayList<>();

    public void createDummyTarjetas(Persona persona) {
        Tarjeta tarjeta = new Tarjeta("0000 0000 0000 0000", "12/12/2000", "000", persona);
        addTarjeta(tarjeta);
    }

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }
    public void addTarjeta(Tarjeta tarjeta) {
        tarjetas.add(tarjeta);
    }

    public void showTarjetas() {
        for (Tarjeta tarjeta : tarjetas) {
            System.out.println(tarjeta);
        }
    }


}
