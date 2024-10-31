/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

/**
 *
 * @author RojeruSan
 */
import javax.swing.JPanel;

public class CambiaPanel {
    private JPanel container;
    private JPanel content;

    public CambiaPanel(JPanel container, JPanel content) {
        this.container = container;
        this.content = content;

        this.container.removeAll();

        // Establecer tamaño y posición de `content`
        content.setBounds(0, 0, container.getWidth(), container.getHeight()); // O un tamaño deseado

        this.container.add(this.content); // Añade content a container
        this.container.revalidate();
        this.container.repaint();
    }
}

