/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import control.ControlGrupo;

/**
 *
 * @author nacho
 */
public class PanelAlumno extends JPanel {

    private JLabel[] etiqs;
    private JTextField[] textos;
    private JButton[] botones;
    private JTable tabla;
    private int fila;
    private DefaultTableModel dtm;
    private JComboBox comboGrupos;

    public PanelAlumno() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        etiqs = new JLabel[5];
        textos = new JTextField[4];
        comboGrupos = new JComboBox();
        String[] nombres = {
            "Nombre", "Edad", "Boleta", "Grupo", "Grupos"
        };
        int x = 10;
        int y = 10;
        int incY = 30;
        int ancho = 130;
        int alto = 30;
        for (int n = 0; n < etiqs.length; n++) {
            if (n < etiqs.length - 1) {
                etiqs[n] = new JLabel(nombres[n]);
                textos[n] = new JTextField(35);
                etiqs[n].setBounds(
                        x, y + (n * incY), ancho, alto);
                textos[n].setBounds(
                        x + ancho + 10, y + (n * incY), ancho + 20, alto);
                add(etiqs[n]);
                add(textos[n]);
            } else {
                etiqs[n] = new JLabel(nombres[n]);
                add(etiqs[n]);
                etiqs[n].setBounds(
                        x, y + (n * incY), ancho, alto);
                comboGrupos.setBounds(
                        x + ancho + 10, y + (n * incY), ancho + 20, alto);
                add(comboGrupos);
            }
        }

        botones = new JButton[4];
        String[] nombreBotones = {
            "Adicionar alumno",
            "Guardar grupo",
            "Salir",
            "Cargar grupo"
        };
        for (int n = 0; n < botones.length; n++) {
            botones[n] = new JButton(nombreBotones[n]);
            add(botones[n]);
            botones[n].addActionListener(new ControlGrupo(this));
        }
        botones[0].setBounds(x, y + (4 * incY), ancho, alto);
        botones[1].setBounds(x + ancho + 10, y + (4 * incY), ancho, alto);
        botones[2].setBounds(x, y + (4 * incY) + alto + 10, ancho, alto);
        botones[3].setBounds(x + ancho + 10, y + (4 * incY) + alto + 10, ancho, alto);
        String[] columnas = {
            "Alumno", "Edad", "Boleta", "Grupo"
        };
        String[][] datos = {
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""}
        };
        dtm = new DefaultTableModel(datos, columnas);
        tabla = new JTable(dtm);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll);
        scroll.setBounds(10, 220, 320, 300);
        fila = 0;
    }

    public JTextField getTextos(int cual) {
        if (cual < 0 || cual >= textos.length) {
            return null;
        }
        return textos[cual];
    }

    public void addAlumno() {
        dtm.setValueAt(textos[0].getText(), fila, 1);
        dtm.setValueAt(textos[1].getText(), fila, 2);
        dtm.setValueAt(textos[2].getText(), fila, 3);
        dtm.setValueAt(textos[3].getText(), fila, 4);
        fila++;
    }

    public void resetFila() {
        fila = 0;
    }

    public void addAlumno(String nombre, int edad, String boleta, String grupo) {
        dtm.setValueAt(nombre, fila, 1);
        dtm.setValueAt("" + edad, fila, 2);
        dtm.setValueAt(boleta, fila, 3);
        dtm.setValueAt(grupo, fila, 4);
        fila++;
    }
}
