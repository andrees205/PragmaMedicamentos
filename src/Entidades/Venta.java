/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author andre
 */
public class Venta {
    private int idVenta;
    private Date fechaVenta;
    private int idUsuario;
    private double MontoTotal;

    public Venta() {
    }

    public Venta(int idVenta, Date fechaVenta, int idUsuario, double MontoTotal) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.idUsuario = idUsuario;
        this.MontoTotal = MontoTotal;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public double getMontoTotal() {
        return MontoTotal;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setMontoTotal(double MontoTotal) {
        this.MontoTotal = MontoTotal;
    }
    
    
}
