/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import Entidades.Usuario;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Entidades.*;
import EntidadesDAO.*;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author andre
 */
public class pnlGraficos extends javax.swing.JPanel {

    private ArrayList<Venta> listaVentas;
    private VentaDAO ventaDAO;
    private Venta venta;
    /**
     * Creates new form pnlGraficos
     */
    Usuario userSesion;
    public pnlGraficos() {
        initComponents();
        listaVentas = new ArrayList<>();
        ventaDAO = new VentaDAO();
        venta = new Venta();
    }
    public pnlGraficos(Usuario userSesion) {
        initComponents();
        this.userSesion = userSesion;
        listaVentas = new ArrayList<>();
        ventaDAO = new VentaDAO();
        venta = new Venta();
    }
    
    public void crearGrafico() {
        int j=0;
        this.listaVentas = this.ventaDAO.ConsultarVentas();
        
        Map<String, Integer> conteoVentas = new HashMap<>();
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        
        for (int i=0; i<this.listaVentas.size(); i++) {

            String fechaMes = new SimpleDateFormat("yyyy-MM").format(venta.getFechaVenta());
            int idVenta = this.listaVentas.get(i).getIdVenta();
            conteoVentas.put(fechaMes, conteoVentas.getOrDefault(idVenta, 0) + 1);
        }
        
        for (Map.Entry<String, Integer> entry : conteoVentas.entrySet()) {
            j++;
            String fechaMes = entry.getKey();
            int totalVentas = entry.getValue();
            int idVenta = this.listaVentas.get(j).getIdVenta();
            datos.setValue(totalVentas, "Ventas", Integer.toString(idVenta));
        }
        
        
        
        
//        // Usamos un HashMap para almacenar las fechas (por mes)
//        Map<String, Map<Integer, Integer>> conteoVentasPorMes = new HashMap<>();
//
//        // Llenar el Map con los datos
//        for (Venta venta : listaVentas) {
//            // Solo extraemos año y mes de la fecha
//            String fechaMes = new SimpleDateFormat("yyyy-MM").format(venta.getFechaVenta());
//            int idVenta = venta.getIdVenta();
//
//            
//            // Si la fecha (mes) no existe en el mapa, la agregamos
//            if (!conteoVentasPorMes.containsKey(fechaMes)) {
//                conteoVentasPorMes.put(fechaMes, new HashMap<>());
//            }
//
//            // Contar la receta para ese mes
//            Map<Integer, Integer> ventasPorMes = conteoVentasPorMes.get(fechaMes);
//            ventasPorMes.put(idVenta, ventasPorMes.getOrDefault(idVenta, 0) + 1);
//        }
//
//        // Ordenar las fechas por orden cronológico
//        ArrayList<String> fechasOrdenadas = new ArrayList<>(conteoVentasPorMes.keySet());
//        fechasOrdenadas.sort((fecha1, fecha2) -> fecha1.compareTo(fecha2));
//
//        // Crear el conjunto de datos para el gráfico
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//        
//        for (String fecha : fechasOrdenadas) {
//            Map<Integer, Integer> recetasPorMes = conteoVentasPorMes.get(fecha);
//
//            
//            for (Map.Entry<Integer, Integer> entryReceta : recetasPorMes.entrySet()) {
//                int idVenta = entryReceta.getKey();  // Nombre de la receta
//                int cantidad = entryReceta.getValue();  // Cantidad de veces seleccionada
//
//                // Asignar la fecha como X (mes) y la cantidad como Y
//                dataset.addValue(cantidad, "Ventas", fecha);  // Fecha como X, nombre de la receta como Y
//            }
//        }
//
//        // Crear el gráfico de líneas usando DefaultCategoryDataset
//        JFreeChart chart = ChartFactory.createLineChart(
//            "Recetas más Populares por Mes",  // Título
//            "Mes",  // Etiqueta eje X (mes)
//            "Cantidad de Favoritos",  // Etiqueta eje Y
//            dataset,  // Datos
//            PlotOrientation.VERTICAL,
//            true,  // Mostrar leyenda
//            true,  // Mostrar tooltip
//            false  // Mostrar URL
//        );
//
//        // Configurar el panel donde se dibujará el gráfico
//        ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setPreferredSize(jPanel1.getSize());
//        jPanel1.removeAll();  // Limpiar el panel
//        jPanel1.setLayout(new BorderLayout());
//        jPanel1.add(chartPanel, BorderLayout.CENTER);  // Agregar el gráfico al panel
//        jPanel1.revalidate();  // Redibujar el panel
//        jPanel1.repaint();  // Redibujar la interfaz
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

        setBackground(new java.awt.Color(56, 102, 65));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 720));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
