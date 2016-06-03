/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

//import javax.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

/**
 *
 * @author nacho
 */
public class MiFrameApp extends JFrame implements WindowListener {
    private PanelAlumno panel;
    
    public MiFrameApp(){
        super("Modelo Vista Controlador");
        initComponents();
    }
    private void initComponents(){
        panel = new PanelAlumno();
        Container contenedor = this.getContentPane();
        contenedor.add(panel);
        pack();
    }
    @Override
    public void windowOpened(WindowEvent e) {
    }
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    @Override
    public void windowClosed(WindowEvent e) {
        System.exit(0);
    }
    @Override
    public void windowIconified(WindowEvent e) {
    }
    @Override
    public void windowDeiconified(WindowEvent e) {
    }
    @Override
    public void windowActivated(WindowEvent e) {
    }
    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
