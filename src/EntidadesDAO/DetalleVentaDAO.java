/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesDAO;

import Entidades.DetalleVenta;
import db.cn;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author kater
 */
public class DetalleVentaDAO {
    
    private cn CN;
    private ResultSet rs;

    public DetalleVentaDAO() {
        this.CN = new cn();
    }
    
    public ArrayList<DetalleVenta> ConsultarDetalles() {
        ArrayList<DetalleVenta> listaDetalles = new ArrayList<DetalleVenta>();
        String sSQL = "{CALL ObtenerDetallesVentas()};";

        try {
            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);

            rs = cs.executeQuery();
            while (rs.next()) {
                DetalleVenta detalle = new DetalleVenta();
                
                detalle.setIdDetalleVenta(rs.getInt(1));
                detalle.setIdVenta(rs.getInt(2));
                detalle.setIdMedicamento(rs.getInt(3));
                detalle.setNombreMedicamento(rs.getString(4));
                detalle.setCantidad(rs.getInt(5));
                detalle.setPrecioVendido(rs.getDouble(6));
                
                listaDetalles.add(detalle);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        return listaDetalles;
    }
    
    public boolean InsertarDetalle(DetalleVenta detalle) {
        String sSQL = "{CALL insertar_detalleventa(?,?,?,?)}";
        
        try {
            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);
            
            cs.setInt(1, detalle.getIdVenta());
            cs.setInt(2,  detalle.getIdMedicamento());
            cs.setInt(3, detalle.getCantidad());
            cs.setDouble(4, detalle.getPrecioVendido());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean ActualizarDetalleVenta(DetalleVenta detalle) {
        String sSQL = "CALL actualizar_detalleventa(?,?,?,?,?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setInt(1, detalle.getIdDetalleVenta());
            cs.setInt(2, detalle.getIdVenta());
            cs.setInt(3,  detalle.getIdMedicamento());
            cs.setInt(4, detalle.getCantidad());
            cs.setDouble(5, detalle.getPrecioVendido());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean EliminarDetalleVenta(int idDetalle) {
        String sSQL = "CALL eliminar_detalleventa(?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setInt(1, idDetalle);
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    
}
