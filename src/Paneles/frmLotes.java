/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import Entidades.Lote;
import EntidadesDAO.LoteDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author andre
 */
public class frmLotes extends javax.swing.JPanel {
    
//    private cn oCon;
    private ArrayList<Lote> listaLotes;
    private DefaultTableModel tablaLotes;
    private LoteDAO loteDAO;
    private Lote lote;
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-mm-dd");
    
    /**
     * Creates new form frmLotes
     */
    public frmLotes() {
        initComponents();
        listaLotes = new ArrayList<>();
        tablaLotes = (DefaultTableModel) this.jTable1.getModel();
//        this.oCon= new cn();
        loteDAO = new LoteDAO();
        CargarTablaLotes();
        
    }

    private void CargarTablaLotes() {
        this.tablaLotes.setRowCount(0);
        this.listaLotes = this.loteDAO.ConsultarLote();
        
        for(int i=0; i<this.listaLotes.size(); i++)
        {
            try{
               String[] registroLotes={
                Integer.toString(this.listaLotes.get(i).getIdLote()),
                this.listaLotes.get(i).getNombreMedicamento(),
                Integer.toString(this.listaLotes.get(i).getCantidad()),
                this.listaLotes.get(i).getNombreProveedor(),
                this.listaLotes.get(i).getNombreUsuario(),
                Double.toString(this.listaLotes.get(i).getPrecioCosto()),
                Double.toString(this.listaLotes.get(i).getPrecioUnitario()),
                Double.toString(this.listaLotes.get(i).getPrecioMayoreo()),
                formatoFecha.format(this.listaLotes.get(i).getFecha()),
                this.listaLotes.get(i).getUbicacion()
            };
            
            this.tablaLotes.addRow(registroLotes);
            }
            catch (Exception e)
            {
                e.printStackTrace(); // Mostrar el error en consola
            }
            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(56, 102, 65));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MEDICAMENTO", "CANTIDAD", "PROVEEDOR", "USUARIO", "PRECIO", "PRECIO U", "PRECIO M", "CADUCIDAD", "UBICACION"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 630, 580));
        add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 450, 270, 40));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Límite stock");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 190, 120, 30));
        add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 218, 120, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precio B");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 330, 80, 30));
        add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 218, 110, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cantidad");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 120, 30));

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, 270, 40));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Producto");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, 120, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Producto");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 120, -1));

        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 272, 270, 40));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Costo");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 250, 120, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Lotes/btnComprarLote.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 503, 270, 50));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Precio C");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 330, 80, 30));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Fecha caducidad");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 410, 200, 40));

        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 360, 80, 40));

        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 360, 90, 40));

        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(931, 360, 80, 40));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Precio A");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, 80, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Lotes/btnOrdenar.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 30, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Lotes/btnFiltrar.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 30, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Lotes/FondoLabel.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 720));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
