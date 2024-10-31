/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesDAO;

/**
 *
 * @author andre
 */
import Entidades.Usuario;
import db.cn;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    private cn CN;
    private ResultSet rs;

    public UsuarioDAO() {
        this.CN = new cn();
    }

    public boolean validarPassword(String usuario, String password) {
        String sSQL = "{call validar_password(?,?)};";
        int filasEncontradas = 0;

        try {
            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);

            cs.setString(1, usuario);
            cs.setString(2, password);
            rs = cs.executeQuery();

            while (rs.next()) {
                filasEncontradas = rs.getInt("cantidad_usuarios");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        if (filasEncontradas > 0) {
            return true;
        }

        return false;
    }

}
