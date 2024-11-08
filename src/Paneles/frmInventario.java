/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import Entidades.Lote;
import Entidades.Usuario;
import EntidadesDAO.LoteDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Vistas.frmAdministrador;
import java.util.Vector;
/**
 *
 * @author andre
 */
public class frmInventario extends javax.swing.JPanel {

    /**
     * Creates new form frmInventario
     */
    
    private Usuario userSesion;
    private ArrayList<Lote> listaLotes;
//    private DefaultTableModel tablaLotes;
    private LoteDAO loteDAO;
    private Lote lote;
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-mm-dd");
    public frmInventario() {
        initComponents();
        
        listaLotes = new ArrayList<>();
//        tablaLotes = (DefaultTableModel) this.jTable1.getModel();
        loteDAO = new LoteDAO();
//        CargarTablaLotes();
         CargarTabla();
    }
    
    public frmInventario(Usuario userFrmPrincipal) {
        initComponents();
        this.userSesion = userFrmPrincipal;
        this.jLabel1.setText(this.userSesion.getNombre());
        listaLotes = new ArrayList<>();
//        tablaLotes = (DefaultTableModel) this.jTable1.getModel();
        loteDAO = new LoteDAO();
//        CargarTablaLotes();
        CargarTabla();
    }

//        private void CargarTablaLotes() {
//        this.tablaLotes.setRowCount(0);
//        this.listaLotes = this.loteDAO.ConsultarLote();
//        
//        for(int i=0; i<this.listaLotes.size(); i++)
//        {
//            try{
//               String[] registroLotes={
//                Integer.toString(this.listaLotes.get(i).getIdLote()),
//                this.listaLotes.get(i).getNombreMedicamento(),
//                Integer.toString(this.listaLotes.get(i).getCantidad()),
//                this.listaLotes.get(i).getNombreProveedor(),
//                this.listaLotes.get(i).getNombreUsuario(),
//                Double.toString(this.listaLotes.get(i).getPrecioCosto()),
//                Double.toString(this.listaLotes.get(i).getPrecioUnitario()),
//                Double.toString(this.listaLotes.get(i).getPrecioMayoreo()),
//                formatoFecha.format(this.listaLotes.get(i).getFecha()),
//                this.listaLotes.get(i).getUbicacion()
//            };
//            
//            this.tablaLotes.addRow(registroLotes);
//            }
//            catch (Exception e)
//            {
//                e.printStackTrace(); // Mostrar el error en consola
//            }
//            
//        }
//    }
        
        private void CargarTabla() {
        
        String[] columnas={
            "ID",
            "MEDICAMENTO",
            "CANTIDAD",
            "PROVEEDOR",
            "USUARIO",
            "PRECIO",
            "PRECIO UNITARIO",
            "PRECIO MAYOREO",
            "FECHA",
            "UBICACION"
        };
        
        this.tablaCustom1.setColumnNames(columnas);
        
        this.listaLotes = this.loteDAO.ConsultarLote();
        
        for(int i=0; i<this.listaLotes.size(); i++)
        {
            try{
                Vector<Object> rowData = new Vector<>();
                rowData.add(Integer.toString(this.listaLotes.get(i).getIdLote()));
                rowData.add(this.listaLotes.get(i).getNombreMedicamento());
                rowData.add(Integer.toString(this.listaLotes.get(i).getCantidad()));
                rowData.add(this.listaLotes.get(i).getNombreProveedor());
                rowData.add(this.listaLotes.get(i).getNombreUsuario());
                rowData.add(Double.toString(this.listaLotes.get(i).getPrecioCosto()));
                rowData.add(Double.toString(this.listaLotes.get(i).getPrecioUnitario()));
                rowData.add(Double.toString(this.listaLotes.get(i).getPrecioMayoreo()));
                rowData.add(formatoFecha.format(this.listaLotes.get(i).getFecha()));
                rowData.add(this.listaLotes.get(i).getUbicacion());
            
            this.tablaCustom1.addRow(rowData);
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

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        tablaCustom1 = new Clases.tablaCustom();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(56, 102, 65));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MEDICAMENTO", "CANTIDAD", "PROVEEDOR", "USUARIO", "PRECIO", "PRECIO U", "PRECIO M", "CADUCIDAD", "UBICACION"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 1020, 200));

        jTextField1.setText("Buscar...");
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, 210, 40));
        jPanel2.add(tablaCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 1020, 270));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Inventario/Circulo.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 110, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1111, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 784, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private Clases.tablaCustom tablaCustom1;
    // End of variables declaration//GEN-END:variables
}
