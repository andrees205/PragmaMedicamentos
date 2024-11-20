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
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.Document;

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
        this.listaLotes = this.loteDAO.ConsultarLote();
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
        this.tablaCustom1.clearTable();
        String[] columnas = {
            "ID",
            "MEDICAMENTO",
            "CANTIDAD",
            "LIMITE",
            "PROVEEDOR",
            "USUARIO",
            "PRECIO",
            "PRECIO UNITARIO",
            "PRECIO MAYOREO",
            "FECHA",
            "UBICACION"
        };

        this.tablaCustom1.setColumnNames(columnas);

        

        for (int i = 0; i < this.listaLotes.size(); i++) {
            try {
                Vector<Object> rowData = new Vector<>();
                rowData.add(Integer.toString(this.listaLotes.get(i).getIdLote()));
                rowData.add(this.listaLotes.get(i).getNombreMedicamento());
                rowData.add(Integer.toString(this.listaLotes.get(i).getCantidad()));
                rowData.add(Integer.toString(this.listaLotes.get(i).getLimite()));
                rowData.add(this.listaLotes.get(i).getNombreProveedor());
                rowData.add(this.listaLotes.get(i).getNombreUsuario());
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

        jPanel2 = new javax.swing.JPanel();
        tablaCustom1 = new Clases.tablaCustom();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(56, 102, 65));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaCustom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCustom1MouseClicked(evt);
            }
        });
        jPanel2.add(tablaCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 1020, 500));

        jButton1.setText("Generar reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 60, 120, 40));

        jButton4.setText("Recargar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 100, 30));

        jButton3.setText("Stock al limite");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 620, 120, 30));

        jButton2.setText("Productos caducados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 620, 150, 30));

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

    private void tablaCustom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCustom1MouseClicked

    }//GEN-LAST:event_tablaCustom1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        generarReporte();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.listaLotes = this.loteDAO.ConsultarLotesAgotados();
        this.CargarTabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        this.listaLotes = this.loteDAO.ConsultarLotesVencidos();
        this.CargarTabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.listaLotes = this.loteDAO.ConsultarLote();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void generarReporte() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        int resultado = fileChooser.showSaveDialog(null);
        File rutaSeleccionada = null;

        if (resultado == JFileChooser.APPROVE_OPTION) {
            rutaSeleccionada = fileChooser.getSelectedFile();

            if (!rutaSeleccionada.getAbsolutePath().endsWith(".pdf")) {
                rutaSeleccionada = new File(rutaSeleccionada.getAbsolutePath() + ".pdf");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se seleccionó ninguna ruta", "¡¡ERROR!!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        com.itextpdf.text.Document documento = new com.itextpdf.text.Document();

        try {
            ArrayList<Lote> listadoLotes = this.loteDAO.ConsultarLote();

            PdfWriter.getInstance(documento, new FileOutputStream(rutaSeleccionada));
            documento.open();

            // Fuente del título
            com.itextpdf.text.Font fuenteDelTitulo = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 18, com.itextpdf.text.Font.BOLD);
            Paragraph titulo = new Paragraph("Reporte de Inventario", fuenteDelTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            // Espacio entre el título y la tabla
            documento.add(new Paragraph("\n"));

            // Crear tabla con encabezados
            PdfPTable tabla = new PdfPTable(9); // 9 columnas
            tabla.setWidthPercentage(100);
            tabla.setSpacingBefore(10f);
            tabla.setSpacingAfter(10f);
            tabla.setWidths(new float[]{2, 3, 2, 3, 3, 2, 2, 2, 3}); // Ajusta proporciones de las columnas

            // Encabezados
            String[] encabezados = {
                "ID", "Medicamento", "Cantidad", "Proveedor", "Usuario",
                "Precio Unitario", "Precio Mayoreo", "Precio Costo", "Fecha Vencimiento"
            };
            for (String encabezado : encabezados) {
                PdfPCell celdaEncabezado = new PdfPCell(new Paragraph(encabezado));
                celdaEncabezado.setHorizontalAlignment(Element.ALIGN_CENTER);
                celdaEncabezado.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.addCell(celdaEncabezado);
            }

            // Agregar datos
            for (Lote lote : listadoLotes) {
                tabla.addCell(String.valueOf(lote.getIdLote()));
                tabla.addCell(lote.getNombreMedicamento() != null ? lote.getNombreMedicamento() : "N/A");
                tabla.addCell(String.valueOf(lote.getCantidad()));
                tabla.addCell(lote.getNombreProveedor() != null ? lote.getNombreProveedor() : "N/A");
                tabla.addCell(lote.getNombreUsuario() != null ? lote.getNombreUsuario() : "N/A");
                tabla.addCell(String.valueOf(lote.getPrecioUnitario()));
                tabla.addCell(String.valueOf(lote.getPrecioMayoreo()));
                tabla.addCell(String.valueOf(lote.getPrecioCosto()));
                tabla.addCell(lote.getFecha() != null ? lote.getFecha().toString() : "N/A");
            }

            documento.add(tabla);
            JOptionPane.showMessageDialog(null, "PDF generado correctamente en: " + rutaSeleccionada.getAbsolutePath());
        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (documento.isOpen()) {
                documento.close();
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private Clases.tablaCustom tablaCustom1;
    // End of variables declaration//GEN-END:variables
}
