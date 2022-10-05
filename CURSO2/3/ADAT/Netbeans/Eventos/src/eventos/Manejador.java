/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author manuelconde
 */
public class Manejador implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        JButton boton = (JButton) ae.getSource();
        boton.setText("Gracias");
    }   
}