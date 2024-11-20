/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Entidades.Medicamento;
import EntidadesDAO.MedicamentoDAO;
import Paneles.frmLotes;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kater
 */
public class frmVerMedicinas extends javax.swing.JInternalFrame {

    private frmLotes parentForm;
    MedicamentoDAO medDAO;
    DefaultTableModel model;
    ArrayList<Medicamento> listaMedicinas;
    /**
     * Creates new form frmVerMedicinas
     */
    public frmVerMedicinas() {
        initComponents();
        medDAO = new MedicamentoDAO();
        this.model=(DefaultTableModel) this.jTable1.getModel();
        this.listaMedicinas=new ArrayList();
        cargarTabla();
    }

    public frmVerMedicinas(frmLotes parentForm) {
        initComponents();
        this.parentForm = parentForm;
        medDAO = new MedicamentoDAO();
        this.model=(DefaultTableModel) this.jTable1.getModel();
        this.listaMedicinas=new ArrayList();
        cargarTabla();
    }
    private void cargarTabla(){
        
        this.model.setRowCount(0);
        this.listaMedicinas = this.medDAO.ConsultarMedicamento();
        for (int i = 0; i < this.listaMedicinas.size(); i++) {
            Medicamento med=this.listaMedicinas.get(i);
            String[] data= {Integer.toString(med.getIdMedicamento()), med.getNombre(), med.getNombreCategoria()};
            this.model.addRow(data);
        }
    }
//    
//    public void setParentForm(frmLotes parentForm) {
//        this.parentForm = parentForm;
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Categoria/lblFondoPequeño (2).png"))); // NOI18N

        setClosable(true);

        pnlPrincipal.setBackground(new java.awt.Color(56, 102, 65));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MEDICAMENTO", "CATEGORIA"
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
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila = this.jTable1.getSelectedRow();
        int id = Integer.parseInt(this.jTable1.getValueAt(fila, 0).toString());
        
        String nombre = (String) jTable1.getValueAt(fila, 1);

        parentForm.setMedicina(nombre, id);
        this.dispose();
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}