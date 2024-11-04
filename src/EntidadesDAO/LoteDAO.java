/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesDAO;

import Entidades.Lote;
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
                
                //ACA CREO QUE DA ERROR PORQUE LOTE PIDE EL ID DEL MEDICAMENTO TIPO INT Y EN LA CONSULTA
                //DEL PROCEDIMIENTO SE DEUVELVE UN STRING QUE ES EL NOMBRE DEL MEDICMANTO
                //PARA ARREGLARLO SOLO SE TENDRIA QUE CAMBIAR LOS IDMEDICAMENTO, IDPROVEEDOR, ETC A TIPO STRING
                lote.setIdLote(rs.getInt(1));
                lote.setIdMedicamento(rs.getInt(2));
                lote.setCantidad(rs.getInt(3));
                lote.setIdProveedor(rs.getInt(4));
                lote.setIdUsuario(rs.getInt(5));
                lote.setPrecioCosto(rs.getDouble(6));
                lote.setPrecioUnitario(rs.getDouble(7));
                lote.setPrecioMayoreo(rs.getDouble(8));
                lote.setFecha(rs.getDate(9));
                lote.setUbicacion(rs.getString(10));
                
                listaLotes.add(lote);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        return listaLotes;
    }
    
    
    
}
