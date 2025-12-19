package com.salmontt.data;

import com.salmontt.model.OC.OrdenCompra;
import com.salmontt.model.OC.Producto;
import com.salmontt.model.common.RegistroContable;
import com.salmontt.model.persona.*;

import java.util.ArrayList;
import java.util.List;

public class GestorUI {
    private final List<RegistroContable> personas = new ArrayList<>();
    private final List<Producto> productos = new ArrayList<>();
    private final GestorOC gestorOC = new GestorOC();
    private final GestorPersonas gestorPersonas = new GestorPersonas();
    private final GestorTarjetas gestorTarjetas = new GestorTarjetas();

    private void initializePersonas(){
        if (gestorPersonas.getPersonas().isEmpty()) {
            gestorPersonas.importPersonas("personas.csv");
            personas.addAll(gestorPersonas.getPersonas());
        }
    }

    //registros

    public void addNewRegistroContable(RegistroContable registro){
        personas.add(registro);
    }

    public void showAllContableData(){
        initializePersonas();
        for (RegistroContable registro : personas){
            System.out.println(registro.showContableData());
        }
    }

    public void showAllData(){
        initializePersonas();
        for (RegistroContable registro : personas){
            System.out.println(registro.showData());
        }
    }

    public void showAllEmpleadosContableData(){
        initializePersonas();
        for (RegistroContable registro : personas){
            if (registro instanceof Empleado){
                System.out.println(registro.showContableData());
            }
        }
    }

    public void showAllClienteContableData(){
        initializePersonas();
        for (RegistroContable registro : personas){
            if(registro instanceof Cliente){
                System.out.println(registro.showContableData());
            }
        }
    }

    public void showAllProveedorContableData(){
        initializePersonas();
        for (RegistroContable registro : personas){
            if (registro instanceof Proveedor){
                System.out.println(registro.showContableData());
            }
        }
    }

    // OC

    public void initializeProductos(){
        if (gestorOC.getProductoList().isEmpty()) {
            gestorOC.importProductos("productos.csv");
            productos.addAll(gestorOC.getProductoList());
        }
    }
    public List<Producto> getProductos(){
        return productos;
    }
    public void showAllProductos(){
        initializeProductos();
        gestorOC.showAllProductos();
    }

    public void addOrdenCompra(OrdenCompra ordenCompra){
        gestorOC.getOrdenComprasList().add(ordenCompra);
    }

    public void showAllOrdenCompras(){
        gestorOC.showOrdenCompras();
    }
    // Tarjetas

    public void initializeTarjetas(){
        for (RegistroContable registro : personas){
            if (registro instanceof Cliente){
                gestorTarjetas.createDummyTarjetas((Persona) registro);
            }
        }
    }
    public List<Tarjeta> getTarjetas(){
        return gestorTarjetas.getTarjetas();
    }

    public void showAllTarjetas(){
        gestorTarjetas.showTarjetas();
    }
}
