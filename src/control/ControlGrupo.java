/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.*;
import java.util.Iterator;
import javax.swing.JOptionPane;
//import modelo.Alumno
//import modelo.Grupo
import vista.PanelAlumno;

/**
 *
 * @author nacho
 */
public class ControlGrupo implements ActionListener {

    private PanelAlumno panel;
    private Grupo grupo;

    public ControlGrupo(PanelAlumno panel) {
        this.panel = panel;
        grupo = new Grupo();
    }

    public void actionPerformed(ActionEvent ae) {
        String comando = ae.getActionCommand();
        switch (comando) {
            case "AdicionarAlumno":
                adicionarAlumno();
                break;
            case "GuardarGrupo":
                guardarGrupo();
                break;
            case "CargarGrupo":
                cargarGrupo();
                break;
            case "Salir":
                System.exit(0);
            default:
                cargarGrupos();
        }
    }
}
