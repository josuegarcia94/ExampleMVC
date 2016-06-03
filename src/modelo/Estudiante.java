/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author nacho
 */
public class Estudiante extends Persona {
    private String boleta;    
    
    public Estudiante() {
        this("", 0, "");
    }
    
    public Estudiante(String nombre, int edad, String boleta) {
        super(nombre, edad);
        this.boleta = boleta;
    }
    
    public String getBoleta() {
        return boleta;
    }
    
    public void setBoleta(String boleta) {
        this.boleta = boleta;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Boleta: " + boleta + "\n";
    }
}
