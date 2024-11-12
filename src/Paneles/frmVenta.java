/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import Entidades.Medicamento;
import Entidades.Usuario;
import Entidades.Venta;
import EntidadesDAO.MedicamentoDAO;
import EntidadesDAO.VentaDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Entidades.Lote;
import EntidadesDAO.LoteDAO;

/**
 *
 * @author andre
 */
public class frmVenta extends javax.swing.JPanel {

    private ArrayList<Venta> listaVentas;
    private DefaultTableModel tablaVentas;
    private VentaDAO ventaDAO;
    private Venta venta;
    private Usuario userSesion;
    private ArrayList<Medicamento> listaMedicamentos;
    private MedicamentoDAO medDAO;
    private ArrayList<Lote> listaLotes;
    private LoteDAO loteDAO;
    private Lote lote;
    /**
     * Creates new form frmCarrito
     */
    public frmVenta() {
        initComponents();
        listaVentas = new ArrayList<>();
        tablaVentas = (DefaultTableModel) this.jTable1.getModel();
        ventaDAO = new VentaDAO();
        listaMedicamentos = new ArrayList<>();
        medDAO = new MedicamentoDAO();
        CargarTablaVentas();
        CargarMedicamentos();
        loteDAO = new LoteDAO();
        listaLotes = new ArrayList<>();
        CargarLotes();
    }
    
        public frmVenta(Usuario userFrmPrincipal) {
        initComponents();
        this.userSesion = userFrmPrincipal;
        listaVentas = new ArrayList<>();
        tablaVentas = (DefaultTableModel) this.jTable1.getModel();
        ventaDAO = new VentaDAO();
        listaMedicamentos = new ArrayList<>();
        medDAO = new MedicamentoDAO();
        CargarTablaVentas();
        //CargarMedicamentos();
        loteDAO = new LoteDAO();
        listaLotes = new ArrayList<>();
        CargarLotes();
        
    }
    
    private void CargarTablaVentas() {
        this.tablaVentas.setRowCount(0);
        this.listaVentas = this.ventaDAO.ConsultarVentas();
        
        for(int i=0; i<this.listaVentas.size(); i++)
        {
            try{
               String[] registroVentas={
                Integer.toString(this.listaVentas.get(i).getIdVenta()),
                this.listaVentas.get(i).getNombreUsuario(),
                this.listaVentas.get(i).getNombreCliente(),
                Double.toString(this.listaVentas.get(i).getMontoTotal())
            };
            
            this.tablaVentas.addRow(registroVentas);
            }
            catch (Exception e)
            {
                e.printStackTrace(); // Mostrar el error en consola
            }
            
        }
    }
    

    
    private void CargarMedicamentos()
    {
        this.listaMedicamentos = this.medDAO.ConsultarMedicamento();
        
        this.jComboBox1.removeAllItems();
        for (int i=0; i<this.listaMedicamentos.size(); i++)
        {
            this.jComboBox1.addItem(this.listaMedicamentos.get(i).getNombre());
        }
    }

    private void CargarLotes()
    {
        this.listaLotes = this.loteDAO.ConsultarLote();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(56, 102, 65));
        setPreferredSize(new java.awt.Dimension(280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "USUARIO", "CLIENTE", "MONTO TOTAL"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 600, 580));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Venta/btnAgregar.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 500, 270, 40));

        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, 270, 40));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Venta/btnVender.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 560, 280, 50));
        add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 370, -1, -1));
        add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 370, -1, -1));
        add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 370, -1, -1));

        jSpinner1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 230, 110, 30));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Fecha");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 100, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("C");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 370, 20, 30));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("B");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 370, 20, 30));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("A");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, 40, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Precio");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 280, 100, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 230, 100, 40));

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, 280, 30));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Producto");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, 120, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Venta/FondoLabel.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 1090, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        
        int idMed = this.jComboBox1.getSelectedIndex();
        
        for(int i=0; i<this.listaLotes.size();i++){
            if(this.listaLotes.get(i).getIdMedicamento() == idMed){
                
                this.jLabel7.setText(Double.toString(this.listaLotes.get(i).getPrecioCosto()));
                this.jLabel8.setText(Double.toString(this.listaLotes.get(i).getPrecioUnitario()));
                this.jLabel6.setText(Double.toString(this.listaLotes.get(i).getPrecioMayoreo()));
                break;
            }
        }
    }//GEN-LAST:event_jComboBox1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
