package com.salmontt.app;

import com.salmontt.data.GestorUI;
import com.salmontt.model.OC.OrdenCompra;
import com.salmontt.model.OC.Producto;
import com.salmontt.model.persona.Rut;
import com.salmontt.model.persona.Tarjeta;
import com.salmontt.utils.common.Importer;
import com.salmontt.utils.exceptions.InvalidRutException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);

    static void main(String[] args) {



        // test creating a rut and handling a custom exception
        try {
            Rut rut = new Rut("19134233", "2");
        } catch (InvalidRutException e) {
            log.error("Invalid rut", e);
        }

        // test loading data and showing it
        GestorUI gestor = new GestorUI();
        gestor.showAllData();
        System.out.println("++++++++++++++++++++++++");
        gestor.showAllContableData();
        System.out.println("++++++++++++++++++++++++");
        gestor.showAllEmpleadosContableData();
        System.out.println("++++++++++++++++++++++++");
        gestor.showAllClienteContableData();
        System.out.println("++++++++++++++++++++++++");
        gestor.showAllProveedorContableData();
        System.out.println("++++++++++++++++++++++++");

        // test creating a tarjeta
        gestor.initializeTarjetas();
        gestor.showAllTarjetas();
        System.out.println("++++++++++++++++++++++++");

        // test creating an OC
        gestor.showAllProductos();
        System.out.println("++++++++++++++++++++++++");

        Tarjeta tarjetaOC = gestor.getTarjetas().getFirst();
        List<Producto> productosOC = new ArrayList<>(gestor.getProductos());

        OrdenCompra oc = new OrdenCompra(tarjetaOC,  productosOC);
        gestor.addOrdenCompra(oc);

        gestor.showAllOrdenCompras();
    }
}
