/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesDAO;

import Entidades.Proveedor;
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
public class ProveedorDAO {
    
    private cn CN;
    private ResultSet rs;

    public ProveedorDAO() {
        this.CN = new cn();
    }
    
    public ArrayList<Proveedor> ConsultarProveedores() {
        ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
        String sSQL = "{CALL ObtenerProveedores()};";

        try {
            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);

            rs = cs.executeQuery();
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                
                proveedor.setIdproveedor(rs.getInt(1));
                proveedor.setNombreProveedor(rs.getString(2));
                proveedor.setUbicacion(rs.getString(3));
                
                listaProveedores.add(proveedor);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        return listaProveedores;
    }
    
    public boolean InsertarProveedor(Proveedor prov) {
        String sSQL = "{CALL insertar_proveedor(?,?)}";
        
        try {
            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);
            
            cs.setString(1, prov.getNombreProveedor());
            cs.setString(2, prov.getUbicacion());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean ActualizarProveedor(Proveedor prov) {
        String sSQL = "CALL actualizar_proveedor(?,?,?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setInt(1, prov.getIdproveedor());
            cs.setString(2, prov.getNombreProveedor());
            cs.setString(3, prov.getUbicacion());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean EliminarProveedor(int idProveedor) {
        String sSQL = "CALL eliminar_proveedor(?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setInt(1, idProveedor);
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    
}
