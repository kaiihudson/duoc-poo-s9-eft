package com.salmontt.data;

import com.salmontt.model.OC.OrdenCompra;
import com.salmontt.model.OC.Producto;
import com.salmontt.utils.common.Importer;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Gestor oc.
 */
public class GestorOC {
    private final List<OrdenCompra> ordenComprasList = new ArrayList<>();
    private final List<Producto> productoList = new ArrayList<>();
    private final Importer importer = new Importer();


    /**
     * Import productos.
     *
     * @param route the route
     */
    public void importProductos(String route) {
        List<Producto> productos =  importer.importProductosFromPlainText(route);
        productoList.addAll(productos);
    }

    /**
     * Gets producto list.
     *
     * @return the producto list
     */
    public List<Producto> getProductoList() {
        return productoList;
    }

    /**
     * Show all productos.
     */
    public void showAllProductos() {
        for (Producto producto : productoList) {
            System.out.println(producto);
        }
    }

    /**
     * Show orden compras.
     */
    public void showOrdenCompras() {
        for (OrdenCompra ordenCompra : ordenComprasList) {
            System.out.println(ordenCompra);
        }
    }

    /**
     * Gets orden compras list.
     *
     * @return the orden compras list
     */
    public List<OrdenCompra> getOrdenComprasList() {
        return ordenComprasList;
    }
}
