/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Entidades.Lote;
import Entidades.Usuario;
import EntidadesDAO.LoteDAO;
import Paneles.frmVenta;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
    private DefaultTableModel modeloLotes;
    private LoteDAO loteDAO;
    private Lote lote;
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-mm-dd");
    frmVenta parentVenta;

        public frmInventarioPequeño() {
        initComponents();
        listaLotes = new ArrayList<>();
        modeloLotes = (DefaultTableModel) this.tblInventario.getModel();
        loteDAO = new LoteDAO();
//        CargarTablaLotes();
        CargarTabla();
    }
    
        public frmInventarioPequeño(frmVenta parentFrm) {
        initComponents();
        this.parentVenta  = parentFrm;
        configurarListenerBusqueda();
        listaLotes = new ArrayList<>();
        modeloLotes = (DefaultTableModel) this.tblInventario.getModel();
        loteDAO = new LoteDAO();
//        CargarTablaLotes();
        CargarTabla();
    }

    private void CargarTabla() {

        listaLotes = loteDAO.ConsultarLote();
        this.modeloLotes.setRowCount(0);
        
        for (int i = 0; i < this.listaLotes.size(); i++) {
            Lote lote = this.listaLotes.get(i);
            
            String[] data = {
                String.valueOf(lote.getIdLote()),
                lote.getNombreMedicamento(),
                String.valueOf(lote.getCantidad()),
                String.valueOf(lote.getPrecioCosto()),
                String.valueOf(lote.getPrecioUnitario()),
                String.valueOf(lote.getPrecioMayoreo()),
                String.valueOf(lote.getFecha()),
                lote.getUbicacion()
            };
            
            this.modeloLotes.addRow(data);
        }
        
        this.tblInventario.setModel(modeloLotes);
    }
    
private void filtrarTabla(String textoBusqueda) {
    // Crear el RowFilter que busca coincidencias en la columna de nombres de medicamentos
    RowFilter<Object, Object> rf = RowFilter.regexFilter("(?i)" + textoBusqueda, 1); // 1 es el índice de la columna 'Nombre Medicamento'

    // Aplicar el filtro al modelo
    TableRowSorter<TableModel> sorter = new TableRowSorter<>(modeloLotes);
    sorter.setRowFilter(rf);
    tblInventario.setRowSorter(sorter);
}
private void configurarListenerBusqueda() {
    txtBuscar.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            actualizarFiltro();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            actualizarFiltro();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            actualizarFiltro();
        }

        // Método que actualiza el filtro al cambiar el texto
        private void actualizarFiltro() {
            // Obtener el texto de búsqueda
            String textoBusqueda = txtBuscar.getText(); // Asegúrate de que txtBuscar es el campo de texto donde el usuario ingresa el término de búsqueda

            // Llamar al método de filtrado
            filtrarTabla(textoBusqueda);
        }
    });
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Medicamento", "Cantidad", "Costo", "Unidad", "Mayoreo", "Fecha vencimiento", "Ubicacion"
            }
        ));
        tblInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInventarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInventario);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 530, 510));
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 520, 30));

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

    private void tblInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInventarioMouseClicked
        int filaSeleccionada = this.tblInventario.getSelectedRow();
        
        //int idInventario = Integer.parseInt(this.tblInventario.getValueAt(filaSeleccionada, 0).toString());
        //Lote loteSeleccionado = this.loteDAO.ConsultarLotePorID(idInventario);
        Lote loteSeleccionado = this.listaLotes.get(filaSeleccionada);
        this.parentVenta.ObtenerLoteSeleccionado(loteSeleccionado);
        this.dispose();

    }//GEN-LAST:event_tblInventarioMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
