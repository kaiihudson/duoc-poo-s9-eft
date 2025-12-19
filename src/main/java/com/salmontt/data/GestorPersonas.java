package com.salmontt.data;

import com.salmontt.model.persona.Persona;
import com.salmontt.utils.common.Importer;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Gestor personas.
 */
public class GestorPersonas {
    private final List<Persona> personasList = new ArrayList<>();
    private final Importer importer = new Importer();

    /**
     * Gets personas.
     *
     * @return the personas list
     */
    public List<Persona> getPersonas() {
        return personasList;
    }

    /**
     * Import personas.
     *
     * @param route the route in resources to the file
     */
    public void importPersonas(String route) {
        List<Persona> personas =  importer.importPersonasFromPlainText(route);
        personasList.addAll(personas);
    }
}
