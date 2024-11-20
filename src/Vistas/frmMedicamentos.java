/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Entidades.Categoria;
import Entidades.Lote;
import Paneles.CambiaPanel;
import Paneles.frmInventario;
import Paneles.frmVerCategorias;
import Entidades.Medicamento;
import EntidadesDAO.LoteDAO;
import EntidadesDAO.MedicamentoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andre
 */
public class frmMedicamentos extends javax.swing.JInternalFrame {

    MedicamentoDAO medDAO;
    DefaultTableModel model;
    Medicamento med;
    ArrayList<Medicamento> listaMedicinas;
    boolean blnEditar;
    private ArrayList<Lote> listaLotes;
    private LoteDAO loteDAO;
    /**
     * Creates new form frmMedicamentos
     */
    public frmMedicamentos() {
        initComponents();
        medDAO = new MedicamentoDAO();
        this.model=(DefaultTableModel) this.jTable1.getModel();
        this.listaMedicinas=new ArrayList();
        med = new Medicamento();
        cargarTabla();
        this.blnEditar = false;
    }

    public void setCategoria(String categoriaNombre, int id) {
        this.jTextField1.setText(categoriaNombre); // Actualiza el campo de texto
        this.jLabel4.setText(Integer.toString(id));
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Editar);

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Eliminar);

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(56, 102, 65));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 130, 40));

        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 160, 40));

        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 160, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MEDICAMENTO", "CATEGORIA"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 360, 420));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Medicamento/btnOrdenar.png"))); // NOI18N
        jButton4.setContentAreaFilled(false);
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Medicamento/btnFiltrar.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 30, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Medicamento/btnBuscar.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 40, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Medicamento/btnRegistrarMed (1).png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 280, 40));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Presentación");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 120, 30));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Producto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 120, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 203, 60, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Categoria");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 120, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Medicamento/lblFondoPequeño (2).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        frmVerCategorias frm = new frmVerCategorias();
        frm.setParentForm(this); // Pasar referencia del formulario principal
        frm.setVisible(true);
        this.getDesktopPane().add(frm);
        try {
            frm.setSelected(true);
        } catch (java.beans.PropertyVetoException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if (!this.blnEditar) {
            if(!this.jTextField1.getText().isBlank() && !this.jTextField1.getText().isEmpty() && !this.jTextField2.getText().isBlank() &&
                !this.jTextField2.getText().isEmpty() && !this.jTextField3.getText().isBlank() && !this.jTextField3.getText().isEmpty()){
                Medicamento med = new Medicamento();

                med.setIdCategoria(Integer.parseInt(this.jLabel4.getText()));
                med.setPresentacion(this.jTextField2.getText());
                med.setNombre(this.jTextField3.getText());

                this.medDAO.InsertarMedicamento(med);
                JOptionPane.showMessageDialog(this, "Medicamento Agregado");
                cargarTabla();
            }else{
                JOptionPane.showMessageDialog(this, "Ingrese información en los campos");
            }
        } else {
            
                Medicamento med = new Medicamento();
                med.setIdMedicamento(this.med.getIdMedicamento());
                med.setIdCategoria(Integer.parseInt(this.jLabel4.getText()));
                med.setPresentacion(this.jTextField2.getText());
                med.setNombre(this.jTextField3.getText());
                this.medDAO.ActualizarMedicamento(med);
                JOptionPane.showMessageDialog(rootPane, "Medicamento actualizado", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.blnEditar = false;
                this.cargarTabla();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        int fila = this.jTable1.getSelectedRow();
        if(fila != -1){
            this.blnEditar = true;
            med = this.listaMedicinas.get(fila);
            this.jTextField3.setText(med.getNombre());
            this.jTextField1.setText(med.getNombreCategoria());
            this.jLabel4.setText(Integer.toString(med.getIdCategoria()));
            this.jTextField2.setText(med.getPresentacion());
        }else{
            JOptionPane.showMessageDialog(rootPane, "Seleccione una fila de la tabla", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        boolean eliminar = true;
        int fila = this.jTable1.getSelectedRow();
        med = this.listaMedicinas.get(fila);
        this.listaLotes = this.loteDAO.ConsultarLote();
        if(fila != -1){
            int opc=JOptionPane.showConfirmDialog(rootPane,"Seguro que desea eliminar el medicamento?", "Advertencia!", JOptionPane.YES_NO_OPTION);
            if (opc==JOptionPane.OK_OPTION) {
                for(int i =0; i< this.listaLotes.size(); i++){
                    if(this.listaLotes.get(i).getIdMedicamento() == med.getIdMedicamento()){
                        JOptionPane.showMessageDialog(rootPane, "", "No se puede eliminar el medicamento, su lote correspondiente aun tiene stock", JOptionPane.INFORMATION_MESSAGE);
                        eliminar = false;
                        break;
                        
                    }
                }
            }
            
            if(eliminar==true){
                this.medDAO.EliminarMedicamento(this.med.getIdMedicamento());
                JOptionPane.showMessageDialog(rootPane, "", "Medicamento eliminado exitosamente!!", JOptionPane.INFORMATION_MESSAGE);
                this.cargarTabla();
            }else{
                JOptionPane.showMessageDialog(rootPane, "El medicamento no pudo ser eliminado, intente nuevamente", "Error inesperado!!", JOptionPane.ERROR_MESSAGE);
                this.cargarTabla();
            }
            
        }
        
    }//GEN-LAST:event_EliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
