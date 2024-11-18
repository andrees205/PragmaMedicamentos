/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TablaCustom;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author andre
 */
public class MiTablaCustom extends Clases.tablaCustom {
        public MiTablaCustom() {
        super(); // Llama al constructor de la clase base

        // Agrega un MouseListener personalizado
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
    }
            // Método personalizado para manejar los clics del ratón
    private void tablaMouseClicked(MouseEvent evt) {
        int filaSeleccionada = this.getSelectedRow(); // Obtiene la fila seleccionada
        if (filaSeleccionada != -1) { // Verifica que haya una fila seleccionada
            Object valor = this.getValueAt(filaSeleccionada, 0); // Obtén un valor de la fila (por ejemplo, la primera columna)
            System.out.println("Fila seleccionada: " + filaSeleccionada + ", Valor: " + valor);

            // Lógica personalizada al hacer clic en una fila
        }
    }
}
