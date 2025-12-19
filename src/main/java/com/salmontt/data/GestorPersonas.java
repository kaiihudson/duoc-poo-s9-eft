package com.salmontt.data;

import com.salmontt.model.persona.Persona;
import com.salmontt.utils.common.Importer;

import java.util.ArrayList;
import java.util.List;

public class GestorPersonas {
    private final List<Persona> personasList = new ArrayList<>();
    private final Importer importer = new Importer();

    public List<Persona> getPersonas() {
        return personasList;
    }

    public void importPersonas(String route) {
        List<Persona> personas =  importer.importPersonasFromPlainText(route);
        personasList.addAll(personas);
    }
}
