package com.salmontt.data;

import com.salmontt.model.OC.OrdenCompra;
import com.salmontt.model.OC.Producto;
import com.salmontt.model.common.RegistroContable;
import com.salmontt.model.persona.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Gestor ui.
 */
public class GestorUI {
    private final List<RegistroContable> personas = new ArrayList<>();
    private final List<Producto> productos = new ArrayList<>();
    private final GestorOC gestorOC = new GestorOC();
    private final GestorPersonas gestorPersonas = new GestorPersonas();
    private final GestorTarjetas gestorTarjetas = new GestorTarjetas();

    /**
     * Initialize dummy data inside the class
     */
    private void initializePersonas(){
        if (gestorPersonas.getPersonas().isEmpty()) {
            gestorPersonas.importPersonas("personas.csv");
            personas.addAll(gestorPersonas.getPersonas());
        }
    }

    //registros

    /**
     * Add new registro contable.
     *
     * @param registro the registro
     */
    public void addNewRegistroContable(RegistroContable registro){
        personas.add(registro);
    }

    /**
     * Show all contable data.
     */
    public void showAllContableData(){
        initializePersonas();
        for (RegistroContable registro : personas){
            System.out.println(registro.showContableData());
        }
    }

    /**
     * Show all data.
     */
    public void showAllData(){
        initializePersonas();
        for (RegistroContable registro : personas){
            System.out.println(registro.showData());
        }
    }

    /**
     * Show all empleados contable data.
     */
    public void showAllEmpleadosContableData(){
        initializePersonas();
        for (RegistroContable registro : personas){
            if (registro instanceof Empleado){
                System.out.println(registro.showContableData());
            }
        }
    }

    /**
     * Show all cliente contable data.
     */
    public void showAllClienteContableData(){
        initializePersonas();
        for (RegistroContable registro : personas){
            if(registro instanceof Cliente){
                System.out.println(registro.showContableData());
            }
        }
    }

    /**
     * Show all proveedor contable data.
     */
    public void showAllProveedorContableData(){
        initializePersonas();
        for (RegistroContable registro : personas){
            if (registro instanceof Proveedor){
                System.out.println(registro.showContableData());
            }
        }
    }

    // OC

    /**
     * Initialize productos.
     */
    public void initializeProductos(){
        if (gestorOC.getProductoList().isEmpty()) {
            gestorOC.importProductos("productos.csv");
            productos.addAll(gestorOC.getProductoList());
        }
    }

    /**
     * Get productos list.
     *
     * @return the list
     */
    public List<Producto> getProductos(){
        return productos;
    }

    /**
     * Show all productos.
     */
    public void showAllProductos(){
        initializeProductos();
        gestorOC.showAllProductos();
    }

    /**
     * Add orden compra.
     *
     * @param ordenCompra the orden compra
     */
    public void addOrdenCompra(OrdenCompra ordenCompra){
        gestorOC.getOrdenComprasList().add(ordenCompra);
    }

    /**
     * Show all orden compras.
     */
    public void showAllOrdenCompras(){
        gestorOC.showOrdenCompras();
    }
    // Tarjetas

    /**
     * Initialize tarjetas.
     */
    public void initializeTarjetas(){
        for (RegistroContable registro : personas){
            if (registro instanceof Cliente){
                gestorTarjetas.createDummyTarjetas((Persona) registro);
            }
        }
    }

    /**
     * Get tarjetas list.
     *
     * @return the list
     */
    public List<Tarjeta> getTarjetas(){
        return gestorTarjetas.getTarjetas();
    }

    /**
     * Show all tarjetas.
     */
    public void showAllTarjetas(){
        gestorTarjetas.showTarjetas();
    }
}
