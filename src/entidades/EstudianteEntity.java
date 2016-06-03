/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author nacho
 */
@Entity
public class EstudianteEntity extends PersonaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;
    private String boleta;
    private String idg;

    public EstudianteEntity() {
        this("", 0, "");
    }
    public EstudianteEntity(String nombre, int edad, String boleta){
        super(nombre, edad);
        this.boleta = boleta;
    }
    public String getBoleta(){
        return boleta;
    }
    public void setBoleta(String boleta){
        this.boleta = boleta;
    }
    public String getIdG(){
        return idg;
    }
    public void setIdG(String idg){
        this.idg = idg;
    }
    @Override
    public String toString(){
        return super.toString() + "Boleta: " + boleta + "\n";
    }
}
