package com.salmontt.data;

import com.salmontt.model.OC.OrdenCompra;
import com.salmontt.model.OC.Producto;
import com.salmontt.utils.common.Importer;

import java.util.ArrayList;
import java.util.List;

public class GestorOC {
    private final List<OrdenCompra> ordenComprasList = new ArrayList<>();
    private final List<Producto> productoList = new ArrayList<>();
    private final Importer importer = new Importer();


    public void importProductos(String route) {
        List<Producto> productos =  importer.importProductosFromPlainText(route);
        productoList.addAll(productos);
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void showAllProductos() {
        for (Producto producto : productoList) {
            System.out.println(producto);
        }
    }

    public void showOrdenCompras() {
        for (OrdenCompra ordenCompra : ordenComprasList) {
            System.out.println(ordenCompra);
        }
    }

    public List<OrdenCompra> getOrdenComprasList() {
        return ordenComprasList;
    }
}
