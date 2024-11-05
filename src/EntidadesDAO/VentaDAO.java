/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesDAO;

import Entidades.Venta;
import db.cn;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Date;
/**
 *
 * @author kater
 */
public class VentaDAO {
    
    private cn CN;
    private ResultSet rs;

    public VentaDAO() {
        this.CN = new cn();
    }
    
    public ArrayList<Venta> ConsultarVentas() {
        ArrayList<Venta> listaVentas = new ArrayList<Venta>();
        String sSQL = "{CALL ObtenerVentas()};";

        try {
            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);

            rs = cs.executeQuery();
            while (rs.next()) {
                Venta venta = new Venta();
                
                venta.setIdVenta(rs.getInt(1));
                venta.setFechaVenta(rs.getDate(2));
                venta.setIdUsuario(rs.getInt(3));
                venta.setMontoTotal(rs.getDouble(4));
                
                listaVentas.add(venta);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        return listaVentas;
    }
    
    public boolean InsertarVenta(Venta venta) {
        String sSQL = "{CALL insertar_venta(?,?,?)}";
        
        try {
            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);
            
            cs.setDouble(1, venta.getMontoTotal());
            cs.setDate(2, (java.sql.Date) venta.getFechaVenta());
            cs.setInt(3, venta.getIdUsuario());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean ActualizarVenta(Venta venta) {
        String sSQL = "CALL actualizar_venta(?,?,?,?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setInt(1, venta.getIdVenta());
            cs.setDouble(2, venta.getMontoTotal());
            cs.setDate(3, (java.sql.Date) venta.getFechaVenta());
            cs.setInt(4, venta.getIdUsuario());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean EliminarVenta(int idVenta) {
        String sSQL = "CALL eliminar_venta(?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setInt(1, idVenta);
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
}