/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Entidades.Lote;
import Entidades.Usuario;
import EntidadesDAO.LoteDAO;
import Paneles.frmVenta;
import TablaCustom.MiTablaCustom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author andre
 */
public class frmInventarioPequeño extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmInventarioPequeño4
     */
    private Usuario userSesion;
    private ArrayList<Lote> listaLotes;
//    private DefaultTableModel tablaLotes;
    private LoteDAO loteDAO;
    private Lote lote;
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-mm-dd");
    frmVenta parentVenta;

    public frmInventarioPequeño() {
        initComponents();
        listaLotes = new ArrayList<>();
//        tablaLotes = (DefaultTableModel) this.jTable1.getModel();
        loteDAO = new LoteDAO();
//        CargarTablaLotes();
        CargarTabla();
    }
    
        public frmInventarioPequeño(frmVenta parentFrm) {
        initComponents();
        this.parentVenta  = parentFrm;
        listaLotes = new ArrayList<>();
//        tablaLotes = (DefaultTableModel) this.jTable1.getModel();
        loteDAO = new LoteDAO();
//        CargarTablaLotes();
        CargarTabla();
    }

    private void CargarTabla() {

        String[] columnas = {
            "ID",
            "MEDICAMENTO",
            "CANTIDAD",
            "PRECIO",
            "PRECIO UNITARIO",
            "PRECIO MAYOREO",
            "FECHA",
            "UBICACION"
        };

        this.tablaCustom1.setColumnNames(columnas);

        this.listaLotes = this.loteDAO.ConsultarLote();

        for (int i = 0; i < this.listaLotes.size(); i++) {
            try {
                Vector<Object> rowData = new Vector<>();
                rowData.add(Integer.toString(this.listaLotes.get(i).getIdLote()));
                rowData.add(this.listaLotes.get(i).getNombreMedicamento());
                rowData.add(Integer.toString(this.listaLotes.get(i).getCantidad()));
                //rowData.add(this.listaLotes.get(i).getNombreProveedor());
                //rowData.add(this.listaLotes.get(i).getNombreUsuario());
                rowData.add(Double.toString(this.listaLotes.get(i).getPrecioCosto()));
                rowData.add(Double.toString(this.listaLotes.get(i).getPrecioUnitario()));
                rowData.add(Double.toString(this.listaLotes.get(i).getPrecioMayoreo()));
                rowData.add(formatoFecha.format(this.listaLotes.get(i).getFecha()));
                rowData.add(this.listaLotes.get(i).getUbicacion());

                this.tablaCustom1.addRow(rowData);
            } catch (Exception e) {
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

        jPanel1 = new javax.swing.JPanel();
        tablaCustom1 = new Clases.tablaCustom();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaCustom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCustom1MouseClicked(evt);
            }
        });
        jPanel1.add(tablaCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 500, 540));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Categoria/lblFondoPequeño (2).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaCustom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCustom1MouseClicked
        int filaSeleccionada = this.tablaCustom1.getSelectedRow();
        int idInventario = (int) this.tablaCustom1.getValueAt(filaSeleccionada, 0);
        Lote loteSeleccionado = this.loteDAO.ConsultarLotePorID(idInventario);
        this.parentVenta.ObtenerLoteSeleccionado(loteSeleccionado);
        this.dispose();
    }//GEN-LAST:event_tablaCustom1MouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private Clases.tablaCustom tablaCustom1;
    // End of variables declaration//GEN-END:variables
}
