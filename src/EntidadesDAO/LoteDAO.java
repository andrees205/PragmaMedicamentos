/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesDAO;

import Entidades.Lote;
import db.cn;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author kater
 */
public class LoteDAO {
    
    private cn CN;
    private ResultSet rs;

    public LoteDAO() {
        this.CN = new cn();
    }
    
    public ArrayList<Lote> ConsultarLote() {
        ArrayList<Lote> listaLotes = new ArrayList<Lote>();
        String sSQL = "{CALL ObtenerLotes()};";

        try {
            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);

            rs = cs.executeQuery();
            while (rs.next()) {
                Lote lote = new Lote();
                
                lote.setIdLote(rs.getInt(1));
                lote.setIdMedicamento(rs.getInt(2));
                lote.setNombreMedicamento(rs.getString(3));
                lote.setCantidad(rs.getInt(4));
                lote.setLimite(rs.getInt(5));
                lote.setIdProveedor(rs.getInt(6));
                lote.setNombreProveedor(rs.getString(7));
                lote.setIdUsuario(rs.getInt(8));
                lote.setNombreUsuario(rs.getString(9));
                lote.setPrecioCosto(rs.getDouble(10));
                lote.setPrecioUnitario(rs.getDouble(11));
                lote.setPrecioMayoreo(rs.getDouble(12));
                lote.setFecha(rs.getDate(13));
                lote.setUbicacion(rs.getString(14));
                
                listaLotes.add(lote);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        return listaLotes;
    }
    
    
    public Lote ConsultarLotePorID(int idLote) {
        //ArrayList<Lote> listaLotes = new ArrayList<Lote>();
        Lote lote = new Lote();
        String sSQL = "{CALL BuscarLotePorID(?)};";

        try {
            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);
            cs.setInt(1, idLote);
            rs = cs.executeQuery();
            while (rs.next()) {
                //Lote lote = new Lote();
                
                lote.setIdLote(rs.getInt(1));
                lote.setIdMedicamento(rs.getInt(2));
                lote.setNombreMedicamento(rs.getString(3));
                lote.setCantidad(rs.getInt(4));
                lote.setLimite(rs.getInt(5));
                lote.setIdProveedor(rs.getInt(6));
                lote.setNombreProveedor(rs.getString(7));
                lote.setIdUsuario(rs.getInt(8));
                lote.setNombreUsuario(rs.getString(9));
                lote.setPrecioCosto(rs.getDouble(10));
                lote.setPrecioUnitario(rs.getDouble(11));
                lote.setPrecioMayoreo(rs.getDouble(12));
                lote.setFecha(rs.getDate(13));
                lote.setUbicacion(rs.getString(14));
                
                //listaLotes.add(lote);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
            
        }

        return lote;
    }
    
    public boolean InsertarLote(Lote lote) {
        String sSQL = "{CALL insertar_lote(?,?,?,?,?,?,?,?,?,?)}";
        
        try {
            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);
            
            cs.setInt(1, lote.getIdMedicamento());
            cs.setInt(2,  lote.getCantidad());
            cs.setInt(3,  lote.getLimite());
            cs.setInt(4, lote.getIdProveedor());
            cs.setInt(5, lote.getIdUsuario());
            cs.setDouble(6, lote.getPrecioCosto());
            cs.setDouble(7, lote.getPrecioMayoreo());
            cs.setDouble(8, lote.getPrecioUnitario());
            cs.setDate(9, new java.sql.Date(lote.getFecha().getTime()));
            cs.setString(10, lote.getUbicacion());
            cs.executeUpdate();
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
            return false;
        }
    }
    
    public boolean ActualizarLote(Lote lote) {
        String sSQL = "CALL actualizar_lote(?,?,?,?,?,?,?,?,?,?,?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setInt(1, lote.getIdLote());
            cs.setInt(2, lote.getIdMedicamento());
            cs.setInt(3,  lote.getCantidad());
            cs.setInt(4,  lote.getLimite());
            cs.setInt(5, lote.getIdProveedor());
            cs.setInt(6, lote.getIdUsuario());
            cs.setDouble(7, lote.getPrecioCosto());
            cs.setDouble(8, lote.getPrecioMayoreo());
            cs.setDouble(9, lote.getPrecioMayoreo());
            cs.setDate(10, (Date) lote.getFecha());
            cs.setString(11, lote.getUbicacion());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean EliminarLote(int idLote) {
        String sSQL = "CALL eliminar_lote(?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setInt(1, idLote);
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
}
