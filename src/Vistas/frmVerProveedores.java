/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Paneles.frmLotes;
import EntidadesDAO.ProveedorDAO;
import Entidades.Proveedor;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kater
 */
public class frmVerProveedores extends javax.swing.JInternalFrame {

    private frmLotes parentForm;
    private ProveedorDAO provDAO;
    DefaultTableModel model;
    ArrayList<Proveedor> listaProveedores;
    /**
     * Creates new form frmVerProveedores
     */
    public frmVerProveedores() {
        initComponents();
        provDAO = new ProveedorDAO();
        this.model=(DefaultTableModel) this.jTable1.getModel();
        this.listaProveedores=new ArrayList();
        cargarTabla();
    }

    public frmVerProveedores(frmLotes parentForm) {
        initComponents();
        this.parentForm = parentForm;
        provDAO = new ProveedorDAO();
        this.model=(DefaultTableModel) this.jTable1.getModel();
        this.listaProveedores=new ArrayList();
        cargarTabla();
    }
    
    private void cargarTabla(){
        
        this.model.setRowCount(0);
        this.listaProveedores = this.provDAO.ConsultarProveedores();
        for (int i = 0; i < this.listaProveedores.size(); i++) {
            Proveedor prov=this.listaProveedores.get(i);
            String[] data= {Integer.toString(prov.getIdproveedor()), prov.getNombreProveedor()};
            this.model.addRow(data);
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

        pnlPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        pnlPrincipal.setBackground(new java.awt.Color(56, 102, 65));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PROVEEDOR"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila = this.jTable1.getSelectedRow();
        int id = Integer.parseInt(this.jTable1.getValueAt(fila, 0).toString());

        String nombre = (String) jTable1.getValueAt(fila, 1);

        parentForm.setProveedor(nombre, id);
        this.dispose();
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
