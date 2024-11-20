/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import Entidades.Usuario;
import Entidades.*;
import EntidadesDAO.*;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author andre
 */
public class pnlGraficos extends javax.swing.JPanel {

    private ArrayList<Venta> listaVentas;
    private VentaDAO ventaDAO;
    private Venta venta;
    private ArrayList<DetalleVenta> listaDetalles;
    private DetalleVenta detalle;
    private DetalleVentaDAO detalleDAO;
    /**
     * Creates new form pnlGraficos
     */
    Usuario userSesion;
    public pnlGraficos() {
        initComponents();
        listaVentas = new ArrayList<>();
        ventaDAO = new VentaDAO();
        venta = new Venta();
        listaDetalles = new ArrayList<>();
        detalleDAO = new DetalleVentaDAO();
        detalle = new DetalleVenta();
        crearGraficoVentas();
        graficoBarras();
        
    }
    public pnlGraficos(Usuario userSesion) {
        initComponents();
        this.userSesion = userSesion;
        listaVentas = new ArrayList<>();
        ventaDAO = new VentaDAO();
        venta = new Venta();
        listaDetalles = new ArrayList<>();
        detalleDAO = new DetalleVentaDAO();
        detalle = new DetalleVenta();
        crearGraficoVentas();
        graficoBarras();
                
        
    }
    
    public void graficoBarras(){
        
        this.listaDetalles=  this.detalleDAO.ConsultarDetalles();
        // Agrupar las cantidades vendidas por nombre de medicamento.
        Map<String, Integer> conteoMedicinas = new HashMap<>();
        for (DetalleVenta detalle : listaDetalles) {
            String nombreMedicamento = detalle.getNombreMedicamento();
            conteoMedicinas.put(
                nombreMedicamento,
                conteoMedicinas.getOrDefault(nombreMedicamento, 0) + detalle.getCantidad()
            );
        }

        // Ordenar las medicinas por cantidad y tomar las 10 más vendidas.
        Map<String, Integer> topMedicinas = conteoMedicinas.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .limit(10)
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                HashMap::new
            ));

        // Crear el conjunto de datos para el gráfico de barras.
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : topMedicinas.entrySet()) {
            dataset.addValue(entry.getValue(), "Cantidad Vendida", entry.getKey());
        }

        // Crear el gráfico de barras.
        JFreeChart barChart = ChartFactory.createBarChart(
            "Top 10 Medicinas Más Vendidas", // Título
            "Medicinas",                    // Etiqueta eje X
            "Cantidad Vendida",             // Etiqueta eje Y
            dataset,                        // Datos
            PlotOrientation.VERTICAL,       // Orientación del gráfico
            true,                           // Incluir leyenda
            true,                           // Incluir tooltips
            false                           // No incluir URLs
        );

        // Configuración del panel del gráfico.
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(jPanel3.getSize());
        jPanel3.removeAll();
        jPanel3.setLayout(new BorderLayout());
        jPanel3.add(chartPanel, BorderLayout.CENTER);
        jPanel3.revalidate();
        jPanel3.repaint();
    }
    public void crearGraficoVentas() {
        
        this.listaVentas = this.ventaDAO.ConsultarVentas();

        // Usamos un HashMap para almacenar las ventas agrupadas por mes.
        Map<String, Integer> conteoVentas = new HashMap<>();
        SimpleDateFormat formatoMes = new SimpleDateFormat("yyyy-MM");

        for (Venta venta : listaVentas) {
            String fechaMes = formatoMes.format(venta.getFechaVenta());
            conteoVentas.put(fechaMes, conteoVentas.getOrDefault(fechaMes, 0) + 1);
        }

        // Creamos el conjunto de datos para el gráfico.
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : conteoVentas.entrySet()) {
            dataset.addValue(entry.getValue(), "Ventas", entry.getKey());
        }

        // Crear el gráfico de líneas.
        JFreeChart chart = ChartFactory.createLineChart(
            "Ventas por Mes",           // Título del gráfico
            "Mes",                      // Etiqueta del eje X
            "Cantidad de Ventas",       // Etiqueta del eje Y
            dataset,                    // Datos
            PlotOrientation.VERTICAL,   // Orientación del gráfico
            true,                       // Incluir leyenda
            true,                       // Incluir tooltips
            false                       // URLs no necesarias
        );

        // Configuración del panel del gráfico.
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(jPanel2.getSize());
        jPanel2.removeAll();
        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(chartPanel, BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
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
        pnlPrincipal = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(56, 102, 65));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlPrincipal.setBackground(new java.awt.Color(56, 102, 65));

        jTabbedPane1.addTab("Gráfico de ventas", jPanel2);
        jTabbedPane1.addTab("Productos más vendidos", jPanel3);

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jPanel1.add(pnlPrincipal);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 720));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
