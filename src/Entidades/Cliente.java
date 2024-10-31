/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author andre
 */
public class Cliente {
    private int idCliente;
    private String nombre;
    private String Ubicacion;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String Ubicacion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.Ubicacion = Ubicacion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }
    
    
}
