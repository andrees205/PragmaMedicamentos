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
        tablaCustom1 = new Clases.tablaCustom();
        jButton1 = new javax.swing.JButton();
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
        } 
        else {
            JOptionPane.showMessageDialog(null, "No se seleccionó ninguna ruta", "¡¡ERROR!!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        com.itextpdf.text.Document documento = new com.itextpdf.text.Document();

        try {
            ArrayList<Lote> listadoLotes = this.loteDAO.ConsultarLote();
            
            PdfWriter.getInstance(documento, new FileOutputStream(rutaSeleccionada));
            documento.open();

            com.itextpdf.text.Font fuenteDelTitulo = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 18, com.itextpdf.text.Font.BOLD);
            Paragraph titulo = new Paragraph("Reporte de Inventario", fuenteDelTitulo);
            titulo.setAlignment(Element.ALIGN_LEFT);
            
            String rutaImagen = "src/Elementos/Login LogoPragma.png";
            Image imagen = Image.getInstance(rutaImagen);
            imagen.scaleToFit(150, 50); // Ajustar el tamaño de la imagen

            // Crear una tabla para organizar el título y la imagen
            PdfPTable encabezado = new PdfPTable(2); // 2 columnas
            encabezado.setWidthPercentage(100); // Ancho total de la página
            encabezado.setWidths(new float[]{3, 1}); // Proporción de columnas (3:1)

            // Celda para el título
            PdfPCell celdaTitulo = new PdfPCell(titulo);
            celdaTitulo.setBorder(PdfPCell.NO_BORDER); // Sin bordes
            celdaTitulo.setVerticalAlignment(Element.ALIGN_MIDDLE); // Alinear al centro verticalmente

            // Celda para la imagen
            PdfPCell celdaImagen = new PdfPCell(imagen);
            celdaImagen.setBorder(PdfPCell.NO_BORDER); // Sin bordes
            celdaImagen.setHorizontalAlignment(Element.ALIGN_RIGHT); // Alinear a la derecha
            celdaImagen.setVerticalAlignment(Element.ALIGN_MIDDLE);

            // Agregar las celdas a la tabla
            encabezado.addCell(celdaTitulo);
            encabezado.addCell(celdaImagen);

            // Agregar la tabla al documento
            documento.add(encabezado);

            // Espacio entre encabezado y contenido
            documento.add(new Paragraph("\n"));

            // Crear la tabla del reporte
            PdfPTable tabla = new PdfPTable(6);
            tabla.setWidthPercentage(100);
            tabla.setSpacingBefore(10f);
            tabla.setSpacingAfter(10f);

            // Encabezados de la tabla
            PdfPCell encabezadoIDDetalleVenta = new PdfPCell(new Paragraph("ID"));
            PdfPCell encabezadoProducto = new PdfPCell(new Paragraph("Producto"));
            PdfPCell encabezadoCategoria = new PdfPCell(new Paragraph("Categoria"));
            PdfPCell encabezadoFechaCompra = new PdfPCell(new Paragraph("Fecha Compra"));
            PdfPCell encabezadoCantidad = new PdfPCell(new Paragraph("Cantidad"));
            PdfPCell encabezadoPrecioUnitario = new PdfPCell(new Paragraph("Precio Unitario"));

            // Alinear el texto en los encabezados
            encabezadoIDDetalleVenta.setHorizontalAlignment(Element.ALIGN_CENTER);
            encabezadoProducto.setHorizontalAlignment(Element.ALIGN_CENTER);
            encabezadoCategoria.setHorizontalAlignment(Element.ALIGN_CENTER);
            encabezadoFechaCompra.setHorizontalAlignment(Element.ALIGN_CENTER);
            encabezadoCantidad.setHorizontalAlignment(Element.ALIGN_CENTER);
            encabezadoPrecioUnitario.setHorizontalAlignment(Element.ALIGN_CENTER);

            // Agregar los encabezados a la tabla
            tabla.addCell(encabezadoIDDetalleVenta);
            tabla.addCell(encabezadoProducto);
            tabla.addCell(encabezadoCategoria);
            tabla.addCell(encabezadoFechaCompra);
            tabla.addCell(encabezadoCantidad);
            tabla.addCell(encabezadoPrecioUnitario);

            // Agregar los datos de la tabla jtPersonajes

            for (int i = 0; i < listadoLotes.size(); i++) {
                tabla.addCell(String.valueOf(listadoLotes.get(i).getIdLote()));
                tabla.addCell(listadoLotes.get(i).getNombreMedicamento());
                tabla.addCell(String.valueOf(listadoLotes.get(i).getCantidad()));
                tabla.addCell(listadoLotes.get(i).getNombreProveedor());
                tabla.addCell(listadoLotes.get(i).getNombreUsuario());
                tabla.addCell(String.valueOf(listadoLotes.get(i).getPrecioCosto()));
                tabla.addCell(String.valueOf(listadoLotes.get(i).getPrecioMayoreo()));
                tabla.addCell(String.valueOf(listadoLotes.get(i).getPrecioUnitario()));
                tabla.addCell(listadoLotes.get(i).getFecha().toString());
            }

            // Agregar la tabla al documento
            documento.add(tabla);

            JOptionPane.showMessageDialog(null, "PDF generado correctamente en: " + rutaSeleccionada.getAbsolutePath());
        } 
        catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            documento.close();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private Clases.tablaCustom tablaCustom1;
    // End of variables declaration//GEN-END:variables
}
