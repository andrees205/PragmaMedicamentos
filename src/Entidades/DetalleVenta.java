/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author andre
 */
public class DetalleVenta {

    private int idDetalleVenta;
    private int idVenta;
    int idLote;
    private int idMedicamento;
    private String nombreMedicamento;
    private int Cantidad;
    private double precioVendido;
    private double total;

    public DetalleVenta() {
    }

    public DetalleVenta(int idDetalleVenta, int idVenta, int idLote, int idMedicamento, String nombreMedicamento, int Cantidad, double precioVendido, double total) {
        this.idDetalleVenta = idDetalleVenta;
        this.idVenta = idVenta;
        this.idLote = idLote;
        this.idMedicamento = idMedicamento;
        this.nombreMedicamento = nombreMedicamento;
        this.Cantidad = Cantidad;
        this.precioVendido = precioVendido;
        this.total = total;
    }

    

    public DetalleVenta(int idVenta, int idLote, int Cantidad, double precioVendido) {

        this.idVenta = idVenta;
        this.idLote = idLote;

        this.Cantidad = Cantidad;
        this.precioVendido = precioVendido;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public int getIdLote() {
        return idLote;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public double getPrecioVendido() {
        return precioVendido;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public void setPrecioVendido(double precioVendido) {
        this.precioVendido = precioVendido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
