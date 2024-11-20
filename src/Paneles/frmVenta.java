/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import Entidades.Cliente;
import Entidades.Medicamento;
import Entidades.Usuario;
import Entidades.Venta;
import Entidades.DetalleVenta;
import EntidadesDAO.MedicamentoDAO;
import EntidadesDAO.DetalleVentaDAO;
import EntidadesDAO.VentaDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Entidades.Lote;
import EntidadesDAO.LoteDAO;
import Vistas.frmAdministrador;
import Vistas.frmCategoria;
import Vistas.frmClienteSeleccionar;
import Vistas.frmInventarioPequeño;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class frmVenta extends javax.swing.JPanel {

    private ArrayList<Venta> listaVentas;
    private ArrayList<DetalleVenta> carritoDetalleVenta;
    private ArrayList<DetalleVenta> listaDetallesVenta;
    private DefaultTableModel modeloDetalle;
    private DefaultTableModel modeloMaestro;
    private DefaultTableModel modeloMaestroDetalle;
    private VentaDAO ventaDAO;
    private Venta venta;
    private Usuario userSesion;
    private ArrayList<Medicamento> listaMedicamentos;
    private MedicamentoDAO medDAO;
    private ArrayList<Lote> listaLotes;
    private LoteDAO loteDAO;
    private Lote lote;
    private Lote loteSeleccionado;
    private DetalleVenta detalleVenta;
    private DetalleVentaDAO detalleVentaDAO;
    private Component rootPane;
    double totalPagar;
    Cliente clienteSeleccionado;
    frmAdministrador parent;
    DecimalFormat df = new DecimalFormat("#.00");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form frmCarrito
     */
    public frmVenta() {
        initComponents();

        listaVentas = new ArrayList<>();
        carritoDetalleVenta = new ArrayList<>();
        modeloDetalle = (DefaultTableModel) this.tblCarrito.getModel();
        ventaDAO = new VentaDAO();
        listaMedicamentos = new ArrayList<>();
        medDAO = new MedicamentoDAO();
        CargarTablaVentas();
        //CargarMedicamentos();
        loteDAO = new LoteDAO();
        listaLotes = new ArrayList<>();
        venta = new Venta();
        detalleVenta = new DetalleVenta();
        detalleVentaDAO = new DetalleVentaDAO();
        //CargarLotes();
        cargarDetalleVenta();
    }

    public frmVenta(Usuario userFrmPrincipal, frmAdministrador parent) {
        initComponents();
        this.parent = parent;
        this.userSesion = userFrmPrincipal;
        this.loteSeleccionado = new Lote();
        listaVentas = new ArrayList<>();
        listaDetallesVenta = new ArrayList<>();
        modeloDetalle = (DefaultTableModel) this.tblCarrito.getModel();
        modeloMaestro = (DefaultTableModel) this.tblVentasMaestro.getModel();
        modeloMaestroDetalle = (DefaultTableModel) this.tblDetalleVenta.getModel();
        ventaDAO = new VentaDAO();
        listaMedicamentos = new ArrayList<>();
        medDAO = new MedicamentoDAO();
        this.clienteSeleccionado = new Cliente();
        CargarTablaVentas();
        //CargarMedicamentos();
        loteDAO = new LoteDAO();
        listaLotes = new ArrayList<>();
        venta = new Venta();
        carritoDetalleVenta = new ArrayList<>();
        detalleVenta = new DetalleVenta();
        detalleVentaDAO = new DetalleVentaDAO();
        //CargarLotes();
        //cargarDetalleVenta();

        jDateChooser1.setDate(new Date());
    }

    private void cargarDetalleVenta() {
        this.carritoDetalleVenta = this.detalleVentaDAO.ConsultarDetalles();
    }

private void CargarTablaVentas() { 
    this.modeloMaestro.setRowCount(0);  // Limpiar la tabla antes de cargar los nuevos datos
    
    // Obtener las ventas desde la base de datos
    this.listaVentas = this.ventaDAO.ConsultarVentas(); 
    
    // Recorrer la lista de ventas
    for (int i = 0; i < this.listaVentas.size(); i++) { 
        try { 
             String fechaVenta = sdf.format(this.listaVentas.get(i).getFechaVenta());
            // Crear el arreglo de registros para cada fila
            String[] registroVentas = { 
                Integer.toString(this.listaVentas.get(i).getIdVenta()), 
                this.listaVentas.get(i).getNombreUsuario(), 
                this.listaVentas.get(i).getNombreCliente(), 
                Double.toString(this.listaVentas.get(i).getMontoTotal()), 
                fechaVenta    // Aquí estaba el error: falta la coma y el punto y coma era innecesario
            }; 
            
            // Añadir el registro a la tabla
            this.modeloMaestro.addRow(registroVentas); 
        } catch (Exception e) { 
            e.printStackTrace();  // Mostrar el error en consola 
        } 
    } 
}



    /*private void CargarMedicamentos()
    {
        this.listaMedicamentos = this.medDAO.ConsultarMedicamento();
        
        this.jComboBox1.removeAllItems();
        for (int i=0; i<this.listaMedicamentos.size(); i++)
        {
            this.jComboBox1.addItem(this.listaMedicamentos.get(i).getNombre());
        }
    }*/
 /*private void CargarLotes() {
        this.listaLotes = this.loteDAO.ConsultarLote();
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu2 = new javax.swing.JPopupMenu();
        menuEditar = new javax.swing.JMenuItem();
        menuEliminar = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarrito = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtPrecio = new javax.swing.JTextField();
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
        txtProducto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVentasMaestro = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDetalleVenta = new javax.swing.JTable();

        menuEditar.setText("Editar");
        menuEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarActionPerformed(evt);
            }
        });
        jPopupMenu2.add(menuEditar);

        menuEliminar.setText("Eliminar");
        menuEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliminarActionPerformed(evt);
            }
        });
        jPopupMenu2.add(menuEliminar);

        setBackground(new java.awt.Color(56, 102, 65));
        setPreferredSize(new java.awt.Dimension(280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(56, 102, 65));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Medicamento/btnBuscar.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 190, 40, 40));

        tblCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicamento", "Cantidad", "Precio unitario", "Subtotal"
            }
        ));
        tblCarrito.setComponentPopupMenu(jPopupMenu2);
        jScrollPane1.setViewportView(tblCarrito);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 600, 580));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Venta/btnAgregar.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 500, 270, 40));

        txtPrecio.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecio.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, 270, 40));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Venta/btnVender.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 560, 280, 50));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 370, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 370, -1, -1));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 370, -1, -1));

        jSpinner1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jPanel1.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 240, 110, 30));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Fecha");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 100, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("C");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 370, 20, 30));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("B");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 370, 20, 30));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("A");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, 40, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Precio");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 280, 100, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 240, 100, 40));

        txtProducto.setEditable(false);
        txtProducto.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 280, 40));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Producto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 120, -1));

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 452, 280, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Medicamento/btnBuscar.png"))); // NOI18N
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 110, 40, 40));

        txtCliente.setEditable(false);
        txtCliente.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 280, 40));

        lblTotal.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setText("jLabel10");
        jPanel1.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 640, 190, 30));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cliente");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 120, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elementos/Venta/FondoLabel.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 710));

        jTabbedPane1.addTab("Generar Venta", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblVentasMaestro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Usuario", "Cliente", "Monto Total", "Fecha"
            }
        ));
        tblVentasMaestro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVentasMaestroMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblVentasMaestro);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 500, 590));

        tblDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ID Venta", "Cantidad", "Precio Vendido", "Medicamento", "Lote"
            }
        ));
        jScrollPane3.setViewportView(tblDetalleVenta);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 40, 510, 590));

        jTabbedPane1.addTab("Ventas Generales", jPanel2);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.detalleVenta = new DetalleVenta();
        //se genera el idVenta a la hora de procesar la venta
        detalleVenta.setIdLote(this.loteSeleccionado.getIdMedicamento());
        detalleVenta.setNombreMedicamento(this.loteSeleccionado.getNombreMedicamento());
        int cantidadAVender = ((int) this.jSpinner1.getValue());
        if (cantidadAVender > this.loteSeleccionado.getCantidad()) {
            JOptionPane.showMessageDialog(rootPane, "Error, no hay suficiente cantidad en el stock", " ", JOptionPane.ERROR_MESSAGE);
        } else {

            detalleVenta.setCantidad(cantidadAVender);
            detalleVenta.setPrecioVendido(Double.parseDouble(this.txtPrecio.getText()));
            double totalDetalleVenta = detalleVenta.getCantidad() * detalleVenta.getPrecioVendido();
            detalleVenta.setTotal(totalDetalleVenta);
            this.carritoDetalleVenta.add(detalleVenta);

            this.ActualizarTotal();
            this.CargarCarrito();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ActualizarTotal() {
        this.totalPagar = 0;

        // Iterar sobre todos los elementos del carrito
        for (DetalleVenta dt : this.carritoDetalleVenta) {
            this.totalPagar += dt.getTotal(); // Sumar el total de cada detalle
        }

        // Mostrar el total en el lblTotal con dos decimales
        this.lblTotal.setText("Total a pagar: " + String.format("%.2f", this.totalPagar));
    }

    private void CargarCarrito() {
        this.modeloDetalle.setRowCount(0);

        this.modeloDetalle.setRowCount(0);

        for (int i = 0; i < this.carritoDetalleVenta.size(); i++) {
            DetalleVenta dt = this.carritoDetalleVenta.get(i);
            double subTotal = dt.getCantidad() * dt.getPrecioVendido();
            String[] data = {
                dt.getNombreMedicamento(),
                String.valueOf(dt.getCantidad()),
                String.valueOf(dt.getPrecioVendido()),
                String.valueOf(dt.getTotal()), //String.format("%.2f", dt.getPrecioVendido()),
            };

            this.modeloDetalle.addRow(data);
        }

        this.tblCarrito.setModel(modeloDetalle);

    }
    
    private void MostrarVentas() {
        this.modeloMaestroDetalle.setRowCount(0);
        

        for (int i = 0; i < this.listaDetallesVenta.size(); i++) {
            DetalleVenta dt = this.listaDetallesVenta.get(i);
            double subTotal = dt.getCantidad() * dt.getPrecioVendido();
            String[] data = {
                //dt.getNombreMedicamento(),
                String.valueOf(dt.getIdDetalleVenta()),
                String.valueOf(dt.getIdVenta()),
                
                String.valueOf(dt.getCantidad()),
                String.valueOf(dt.getPrecioVendido()),
                dt.getNombreMedicamento(),
                String.valueOf(dt.getIdLote()), //String.format("%.2f", dt.getPrecioVendido()),
            };

            this.modeloMaestroDetalle.addRow(data);
        }

        this.tblDetalleVenta.setModel(modeloMaestroDetalle);

    }


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //frmInventarioPequeño frmInv = new frmInventarioPequeño();
        frmInventarioPequeño frmInv = new frmInventarioPequeño(this);
        frmInv.setVisible(true);
        this.parent.getDesktopPanel().add(frmInv);
        //this.parent.add(frmInv);
        frmInv.moveToFront();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void menuEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarActionPerformed
        int fila = this.tblCarrito.getSelectedRow();
        int id = Integer.parseInt(tblCarrito.getValueAt(fila, 0).toString());

        for (int i = 0; i < this.listaVentas.size(); i++) {
            if (this.listaVentas.get(i).getIdVenta() == id) {
                venta = this.listaVentas.get(i);
                break;
            }
        }
        int opc = JOptionPane.showConfirmDialog(rootPane, "Seguro que desea eliminar la venta", "Advertencia!", JOptionPane.YES_NO_OPTION);
        if (opc == JOptionPane.OK_OPTION) {

        }
    }//GEN-LAST:event_menuEditarActionPerformed

    private void menuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliminarActionPerformed
        int fila = this.tblCarrito.getSelectedRow();
        int id = Integer.parseInt(tblCarrito.getValueAt(fila, 0).toString());

        for (int i = 0; i < this.listaVentas.size(); i++) {
            if (this.listaVentas.get(i).getIdVenta() == id) {
                venta = this.listaVentas.get(i);
                break;
            }
        }
        int opc = JOptionPane.showConfirmDialog(rootPane, "Seguro que desea eliminar la venta", "Advertencia!", JOptionPane.YES_NO_OPTION);
        if (opc == JOptionPane.OK_OPTION) {

            for (int i = 0; i < this.carritoDetalleVenta.size(); i++) {
                if (this.carritoDetalleVenta.get(i).getIdVenta() == venta.getIdVenta()) {
                    this.detalleVentaDAO.DevolucionLote(venta.getIdVenta());
                    break;
                }
            }
            //hasta que se termine de devolver la cantidad a los lotes se elimina la venta y el detalleventa
            this.ventaDAO.EliminarVenta(venta.getIdVenta());
            JOptionPane.showMessageDialog(rootPane, "Venta eliminado exitosamente!!", " ", JOptionPane.INFORMATION_MESSAGE);

            this.CargarTablaVentas();
        }
    }//GEN-LAST:event_menuEliminarActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        txtPrecio.setText(String.valueOf(loteSeleccionado.getPrecioCosto()));
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        txtPrecio.setText(String.valueOf(loteSeleccionado.getPrecioUnitario()));
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        txtPrecio.setText(String.valueOf(loteSeleccionado.getPrecioMayoreo()));
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        frmClienteSeleccionar frmCliente = new frmClienteSeleccionar(this);
        frmCliente.setVisible(true);
        this.parent.getDesktopPanel().add(frmCliente);
        frmCliente.moveToFront();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Venta venta = new Venta();

        String fechaFormateada = sdf.format(this.jDateChooser1.getDate());

        try {
            java.sql.Date fechaVenta = java.sql.Date.valueOf(fechaFormateada);
            venta.setFechaVenta(fechaVenta);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al procesar la fecha", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Detener si hay un problema con la fecha
        }
        venta.setIdUsuario(this.userSesion.getIdusuario());
        venta.setIdCliente(this.clienteSeleccionado.getIdCliente());
        venta.setMontoTotal(totalPagar);

        this.ventaDAO.InsertarVenta(venta);
        int ultimoIDVenta = this.ventaDAO.ObtenerUltimoIDVenta();

        for (int i = 0; i < this.carritoDetalleVenta.size(); i++) {
            DetalleVenta detalleVenta = new DetalleVenta(
                    ultimoIDVenta,
                    carritoDetalleVenta.get(i).getIdLote(),
                    carritoDetalleVenta.get(i).getCantidad(),
                    carritoDetalleVenta.get(i).getPrecioVendido()
            );

            detalleVentaDAO.InsertarDetalle(detalleVenta);
        }
        JOptionPane.showMessageDialog(null, "Venta realizada con éxito", "Succes", JOptionPane.INFORMATION_MESSAGE);
        this.modeloDetalle.setRowCount(0);
        this.txtCliente.setText("");
        this.txtProducto.setText("");
        this.txtPrecio.setText("");
        this.jSpinner1.setValue(0);
        this.lblTotal.setText("");
        this.carritoDetalleVenta.clear();
        this.clienteSeleccionado = null;
        this.loteSeleccionado = null;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblVentasMaestroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVentasMaestroMouseClicked
        int fila = this.tblVentasMaestro.getSelectedRow();
        Venta ventaSeleccionada = this.listaVentas.get(fila);
        this.listaDetallesVenta = this.detalleVentaDAO.ConsultarDetallesById(ventaSeleccionada.getIdVenta());
        this.MostrarVentas();
    }//GEN-LAST:event_tblVentasMaestroMouseClicked

    public void ObtenerLoteSeleccionado(Lote loteSeleccionado) {
        this.loteSeleccionado = loteSeleccionado;
        this.txtProducto.setText(this.loteSeleccionado.getNombreMedicamento());
    }

    public void ObtenerClienteSeleccionado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
        this.txtCliente.setText(this.clienteSeleccionado.getNombre());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JMenuItem menuEditar;
    private javax.swing.JMenuItem menuEliminar;
    private javax.swing.JTable tblCarrito;
    private javax.swing.JTable tblDetalleVenta;
    private javax.swing.JTable tblVentasMaestro;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
