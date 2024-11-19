/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Entidades.Cliente;
import Entidades.Usuario;
import EntidadesDAO.ClienteDAO;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andre
 */
public class frmCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmCliente
     */
    ClienteDAO clienteDao;
    DefaultTableModel modelClientes;
    ArrayList<Cliente> listaClientes;
    Cliente clienteSeleccionado;
    String nombre, ubicacion;
    private Usuario userSesion;
    private Component rootPane;
    
    public frmCliente(Usuario userFrmPrincipal) {
        initComponents();
        this.userSesion = userFrmPrincipal;
        this.clienteDao = new ClienteDAO();
        
        this.modelClientes=(DefaultTableModel) this.tblClientes.getModel();
        this.listaClientes=new ArrayList();
        this.listaClientes=this.clienteDao.ConsultarClientes();
        this.RecargarUsuarios();
        this.clienteSeleccionado= new Cliente();
    }
        public frmCliente() {
        initComponents();
        this.clienteDao = new ClienteDAO();
        
        this.modelClientes=(DefaultTableModel) this.tblClientes.getModel();
        this.listaClientes=new ArrayList();
        this.listaClientes=this.clienteDao.ConsultarClientes();
        this.RecargarUsuarios();
        this.clienteSeleccionado= new Cliente();
    }
    
    private void RecargarUsuarios()
    {
        this.tblClientes.clearSelection();
        this.modelClientes.setRowCount(0);
        for (int i = 0; i < this.listaClientes.size(); i++) {
            Cliente cliente=this.listaClientes.get(i);
            String[] data= {cliente.getNombre(), cliente.getUbicacion()};
            this.modelClientes.addRow(data);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Medicamento/btnOrdenar.png"))); // NOI18N
        jButton4.setContentAreaFilled(false);
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Medicamento/btnFiltrar.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 30, 30));

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Cliente", "Ubicación"
            }
        ));
        jScrollPane1.setViewportView(tblClientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 360, 420));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Cliente/btnRegistrarCliente.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 280, 40));

        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 160, 40));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 120, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ubicación");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 120, 30));

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 160, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Categoria/lblFondoPequeño (2).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
}
