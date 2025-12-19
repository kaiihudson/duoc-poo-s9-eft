package com.salmontt.utils.common;

import com.salmontt.model.OC.Producto;
import com.salmontt.model.persona.*;
import com.salmontt.utils.exceptions.InvalidRutException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.salmontt.utils.common.Utils.validateInteger;

public class Importer {
    private static final Logger log = LogManager.getLogger(Importer.class);

    public File loadTxtFile(String filePath) throws IllegalAccessException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(filePath);
        if (resource == null) {
            throw new IllegalAccessException("file not found");
        } else {
            return new File(resource.toURI());
        }
    }

    public List<Persona> importPersonasFromPlainText(String filePath){
        List<Persona> importedData = new ArrayList<>();
        int counter = 0;
        try (Scanner reader = new Scanner(loadTxtFile(filePath))) {
            while (reader.hasNextLine()) {
                counter++;
                String data = reader.nextLine();
                String[] dataParts = data.split(",");
                if(dataParts.length >= 2){
                    switch (dataParts.length) {
                        case 6:
                            try {
                                Cliente cliente = new Cliente();
                                cliente.setNombre(dataParts[0]);
                                cliente.setApellido(dataParts[1]);
                                String[] rutParts =  dataParts[2].toLowerCase().replaceAll("\\.", "").split("-");
                                cliente.setRut(new Rut(rutParts[0], rutParts[1]));
                                Direccion direccion = new Direccion(dataParts[3], dataParts[4], dataParts[5]);
                                cliente.setDireccion(direccion);
                                importedData.add(cliente);
                            } catch (InvalidRutException e){
                                log.error("Invalid rut");
                            }
                            break;
                        case 8:
                            try {
                                Empleado empleado = new Empleado();
                                empleado.setNombre(dataParts[0]);
                                empleado.setApellido(dataParts[1]);
                                String[] rutParts =  dataParts[2].toLowerCase().replaceAll("\\.", "").split("-");
                                empleado.setRut(new Rut(rutParts[0], rutParts[1]));
                                Direccion direccion = new Direccion(dataParts[3], dataParts[4], dataParts[5]);
                                empleado.setDireccion(direccion);
                                empleado.setSueldo(validateInteger(dataParts[6]));
                                empleado.setFechaContratacion(dataParts[7]);
                                importedData.add(empleado);
                            } catch (InvalidRutException e){
                                log.error("Invalid rut");
                            } catch (NumberFormatException e){
                                log.error("Invalid salary");
                            }
                            break;
                        case 9:
                            try {
                                Proveedor proveedor = new Proveedor();
                                proveedor.setNombre(dataParts[0]);
                                proveedor.setApellido(dataParts[1]);
                                String[] rutParts =  dataParts[2].toLowerCase().replaceAll("\\.", "").split("-");
                                proveedor.setRut(new Rut(rutParts[0], rutParts[1]));
                                Direccion direccion = new Direccion(dataParts[3], dataParts[4], dataParts[5]);
                                proveedor.setDireccion(direccion);
                                proveedor.setFechaContratacion(dataParts[6]);
                                proveedor.setCompania(dataParts[7]);
                                proveedor.setUFContrato(validateInteger(dataParts[8]));
                                importedData.add(proveedor);
                            } catch (InvalidRutException e){
                                log.error("Invalid rut");
                            } catch (NumberFormatException e){
                                log.error("Invalid salary");
                            }
                            break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            log.error("File not found");
        } catch (URISyntaxException ex) {
            log.error("URI Syntax error on: {}", filePath);
            System.err.println("URI syntax error on " + filePath);
        } catch (IllegalAccessException ex) {
            log.error("Illegal access exception.", ex);
        }        return importedData;
    }

    public List<Producto> importProductosFromPlainText(String filePath){
        List<Producto> importedData = new ArrayList<>();
        int counter = 0;
        try (Scanner reader = new Scanner(loadTxtFile(filePath))) {
            while (reader.hasNextLine()) {
                counter++;
                String data = reader.nextLine();
                String[] dataParts = data.split(",");
                if(dataParts.length == 2){
                    try {
                        Producto producto = new Producto();
                        producto.setNombre(dataParts[0]);
                        producto.setPrecio(validateInteger(dataParts[1]));
                        importedData.add(producto);
                    } catch (NumberFormatException e ) {
                        log.error("Invalid price");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            log.error("File not found");
        } catch (URISyntaxException ex) {
            log.error("URI Syntax error on: {}", filePath);
            System.err.println("URI syntax error on " + filePath);
        } catch (IllegalAccessException ex) {
            log.error("Illegal access exception.", ex);
        }        return importedData;
    }
}

