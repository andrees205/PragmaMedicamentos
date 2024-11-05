/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesDAO;

import Entidades.Cliente;
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
public class ClienteDAO {
    
    private cn CN;
    private ResultSet rs;

    public ClienteDAO() {
        this.CN = new cn();
    }
    
    public ArrayList<Cliente> ConsultarClientes() {
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        String sSQL = "{CALL ObtenerClientes()};";

        try {
            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);

            rs = cs.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                
                cliente.setIdCliente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setUbicacion(rs.getString(3));
                
                listaClientes.add(cliente);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        return listaClientes;
    }
    
    public boolean InsertarCliente(Cliente cliente) {
        String sSQL = "{CALL insertar_cliente(?,?)}";
        
        try {
            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);
            
            cs.setString(1, cliente.getNombre());
            cs.setString(2,  cliente.getUbicacion());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean ActualizarCliente(Cliente cliente) {
        String sSQL = "CALL actualizar_cliente(?,?,?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setInt(1, cliente.getIdCliente());
            cs.setString(2, cliente.getNombre());
            cs.setString(2, cliente.getUbicacion());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean EliminarCliente(int idCliente) {
        String sSQL = "CALL eliminar_cliente(?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setInt(1, idCliente);
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
}
