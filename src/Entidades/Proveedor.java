/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author andre
 */
public class Proveedor {
    private int idproveedor;
    private String nombreProveedor;
    private String ubicacion;

    public Proveedor() {
    }

    public Proveedor(int idproveedor, String nombreProveedor, String ubicacion) {
        this.idproveedor = idproveedor;
        this.nombreProveedor = nombreProveedor;
        this.ubicacion = ubicacion;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
}
