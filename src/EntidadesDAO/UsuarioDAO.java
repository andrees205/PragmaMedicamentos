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

    public ArrayList<Usuario> ConsultarUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        String sSQL = "{call ObtenerUsuarios()};";

        try {
            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);

            rs = cs.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();

                user.setIdusuario(rs.getInt(1));
                user.setNombre(rs.getString(2));
                user.setContraseña(rs.getString(3));
                user.setRol(rs.getString(4));

                listaUsuarios.add(user);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        return listaUsuarios;
    }

    public boolean InsertarUsuario(Usuario user) {
        String sSQL = "{call insertar_usuario(?,?,?)}";

        try {
            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);

            cs.setString(1, user.getNombre());
            cs.setString(2, user.getRol());
            cs.setString(3, user.getContraseña());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
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

    public boolean UsuarioExiste(String usuario) {
        String sSQL = "CALL usuario_existe(?)";
        int filas = 0;

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setString(1, usuario);
            rs = cs.executeQuery();

            while (rs.next()) {
                filas = rs.getInt("usuarios_encontrados");
            }
            if (filas > 0) {
                return true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean EliminarUsuario(int idEmpleado) {
        String sSQL = "CALL eliminar_usuario(?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setInt(1, idEmpleado);
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public Usuario ObtenerUsuarioSesion(String usuario, String password) {

        String sSQL = "{call obtener_usuario_sesion(?,?)};";
        Usuario user = new Usuario();
        try {

            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);
            cs.setString(1, usuario);
            cs.setString(2, password);
            rs = cs.executeQuery();

            while (rs.next()) {

                user.setIdusuario(rs.getInt(1));
                user.setNombre(rs.getString(2));
                user.setRol(rs.getString(3));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        return user;
    }
}
