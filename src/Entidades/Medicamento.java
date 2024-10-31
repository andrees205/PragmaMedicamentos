/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author andre
 */
public class Medicamento {
    private int idMedicamento;
    private int idCategoria;
    private String presentacion;
    private String nombre;

    public Medicamento() {
    }

    public Medicamento(int idMedicamento, int idCategoria, String presentacion, String nombre) {
        this.idMedicamento = idMedicamento;
        this.idCategoria = idCategoria;
        this.presentacion = presentacion;
        this.nombre = nombre;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
