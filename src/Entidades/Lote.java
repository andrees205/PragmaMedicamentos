/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author andre
 */
import java.util.Date;
public class Lote {
    private int idLote;
    private int idMedicamento;
    private int Cantidad;
    private int idProveedor;
    private int idUsuario;
    private double precioCosto;
    private double precioUnitario;
    private double precioMayoreo;
    private Date fecha;
    private String ubicacion;

    public Lote() {
    }

    public Lote(int idLote, int idMedicamento, int Cantidad, int idProveedor, int idUsuario, double precioCosto, double precioUnitario, double precioMayoreo, Date fecha, String ubicacion) {
        this.idLote = idLote;
        this.idMedicamento = idMedicamento;
        this.Cantidad = Cantidad;
        this.idProveedor = idProveedor;
        this.idUsuario = idUsuario;
        this.precioCosto = precioCosto;
        this.precioUnitario = precioUnitario;
        this.precioMayoreo = precioMayoreo;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
    }

    public int getIdLote() {
        return idLote;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getPrecioMayoreo() {
        return precioMayoreo;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setPrecioMayoreo(double precioMayoreo) {
        this.precioMayoreo = precioMayoreo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
    
    
}
