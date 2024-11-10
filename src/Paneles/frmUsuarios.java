/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import Entidades.Hash;
import Entidades.Usuario;
import EntidadesDAO.UsuarioDAO;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andre
 */
public class frmUsuarios extends javax.swing.JPanel {

    /**
     * Creates new form frmUsuarios
     */
    UsuarioDAO usuarioDAO;
    DefaultTableModel modelUsuarios;
    ArrayList<Usuario> usuarios;
    Usuario usuarioSeleccionado;
    String nombre, password, rol;
    private Usuario userSesion;
    private Component rootPane;

    public frmUsuarios() {
        initComponents();
        this.usuarioDAO= new UsuarioDAO();
        this.modelUsuarios=(DefaultTableModel) this.tblUsuarios.getModel();
        this.usuarios=new ArrayList();
        this.usuarios=this.usuarioDAO.ConsultarUsuarios();
        this.RecargarUsuarios();
        this.usuarioSeleccionado= new Usuario();
    }
    
        public frmUsuarios(Usuario userFrmPrincipal) {
        initComponents();
        this.userSesion = userFrmPrincipal;
        this.usuarioDAO= new UsuarioDAO();
        this.modelUsuarios=(DefaultTableModel) this.tblUsuarios.getModel();
        this.usuarios=new ArrayList();
        this.usuarios=this.usuarioDAO.ConsultarUsuarios();
        this.RecargarUsuarios();
        this.usuarioSeleccionado= new Usuario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuEditar = new javax.swing.JMenuItem();
        menuBorrar = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRol = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        txtNombreUsuario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        menuEditar.setText("Editar");
        menuEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuEditar);

        menuBorrar.setText("Borrar");
        menuBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBorrarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuBorrar);

        setBackground(new java.awt.Color(56, 102, 65));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rol");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 340, 120, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Usuarios/btnRegistrarUsuario.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 430, 280, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, 120, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contraseña");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 120, -1));

        txtRol.setBackground(new java.awt.Color(255, 255, 255));
        txtRol.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        add(txtRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, 280, 40));

        txtContraseña.setBackground(new java.awt.Color(255, 255, 255));
        txtContraseña.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 280, 40));

        txtNombreUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreUsuario.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 210, 280, 40));

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Contraseña", "Rol"
            }
        ));
        tblUsuarios.setComponentPopupMenu(jPopupMenu1);
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 610, 580));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Usuarios/FondoLabel.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.CapturarDatosUsuario();
        if (this.ValidarTextFields(nombre, rol, password)) {
            if (this.usuarioDAO.UsuarioExiste(nombre)) {
                JOptionPane.showMessageDialog(rootPane, "Cada empleado debe tener un nombre de usuario unico", "El usuario ya existe", JOptionPane.WARNING_MESSAGE);
            } else {
                Usuario user = new Usuario(nombre, password, rol);
                if (this.usuarioDAO.InsertarUsuario(user)) {
                    JOptionPane.showMessageDialog(rootPane, "", "Empleado agregado exitosamente!!", JOptionPane.INFORMATION_MESSAGE);
                    this.usuarios = this.usuarioDAO.ConsultarUsuarios();
                    this.RecargarUsuarios();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "El empleado no pudo ser agregado, revise los datos ingresados", "Error inesperado!!", JOptionPane.WARNING_MESSAGE);
                }
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Todos los datos deben ser llenados", "Datos incompletos o vacios", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void menuBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBorrarActionPerformed
        int fila=this.tblUsuarios.getSelectedRow();
        this.usuarioSeleccionado=this.usuarios.get(fila);
        
        int opc=JOptionPane.showConfirmDialog(rootPane,"Seguro que desea eliminar el usuario?", "Advertencia!", JOptionPane.YES_NO_OPTION);
        if (opc==JOptionPane.OK_OPTION) {
            if (this.usuarioDAO.EliminarUsuario(this.usuarioSeleccionado.getIdusuario())) {
                JOptionPane.showMessageDialog(rootPane, "", "Empleado eliminado exitosamente!!", JOptionPane.INFORMATION_MESSAGE);
                this.usuarios=this.usuarioDAO.ConsultarUsuarios();
                this.RecargarUsuarios();
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "El usuario no pudo ser eliminado, intente nuevamente", "Error inesperado!!", JOptionPane.ERROR_MESSAGE);
                this.RecargarUsuarios();
            }
        }
    }//GEN-LAST:event_menuBorrarActionPerformed

    private void menuEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarActionPerformed
        int registro = this.tblUsuarios.getSelectedRow();
        this.txtNombreUsuario.setText(tblUsuarios.getValueAt(registro, 0).toString());
        this.txtContraseña.setText(tblUsuarios.getValueAt(registro, 1).toString());
        this.txtRol.setText(tblUsuarios.getValueAt(registro, 2).toString());
    }//GEN-LAST:event_menuEditarActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblUsuariosMouseClicked

        
    private void RecargarUsuarios()
    {
        this.tblUsuarios.clearSelection();
        this.modelUsuarios.setRowCount(0);
        this.txtContraseña.setText("");
        for (int i = 0; i < this.usuarios.size(); i++) {
            Usuario user=this.usuarios.get(i);
            String[] data= {user.getNombre(), user.getContraseña(),user.getRol()};
            this.modelUsuarios.addRow(data);
        }
    }
    
    private void CapturarDatosUsuario() {
        this.nombre = this.txtNombreUsuario.getText().trim();
        this.rol = this.txtRol.getText().trim();
        this.password = Hash.toSHA1(this.txtContraseña.getText().trim());
    }

    private boolean ValidarTextFields(String nombre, String rol, String password) {
        if (nombre.isEmpty() || nombre.isBlank()) {
            return false;
        }
        if (rol.isEmpty() || rol.isBlank()) {
            return false;
        }
        return !(password.isEmpty() || password.isBlank());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuBorrar;
    private javax.swing.JMenuItem menuEditar;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtRol;
    // End of variables declaration//GEN-END:variables
}
