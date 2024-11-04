/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesDAO;

/**
 *
 * @author andre
 */
import Entidades.Categoria;
import db.cn;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CategoriaDAO {

    private cn CN;
    private ResultSet rs;

    public CategoriaDAO() {
        this.CN = new cn();
    }

    public ArrayList<Categoria> ConsultarCategorias() {
        ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
        String sSQL = "{call ObtenerCategorias()};";

        try {
            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);

            rs = cs.executeQuery();
            while (rs.next()) {
                Categoria cat = new Categoria();

                cat.setIdcategoria(rs.getInt(1));
                cat.setNombreCategoria(rs.getString(2));
                cat.setDescripcion(rs.getString(3));

                listaCategorias.add(cat);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        return listaCategorias;
    }

    public boolean InsertarCategoria(Categoria cat) {
        String sSQL = "{call insertar_categoria(?,?)}";

        try {
            CallableStatement cs = this.CN.getConexion().prepareCall(sSQL);

            cs.setString(1, cat.getNombreCategoria());
            cs.setString(2, cat.getDescripcion());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean EliminarCategoria(int idCategoria) {
        String sSQL = "CALL eliminar_categoria(?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setInt(1, idCategoria);
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
