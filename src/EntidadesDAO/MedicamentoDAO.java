/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesDAO;

import Entidades.Medicamento;
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
public class MedicamentoDAO {
    
    private cn CN;
    private ResultSet rs;

    public MedicamentoDAO() {
        this.CN = new cn();
    }
    
    public ArrayList<Medicamento> ConsultarMedicamento() {
        ArrayList<Medicamento> listaMedicamentos = new ArrayList<Medicamento>();
        String sSQL = "{CALL ObtenerMedicamentos()};";

        try {
            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);

            rs = cs.executeQuery();
            while (rs.next()) {
                Medicamento med = new Medicamento();
                
                med.setIdMedicamento(rs.getInt(1));
                med.setIdCategoria(rs.getInt(2));
                med.setNombreCategoria(rs.getString(3));
                med.setPresentacion(rs.getString(4));
                med.setNombre(rs.getString(5));
                listaMedicamentos.add(med);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        return listaMedicamentos;
    }
    
    public boolean InsertarMedicamento(Medicamento med) {
        String sSQL = "{CALL insertar_medicamento(?,?,?)}";
        
        try {
            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);
            
            cs.setInt(1, med.getIdCategoria());
            cs.setString(2,  med.getPresentacion());
            cs.setString(3, med.getNombre());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean ActualizarMedicamento(Medicamento med) {
        String sSQL = "CALL actualizar_medicamento(?,?,?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setInt(1, med.getIdMedicamento());
            cs.setString(2, med.getPresentacion());
            cs.setString(3, med.getNombre());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean EliminarMedicamento(int idMed) {
        String sSQL = "CALL eliminar_medicamento(?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setInt(1, idMed);
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
}
